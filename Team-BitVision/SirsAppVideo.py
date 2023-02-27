import cv2 as cv
import numpy as np

# Loading the image
img_plane = cv.imread('construction.png')

cv.imshow('ground',img_plane)

# CrayScaling
gray_img = cv.cvtColor(img_plane, cv.COLOR_BGR2gray_img)

# Apply threshold for Morphological Operations
# Using otsu filter
thresh = cv.threshold(gray_img, 0, 255, cv.THRESH_BINARY + cv.THRESH_OTSU)[1]

# Remove noise
kernel = cv.getStructuringElement(cv.MORPH_ELLIPSE, (5, 5))
thresh = cv.morphologyEx(thresh, cv.MORPH_OPEN, kernel)

# Identify contours
contours, _ = cv.findContours(thresh, cv.RETR_EXTERNAL, cv.CHAIN_APPROX_SIMPLE)

# Extract ground contour
ground_contour = max(contours, key=cv.contourArea)

# Create mask
mask = np.zeros_like(gray_img)
cv.drawContours(mask, [ground_contour], 0, 255, -1)

# Apply mask to original image
ground = cv.bitwise_and(img_plane, img_plane, mask=mask)

highest_contour = max(contours, key=lambda c: cv.boundingRect(c)[1])

# Get the coordinates of the highest point
x, y, _, _ = cv.boundingRect(highest_contour)
highest_point = (x, y)

# Draw a circle at the highest point (optional)
cv.circle(img_plane, highest_point, 5, (0, 0, 255), -1)

# Show result
cv.imshow('Ground', ground)
cv.waitKey(0)
cv.destroyAllWindows()
