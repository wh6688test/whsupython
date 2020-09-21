

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import java.util.stream.Collectors;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Stack;

/**common string methods
 * 1.String mys=String.valueOf(primitiveType/Object i)
 * 2. trim()/toUpperCase()/toLowerCase()/isEmpty()/length()
 * 3. split()/replace()/replaceAll()/replaceFirst()/indexOf()/contains()/matches()/substring/subSequence()
 * 4.toCharArray()/charAt()//startsWith()/endsWith()/getBytes()/indexOf/lastIndexOf()
 * 5. compareTo/compareToIgnoreCase()
 * 6. format()/equals()/hashCode()/concat()/intern()
 */
public class MyLeet {
    public MyLeet() {

    }
    public static void printSubString() {
        String result = "" ;
        
          for (int i=0; i<5; i++) {
              if (i != 0) {
                 result= result + " " + (i+1);
              } else {
                  result= result + (i+1);
              }
              System.out.println(result);
          }
    }
    public static boolean isPalindrome(String input) {
       if (input == null)
           return false;
       int l=input.length();
       for (int i=0;i<l;i++) {
           if (input.charAt(i) != input.charAt(l-1-i)) {
              return false;
           }
       }
       return true;
    }

    public static String removeCharsFromString(String input, char c) {
        return input.replaceAll(String.valueOf(c), "");
    }

    public static int printMyFibo(int count) {
         int result=0, a=0, b=1;
         if (count==1) {
             return 0;
         }
        if (count==2) {
             return 1;
         } 
         for (int i=3;i<=count;i++) {
             result=a+b;
             a=b;
             b=result;
         }
         return result;
    }
    public static int printMyFiboR(int count) {
         
         if (count==1) {
             return 0;
         }
         if (count==2) {
             return 1;
         }
         return printMyFiboR(count-2)+printMyFiboR(count-1);
         
    }
    public int lt_reverse(int x) {
       try {
        String xs=String.valueOf(x);
        int l=xs.length();
        if (l==1) {
            return x;
        }
        if (xs.charAt(0)=='-') {
            
         return Integer.parseInt(String.valueOf(xs.charAt(0))+(new StringBuilder((xs.substring(1))).reverse().toString()));
        
        }
        return Integer.valueOf(new StringBuilder(xs).reverse().toString());
    } catch(NumberFormatException e) {
           return 0;
       }
    }
    public int lt_reverse2(int x) {
     try {
         
        if (x <10 && x>=0) {
            return x;
        }
       
        String xs=String.valueOf(x);
        int l=xs.length();
        StringBuilder sb=new StringBuilder();
           
      
        if (xs.charAt(0)=='-') {
            for (int i=l-1;i>=1;i--) {
                sb.append(String.valueOf(xs.charAt(i)));
            }
            return (-Integer.parseInt(sb.toString()));
        } 
        for (int i=l-1;i>=0;i--) {
           sb.append(String.valueOf(xs.charAt(i)));
        }
        return Integer.parseInt(sb.toString());
    } catch(NumberFormatException e) {
           return 0;
       }
    }

    public int largestValue(int [] values) {
        return  1;
    }

    public static int[] leetSum2(int[] input, int target) {
        if (input == null) {
            return null;
        }
        int l=input.length;
        if( l == 1) {
          return null;
        }
        for (int i=0; i<l-1; i++) {
            for (int j=i+1;j<l;j++) {
                if (input[i]+input[j] == target) 
                  return new int[]{i,j};
            }
        }
        return null;
    }

    public static Integer[] leetSum2b(Integer[] input, int target) {
        if (input == null) {
            return null;
        }
        int l=input.length;
        if( l == 1) {
          return null;
        }
        Integer[] result=new Integer[2];
        List<Integer> inputL = Arrays.asList(input);
        for (int i=0; i<l; i++) { 
           int target2=target-input[i];
           int p2=inputL.indexOf(target2);
           if (p2 != -1) {
               result[0]=i;
               result[1]=p2;
               return result;
           }
        }
        return null;
    }

    public static int[] leetSum2c(int[] input1, int target) {
        if (input1 == null) {
            return null;
        }
        int l=input1.length;
        if( l == 1) {
          return null;
        }
        
        Map<Integer, Integer> result = new HashMap<>();
        for (int i=0; i<l; i++) {
            int second=target-input1[i];

            if (result.containsKey(input1[i])) {
                return new int[]{result.get(input1[i]), i} ;
            } else {
                result.put(second, i);
            }
        }

         return null;
        }


    public static int leetReverseInt(int orig) {
        if (orig < 10 && orig > -10)
          return orig;
        else if (orig<0) {
            StringBuilder sb=new StringBuilder(String.valueOf(orig).substring(1));
            return -Integer.parseInt(sb.reverse().toString());
        } else {
            StringBuilder sb=new StringBuilder(String.valueOf(orig));
            return Integer.parseInt(sb.reverse().toString());
        }
    }
   public static int leetReverseIntb(int orig) {
        if (orig < 10 && orig > -10)
          return orig;
        else if (orig<0) {
            String m=String.valueOf(orig);
            StringBuilder a = new StringBuilder();
            for (int i=m.length()-1;i>=1;i--) {
              a.append(m.charAt(i));
            }
            return -Integer.parseInt(a.toString());
        } else {
            String m=String.valueOf(orig);
            StringBuilder sb=new StringBuilder();
            for (int i=m.length()-1;i>=0;i--) {
                sb.append(m.charAt(i));
            }
            return Integer.parseInt(sb.toString());
        }
    }

