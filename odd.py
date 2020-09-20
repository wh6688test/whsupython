def myodd(b=1, e=100):
    result=[]
    for i in range(b, e+1):
        if i%2 != 0:
            result.append(i)
    return result

print(myodd())

        
