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

  public static void merge(SortableLinkedList original, SortableLinkedList[] buckets) {
    for (int i = 0; i < buckets.length; i++) {
      original.extend(buckets[i]);
    }
  }

//all of the above are constant time

  public static void radixSortSimple(SortableLinkedList data) {
    int passes = 1;
    int setSize = data.size();
    System.out.println();
    for (int i = 0; i < passes; i++) { //O(1) kinda?
      SortableLinkedList[] Buckets;
      Buckets = new SortableLinkedList[10];
      for (int m = 0; m < 10; m++) { // O(1)
        SortableLinkedList temp = new SortableLinkedList();
        Buckets[m] = temp;
      }
      for (int j = 0; j < setSize; j++) { //O(N)
        int here = data.get(0).intValue();
        SortableLinkedList aBucket = Buckets[nth(here, i)];
        aBucket.add( data.get(0) );
        Buckets[nth(here, i)] = aBucket;
        if (i == 0 && length(here) > passes) passes = length(here);
        data.remove(0);
      }
      merge(data, Buckets); //O(1)
    }
  }

  public static void radixSort(SortableLinkedList data) { //this sh*t is way past O(N)
    SortableLinkedList negData = new SortableLinkedList();
    SortableLinkedList posData = new SortableLinkedList();
    int setSize = data.size();
    for (int i = 0; i < setSize; i++) { //
      if (data.get(0) < 0) {
        negData.add( -1 * data.get(0) );
      } else {
        posData.add( data.get(0) );
      }
      data.remove(0);
    }
    radixSortSimple(negData); // O(N)
    flipItandSwitchSigns(negData);
    radixSortSimple(posData); // O(N)
    SortableLinkedList[] Numbers;
    Numbers = new SortableLinkedList[2];
    Numbers[0] = negData;
    Numbers[1] = posData;
    merge(data, Numbers);
  }

  private static void flipItandSwitchSigns(SortableLinkedList data) {
    SortableLinkedList temp = new SortableLinkedList();
    for (int i = 0; i < data.size(); i++) {
      temp.add(data.get(i));
    }
    for (int i = 0; i < temp.size(); i++) {
      Integer x = temp.get(temp.size() - i - 1);
      data.set( i , -1*x );
    }
  }



////
}
