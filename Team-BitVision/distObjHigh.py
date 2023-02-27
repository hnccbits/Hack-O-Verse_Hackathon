import cv2
import math

# Load the image and convert it to grayscale
img = cv2.imread('tableBest.jpg')
gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)

# Threshold the image to obtain a binary image
_, thresh = cv2.threshold(gray, 0, 255, cv2.THRESH_BINARY_INV + cv2.THRESH_OTSU)

cv2.imshow('bin',thresh)

#Find the contours of the object in the binary image
contours, _ = cv2.findContours(thresh, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_NONE)

# Find the contour with the highest Y-coordinate
highest_contour = max(contours, key=lambda c: cv2.boundingRect(c)[1])

# Get the coordinates of the highest point
x, y, _, _ = cv2.boundingRect(highest_contour)
highest_point = (x, y)

# Compute the centroid of the object
M = cv2.moments(highest_contour)

if M["m00"] != 0:
    centroid_x = int(M["m10"] / M["m00"])
    centroid_y = int(M["m01"] / M["m00"])
else:
    # set values as what you need in the situation
    centroid_x, centroid_y = 0, 0
centroid = (centroid_x, centroid_y)

# Calculate the distance between the highest point and the centroid
distance = math.sqrt((highest_point[0] - centroid[0]) ** 2 + (highest_point[1] - centroid[1]) ** 2)

# Draw a line between the highest point and the centroid (optional)
cv2.line(img, highest_point, centroid, (0, 0, 255), 2)

print(distance)

# Display the result
cv2.imshow('Result', img)
cv2.waitKey(0)
cv2.destroyAllWindows()
