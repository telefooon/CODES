import java.util.*;

public class queue {
    // stack using 2 queue
    static class stack{
        static Queue<Integer> q1= new LinkedList<>();
        static Queue<Integer> q2= new LinkedList<>();
        
    public static boolean isEmpty(){
        return q1.isEmpty() && q2.isEmpty();
        }

        public static void push(int data){
            if(!q1.isEmpty()){
                q1.add(data);
            }
            else{
                q2.add(data);
            }
        }

     }
     public static void interleave(Queue<Integer> q){
        Queue<Integer> q1= new LinkedList<>();
        int size=q.size();
        for(int i=0;i<size/2;i++){
            q1.add(q.remove());
            
        }
        while(!q1.isEmpty()){
                q.add(q1.remove());
                q.add(q.remove());

            }
       
     }
     public static void reverse(Queue<Integer> q){
        Stack<Integer> s= new Stack<>();
        while(!q.isEmpty()){
            s.push(q.remove());
        }
        while(!s.isEmpty()){
            q.add(s.pop());
        }

     }
       

        public static void nonrepeating(String str){ //O(n)
            int freq[]= new int[26];
            Queue<Character> q= new LinkedList<>();
            for(int i=0;i<str.length();i++){
                char curr=str.charAt(i);
                q.add(curr);
                freq[curr-'a']++;
                while(!q.isEmpty()&& freq[q.peek()-'a']>1){
                    q.remove();
                }
                if(q.isEmpty()){
                  System.out.print(-1+" ");
                }
                else{
                    System.out.print(q.peek()+" "); // q ke front parr non-repeating character hai and print it
                }

            }
                
        }
        
        
        
    


    public static void main(String[] args) {
        String str;
        str="aabccxb";
        // nonrepeating(str);
          Queue<Integer> q= new LinkedList<>();
          q.add(1);
          q.add(2);
          q.add(3);
          q.add(4);
          q.add(5);
          q.add(6);
          q.add(7);
          q.add(8);
          q.add(9);
          q.add(10);
          reverse(q);
          while(!q.isEmpty()){
            System.out.print(q.remove()+" ");
          }




        // queuee q = new queuee();
        // queueue q= new queueue();
        // stack s= new stack();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // while (!q.isEmpty()) {
        //     System.out.println(q.peek());
        //     q.remove();
        // }
    }

}
//  
           //queue using two stacks
//  static Stack<Integer> s1=  new Stack<>();
//         static Stack<Integer> s2=  new Stack<>();


//     public static boolean isEmpty(){
//         return s1.isEmpty();
//     }
//     public static void add(int data){
//         while(!s1.isEmpty()){
//             s2.push(s1.pop());
//         }
//         s1.push(data);
//         while(!s2.isEmpty()){
//             s1.push(s2.pop());
//         }
        
//     }
//     public static int remove(){
//         if(s1.isEmpty()){
//             System.out.println("queue is empty");

//         return -1;
//         }
//         return s1.pop();
//     }
//     public static int peek(){
//          if(s1.isEmpty()){
//             System.out.println("queue is empty");

//         return -1;
//         }

//         return s1.peek();

//     }


    // static class Node {
    //     int data;
    //     Node next;
    //     Node(int data){
    //         this.data = data;
    //         this.next = null;
    //     }
    // }

    // static class queuee {
    //     static Node head = null;
    //     static Node tail = null;

    //     public static boolean isEmpty() {
    //         return head == null && tail == null;
    //     }

    //     public static void add(int data) {
    //         Node newnode = new Node(data);
    //         if (head == null) {
    //             head = tail = newnode;
    //             return;
    //         }
    //         tail.next = newnode;
    //         tail = newnode;
    //     }

    //     public static int remove() {
    //         if (isEmpty()) {
    //             System.out.println("Queue is empty");
    //             return -1;
    //         }
    //         int front = head.data;
    //         if (tail == head) {
    //             head = tail = null;
    //         } else {
    //             head = head.next;
    //         }
    //         return front;
    //     }

    //     public static int peek() {
    //         if (isEmpty()) {
    //             System.out.println("Empty queue");
    //             return -1;
    //         }
    //         return head.data;
    //     }
    // }