    public static void leetValidPhone(String filePathName) throws FileNotFoundException {

        //read from phone file

        //check if first one not (, only - and number and nxxx-xxx-xxxxx
        //if first one (:check 4th must be )
        //check the last 8 characters in the format of xxx-xxxxx
        try (Scanner thisScanner= new Scanner(filePathName)) {
           while (thisScanner.hasNextLine()) {
            String nextLine=thisScanner.nextLine().trim();
            String pattern1 = "^(([0-9]{3})|(\\([0-9]{3}\\) )-([0-9]{3})-([0-9]{3})$";
            if ( nextLine.matches(pattern1)) {
               System.out.println(nextLine);
            }
          }
        } catch (Exception e) {
          throw(e);
        }
    }

    public static boolean leetBuddyString(String A, String B) {
        if (A == null || B == null) 
           return false;

        int la=A.length();
        int lb=B.length();
        if (la != lb || la < 2)
          return false;

        Set<String> resulta= new HashSet<>();
        Set<String> resultb= new HashSet<>();

        for (int i=0;i<la;i++) {
            if (   (B.indexOf(A.charAt(i)) == -1) || (A.indexOf(B.charAt(i)) == -1) ) {
                return false;
            }
            if (A.charAt(i) != B.charAt(i)) {
                resulta.add(String.valueOf(A.charAt(i)));
                resultb.add(String.valueOf(B.charAt(i)));
            }
        }
        System.out.println("comparing the results : " + resulta.toString() + " " + resultb.toString());
        if (!resulta.isEmpty() && !resultb.isEmpty() && resulta.size()<=2 && resultb.size()<=2 && resulta.equals(resultb)) {
            return true;
        }
        return false;
    }
    public static boolean leetIsPerfect(int num) {
         if (num <=0)
           return false;

         int sum=0;
         for (int i=1;i<num;i++) {
           if (num%i == 0) 
               sum+=i;
         }
         return sum==num;
    }

    public static boolean leetIsValidParentheses(String input) {
       
        String charSet="(){}[]";
        Stack<String> r1 = new Stack<>();
        Stack<String> r2 = new Stack<>();
        Stack<String> r3 = new Stack<>();

        if (input == null)
           return false;
        int l=input.length();
        if (l % 2 != 0)
           return false;
        for (int i=0;i<l;i++) {
            if (input.indexOf(input.charAt(i)) == -1) 
               return false;
            if (input.charAt(i) == '(') {
                r1.push(String.valueOf('('));
            } else if (input.charAt(i) == ')') {
                if (r1.size()==0)
                   return false;
                r1.pop();
            }
            if (input.charAt(i) == '{') {
                r2.push(String.valueOf('{'));
            } else if (input.charAt(i) == '}') {
                if (r2.size()==0)
                   return false;
                r2.pop();
            }
            if (input.charAt(i) == '[') {
                r3.push(String.valueOf('['));
            } else if (input.charAt(i) == ']') {
                if (r3.size()==0)
                   return false;
                r3.pop();
            }
            if (r1.size() == 0 && r2.size() == 0 && r3.size() == 0)
               return true;
        }
        return false;
    }
    public static boolean[] leetKidsMaxCandies(int[] current, int extra) {

        if (current == null)
           return null;

        int l=current.length;
        boolean []result = new boolean[l];
        if (l==1)
           return  new boolean[]{true};
        //get the current max
        int m=current[0];
        for (int i=1;i<l;i++) {
            if (m<current[i]) {
               m=current[i];
            }
        }
        //decide the result
        for (int i=0;i<l;i++) {
           if (current[i]+extra>=m) {
               result[i]=true;
           } else {
               result[i]=false;
           }
        }
        return result;
    }

    static public String leetLongestCommonP(String[]inputs) {
        if (inputs == null || inputs.length == 0)
           return null;
        if (inputs.length==1)
           return inputs[0];

        int l=inputs[0].length();
        String result="";
        //get the smallest one
        for (String input: inputs) {
            if (input.length()<l) {
              l=input.length();
              result=input;
            }
        }
        //get substring from the smallest one
        for (String input:inputs) {
           for (int i=l-1;i>=0;i--) {
               if (input.indexOf(result.charAt(i)) == -1) {
                   if (i==0)
                      return "";
                   result=result.substring(0, i);
               }
           }
        }
        return result;
    }

    public static int leetShortedUnsortedCSub(int[]input) {
        if (input == null)
          return 0;
        int l=input.length;
        if (l<=1)
          return 0;

        int result=l;
        int [] sorted=Arrays.copyOf(input, l);
        Arrays.sort(sorted);
        if (sorted==input) {
            return 0;
        }
        boolean leftStop=false;
        boolean rightStop=false;

        for (int i=0;i<l;i++) {
           if (!leftStop && sorted[i] != input[i] ) {
              result=result-i;
              leftStop=true;
           }
           if (!rightStop && sorted[l-1-i] != input[l-1-i]) {
               result=result-i;
               rightStop=true;
           }
           if (leftStop && rightStop)
              return result;
       }
       return 0;
    }

