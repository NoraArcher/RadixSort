//with negative numbers can you sort them as negstive digits?? so an array of 19 digits (-9 to 9)
//or just ignore negs for now ???
import java.lang.Math.*;
public class Radix {

  public static int nth(int n, int col) {
    if (n < 0) n = -1 * n;
    int x = (int)( n / Math.pow(10, col) );
    return (x % 10);
  }

  public static int length(int n) {
    if (n < 0) n = -1 * n;
    String word = n + "";
    return word.length();
  }

  public static void merge(MyLinkedList original, MyLinkedList[] buckets) {
    for (int i = 0; i < buckets.length; i++) {
      original.extend(buckets[i]);
    }
  }



////
}
