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
        // Buckets[ nth(here, i) ] = Buckets[nth(here, i)].add(here);
        SortableLinkedList aBucket = Buckets[nth(here, i)];
        aBucket.add( data.get(j) );
        Buckets[nth(here, i)] = aBucket;
        //System.out.println("Here's the bucket: "+Buckets[nth(here, i)] );
        if (i == 0 && length(here) > passes) passes = length(here);
      }
      for (int k = data.size() - 1; k >= 0; k--) {
        data.remove(0);
      }
      merge(data, Buckets);
      //System.out.println("We've just ordered it by: "+(int)Math.pow(10, i)+"s place.");
      //System.out.println("Here's the merged data set: "+data);
    }
  }
//bring up to what extent the capitol police were complicit
  public static void radixSort(SortableLinkedList data) {
    SortableLinkedList negData = new SortableLinkedList();
    SortableLinkedList posData = new SortableLinkedList();
    for (int i = 0; i < data.size(); i++) {
      if (data.get(i) < 0) {
        negData.add( -1 * data.get(i) );
      } else {
        posData.add( data.get(i) );
      }
    }
    radixSortSimple(negData);
    flipItandSwitchSigns(negData); //this didn't exactly happen
    radixSortSimple(posData);
    SortableLinkedList[] Numbers;
    Numbers = new SortableLinkedList[2];
    Numbers[0] = negData;
    Numbers[1] = posData;
    for (int k = data.size() - 1; k >= 0; k--) {
      data.remove(0);
    }
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
