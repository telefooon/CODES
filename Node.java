import java.util.*;
public class Node{
    Node next = null;
    Node prev = null;
    int val;
    Node(Node next, Node prev, int val){
        this.next = next;
        this.prev = prev;
        this.val = val;
    }
    Node(int val) {
        this.val = val;
    }
}
public class cf{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node head = new Node();

        while(head != null){
            head.val = sc.nextInt();
            head = head.next;
        }
    }
}