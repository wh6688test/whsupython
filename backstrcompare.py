class Solution:
    def backspaceCompare(self, S: str, T: str) -> bool:
        results:list=[]
        resultt:list =[]

        for sc in list(S.strip()):
            if (sc != "#"):
                  results.append(sc)
            else:
                  if (len(results) != 0):
                       results.pop()
                    
        for tc in list(T.strip()):
            if (tc != "#"):
                 resultt.append(tc)
                 resultt.
            else:
                 if (len(resultt) != 0):
                     resultt.pop()
        return "".join(results) == "".join(resultt)

        def numJewelsInStones(self, J: str, S: str) -> int:
        
        if ( J is None or len(J) == 0):
            return 0;
        
        if (S is None or len(S) ==0):
            return 0;
    
        count=0; 
       
        for a in S:
            if (a in J):
                count+=1;

        return count;
        
        def 

print(Solution().backspaceCompare("ab#c", "ad#c"))




        