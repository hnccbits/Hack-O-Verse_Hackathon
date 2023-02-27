import cv2
import numpy as np

# Read the image in grayscale
image = cv2.imread('consNew.jpg', cv2.IMREAD_GRAYSCALE)

# Convert the image to a binary image
_, binary = cv2.threshold(image, 0, 255, cv2.THRESH_BINARY)

# Compute the distance transform
distance = cv2.distanceTransform(binary, cv2.DIST_L2, 3)

# Find the minimum distance between edges
minVal, _, minLoc, _ = cv2.minMaxLoc(distance, binary)

print("Minimum distance between edges:", minVal)
