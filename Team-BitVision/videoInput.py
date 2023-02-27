import cv2 as cv
import numpy as np

frameWidth = 640
frameHeight = 360

cap = cv.VideoCapture(0)

while True :
    isTrue, frame = cap.read()
    
    # ------- # 



# Convert the frame to grayscale
    gray = cv.cvtColor(frame, cv.COLOR_BGR2GRAY)

# Apply a threshold to the frame to separate the object from the background
    _, thresh = cv.threshold(gray, 0, 255, cv.THRESH_BINARY_INV+cv.THRESH_OTSU)

# Find the contours of the object in the thresholded frame
    contours, _ = cv.findContours(thresh, cv.RETR_EXTERNAL, cv.CHAIN_APPROX_SIMPLE)

# Find the largest contour, which should be the object
    largest_contour = max(contours, key=cv.contourArea)

# Compute the minimum enclosing circle of the contour
    (x, y), radius = cv.minEnclosingCircle(largest_contour)

# Draw the circle on the frame
    cv.circle(frame, (int(x), int(y)), int(radius), (0, 255, 0), 2)

# Estimate the height of the object
# Assume that the object is a cylinder
    object_height = 1.5 # in meters
    focal_length = 500 # in pixels
    frame_height = frame.shape[0] # in pixels
    estimated_height = (object_height * focal_length) / radius

# Display the frame with the circle and the estimated height
    cv.putText(frame, f"Estimated height: {estimated_height:.2f} meters", (10, frame_height-20),
    cv.FONT_HERSHEY_SIMPLEX, 0.5, (0, 255, 0), 2)
    cv.imshow("Object Height Estimation", frame)
    cv.waitKey(0)
    cv.destroyAllWindows()

    # ------- #

    cap.release()

    if cv.waitKey(20) & 0xFF == ord('q') :
        break


cv.destroyAllWindows()