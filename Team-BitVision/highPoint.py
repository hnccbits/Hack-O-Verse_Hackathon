import cv2

# Load the image and convert it to grayscale
img = cv2.imread('park.jpg')
gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)

# Threshold the image to obtain a binary image
_, thresh = cv2.threshold(gray, 0, 255, cv2.THRESH_BINARY_INV + cv2.THRESH_OTSU)

# Find the contours of the object in the binary image
contours, _ = cv2.findContours(thresh, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_NONE)

# Find the contour with the highest Y-coordinate
highest_contour = max(contours, key=lambda c: cv2.boundingRect(c)[1])

# Get the coordinates of the highest point
x, y, _, _ = cv2.boundingRect(highest_contour)
highest_point = (x, y)

# Draw a circle at the highest point (optional)
cv2.circle(img, highest_point, 5, (0, 0, 255), -1)

# Display the result
cv2.imshow('Result', img)
cv2.waitKey(0)
cv2.destroyAllWindows()
