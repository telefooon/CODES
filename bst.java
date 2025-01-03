import java.util.*;
public class bst{
    static class Node{
        int data;
        Node left;// by deault null
        Node right;// by default null
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public static void preorder(Node root){
                    if(root==null){
                       
        
                        return ;
                    }
                    System.out.print(" "+root.data);
                    preorder(root.left);
                    preorder(root.right);
                }
    public static Node insert(Node root, int val){// build a bst
        if(root==null){
            root= new Node(val);
            return root;
        }
        if(root.data>val){
            // left subtree
            root.left=insert(root.left, val);
        }
        else{
           root.right= insert(root.right, val);
        }
        return root;

    }
    public static void inorder(Node root){
        if(root==null){
            return ;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static boolean search(Node root, int key){
        if(root==null){
            return false;
        }
        if(key==root.data){
            return true;
        }
        if(root.data>key){
             return search(root.left, key);

        }
        else{
            return search(root.right, key);
        }
        
    }
    public static Node delete(Node root, int val){
        if(root.data<val){

            root.right=delete(root.right, val);
        }
        else if(root.data>val){
          root.left=  delete(root.left, val);
        }
        else{
            //case-1(leaf node)
            if(root.left==null&& root.right==null){// condition for leaf node
                return null;
            }
            //case-2 single child 
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            //case-3 both children  

            Node IS=findinordersuccessor(root.right);
            root.data=IS.data;
            root.right=delete(root.right, IS.data);

        }
        return root;
        
    }
    public static Node findinordersuccessor(Node root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
    public static void printrange(Node root, int k1, int k2){
        if(root==null){
            return ;
        }
        //case-1
        if(k1<=root.data && root.data<=k2){
            printrange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printrange(root.right, k1, k2);
        }
        else if(root.data>k2){
            printrange(root.right, k1, k2);
        }
        else{
            printrange(root.left, k1, k2);
        }
    }
    public static void printpathh(ArrayList<Integer> path){
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i)+"->");
        }
        System.out.println("null");
    }

    public static void printpath(Node root, ArrayList<Integer> path){
        if(root==null){
            return ;
        }
        
        path.add(root.data);
        if(root.left==null && root.right==null){
            printpathh(path);
        }
        printpath(root.left, path);
        printpath(root.right, path);
        path.remove(path.size()-1);
        return;
    }
    public static boolean validbst(Node root, Node min, Node max){
        if(root==null){
            return true;
        } // conditions for a valid bst
        if ((min != null && root.data <= min.data) || (max != null && root.data >= max.data)) {
            return false;
        }
        return validbst(root.left, min, root) && validbst(root.right, root, max);

    }
    public static Node mirror(Node root){
        if(root == null){
            return null;
        }
       Node rightmirrorm=mirror(root.right);
       Node leftmirror=mirror(root.left);
       root.left=rightmirrorm;
       root.right=leftmirror;
       return root;
    }
    public static Node createbst(int arr[], int start, int end){
        if(start>end){
            return null;
        }
        int mid=(start+end)/2;
        Node root= new Node(arr[mid]);
         root.left=createbst(arr, start, mid-1);
         root.right=createbst(arr, mid+1, end);
        return root;
    }
     public static Node createbst1(ArrayList<Integer> inorder, int start, int end){
        if(start>end){
            return null;
        }
        int mid=(start+end)/2;
        Node root= new Node(inorder.get(mid));
         root.left=createbst1(inorder, start, mid-1);
         root.right=createbst1(inorder, mid+1, end);
        return root;
    }
    public static void createinorder(Node root, ArrayList<Integer> inorder){
        if(root==null){
            return;
        }
        createinorder(root.left, inorder);
        inorder.add(root.data);
        createinorder(root.right, inorder);
    }
    public static Node createBST(Node root){
        // create a inorder BST
        ArrayList<Integer> inorder= new ArrayList<>();
        createinorder(root, inorder);
        // sorted inorder-> balanced BST
        root=createbst1(inorder,0,inorder.size()-1);
        return root;
    }
     public static  Node mergeBST(Node root1, Node root2){
        ArrayList<Integer> arr1= new ArrayList<>();
        createinorder(root1,arr1);
        ArrayList<Integer> arr2= new ArrayList<>();
        createinorder(root2,arr2);

        ArrayList<Integer> Final= new ArrayList<>();
        int i=0,j=0;
        while(i<arr1.size()&& j<arr2.size()){
            if(arr1.get(i)<=arr2.get(j)){
                Final.add(arr1.get(i));
                i++;
            }
            else{
                Final.add(arr2.get(j));
                j++;
            }
        }
        while(i<arr1.size()){
            Final.add(arr1.get(i));
                i++;

        }
        while(j<arr2.size()){
            Final.add(arr2.get(j));
                j++;
        }
        return createbst1(Final, 0, Final.size()-1);
        
    }
    static class information{
        boolean isbst;
        int size;
        int min; 
        int max;
        public information(boolean isbst,int size,int min,int max){
            this.isbst=isbst;
            this.size=size;
            this.min=min;
            this.max=max;
        }

    }
    static int maxsize=0;
    public static information largestbst(Node root){
        if(root==null){
            return new information(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        information infoRight=largestbst(root.right);
        information infoLeft=largestbst(root.left);
        int size= infoRight.size+infoLeft.size+1;
        int min= Math.min(root.data,Math.min(infoLeft.min, infoRight.min));
        int max= Math.max(root.data,Math.max(infoLeft.max,infoRight.max));
        if ((root.data <= infoLeft.max) || (root.data >= infoRight.min)) {
            return new information(false, size, min, max);
        }
        if(infoLeft.isbst&& infoRight.isbst){
            maxsize=Math.max(maxsize,size);
         return   new information(true, size, min, max);
        }

        return new information(false, size, min, max);

    }
   
    public static void main(String[] args) {
        

        Node root1= new Node(2);
        root1.left=new Node(1);
        root1.right= new Node(4);


        Node root2 = new Node(9);
        root2.left=new Node(3);
        root2.right=new Node(12);

       Node root= mergeBST(root1, root2);
       preorder(root);
        //  Node root=new Node(50);
        //  root.left=new Node(30);
        //  root.left.left=new Node(5);
        //  root.left.right=new Node(20);
        //  root.right=new Node(60);
        //  root.right.left=new Node(45);
        //  root.right.right=new Node(70);
        //  root.right.right.left=new Node(65);
        //  root.right.right.right=new Node(80);
        
        //  information info=largestbst(root);
        //  System.out.println("size " + maxsize);


       
   
       

    }
    }
 //     Node root=new Node(8);
    //     root.left=new Node(5);
    //     root.right=new Node(10);
    //     root.left.left=new Node(3);
    //     root.left.right=new Node(6);
    //     root.right.right=new Node(11);
    //    root= mirror(root);
    //    preorder(root);
    
    
    // int val[]={8,5,3,6,10,11,14};
        // Node root=null;
        // for(int i=0;i<val.length;i++){
        //      root=insert(root, val[i]);
        // }
        // inorder(root);
        // System.out.println();
        // if(validbst(root, null,null)){
        //     System.out.println("valid");
        // }
        // else{
        //     System.out.println("notvalid");
        // }
        
        
    // printrange(root, 5, 12);java bst.java
        // printpath(root, new ArrayList<>());
        // root=delete(root, 5);
        // inorder(root);
        // if(search(root, 9)){
        //     System.out.println("found");
        // }
        // else{
        //     System.out.println("go fuck yourself :)");
        // }