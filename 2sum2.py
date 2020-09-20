import itertools
from itertools import combinations

def find_two_sum(numbers, target_sum):
    """
    :param numbers: (list of ints) The list of numbers.
    :param target_sum: (int) The required target sum.
    :returns: (a tuple of 2 ints) The indices of the two elements whose sum is equal to target_sum
    """
    for c in itertools.combinations(numbers,2):
     if c[0]+c[1] == target_sum:
        return numbers.index(c[0]), numbers.index(c[1])

    return None

if __name__ == "__main__":
    print(find_two_sum([1, 2, 3, 4, 5, 6,7, 10, -1], 7))
