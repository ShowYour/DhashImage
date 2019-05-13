import cv2
import sys
from dHash import DHash


def get_image_dhash():
    url = sys.argv[1]
    cap = cv2.VideoCapture(url)
    ret = cap.isOpened()
    if ret:
        img = cap.read()[1]
        dhash = DHash.calculate_hash(img)
        print(dhash)
    cap.release()


if __name__ == '__main__':
    get_image_dhash()
