import cv2

# Load the reference image and convert it to grayscale
reference_image = cv2.imread('construction.png')
reference_gray = cv2.cvtColor(reference_image, cv2.COLOR_BGR2GRAY)

# Create a SIFT detector and compute the keypoints and descriptors for the reference image
sift = cv2.SIFT_create()
reference_kp, reference_desc = sift.detectAndCompute(reference_gray, None)

# Load the image to search for the object in and convert it to grayscale
search_image = cv2.imread('construction.png')
search_gray = cv2.cvtColor(search_image, cv2.COLOR_BGR2GRAY)

# Compute the keypoints and descriptors for the search image
search_kp, search_desc = sift.detectAndCompute(search_gray, None)

# Create a Brute-Force Matcher and match the descriptors in the refereccnce and search images
bf = cv2.BFMatcher()
matches = bf.match(reference_desc, search_desc)

# Sort the matches by their distance
matches = sorted(matches, key = lambda x:x.distance)

# Draw the top 10 matches on the search image
result = cv2.drawMatches(reference_image, reference_kp, search_image, search_kp, matches[:10], None, flags=2)

# Show the result image
cv2.imshow('Result', result)
cv2.waitKey(0)
cv2.destroyAllWindows()
