
import cv2
import numpy as np

# Read in the image
img = cv2.imread('cube.jpeg')

# Convert to grayscale
gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)

# Apply Gaussian blur
blur = cv2.GaussianBlur(gray, (5, 5), 0)

# Apply Canny edge detection
edges = cv2.Canny(blur, 100, 200)

# Find contours
contours, _ = cv2.findContours(edges, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)

# Find the largest contour
largest_contour = max(contours, key=cv2.contourArea)

# Approximate the contour with a polygon
epsilon = 0.1 * cv2.arcLength(largest_contour, True)
approx = cv2.approxPolyDP(largest_contour, epsilon, True)

# Draw the polygon on the image
cv2.drawContours(img, [approx], 0, (0, 255, 0), 2)

# Display the result
cv2.imshow('Edge Polygon', img)
cv2.waitKey(0)

# Clean up
cv2.destroyAllWindows()