def isHappy(n):

        if n<=0:
            return false
        if n<10:
            return n==1
        
        existingnumber=set()
        sum1=0
      
        
        while sum1 not in existingnumber:
            print(sum1)            
            existingnumber.add(n)
         
            temp1=n
            while temp1>0:
              d1=temp1%10
              sum1+=d1**2
              temp1=temp1//10
            sum1+=temp1**2
            if sum1 == 1:
                return True
           
            n=sum1

        return False 

print(isHappy(19))