    public static int leetShortedUnsortedCSub2(int[]input) {
        if (input == null)
          return 0;
        int l=input.length;
        if (l<=1)
          return 0;

        int result=l;

        boolean leftStop=false;
        boolean rightStop=false;

        for (int i=0;i+1<l && l-2-i>=0;i++) {
           if (!leftStop && (input[i+1] < input[i]))  {
              result=result-i;
              leftStop=true;
           }
           if (!rightStop && input[l-2-i] > input[l-1-i]) {
               result=result-i;
               rightStop=true;
           }
           if (leftStop && rightStop) {
              return result;
           }
       }
       return 0;
    }

    public int lt_maxProfit(int[] prices) {
        
        int result=0;
        if (prices == null) {
            return 0;
        }
        int l=prices.length;
        if (l==1) {
            return 0;
        }
        int pre=prices[0];
        for (int i=1;i<l;i++) {        
            if (prices[i] > pre) {
                result+=prices[i]-pre;
            }
            pre=prices[i];
        }
        return result;
    }
    //reverse String inline
    public static void lc_reverseString(char[] s) {
        if ( s == null || s.length <=1) {
            System.out.println(Arrays.toString(s));
            return;
        }
        char tmp=s[0];
        int l=s.length;
        for (int i=0; i<l/2;i++) {
            tmp=s[l-1-i];
            s[l-1-i]=s[i];
            s[i]=tmp;
        }
        System.out.println(Arrays.toString(s));
        return;
    }
    public static int lc_singleNumber(int[] nums) {
        if (nums.length <=1)
            return nums[0];
        Arrays.sort(nums);
        if (nums[0] != nums[1]) {
            return nums[0];
        } 
        for (int i=1;i<nums.length-1;i++) {
            if (nums[i+1] != nums[i] && nums[i] != nums[i-1]) {
                return nums[i];
            }
        }
        if (nums[nums.length-1] != nums[nums.length-2]) {
            return nums[nums.length-1];
        }
        return -1;
    }

