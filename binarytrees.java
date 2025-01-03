import java.util.*;
public class binarytrees{
    static class Node {
        int data;
        Node right;
        Node left;

        Node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

        
        public static int height(Node root){
            if(root==null){
                return 0;
            }
            int lh=height(root.left);
            int rh=height(root.right);
            return Math.max(lh, rh)+1;
        }
        public static int countnodes(Node root){
            if(root==null){
                return 0;
            }
            int lh=countnodes(root.left);
            int rh=countnodes(root.right);
            // return Math.max(lh, rh)+1;
            return lh+rh+1;
        }
        public static int sum(Node root){ //O(n^2)
            if(root==null){
                return 0;
            }
            int leftsum=sum(root.left);
            int rightsum=sum(root.right);
            return leftsum+rightsum+root.data;
        }
        public static int diamtere(Node root){
            if(root==null){
                return 0;
            }
            int ld=diamtere(root.left);
            int rd=diamtere(root.right);
            int lh=height(root.left);
            int rh=height(root.right);
            int selfdia=lh+rh+1;
            return Math.max(selfdia, Math.max(ld,rd));
        }
        static class info{
            int diam;
            int ht;
            public info(int diam,int ht){
                this.diam=diam;
                this.ht=ht;
            }

        }
        public static info diameter(Node root){//O(n)
            if(root==null){
                return new info(0, 0);
            }
            info leftinfo=diameter(root.left);
            info rightinfo=diameter(root.right);
            int diameter=Math.max(Math.max(leftinfo.diam,rightinfo.diam),leftinfo.ht+rightinfo.ht+1);
            int ht= Math.max(leftinfo.ht,rightinfo.ht)+1;
            return new info(diameter, ht);


        }
        public static boolean isIdentical(Node root, Node subroot){
            if(root==null && subroot==null){
                return true;
            }
            else if(root==null|| subroot==null||root.data!=subroot.data){
                return false;
            }
            if(!isIdentical(root.left, subroot.left)){ // agar left subtree and left node of tree is un-indentical return false
                return false;
            }
             if(!isIdentical(root.right, subroot.right)){
                return false;
            }
            return true;
        }
        public static boolean issubtress(Node root, Node subroot){
            if(root==null){
                return false;
            }
            if(root.data==subroot.data){ // agar root ka pehla data== subtree ka pehla data
                if(isIdentical(root,subroot)){
                return true;
            }
        }
        boolean rightans=issubtress(root.right, subroot); // given tree mai traverse karenge right subtree jabh tak koi node ka data mile jo subroot ka starting data ke equal hoga
        boolean leftans=issubtress(root.left, subroot);//given tree mai traverse karenge left subtree jabh tak koi node ka data mile jo subroot ka starting data ke equal hoga
        return leftans||rightans;
        }

        static class infoo{
            Node node;
            int hd;
            public infoo(Node node, int hd){
                this.node=node;
                this.hd=hd;
            }
        }
        public static void topview(Node root) {
            Queue<infoo> q = new LinkedList<>();
            HashMap<Integer, Node> map = new HashMap<>();
            q.add(new infoo(root, 0));
            q.add(null);
            int min = 0, max = 0;
        
            while (!q.isEmpty()) {
                infoo curr = q.remove();
                if (curr == null) {
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    if (!map.containsKey(curr.hd)) {  // horizontal distance first occurrence
                        map.put(curr.hd, curr.node);
                    }
                    if (curr.node.left != null) {  // along the negative x-axis
                        q.add(new infoo(curr.node.left, curr.hd - 1));
                        min = Math.min(min, curr.hd - 1);
                    }
                    if (curr.node.right != null) {
                        q.add(new infoo(curr.node.right, curr.hd + 1));
                        max = Math.max(max, curr.hd + 1);
                    }
                }
            }
            for (int i = min; i <=max; i++) {
                System.out.print(map.get(i).data + " ");
            }
            System.out.println();
        }
        public static void klevel(Node root, int level, int k){ //O(n)
            if(root==null){
                System.out.println();
            }
            if(level==k){
                System.out.print(root.data+" ");
                return;
            }
            klevel(root.left, level+1, k);
            klevel(root.right, level+1, k);

        }
        public static boolean getpath(Node root, int n, ArrayList<Node> path){
            if(root==null){
                return false;
            }
            path.add(root);
            if(root.data==n){
                return true;
            }
            boolean foundleft=getpath(root.left, n, path);
            boolean foundright=getpath(root.right, n, path);
            if(foundright||foundleft){
                return true;

            }
            path.remove(path.size()-1);
            return false;



        }
        public static Node LCA(Node root, int n1, int n2){//O(n)
            ArrayList<Node> path1= new ArrayList<>();
                        ArrayList<Node> path2= new ArrayList<>();

            getpath(root,n1,path1);
            getpath(root,n2,path2);
            int i=0;
            for(int i=0;i<path1.size()&&i<path2.size();i++){
                if(path1.get(i)!=path2.get(i)){
                    break;
                }
                // return i-1 index for the last common node

            }
            Node LCA= path1.get(i-1);
            return LCA;

        }
        public static Node lca2(Node root, int n1, int n2){
            if(root==null||root.data==n1|| root.data==n2){
                return root;
            }
           Node leftlca= lca2(root.left, n1, n2);
           Node rightlca=lca2(root.right, n1, n2);

           if(rightlca==null){ // right subtrees doesnt have the value looking for the value is in leftsubtree
            return leftlca;
           }
           if(leftlca==null){// left subtrees doesnt have the value looking for the value is in rightsubtree
            return rightlca;
           }
           return root;//either doesnt give null that means the value is in both and the root is the common ancestor

        }
        public static int lcadist(Node root, int n){
            if(root==null){
                return -1;
            }
            if(root.data==n){
                return 0;
            }
            int leftdist=lcadist(root.left, n);
            int rightdist=lcadist(root.right, n);
            if(leftdist==-1 && rightdist==-1){
                return -1;
            }
            else if(leftdist==-1){
                return rightdist+1;

            }
            else {
                return leftdist+1;
                }
            

        }

