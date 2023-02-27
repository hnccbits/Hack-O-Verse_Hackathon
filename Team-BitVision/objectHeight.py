import cv2
import numpy as np

# Load the image
image_path = "park.jpg"
image = cv2.imread(image_path)

# Convert the image to grayscale
gray = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)

# Apply a threshold to the image to separate the object from the background
_, thresh = cv2.threshold(gray, 0, 255, cv2.THRESH_BINARY_INV+cv2.THRESH_OTSU)

# Find the contours of the object in the thresholded image
contours, _ = cv2.findContours(thresh, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)

# Find the largest contour, which should be the object
largest_contour = max(contours, key=cv2.contourArea)

# Compute the minimum enclosing circle of the contour
(x, y), radius = cv2.minEnclosingCircle(largest_contour)

# Draw the circle on the image
cv2.circle(image, (int(x), int(y)), int(radius), (0, 255, 0), 2)

# Estimate the height of the object
# Assume that the object is a cylinder
object_height = 1.5 # in meters
focal_length = 500 # in pixels
image_height = image.shape[0] # in pixels
estimated_height = (object_height * focal_length) / radius

# Display the image with the circle and the estimated height
cv2.putText(image, f"Estimated height: {estimated_height:.2f} meters", (10, image_height-20),
            cv2.FONT_HERSHEY_SIMPLEX, 0.5, (0, 255, 0), 2)
cv2.imshow("Object Height Estimation", image)
cv2.waitKey(0)
cv2.destroyAllWindows()
