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
while True:
    result = model('Bicycle.png', show = True)
    print(coordinates(result))