public class DriverRadix {
  public static void main(String[] args) {

    // for (String num : args) {
    //   int n = Integer.parseInt(num);
    //   System.out.println("Number is: "+num+", and length is: "+Radix.length(n));
    //   System.out.println("Ones place: "+Radix.nth(n, 0)+", Tens place: "+Radix.nth(n, 1)+", and Hundreds place: "+Radix.nth(n, 2));
    //   System.out.println();
    // }
    //
    // SortableLinkedList gouda = new SortableLinkedList(); //gouda.add("cheese");
    // SortableLinkedList zer0 = new SortableLinkedList(); SortableLinkedList on1e = new SortableLinkedList();
    // zer0.add(50); zer0.add(340);  zer0.add(0);
    // on1e.add(-1); on1e.add(71);  on1e.add(-891);
    // SortableLinkedList tw02 = new SortableLinkedList(); SortableLinkedList thre3 = new SortableLinkedList();
    // thre3.add(5333); thre3.add(43);  thre3.add(03);
    //
    // SortableLinkedList[] Buckets;
    // Buckets = new SortableLinkedList[4];
    // Buckets[0] = zer0;  Buckets[1] = on1e;  Buckets[2] = tw02; Buckets[3] = thre3;
    // Radix.merge(gouda, Buckets);
    // System.out.println();
    // System.out.println("Merger: "+gouda);
    // for (int i = 0; i < Buckets.length; i++) {
    //   System.out.println("What remains in the buckets: "+Buckets[i]);
    // }

    SortableLinkedList input = new SortableLinkedList();
    for (String num : args) {
      int n = Integer.parseInt(num);
      input.add(n);
    }
    System.out.println();
    System.out.println("Unsorted: "+input+" "+input.size());
    Radix.radixSortSimple(input);
    System.out.println("\nSorted: "+input+" "+input.size());




  }
}
