import cv2

# Load image
img = cv2.imread('park.jpg')

# Convert to grayscale
gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)

cv2.imshow('gray', gray)

cv2.waitKey(0)
cv2.destroyAllWindows()