import math
def find_roots(a, b, c):
   if (a == 0) and (b == 0):
     return None
   if (a == 0) and (b != 0):
     return (-c/b, -c/b)

   p2=math.sqrt(b**2-4*a*c)
   r1=((-b+p2)/(2*a))
   r2=((-b-p2)/(2*a))
   return (r1, r2)

print(find_roots(2, 10, 8))   
print(find_roots(0, 2, 8))   
