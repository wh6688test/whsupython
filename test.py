def factorial(in1):
    if in1==0:
        return 0
    if in1==1:
        return 1
    
    return in1 * factorial(in1-1)

print(factorial(5))