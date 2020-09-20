def largest_pair(nums,target):
   result =[]
   for i, num in enumerate(nums):
       temp=target-30-num
       if temp in nums and nums.index(temp) != i:
           if not result or max(result) < max(nums[i], temp):
             result=[i, nums.index(temp)]
   return result    


print(largest_pair([1, 10, 25, 35, 60], 90))
print(largest_pair([20, 50, 40, 25, 30, 10], 90))


def factorial(n):
    if n==0:
        return 0
    if n==1:
        return 1

    result=1
    for i in range(1, n+1):
        result *=i
    return result

def odd_all(start, end):
    return [i for i in range(start, end+1) if i%2 != 0]


def topKFrequent( words, k) :
        
        temp={}
        
        for w in words:
            if w not in temp.keys():
                temp[w]=1
            else:
               temp[w] +=1

        temp={k1:v1 for k1, v1 in sorted(temp.items(), key=lambda item:(-item[1], item[0]))}

        print (temp) 
        result=list(temp.keys())
        return result[0:k]
            

#print(factorial(1))
#print(factorial(2))
#print(factorial(5))

#print (odd_all(1, 100))

topKFrequent(["i", "love", "leetcode", "i", "love", "coding"], 2)

 simple max sum subarray that adds up to a certain sum


#JP Morgan and Chase Interview Experience
#Stock buy and sell :
#https://www.geeksforgeeks.org/stock-buy-sell/

#

https://www.geeksforgeeks.org/jp-morgan-chase-co-interview-experience-set-4-campus-fte/

https://leetcode.com/problems/maximal-square/


---

Find occurance of a substring in a string : 

String manipulations : 

      string.startswith(substring, beg, end)

check any of a string is digit or alpha...

if any(map(str.isdigit, s)):
    result[0]="True"

unlike other languages, python split without arguments split against white space

 return " ".join([ss.strip().capitalize() for ss in s.strip().split()])

convert a string to list :  list(string) or result=[] result[:]=string

[c for c in string]


--

python : how to avoid using existing namespace

  if 'myval' in locals()
  if 'myval' in globals()
  if hasattr(obj, 'attr_name'):
    
  if a in __builtins__:
       
