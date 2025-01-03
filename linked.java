public class Linked {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;//by default initializes at 0

    public void add_first(int data) {
        Node newnode = new Node(data); // create a new node
        size++;

        if (head == null) {
            head = tail = newnode; // Set head and tail to the new node if the list is empty
            return;
        }
        newnode.next = head;
        head = newnode;
    }

    public void add_last(int data) {
        Node newnode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newnode; // Set head and tail to the new node if the list is empty
            return;
        }

        tail.next = newnode;
        tail = newnode;
    }

    public void printlist() {
        if (head == null) {
            System.out.println("Empty linked list");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
    public void insert_index(int data, int n){
        Node temp = new Node(data);
         Node newnode = new Node(data);
        if (head == null) {
            head = tail = newnode; // Set head and tail to the new node if the list is empty
            return;
        }
        temp=head;
        int i=0;
        while(i<n-1){
            temp=temp.next;
            i++;
        }
        newnode.next=temp.next;
        temp.next=newnode;


    }
    public int remove_first(){
        
         int val=head.data;
         head=head.next;
         return val;
}
    public int remove_last(){
        if(size==0){
            System.out.println("empty list");
            return Integer.MIN_VALUE;
        }
        else if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }
    Node prev=head;
    for(int i=0;i<size-2;i++){
        prev=prev.next;
    }

   
int val=prev.next.data;
    prev.next=null;
tail=prev;
size--;
return val;
    }
    public  int itrsearch(int key){ //O(n)
        Node temp=head;
        int i=0;
        while(temp!=null){
            if(temp.data==key){
                return i;
            }
            else{
                temp=temp.next;
                i++;
            }
        }
        return -1;

   }
   public static int helper(Node head, int key){
    if(head==null){
        return -1;
    }
    if(head.data==key){ // as the head will shift with each call , the head sitting at the key will have index as 0
        return 0;
    }
    int idx=helper(head.next, key);
    if(idx==-1){
        return -1;
    }
    return idx+1;
   }

   public int recusearch(int key){
   return helper(head, key);
   }
   public void reverse(){
    Node prev=null;
    Node curr=tail=head;
    Node next;
    while(curr!=null){
        next=curr.next;
        curr.next=prev;
        prev=curr;
        curr=next;

    }
    head=prev;
   }
   public void removenth(int nth){
    //size calculation
    int sz=1;
    Node temp=head;
    while(temp!=null){
        temp=temp.next;
        sz++;
    }
    if(nth==sz){
        head=head.next;//remove head
        return;
    }
    Node prev;
    int i=1;//indexing
    int findindex=sz-nth;
    prev=head;      
    while(i<findindex){
        prev=prev.next;
        i++;
    }
    prev.next=prev.next.next;
    return;
     }
     public Node findmid(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;//slow +1
            fast=fast.next.next;//fast +2
        }
        return slow;//middle node
 }
   public boolean palindrome(){
    if(head==null||head.next==null){
        return true;
    }
    //step-1 find mid
    Node midnode=findmid(head);
    //step-2 reverse
    Node prev=null;
    Node curr=midnode;
    Node next;
    while(curr!=null){
        next=curr.next;
        curr.next=prev;
        prev=curr;
        curr=next;
}
Node right=prev;//head of the right half
Node left=head;
//step-2 check left and right half
while(right!=null){
    if(left.data!=right.data){
        return false;
    }
    left=left.next;
    right=right.next;
}
return true;
   }

   public static boolean iscycle(){
    Node slow=head;
    Node fast=head;
    while(fast!=null&& fast.next!=null){
        slow=slow.next;
        fast=fast.next.next;
        if(slow==fast){
            return true;
        }
    }
    return false;
   }
   public static void removecycle(){
    Node fast=head;
    Node slow=head;
    boolean exists=false;
  
    
    while(fast!=null&& fast.next!=null){
        slow=slow.next;
        fast=fast.next.next;
        if(slow==fast){
            exists=true;
            break;

        }

    }
    if(exists==false){
        System.out.println("doesnt exist go fuck your self");
    }
   
        slow=head;
          Node prev=null; // will be pointing to second last node after iterations
          //find meeting point
        while(slow!=fast){
            prev=fast;
            slow=slow.next;
            fast=fast.next;
        }
       
            
            //deletings last node
            prev.next=null;
   }
   private Node getmid(Node head){
    Node slow=head;
    Node fast=head.next;
    while(fast!=null && fast.next!=null){
        slow=slow.next;
        fast=fast.next.next;
    }
    return slow; //mid


   }
   private Node merge(Node head1 , Node head2){
    Node mergNode= new Node(-1);
    Node temp=mergNode; 
    while(head1!=null && head2!=null){
        if(head1.data<head2.data2){
            temp.next=head1;
            head1=head1.next;
            temp=temp.next;
        }
        else{
            temp.next=head2;
            head2=head2.next;
             temp=temp.next;
        }
    }
    while(head1!=null){
        temp.next=head1;
         head1=head1.next;
            temp=temp.next;
    }
    while(head2!=null){
         temp.next=head2;
            head2=head2.next;
             temp=temp.next;

    }
    return mergNode.next; // to remove -1 stored at the beginning
   }
   public Node mergesort(Node head){
    if(head==null||head.next==null){
        return head;
    }
    //find mid
    Node mid=getmid(head);
    //call for left and right half
    Node righthead=mid.next; //right half ka head mid ka next
    mid=null;
    Node newlefthead;

    newlefthead=mergesort(head); //for left half
    Node newrighthead;
   newrighthead= mergesort(righthead);
    return merge(lefthead,newrighthead);

   } 
    public static void main(String[] args) {
        // Linked link = new Linked();
        // link.add_last(1);
        // link.add_last(2);
        // link.add_last(2);
       // link.add_last(1);
        // // link.printlist();
        // // link.remove_last();
        // // link.printlist();
        // // System.out.println( link.recusearch(5));
        // System.out.println(link.palindrome());

        head=new Node(1);//creating a cycle link
        
        Node temp=new Node(2);
        head.next=temp;
        head.next.next=new Node(3);
        head.next.next.next=temp;
      System.out.println(iscycle());
removecycle();
System.out.println(iscycle());

        
        
        
       
    }
}

