import sys
from dHash import DHash


def get_hanm_distance():
    dhash1 = sys.argv[1]
    dhash2 = sys.argv[2]
    hamming_distance = DHash.hamming_distance(dhash1, dhash2)
    print(hamming_distance)


if __name__ == '__main__':
    get_hanm_distance()
