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

  public static void radixSortSimple(SortableLinkedList data) {
    int passes = 1;
    System.out.println();
    for (int i = 0; i < passes; i++) {
      SortableLinkedList[] Buckets;
      Buckets = new SortableLinkedList[10];
      for (int m = 0; m < 10; m++) {
        SortableLinkedList temp = new SortableLinkedList();
        Buckets[m] = temp;
      }
      for (int j = 0; j < data.size(); j++) {
        int here = data.get(j).intValue();
        // System.out.println("Number to be sorted: "+here);
        // System.out.println("Looking at the "+(int)Math.pow(10, i)+"s place.");
        // System.out.println("The appropriate bucket: "+nth(here, i));
        //Buckets[ nth(here, i) ] = Buckets[nth(here, i)].add(here);
        SortableLinkedList aBucket = Buckets[nth(here, i)];
        aBucket.add( data.get(j) );
        Buckets[nth(here, i)] = aBucket;
        //System.out.println("Here's the bucket: "+Buckets[nth(here, i)] );
        if (i == 0 && length(here) > passes) passes = length(here);
      }
      SortableLinkedList empty = new SortableLinkedList();
      merge(empty, Buckets);
      data = empty; //i can't do this, but if i loop backwards above and remove from data, the bucket sorting wont be in order
      //merge(data, Buckets)
      System.out.println("We've just ordered it by: "+(int)Math.pow(10, i)+"s place.");
      System.out.println("Here's the merged data set: "+data);
    }
  }

  public static void radixSort(SortableLinkedList data) {
    //allow for negatives :{, DEFINITELY call the mrthod above
    // SortableLinkedList negData, put this in simple sort as positive (do this while you're dividing the total data set), then flip and re-neg
    // SortableLinkedList posData, put this in simple sort
    // SortableLinkedList[] Positives;
    // Positives = new SortableLinkedList[1];
    // Positives[0] = posData;
    // merge(negData, Positives);
    // data = negData;
  }

  private static SortableLinkedList flipIt(SortableLinkedList data) {
    return data;
  }

  private static void clear(SortableLinkedList data) {
    SortableLinkedList temp = new SortableLinkedList();
    data = temp; //this just... has no effect when called
  }



////
}