         public static int mindis(Node root, int n1, int n2){
            Node lca=lca2(root, n1, n2);
           int dist1=lcadist(root, n1);
           int dist2=lcadist(root, n2);
           return dist1+dist2;
         }
         public static int kthanc(Node root, int n, int k){
            if(root==null){
                return -1;
            }
            if(root.data==n){
                return 0;
            }
            int rightdist=kthanc(root.right, n, k);
            int leftdist=kthanc(root.left, n, k);
            if(rightdist==-1 && leftdist==-1){
                return -1;
            }
            int max= Math.max(leftdist,rightdist);
            if(max+1==k){
                System.out.println(root.data);

            }
            return max+1;
            
         }
         

    

    public static void main(String[] args) {
        /*              1
         *             / \
         *            2   3
         *           / \ / \
         *          4  5 6  7
         */
        
        Node root= new Node(1);
        root.left= new Node(2);
        root.right=new Node(3);
        root.left.left= new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);
        int k=2;
        kthanc(root, 5, 2);
       

        //                2
        //               / \
        //              4   5
        // Node subroot= new Node(2);
        // subroot.left= new Node(4);
        // subroot.right=new Node(6);
        //         System.out.println(issubtress(root, subroot));


      
    }
}

// static class Node{
//         int data;
//         Node right;
//         Node left;

//         Node(int data){
//             this.data=data;
//             this.right=null;
//              this.left=null;
//         }
//     }
//     static class binary{
//         static int idx=-1;
//         public static Node buildtree(int nodes[]){
//             idx++;
//             if(nodes[idx]==-1){
//                 return null;
//             }
//             Node newnode= new Node(nodes[idx]);
//             newnode.left=buildtree(nodes);
//             newnode.right=buildtree(nodes);
//             return newnode;


//         }
//         public static void preorder(Node root){
//             if(root==null){
//                 System.out.print("-1");

//                 return ;
//             }
//             System.out.print(" "+root.data);
//             preorder(root.left);
//             preorder(root.right);
//         }
//         public static void inorder(Node root){
//             if(root==null){
//                 System.out.print("-1");
//                 return;
//             }
//             inorder(root.left);
//             System.out.print(" "+root.data);            
//             inorder(root.right);
//         }
//         public static void postorder(Node root){
//             if(root==null){
//                 return;
//             }
//             postorder(root.left);
//             postorder(root.right);
//             System.out.print(" "+root.data);
//         }
//         public static void levelorder(Node root){
//             if(root==null){
//                 return;
//             }
//             Queue<Node> q= new LinkedList<>();
//             q.add(root);
//             q.add(null);
//             while(!q.isEmpty()){
//                 Node currnode= q.remove();
//                 if(currnode==null){// agar null hai toh next line
//                     System.out.println();
                
//                 if(q.isEmpty()){// queue empty hai toh break
//                         break;
//                     }
//                 else{
//                     q.add(null);// taaki next level mai bhi next line print ho jae because queue mai null push ho jaega
                    
//                 }
//             }
//             else{
//                 System.out.print(currnode.data +" ");
//                 if(currnode.left!=null){
//                     q.add(currnode.left);
//                 }
//                 if(currnode.right!=null){
//                     q.add(currnode.right);
//                 }
//             }
//             }
//         }
        //// MAIN
//  int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
    // binary  tree= new  binary();
    // Node root=tree.buildtree(nodes);
    // tree.levelorder(root);