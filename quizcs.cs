 
using System;
using System.Linq;

namespace myapp
{
  class Program 
  {
    //remove duplicates
    public static int[] removeDouble(int[] input) {
      return input.Distinct().ToArray();
    }
    public static int sum_up(int[] input) {
      return input.Sum();
    }

    public static int sum_up2(int[] input) {
      int result=0;
      Array.ForEach(input, delegate(int x) {result +=x;});
      return result;
    }
    public static int sum_up3(int[] input) {
      return input.Aggregate((result,x) => result+x);
    }

     public static void Main(string[] argv) {
       int [] input={1, 5, 4, 3, 4, 1};
       Console.WriteLine(string.Join("", removeDouble(input)));
       Console.WriteLine(sum_up(input));
       Console.WriteLine(sum_up2(input));
       Console.WriteLine(sum_up3(input));
   }
 }
}