    public static List<String> lt_fizzBuzz(int n) {
        
        List<String>result=new ArrayList<>();
        
        for (int i=1;i<n+1;i++) {
            if ((i>=5) && (i%5==0) && (i%3==0)) {
                result.add("FizzBuzz");
            } else if ((i>=5) && i%5==0) {
                result.add("Buzz");
            } else if ((i >= 3) && i%3==0) {
                result.add("Fizz");
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }

    public static int lt_majorityElement(int[] nums) {
        if (nums.length ==1) {
            return nums[0];
        }
        Map<Integer, Integer>counts=new HashMap<>();
        for (Integer n:nums) {
            if (!counts.containsKey(n)) {
                counts.put(n, 1);
            } else {
                counts.put(n, counts.get(n)+1);
            }
        }
        Integer maxValue=Collections.max(counts.values());
        for (Map.Entry<Integer, Integer> entry: counts.entrySet()) {
            if (entry.getValue()==maxValue) {
                return entry.getKey().intValue();
            }
        }
        return -1;
    }

    public void lt_moveZeroes(int[] nums) {
        int l=nums.length;
        Stack<Integer> tmpStack=new Stack();
        int zcount=0;
        if (l>1) {
            for (int i=0;i<l;i++) {
                if (nums[i]!=0) {
                    tmpStack.push(nums[i]);
                } else {
                    zcount++;
                }
            }
            for (int i=l-1-zcount;i>=0;i--) {
                nums[i]=tmpStack.pop();
            }
            for (int i=l-1;i>l-1-zcount;i--) {
                nums[i]=0;
            }
        }
    } 

    public boolean lt_isAnagram(String s, String t) {
        
        int sl=s.length();
        int tl=t.length();
        
        if (sl==0 && tl==0) {
            return true;
        }
        if (sl != tl) {
            return false;
        }
        
         Map<String, Integer>tmps=new HashMap<>();
         Map<String, Integer>tmpt=new HashMap<>();
        
        for (int i=0;i<sl;i++) {
            
            if (t.indexOf(s.charAt(i)) == -1) {
                return false;
            }
            if (s.indexOf(t.charAt(i)) == -1) {
                return false;
            }
            
            String myKeys=String.valueOf(s.charAt(i));
            if (!tmps.containsKey(myKeys)) {
                tmps.put(myKeys, 1);
            } else {
                tmps.put(myKeys, tmps.get(myKeys)+1);
            }
            String myKeyt=String.valueOf(t.charAt(i));
            if (!tmpt.containsKey(myKeyt)) {
                tmpt.put(myKeyt, 1);
            } else {
                tmpt.put(myKeyt, tmpt.get(myKeyt)+1);
            }
        }
        
        
        if (tmps.equals(tmpt)) {
            return true;
        }
        return false;
        
      
    }

    public boolean lt_containsDuplicate(int[] nums) {
        if (nums == null || nums.length==0) {
            return false;
        }
        
        Set<Integer> dist=new HashSet<>();
        for (int num:nums) {
            if (dist.contains(num)) {
                return true;
            } else {
                dist.add(num);
            }
        }
        return false;
    }

    public int lt_romanToInt(String s) {
        
            if (s == null || s.length()==0) {
                return 0;
            }
            int l=s.length();
            int result=0;
        
            for (int i=0;i<l;i++) {
              
              switch (s.charAt(i)) {
                  case 'I':
                      if (i != l-1) {
                          
                        if ((s.charAt(i+1)=='V') || (s.charAt(i+1)=='X')) {
                          result-=1;
                        } else {
                          result+=1;
                        }
                      } else {
                         result+=1;
                      }
                      break;
                      
                  case 'V':
                      result+=5;
                      break;
                      
                  case 'X':
                     if (i != l-1) {
                         
                       if ((s.charAt(i+1)=='L') || (s.charAt(i+1)=='C')) {
                          result-=10;
                       } else {
                        result+=10;
                      }
                     } else {
                        result+=10;
                     }
                      break;
                  case 'L':
                      result+=50;
                      break;
                  case 'C':
                      if (i<l-1) {
                          
                        if ((s.charAt(i+1)=='D') || (s.charAt(i+1)=='M')) {
                          result-=100;
                        } else {
                          result+=100;
                        }
                      } else {   
                         result+=100;
                      }
                      break;
                  case 'D':
                      result+=500;
                      break;
                  case 'M':
                      result+=1000;
                      break;
            }
          }
          
          return result; 
    }

     public static int lt_titleToNumberExcel(String s) {
        if (s==null || s.length()==0) {
            return 0;
        }
        int l=s.length();
        int result=0;
        for (int i=0;i<l;i++) {
            int c=(s.toUpperCase()).charAt(i);
            result += Math.pow(26, l-i-1) *((c-64)%100);
         }
         return result;
    }

    public int lt_firstUniqChar(String s) {
        if (s == null || s.length()==0) {
            return -1;
        }
        int l=s.length();
        if (l==1) {
            return 0;
        }
        Map<Character, Integer>dic=new HashMap<>();
        for (int i=0;i<l;i++) {
            Character c = s.charAt(i);
            dic.put(c, dic.getOrDefault(c, 0)+1);
        }
        
        for (int i=0;i<l;i++) {
            if (dic.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
        
    }

    public static int lt_missingNumber(int[] nums) {
        if (nums == null || nums.length==0) {
            return -1;
        }
        
        int l=nums.length;
        if (l==1) {
            if (nums[0] != 0) {
                return 0;
            } else {
               return nums[0]+1;
            }
        }
        Arrays.sort(nums);
        for (int i=0;i<l-1;i++) {
            if (nums[i]+1 != nums[i+1]) {
                return nums[i]+1;
            }
        }
        if (nums[0] != 0) {
            return 0;
        } 
        return nums[l-1]+1;
    }

    public int[] lt_intersectII(int[] nums1, int[] nums2) {
        
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    int l1=nums1.length;
    int l2=nums2.length;
    int lmin=l1;
        
    if (l2 < l1) {
        lmin=l2;
    }
        
    List<Integer>resultl=new ArrayList<>();
    int [] result; 
    for (int i=0, j=0;i<nums1.length && j<nums2.length;) {
        
        if (nums1[i] < nums2[j]) {
            i++;
        } else if (nums1[i] > nums2[j]) {
            j++;
        } else {
            resultl.add(nums1[i]);
            i++;
            j++;
        }
    }
    int rl=resultl.size();
    result=new int[rl];
    for (int i=0;i<rl;i++) {
        result[i]=resultl.get(i);
    }
    return result;
 }

 public int[] lt_intersectIIb(int[] nums1, int[] nums2) {
        
    Map<Integer, Integer>existing=new HashMap<>();
        
    List<Integer>resultl=new ArrayList<>();
    int [] result; 
    
    for (int num1: nums1) {
        if (existing.containsKey(num1)) {
           existing.put(num1, existing.get(num1)+1);
        } else {
            existing.put(num1, 1);
        }
    }
        
    for (int num2:nums2) {
        
        if (existing.containsKey(num2) && existing.get(num2)>=1) {
            existing.put(num2, existing.get(num2)-1);
            resultl.add(num2);
        } 
    }
        
    int rl=resultl.size();
    result=new int[rl];
    for (int i=0;i<rl;i++) {
        result[i]=resultl.get(i);
    }
    return result;
 }
 public int lt_countPrimes(int n) {
        if (n<=2) {
            return 0;
        }
        int count=0;
        boolean [] primes = new boolean[n];
        
        for (int i=2;i<n;i++) {
            primes[i]=true;
        }
        
        for (int i=2;i<n;i++) {
            if (primes[i]) {
                for (int j=i+i;j<n;j+=i) {
                    primes[j]=false;
                }
            }
        }
        
        for (int i=2;i<primes.length;i++) {
            if (primes[i]) {
                count++;
            }
        }
        return count;
    }

    public int lt_mySqrtb(int x) {
       if (x==1 || x==0) return x;
       long result=x;
        
       while (result*result > x) {
           result=(result+x/result)/2;
       }
       return (int) result;
    }

    public static int lt_mySqrt2(int x) {
        return (int) Math.floor(Math.sqrt(x));
      
    }

    public static void rotate_array(int[] nums, int k) {
        int l=nums.length;
        
        if (l==1 && k>=l && k%l==0) {
            System.out.println(nums.toString());
            return;
        }
        
        int[]temp=new int[l];
        int k2=k%l;
        for (int i=0, j=0;i<l && j< l;i++) {
            if (i<k2) {
               temp[i]=nums[l-k2+i];
            } else {
               temp[i]=nums[j];
               j++;
            }
        }
        for (int i=0;i<l;i++) {
            nums[i]=temp[i];
        }
        
        System.out.println(nums.toString());
    }
    public int lt_strStr(String haystack, String needle) {
        
        if (needle == null || needle.length()==0) {
            return 0;
        }
        if (haystack == null || haystack.length()==0) {
            return -1;
        }
        return haystack.indexOf(needle);
        
    }

    public static String lt_longestCommonPrefix(String[] strs) {
       
        int neq=-1;
        if (strs == null) {
            return "";
        }
        if (strs.length==1) {
            return strs[0];
        }
        
        int minl=-1;
        for (int i=0;i<strs.length-1;i++) {
            if (strs[i] == null || strs[i].length() == 0) {
                return "";
            }
            if (minl==-1) {
                minl=strs[0].length();
            }
            if ( strs[i+1].length() < minl ) {
                minl=strs[i+1].length();
            }
        } 
        System.out.println("minl : " + minl);

        for (int i=0;i<minl;i++) {
           for (int j=0;j<strs.length-1;j++) {
             if (strs[j].charAt(i) != strs[j+1].charAt(i)) {
                 neq=i;
                 break;
              }
            }
            if (neq != -1) {
              return strs[0].substring(0, neq);
            }
         }
         if (neq == -1 && minl > 0) {
           return strs[0].substring(0, minl);
         } else {
             return "";
         }
    }

     public boolean lt_isPalindrome(String s) {
        if (s==null || s.length() <=1) {
            return true;
        }
        
        String s1=((s.trim()).toLowerCase()).replaceAll("[^a-z0-9]", "");
        int l=s1.length();
        for (int i=0;i<l;i++) {
            if (s1.charAt(i) != s1.charAt(l-1-i) ){
                return false;
            }
        }
        return true;
    }
    //long overflow
    public static int lt_trailingZeroes(int n) {

        if (n<=1) {
            return 0;
        }
        
        long result=1;
        for (int i=1;i<=n;i++) {
            result*=i;
        }
        System.out.println(result);
        String rs=String.valueOf(result);
        int l=rs.length();
        int count=0;
        for (int i=l-1;i>=0;i--) {
            if (rs.charAt(i)=='0') {
               count++;
            } else {
                return count;
            }
        }
        return count;
        
    }
    //referencing : https://zxi.mytechroad.com/blog/math/leetcode-172-factorial-trailing-zeroes/
    public int lt_trailingZeroe2(int n) {
       if (n<5) {
           return 0;
       }
    
       return n/5+lt_trailingZeroes(n/5);
    }


    public static int[] let_brutal_twoSum(int[] nums, int target) {
        
        int l=nums.length;
        
        int[]result=new int[2];
        for (int i=0;i<l;i++) {
            int second=target-nums[i];
            for (int j=i+1;j<l;j++) {
                if ( nums[j]==second && j != i) {
                    result[0]=i;
                    result[1]=j;
                    return result;
                }
            }
        }
        return null;
    }

     public static int[] lt_twoSumb(int[] nums, int target) {
        
       if (nums == null || nums.length<2) {
           return new int[]{0, 0};
       }
       Map<Integer, Integer>allNumbers=new HashMap<>();
       int l=nums.length;
        
       for (int i=0;i<l;i++) {
           if (!allNumbers.containsKey(nums[i])) {
               allNumbers.put(nums[i], i);
           }
           int second=target-nums[i];
           if (allNumbers.containsKey(second) && i != allNumbers.get(second)) {
               return new int[]{allNumbers.get(second), i};
           }
       }
       return new int[]{0,0};
    
    }
    public boolean lt_isValidParentheses(String s) {
        Stack<Character> result=new Stack();
        
        int l=s.length();
        if (l%2 != 0) {
            return false;
        }
        for (int i=0;i<l;i++) {
            if (s.charAt(i)=='{') {
                result.push(s.charAt(i));
            }
            else if (s.charAt(i) == '[')
                result.push(s.charAt(i));
                
            else if (s.charAt(i) == '(') {
                result.push(s.charAt(i));
                
            } else if (s.charAt(i)=='}') {
                    if (result.isEmpty()) {
                        return false;
                    }
                    if (result.pop() != '{') {
                        return false;
                    }
            } else if (s.charAt(i) == ']') {
                   if (result.isEmpty()){
                       return false;
                   }
                   if (result.pop() != '[') {
                       return false;
                   }
            } else if (s.charAt(i) == ')') {
                if (result.isEmpty()){
                    return false;
                }
                if (result.pop() != '(') {
                    return false;
                }
            }
        }
        if (!result.isEmpty()) {
            return false;
        }
        return true;
        
    }

    public int lt_searchInsert(int[] nums, int target) {
        if (nums==null) {
            return 0;
        }
        int l=nums.length;
        if (target <nums[0]) {
            return 0;
        }
        if (target > nums[l-1]) {
            return l;
        }
        
        int p=Arrays.binarySearch(nums, target);
        if (p>=0) {
            return p;
        } else {
          return -(p+1);
        }
    }

    public ListNode lt_mergeTwoLists(ListNode l1, ListNode l2) {
    
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode result=new ListNode(0);
        ListNode head=result;
        ListNode t1=l1;
        ListNode t2=l2;
        
        while (t1 != null && t2 != null) {
           if (t2.val <= t1.val) {
              result.next=t2;
              t2=t2.next;
           } else {
               result.next=t1;
               t1=t1.next;
           }
           result=result.next;
        }
        if (t1 != null) {
            result.next=t1;
        } 
        if (t2 != null) {
            result.next=t2;
        }
        return head.next;
    }
    public int lt_removeDuplicates(int[] nums) {
        if (nums==null || nums.length==0) {
            return 0;
        }
       int l=nums.length;
       if (l==1) {
           return 1;
       }
       Map<Integer, Integer>result=new HashMap<>();
       for (int i=0, j=0;i<nums.length;i++) {
           if (!result.keySet().contains(nums[i])) {
               result.put(nums[i], j);
               j++;
           } 
       }
       int i=0;
       for (Integer key:result.keySet()) {
           nums[result.get(key)]=key;
           i++;
       }
       return result.keySet().size();
        
    }

   

public int maxSubArray(int[] nums) {
    int result = nums[0];
    int[] sum =  new int[nums.length];
    sum[0] = nums[0];
 
    for(int i=1; i<nums.length; i++){
        sum[i] = Math.max(nums[i], sum[i-1] + nums[i]);
        result = Math.max(result, sum[i]);
    }
 
    return result;
}

public int maxSubArray2(int[] nums) {
    int result = nums[0];
    int sum = nums[0];
 
    for(int i=1; i<nums.length; i++){
        //sum + current vs current
        sum = Math.max(nums[i], sum + nums[i]);
        //previous sum vs current sum
        result = Math.max(result, sum);
    }
 
    return result;
}

public int lt_climbStairs(int n) {
        int[]result=new int[n];
        
        if (n==1){
            return 1;
        }
        if (n==2) {
            return 2;
        }
        
        int i=2;
        while (i<n) {
            result[0]=1;
            result[1]=2;
            result[i]=result[i-1]+result[i-2];
            i++;
        }
        return result[n-1];
    }

 public void lt_merge(int[] nums1, int m, int[] nums2, int n) {
        
        int l=m+n;
        List<Integer>resultl=new ArrayList<>(l);
        for (int i=0;i<m;i++) {
           resultl.add(nums1[i]);
        }
        for (int i=0;i<n;i++) {
           resultl.add(nums2[i]);
        }
    
        for (int i=0;i< resultl.size();i++) {
            nums1[i]=resultl.get(i).intValue();
        }
        Arrays.sort(nums1);
    }

    public boolean lt_isSymmetric(TreeNode root) {
        
        TreeNode result=root;
        
        if (result == null) {
            return true;
        }
        return lt_isSymmetric(result.left, result.right);
        
        
        
    }

    //https://www.programcreek.com/2014/03/leetcode-symmetric-tree-java/

    private boolean lt_isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
                return true;
         } else if (left == null || right == null) {
                return false;
        } else if (left.val != right.val) {
            return false;
        } 
        
        if (!lt_isSymmetric(left.left, right.right)) {
            return false;
        }
        if (!lt_isSymmetric(right.left, left.right)) {
            return false;
        }
        return true;
    }

    public boolean lt_hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return false;
        }
        ListNode slow=head;
        ListNode fast=head;
        
        while (slow != null && fast != null && fast.next != null) {
           slow=slow.next;
           fast=fast.next.next;
           if (fast == slow) {
               return true;
           }
        }
        return false;
    }
    public ListNode lt_deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next==null) {
            return head;
        }
       ListNode pre=head;
       ListNode current=head;
       ListNode newhead=pre;
       Map<Integer, Integer>count=new HashMap<>();
        
       while (current != null) {
            if (!count.containsKey(current.val)) {
                count.put(current.val, 1);
                pre=current;
            } else {
                pre.next=current.next;
            }
            current=current.next;
        }
        return newhead;
        
    }

    public int lt_lengthOfLastWord(String s) {
        String n=s.trim();
        if (n == null || n.length()==0) {
            return 0;
        }
        String[] splited=n.split(" ");
        int l=splited.length;
        return (splited[l-1].trim()).length();
        
    }

    public int[] lt_plusOne(int[] digits) {
        
        if (digits == null || digits.length==0) {
            return null;
        }
        int l=digits.length;
        
        Stack<Integer> temp=new Stack<>();
       
        int a=0, d=0;
        
        for (int i=l-1;i>=0;i--) {
            d=digits[i];
            if (i==l-1) {
                if (digits[i]+1>=10){
                    a=1;
                    d=digits[l-1]-10+1;
                } else {
                    a=0;
                    d=digits[l-1]+1;
                }
            } else {
                d=digits[i]+a;
                if (d>=10) {
                    a=1;
                    d=d-10;
                } else {
                    a=0;
                }
            }
            temp.push(d);
        }
        if (a==1) {
            temp.push(a);
        }
        int rl=temp.size();
        int[]result=new int[rl];
        
        for(int i=0;i<rl;i++) {
            result[i]=temp.pop();
        }
        return result;
       
    }
    public String lt_addBinary(String a, String b) {
        int carry=0;
        int al=a.trim().length();
        int bl=b.trim().length();
        
        if (a==null || a.length()==0) {
            return b;
        }
        if (b==null || b.length()==0) {
            return a;
        }
        Stack<Integer> as=new Stack<>();
        Stack<Integer> bs=new Stack<>();
        
        for (int i=0;i<al;i++) {
          as.push(Integer.parseInt(String.valueOf((a.trim()).charAt(i))));
        }
        for (int i=0;i<bl;i++) {
          bs.push(Integer.parseInt(String.valueOf((b.trim()).charAt(i))));
        }
        
        Integer d=0;
        StringBuilder resultb=new StringBuilder();
        while (as.size()!=0 || bs.size()!=0) {
            if (bs.size()==0) {
                d=carry+as.pop();
            } else if (as.size()==0) {
                d=carry+bs.pop();
            } else {
                d=carry+as.pop() + bs.pop();
            } 
            if (d>=2){
                carry=d/2;
                d=d%2;
            } else {
                carry=0;
            }
            resultb.append(String.valueOf(d));
        }
        if (carry==1) {
            resultb.append(String.valueOf(1));
        }
        
        return resultb.reverse().toString();
        
    }

    public boolean lt_isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q==null) {
            return true;
        }
        if ((p==null && q != null) || (q==null && p != null)) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
       
        if (p.val == q.val && p.left == null && p.right == null && q.left == null && q.right==null) {
            return true;
        }
        return lt_isSameTree(p.left, q.left) && lt_isSameTree(p.right, q.right);
        
    }

    public int lt_maxProfitI(int[] prices) {
       
        int l=prices.length;
        int profit=0;
        
        for (int i=0;i<l;i++) {
            for (int j=l-1;j>i;j--) {
              if (prices[j]-prices[i]>profit) {
                profit=prices[j]-prices[i];
              }
            }
        }
        return profit;
    }

    //https://www.programcreek.com/2013/01/leetcode-path-sum/
    
