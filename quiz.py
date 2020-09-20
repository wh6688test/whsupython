#remove duplicate no using set
from functools import reduce

def removeDup(input):
    arr=[]
    l=len(input)
    return [set(input)] 

def sum_up(input):
    result=0;
    #python3 new feature
    [result := result+input[i] for i in range(0, len(input))] 
    return result

def reducer(x1, x2):
    return  x1+x2 
def sum_up2(input):
    #python3 new feature
    result=reduce(reducer, input)
    return result

#using list to convert string to char list
def stringToList1(mys):
    return list(mys)

#using list comprehension to convert string to list
def stringToList2(mys):
    return [c for c in mys]

print(removeDup([1, 2, 2, 3, 1, 5]))
print(sum_up([1, 2, 2, 3, 1, 5]))
print(sum_up2([1, 2, 2, 3, 1, 5]))
print(stringToList1("onetwo"))
print(stringToList2("three"))
