import cv2 as cv 
import numpy as np

import scipy
from scipy.spatial import distance as dist
import requests
import time

KNOWN_DISTANCE = 18
PERSON_WIDTH = 16 

# Object detector constant 
CONFIDENCE_THRESHOLD = 0.4
NMS_THRESHOLD = 0.3

# colors for object detected
COLORS = [(255,0,0),(255,0,255),(0, 255, 255), (255, 255, 0), (0, 255, 0), (255, 0, 0)]
GREEN =(0,255,0)
BLACK =(0,0,0)
# defining fonts 
FONTS = cv.FONT_HERSHEY_COMPLEX

class_names = []
with open("classes.txt", "r") as f:
    class_names = [cname.strip() for cname in f.readlines()]
#  setttng up opencv net
yoloNet = cv.dnn.readNet('yolov4-tiny.weights', 'yolov4-tiny.cfg')

yoloNet.setPreferableBackend(cv.dnn.DNN_BACKEND_CUDA)
yoloNet.setPreferableTarget(cv.dnn.DNN_TARGET_CUDA_FP16)

model = cv.dnn_DetectionModel(yoloNet)
model.setInputParams(size=(416, 416), scale=1/255, swapRB=True)

def object_detector(image):
    classes, scores, boxes = model.detect(image, CONFIDENCE_THRESHOLD, NMS_THRESHOLD)
    data_list =[]
    for (classid, score, box) in zip(classes, scores, boxes):
        color= COLORS[int(classid) % len(COLORS)]
        label = "%s : %f" % (class_names[classid], score)

        # draw rectangle on and label on object
        cv.rectangle(image, box, color, 2)
        cv.putText(image, label, (box[0], box[1]-14), FONTS, 0.5, color, 2)
    
        if classid ==0: # person class id 
            data_list.append([class_names[classid], box[2], (box[0], box[1]-2),box])
        
    return data_list

def focal_length_finder (measured_distance, real_width, width_in_rf):
    focal_length = (width_in_rf * measured_distance) / real_width
    print(focal_length)
    return focal_length

# distance finder function 
def distance_finder(focal_length, real_object_width, width_in_frmae):
    distance = (real_object_width * focal_length) / width_in_frmae
    return distance

ref_person = cv.imread('ReferenceImages/img.jpg')


person_data = object_detector(ref_person)
person_width_in_rf = person_data[0][1]
focal_person = 300

cap = cv.VideoCapture(0)
while True:
    ret, frame = cap.read()

    data = object_detector(frame) 
    bbox = []

    for d in data:
        if d[0] =='person':
            distance = distance_finder(focal_person, PERSON_WIDTH, d[1])
            x, y = d[2]
        cv.rectangle(frame, (x, y-3), (x+150, y+23),BLACK,-1 )
        cv.putText(frame, f'Dis: {round(distance,2)} inch', (x+5,y+13), FONTS, 0.48, GREEN, 2)
        bbox.append(d[3])
    
    l = len(bbox)
    frame = cv.putText(frame, str(len(bbox)) + " Object", (50, 50), cv.FONT_HERSHEY_SIMPLEX, 1, (255, 0, 0), 2,
                        cv.LINE_AA)
    stack_x = []
    stack_y = []
    stack_x_print = []
    stack_y_print = []
    global D
    
    if len(bbox) == 0:
        pass
    else:
        for i in range(0, len(bbox)):
            x1 = bbox[i][0]
            y1 = bbox[i][1]
            x2 = bbox[i][0] + bbox[i][2]
            y2 = bbox[i][1] + bbox[i][3]

            mid_x = int((x1 + x2) / 2)
            mid_y = int((y1 + y2) / 2)
            stack_x.append(mid_x)
            stack_y.append(mid_y)
            stack_x_print.append(mid_x)
            stack_y_print.append(mid_y)

            frame = cv.circle(frame, (mid_x, mid_y), 3, [0, 0, 255], -1)
            frame = cv.rectangle(frame, (x1, y1), (x2, y2), [0, 0, 255], 2)

        if len(bbox) == 2:
            D = int(dist.euclidean((stack_x.pop(), stack_y.pop()), (stack_x.pop(), stack_y.pop())))
            frame = cv.line(frame, (stack_x_print.pop(), stack_y_print.pop()),
                             (stack_x_print.pop(), stack_y_print.pop()), [0, 0, 255], 2)
        else:
            D = 0

        if D < 250 and D != 0:
            frame = cv.putText(frame, "!!MOVE AWAY!!", (100, 100), cv.FONT_HERSHEY_SIMPLEX, 2, [0, 0, 255], 4)
            # first please start the local server: request from team brainiacs
            url = 'http://127.0.0.1:5000/accidents'
            data_get = requests.get(url)
            ts = time.time()
            myobj = {"cameraid":"1","closest_distance":D,"timestamp":ts}

            x = requests.post(url, json = myobj)


        frame = cv.putText(frame, str(D / 10) + " cm", (300, 50), cv.FONT_HERSHEY_SIMPLEX,
                            1, (255, 0, 0), 2, cv.LINE_AA)
                    
        # frame = cv.putText(frame, str())
        cv.imshow('hi', frame)
        if cv.waitKey(100) == 13:
            break

cv.destroyAllWindows()
cap.release()