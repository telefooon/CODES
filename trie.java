import java.util.*;
public class trie{
    static class Node{
        Node[] children= new Node[26];
        boolean eow=false;
        int freq;
      public  Node(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
            freq=1;

        }
    }
    public static Node root=new Node();

   
     public static  void insert(String word){
         Node curr= root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]= new Node();
            }
            curr=curr.children[idx];
            
        }
        curr.eow=true;

    }
    public static  void insert1(String word){ // for words problem
         Node curr= root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]= new Node();
            }else{
            curr.children[idx].freq++;
            
            }
            curr=curr.children[idx];

        }
        curr.eow=true;

    }
    public static boolean search(String s){
         Node curr= root;
        for(int i=0;i<s.length();i++){
            int idx=s.charAt(i)-'a';
            if(curr.children[idx]==null){
              return false;            
            }
            curr=curr.children[idx];
            
        }
       return  curr.eow==true;


    }
    public static boolean wordbreak(String key){
        if(key.length()==0){
            return true;
        }
        for(int i = 1; i <= key.length(); i++){
            //substring(beg idx, last idx)
            if(search(key.substring(0, i)) && wordbreak(key.substring(i))){
                return true;
            }
        }
        return false;
    }
     public static void prefix(Node root, String ans){
        if(root==null){
             return;
        }
        if(root.freq==1){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<26;i++){
            if(root.children[i]!=null){
                prefix(root.children[i], ans+(char)(i+'a'));
            }
        }

     }
      public static boolean findprefix(String s){
        Node curr=root;
        for(int i=0;i<s.length();i++){
           int idx=s.charAt(i)-'a';
           if(curr.children[idx]==null){
            return false;
           }
           curr=curr.children[idx];
        }
        return true;

      }

    public static int countnodes(Node root){
        if(root==null){
            return 0;
        }
        int count=0;
        for(int i=0;i<26;i++){
            if(root.children[i]!=null){
                    count+=countnodes(root.children[i]);
            }
        }
        return count+1;
    }
    public static String ans="";
           public static void longestword(Node root, StringBuilder temp){
           if(root==null){
            return;
           }
        for(int i=0;i<26;i++){
            if(root.children[i]!=null && root.children[i].eow==true){
                char ch= (char)(i+'a');
                temp.append(ch);
                if(temp.length()>ans.length()){
                    ans=temp.toString();
                }
                longestword(root.children[i], temp);
                temp.deleteCharAt(temp.length()-1); 

            }

        }
    }
           
    public static void main(String[] args) {

        String words[]={"a","banana","app","appl","ap","apply","apple"};
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }
        longestword(root, new StringBuilder(""));
        System.out.println(ans);
        // String words[]={"zebra","dog","duck","dove"};
        // String pref="zeb";
        // String pref1="zz";
        // for(int i=0;i<words.length;i++){
        //     insert(words[i]);
        // }
        // System.out.println(findprefix(pref));
        // System.out.println(findprefix(pref1));

        // root.freq=-1;
        // prefix(root, "");
    //     String key="ilikesam";
    //    System.out.println( wordbreak(key));
    //     // System.out.println(search("thee"));
    //     // System.out.println(search("thor"));
       
    }
}