public boolean lt_hasPathSum(TreeNode root, int sum) {
        TreeNode n=root;
        if (n == null) {
            return false;
        }
      
        if (n.left == null && n.right == null) {
            return (n.val==sum);
        }
        return lt_hasPathSum(n.left, sum-n.val) || lt_hasPathSum(n.right, sum-n.val);
        
    }    
    
   public int lt_maxDepth(TreeNode root) {
       
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        
  
        return Math.max(1+lt_maxDepth(root.left), 1+lt_maxDepth(root.right));
        
    }
     public ListNode reverseList1(ListNode head) {
        ListNode rnode=null;
        ListNode pre=null;
        
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        
        while (head != null) {
            rnode=new ListNode(head.val, pre);
            pre=rnode;
            head=head.next;
        }
        return rnode; 
        
    }

     public void lt_deleteNode(ListNode node) {
        
        while (node != null && node.next != null) {
            node.val=node.next.val;
            if (node.next.next == null) {
                node.next=null;
            } else {
                node=node.next;
            }
        }
    }

     public boolean lt_isHappy(int n) {
        Set<Integer>result=new HashSet<>();
        
        while (!result.contains(n)) {
            result.add(n);
            n=sumHappy(n);
            if (n==1) {
                return true;
            }
        }
        return false;
    }
         
     int sumHappy(int n) {
        int s=0;
        while (n>0) {
             s+=(n%10)*(n%10);
             n=n/10;
        }
        return s;
    }
    //https://www.programcreek.com/2014/03/leetcode-house-robber-java/
    public int lt_rob(int[] nums) {
        
       
        if (nums == null || nums.length==0) {
            return 0;
        }
        int l=nums.length;
        if (l==1) {
            return nums[0];
        }
        if (l==2) {
            return nums[0]>nums[1]?nums[0]:nums[1];
        }
      
        int e=0;
        int o=0;
       
        
        for (int i=0;i<l;++i) {
                 
            if (i%2==0) { 
                e+=nums[i];
                e=e>o?e:o;
            } else {
               o+=nums[i];
               o=o>e?o:e;
            }
        }
        return (e>o?e:o);
       
    }
    public boolean lt_isPowerOfThree(int n) {
       if (n==0) {
           return false;
       }
       if (n==1 || n==3) {
           return true;
       }
       if (n%3 != 0) {
           return false;
       }
       return lt_isPowerOfThree(n/3);
        
    }

    public ListNode lt_getIntersectionNode(ListNode headA, ListNode headB) {
      
        if (headA == null || headB == null) {
            return null;
        }
        if (headA.next == null && headB.next == null) {
            if (headA == headB) {
                return headA;
            }
            return null;
        }
        ListNode nodeA=headA, nodeB=headB;
    
        while (nodeA != nodeB) {
            if (nodeA==null) {
                nodeA=headB;
            } else {
                nodeA=nodeA.next;
            }
        
            if (nodeB==null) {
                nodeB=headA;
            } else {
                nodeB=nodeB.next;
            }
        }
        return (nodeA == nodeB) ? nodeA:null;
        
    }

    public TreeNode lt_sortedArrayToBST(int[] num) {
		if (num.length == 0)
			return null;
 
		return lt_sortedArrayToBST(num, 0, num.length - 1);
	}
 
	public TreeNode lt_sortedArrayToBST(int[] num, int start, int end) {
		if (start > end)
			return null;
 
		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(num[mid]);
		root.left = lt_sortedArrayToBST(num, start, mid - 1);
		root.right = lt_sortedArrayToBST(num, mid + 1, end);
 
		return root;
	}

    public int lt_getSum(int a, int b) {
        while (b != 0) {
           int c= a&b;
           a=a^b;
           b=c<<1;
        }
        return a;
    }
    //in place exchange using a tmp variable
    public void lt_reverseString(char[] s) {
      if ( s != null && s.length != 0) {   
        char tmp=s[0];
        int l=s.length;
        for (int i=0; i<l/2;i++) {
            tmp=s[l-1-i];
            s[l-1-i]=s[i];
            s[i]=tmp;
        }
      }
    } 

    public static void main(String[] args) {
         
          printSubString();
          System.out.println(String.format("is palindrome : %s ", isPalindrome("124fg")));
          System.out.println(String.format("Is palindrome : %s ", isPalindrome("123321")));
          System.out.println(removeCharsFromString("agddfddd", 'd'));
          System.out.println(removeCharsFromString("ag", 'd'));
          
          System.out.println("my added up : " + printMyFibo(1));
          System.out.println("my added up : " + printMyFibo(2));
          System.out.println("my added up : " + printMyFibo(3));
          System.out.println("my added up : " + printMyFibo(4));
          System.out.println("my added up : " + printMyFibo(5));
          System.out.println("my added up : " + printMyFibo(6));
          System.out.println("my added up : " + printMyFibo(7));
          System.out.println("my added up : " + printMyFibo(8));
          System.out.println("my added up : " + printMyFibo(9));
          System.out.println("my added up : " + printMyFibo(10));

          System.out.println("my added up : " + printMyFiboR(1));
          System.out.println("my added up : " + printMyFiboR(2));
          System.out.println("my added up : " + printMyFiboR(3));
          System.out.println("my added up : " + printMyFiboR(4));
          System.out.println("my added up : " + printMyFiboR(5));
          System.out.println("my added up : " + printMyFiboR(6));
          System.out.println("my added up : " + printMyFiboR(7));
          System.out.println("my added up : " + printMyFiboR(8));
          System.out.println("my added up : " + printMyFiboR(9));
          System.out.println("my added up : " + printMyFiboR(10));

          int [] input1= {2, 7, 11, 15};
          int [] input2= {3, 3, 31, 15};
          int [] input3= {3, 3, 3, 3};

          System.out.println("test sum2 : ");
          int [] result1=leetSum2(input1, 17);
          int [] result2=leetSum2(input2, 9);
          int [] result3=leetSum2(input3, 6);

          System.out.println(result1[0] + " " + result1[1]);
          System.out.println(result2);
          System.out.println(result3[0] + " " + result3[1]);
          
          Integer [] resultb1=leetSum2b((new Integer[]{2, 7, 11, 15}), 17);
          System.out.println(resultb1[0] + " " + resultb1[1]);
         
          int [] resultc1=leetSum2c(input1, 17);
          System.out.println(resultb1[0] + " " + resultc1[1]);
          int [] resultc2=leetSum2c(input3, 6);
          System.out.println(resultb1[0] + " " + resultc2[1]);
          System.out.println(leetReverseInt(123));
          System.out.println(leetReverseInt(-123));
          System.out.println(leetReverseInt(120));
         
          System.out.println(leetReverseInt(1));
          System.out.println(leetReverseInt(-9));
          System.out.println(leetReverseInt(0));
          System.out.println(leetReverseInt(-10));
          System.out.println(leetReverseInt(10));
          System.out.println(leetReverseIntb(-9));
          System.out.println(leetReverseIntb(0));
          System.out.println(leetReverseIntb(-10));
          System.out.println(leetReverseIntb(10));

          System.out.println(leetReverseIntb(123));
          System.out.println(leetReverseIntb(-123));
          System.out.println(leetReverseIntb(120));

          System.out.println(leetBuddyString("ab", "ba"));
          System.out.println(leetBuddyString("ba", "ba"));
          System.out.println(leetBuddyString("aa", "aa"));
          System.out.println(leetBuddyString("", "aa"));
          System.out.println(leetBuddyString("aaaaaaaabc", "baaaaaaaac"));
          System.out.println("is perfect : "+leetIsPerfect(28));
          System.out.println("is valid parentheses : " + leetIsValidParentheses("()"));
          System.out.println("is valid parentheses : " + leetIsValidParentheses("({})[]"));
          System.out.println("is valid parentheses : " + leetIsValidParentheses("({)"));
          System.out.println("is valid parentheses : " + leetIsValidParentheses("][()"));
          int [] input=new int[]{2, 3, 5, 1, 3};
          System.out.println("can it be max : "+ Arrays.toString(leetKidsMaxCandies(input, 3)));
          String [] inputs=new String[]{"flower", "flow", "flight"};
          System.out.println(leetLongestCommonP(inputs));
          inputs=new String[]{"lower", "flow", "light"};
          System.out.println(leetLongestCommonP(inputs));
          int [] myinput1=new int[]{2, 6, 4,8, 10, 9, 15};

          System.out.println(leetShortedUnsortedCSub(myinput1));
          myinput1=new int[]{2, 4, 6,8, 9, 10, 15};
          System.out.println(leetShortedUnsortedCSub(myinput1));
          myinput1=new int[]{9, 4, 6,8, 9, 10, 1};
          System.out.println(leetShortedUnsortedCSub(myinput1));
          
          myinput1=new int[]{2, 6, 4,8, 10, 9, 15};
          System.out.println(leetShortedUnsortedCSub2(myinput1));
          myinput1=new int[]{2, 4, 6,8, 9, 10, 15};
          System.out.println(leetShortedUnsortedCSub2(myinput1));
          myinput1=new int[]{9, 4, 6,8, 9, 10, 1};
          System.out.println(leetShortedUnsortedCSub2(myinput1));

          String[]input5=new String[]{"aaa", "aa", "aaa"};
          System.out.println(lt_longestCommonPrefix(input5));
          System.out.println(lt_trailingZeroes(5));
          System.out.println(lt_trailingZeroes(13));
          System.out.println(lt_trailingZeroes(30));
        
          int[]input6=new int[]{3, 2, 4};
          System.out.println(lt_twoSumb(input6, 6));

    }

}
    