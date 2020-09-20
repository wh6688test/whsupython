def find_two_sum(numbers, target_sum):
    """
    :param numbers: (list of ints) The list of numbers.
    :param target_sum: (int) The required target sum.
    :returns: (a tuple of 2 ints) The indices of the two elements whose sum is equal to target_sum
    """
    s=set()
    l=len(numbers)
    for i in range(l):
        thisn=numbers[i]
        second=target_sum-thisn
        if thisn not in s and second in numbers[slice(i+1,l)]:
            s.add(thisn)
            for j in range(i+1, l):
               if (numbers[j] == second):
                 return (i, j)
    return None

if __name__ == "__main__":
    print(find_two_sum([1, 2, 3, 4, 5, 6,7, 10, -1], 7))
