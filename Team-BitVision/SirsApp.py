import cv2
import numpy as np

# Load the image
img = cv2.imread('tableBest.jpg')

cv2.imshow('ground',img)

# Convert to grayscale
gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)

# Apply threshold
thresh = cv2.threshold(gray, 0, 255, cv2.THRESH_BINARY + cv2.THRESH_OTSU)[1]

cv2.imshow('thresh',thresh)

# Remove noise
kernel = cv2.getStructuringElement(cv2.MORPH_ELLIPSE, (5, 5))
thresh = cv2.morphologyEx(thresh, cv2.MORPH_OPEN, kernel)

# Identify contours
contours, _ = cv2.findContours(thresh, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)

# Extract ground contour
ground_contour = max(contours, key=cv2.contourArea)

# Create mask
mask = np.zeros_like(gray)
cv2.drawContours(mask, [ground_contour], 0, 255, -1)

# Apply mask to original image
ground = cv2.bitwise_and(img, img, mask=mask)

highest_contour = max(contours, key=lambda c: cv2.boundingRect(c)[1])

# Get the coordinates of the highest point
x, y, _, _ = cv2.boundingRect(highest_contour)
highest_point = (x, y)

# Draw a circle at the highest point (optional)
cv2.circle(img, highest_point, 5, (0, 0, 255), -1)

# Show result
cv2.imshow('Ground', ground)
cv2.waitKey(0)
cv2.destroyAllWindows()
