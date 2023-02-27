import cv2
import numpy as np

# Load camera intrinsic parameters
K = np.loadtxt('camera_matrix.txt')
dist_coef = np.loadtxt('distortion_coefficients.txt')

# Load image
img = cv2.imread('object.png')

# Convert to grayscale
gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)

# Find contours
contours, hierarchy = cv2.findContours(gray, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)

# Assume the largest contour is the object
largest_contour = max(contours, key=cv2.contourArea)
object_size_pixels = cv2.arcLength(largest_contour, True)

# Calculate distance
object_size_meters = 0.1  # assume object size is 10 cm
focal_length = K[0, 0]
object_distance = object_size_meters * focal_length / object_size_pixels

print('Object distance:', object_distance, 'meters')
