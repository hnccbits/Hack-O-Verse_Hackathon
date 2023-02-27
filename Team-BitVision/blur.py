import cv2

# Load image
img = cv2.imread('park.jpg')

gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)


blur = cv2.GaussianBlur(gray, (3,3), 0)

blur5 = cv2.GaussianBlur(gray, (5,5), 0)

cv2.imshow('blur',blur)
cv2.imshow('blur2',blur5)



cv2.waitKey(0)
cv2.destroyAllWindows()

