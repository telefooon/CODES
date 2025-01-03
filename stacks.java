import java.util.*;

public class stacks {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Stack {
        static Node head = null;

        public static boolean isEmpty() {
            return head == null;
        }

        public static void push(int data) {
            Node newnode = new Node(data);
            if (isEmpty()) {
                head = newnode;
                return;
            }
            newnode.next = head;
            head = newnode;
        }

        public static int pop() {
            if (isEmpty()) {
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }

        public static int peek() {
            if (isEmpty()) {
                return -1;
            }
            return head.data;
        }
    }
    public static String  reversestring(String str){
        Stack<Character> s= new  Stack<>();
        int idx=0;
        while(idx<str.length()){
          s.push(str.charAt(idx));
          idx ++;  
        }
        StringBuilder result=new Stringbuilder(""); 
        while(!s.isEmpty()){ //character to bahar nikalenge stack se fir stringbuilder mai daalenge
            char curr=s.pop();
            result.append(curr);
    }
    return result.toString();
}
    public static void main(String args[]){
        // Stack<Integer> s=new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // pushbottom(s,4);
        // while(!s.isEmpty()){
        //     System.out.println(s.pop());
        String str="abc";
        String result=reversestring(str);
        System.out.println(result);
            

        }
    }
