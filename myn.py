def isPalindrome(s):
        
        if len(s)<=2:
            return True
        
        l=len(s)
        if s==s[::-1]:
            return True
        ss=s 
        for i in range(l):
            s=ss[0:i]+ss[i+1:l]
            print(s)
            if s==s[::-1]:
                return True
        return False

print(isPalindrome("abca"))
