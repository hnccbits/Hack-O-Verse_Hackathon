import cv2

# Load image
img = cv2.imread('park.jpg')




cv2.imshow('park', img)


cv2.waitKey(0)
cv2.destroyAllWindows()