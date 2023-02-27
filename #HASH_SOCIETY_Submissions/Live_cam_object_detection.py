import ultralytics
import cv2
model = ultralytics.YOLO('yolov8n.pt')

def coordinates(result):
    res = []
    for obj in result:
        boxes  = obj.boxes
        for box in boxes:
            res.append(box.xyxy[0])
    return res
cap = cv2.VideoCapture(0)
print(cap)
while True:
    sucess, image = cap.read()
    # print(sucess)
    result = model(image, stream = True, show=True)
    cv2.imshow("output_image", image)
    cv2.waitKey(1)
    print(coordinates(result))