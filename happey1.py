def isHappy(n):

        if n<=0:
            return false
        if n<10:
            return n==1
        
        existingnumber=[]
        sum1=0
      
        
        while sum1 not in existingnumber:
            existingnumber.append(n)
            sn=str(n)
            l=len(sn)
            sum1=int(sn[0])**2
            for i in range(1, l):
               sum1+=int(sn[i])**2
              
            if sum1 == 1:
                return True
           
            n=sum1
          
        return False

print(isHappy(19))
