import cv2
import numpy as np

# Load input image
img = cv2.imread('park.png', 0)

# Compute moments of the image
M = cv2.moments(img)

# Access moment values
area = M['m00'] # area of the object
cx = int(M['m10'] / M['m00']) # x-coordinate of centroid
cy = int(M['m01'] / M['m00']) # y-coordinate of centroid
mu20 = M['mu20'] / M['m00'] # central moment
mu02 = M['mu02'] / M['m00'] # central moment
