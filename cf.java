    import java.util.*;
    public class cf {
    public static class Node {
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();  // Number of nodes

            // Create the head node and initialize the list
            Node head = new Node(sc.nextInt());  // First node
            Node current = head;  // Keep track of the current node for building the list

            // Input values for the rest of the nodes
            for (int i = 1; i < n; i++) {
                current.next = new Node(sc.nextInt());
                current = current.next;  // Move to the next node
            }

            // Reverse the list and store the new head
            Node reversedHead = reverseList(head);

            // Output the reversed list
            current = reversedHead;
            while (current != null) {
                System.out.print(current.val + " ");
                current = current.next;
            }
        }

        public static Node reverseList(Node head) {
            // Stack to store the node values
            Node prev = null;
            Node next = null;
            // set current pointer to the head node
            Node curr = head;
            // while the current pointer is not NULL
            while (curr != null) {
                // set the next pointer to the next node in the list
                next = curr.next;
                // reverse the current node's pointer to point to the previous node
                curr.next = prev;
                // set the previous pointer to the current node
                prev = curr;
                // move the current pointer to the next node
                curr = next;
            }
            // set the head pointer to the last node, which is the 
            // new first node after
            // reversal
            head = prev;
            return head;
        }
    }
