class Solution:
    def validPalindrome(self, s: str) -> bool:
        if len(s)<=2:
            return True
        
        l=len(s)
        if s==s[::-1]:
            return True
    
        start=0
        end=l-1
        
        while start<end:
            if s[start] != s[end]:
               return self.isPalindrome(s, start+1, end) or self.isPalindrome(s, start, end-1)
            start+=1
            end-=1
           
        return True 
    
    def isPalindrome(self, s1:str, start, end) -> bool:
        while start < end:
          if s1[start] != s1[end]:
            return False
          start+=1
          end-=1
        
        return True
            
print(Solution().validPalindrome("abca"))
