public class DriverRadix {
  public static void main(String[] args) {

    for (String num : args) {
      int n = Integer.parseInt(num);
      System.out.println("Number is: "+num+", and length is: "+Radix.length(n));
      System.out.println("Ones place: "+Radix.nth(n, 0)+", Tens place: "+Radix.nth(n, 1)+", and Hundreds place: "+Radix.nth(n, 2));
      System.out.println();
    }

    MyLinkedList gouda = new MyLinkedList(); //gouda.add("cheese");
    MyLinkedList zer0 = new MyLinkedList(); MyLinkedList on1e = new MyLinkedList();
    zer0.add("50"); zer0.add("340");  zer0.add("0");
    on1e.add("-1"); on1e.add("71");  on1e.add("-891");
    MyLinkedList tw02 = new MyLinkedList(); MyLinkedList thre3 = new MyLinkedList();
    thre3.add("5333"); thre3.add("43");  thre3.add("03");

    MyLinkedList[] Buckets;
    Buckets = new MyLinkedList[4];
    Buckets[0] = zer0;  Buckets[1] = on1e;  Buckets[2] = tw02; Buckets[3] = thre3;
    Radix.merge(gouda, Buckets);
    System.out.println();
    System.out.println("Merger: "+gouda);
    for (int i = 0; i < Buckets.length; i++) {
      System.out.println("What remains in the buckets: "+Buckets[i]);
    }


  }
}
