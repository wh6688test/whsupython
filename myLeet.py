def removeDup(input):
    arr=[]
    l=len(input)
    return [set(input)] 
print(removeDup([1, 2, 2, 3, 1, 5]))

def lt_reverseString(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        if (s != None and len(s) != 0 and len(s) != 1):
          l:int=len(s)
          for i in range(l//2):
            tmp=s[i]
            s[i]=s[l-1-i]
            s[l-1-i]=tmp
