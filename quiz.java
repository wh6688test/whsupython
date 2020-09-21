//import java.util.stream.Stream;
import java.util.stream.IntStream;
import java.util.Arrays;
import java.util.function.BiFunction;

public class quiz {

    public quiz () {
    }
    //remove duplicate numbers, java8
    public  static int [] removeDup8(int [] arr) {
          return IntStream.of(arr).distinct().toArray();
    }
    public static BiFunction<Integer, Integer, Integer>mysum2=(a, b) -> a+b;

    public static int sumMultiple(int[] input) {
       return IntStream.of(input).sum();

     }

    public static void main(String[] argv) {
       System.out.println(Arrays.toString(removeDup8(new int[] {1,2, 3, 2, 3, 1})));

       //binary and unary operators in java using FP
       System.out.println(mysum2.apply(2,3));
       //sum and then squreroot
       System.out.println(mysum2.andThen(Math::sqrt).apply(3, 2));
       System.out.println(sumMultiple(new int[]{1, 2, 3, 4}));
    }


}