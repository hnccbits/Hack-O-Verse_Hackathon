import cv2

img = cv2.imread('construction.png')

cv2.imshow('construction',img)


# Convert to grayscale
gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)



blur = cv2.GaussianBlur(gray, (5,5), 0)

# Apply Canny edge detection
edges = cv2.Canny(blur, 60, 200)

# Display the original and edge-detected images

cv2.imshow('Edges', edges)

cv2.waitKey(0)
cv2.destroyAllWindows()
