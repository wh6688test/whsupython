def myf(n):
    if n==0:
        return 0
    if n==1:
        return 1

    return n*myf(n-1)

print(myf(2))
print(myf(3))
print(myf(4))
