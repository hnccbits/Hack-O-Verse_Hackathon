import cv2

# Load image
img = cv2.imread('image.jpg')

# Convert to grayscale
gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)

cv2.imshow('gray', gray)

# Apply Gaussian blur to reduce noise
# blur = cv2.GaussianBlur(gray, (5,5), 0)

# # Apply Canny edge detection
# edges = cv2.Canny(blur, 100, 200)

# # Display the original and edge-detected images
# cv2.imshow('Original Image', img)
# cv2.imshow('Edges', edges)

cv2.waitKey(0)
cv2.destroyAllWindows()
