import java.util.*;
public class hash{
    static class HashMap<K,V>{ // generic data type can be anything
        private class Node{
            K key;
            V value;
            public Node(K key, V value){
                this.key=key;
                this.value=value;
            }
           
        }

         private int n; //n
         @SuppressWarnings("unchecked")
            private LinkedList<Node> buckets[];//N

            @SuppressWarnings("unchecked")
            public HashMap(){
                this.n=4;
                this.buckets=new LinkedList[4];
                for(int i=0;i<4;i++){
                    this.buckets[i]=new LinkedList<>();
                }

            }
            private int SearchinLL(K key, int bi) {
                LinkedList<Node> ll = buckets[bi];
                int di = 0;
                for (int i = 0; i < ll.size(); i++) {
                    Node node = ll.get(i);
                    if (node.key.equals(key)) {
                        return di;
                    }
                    di++;
                }
                return -1;
            }
            
            private int hashFunction(K key){
                int hc=key.hashCode();
               return  Math.abs(hc) %buckets.length;
            }
            @SuppressWarnings("unchecked")
            private void rehash() {
                LinkedList<Node>[] oldBucket = buckets;
                buckets = (LinkedList<Node>[]) new LinkedList[2 * buckets.length];
            
                for (int i = 0; i < buckets.length; i++) {
                    buckets[i] = new LinkedList<>();
                }
            
                for (int i = 0; i < oldBucket.length; i++) {
                    LinkedList<Node> ll = oldBucket[i];
                    for (int j = 0; j < ll.size(); j++) {
                        Node node = ll.remove();
                        put(node.key, node.value);
                    }
                }
            }
            
            public void put(K key, V value){
                int bi=hashFunction(key);
                int di=SearchinLL(key,bi);
                    if(di!=-1){
                        Node node=buckets[bi].get(di);
                        node.value=value;
                    }
                    else{
                        buckets[bi].add(new Node(key, value));
                        n++;
                    }
                    int lambda = (int)((double)n / buckets.length);
                    if(lambda>2.0){
                        rehash();
                    }

            }
            public boolean containskey(K key){
                int bi=hashFunction(key);
                int di=SearchinLL(key,bi);
                    if(di!=-1){
                        return true;
                    }
                    else{
                        
                        return false;
                    }
                

            }
            public V remove(K key){
                int bi=hashFunction(key);
                int di=SearchinLL(key,bi);
                    if(di!=-1){
                        Node node=buckets[bi].remove(di);
                        n--;
                        return node.value;                   
                    }
                    else{
                    return null;                      
                }
            }
            public V get(K key){
                int bi=hashFunction(key);
                int di=SearchinLL(key,bi);
                    if(di!=-1){
                        Node node=buckets[bi].get(di);
                            return node.value;
                    }
                    else{
                       
                        return null;
                    }

            }
            public ArrayList<K> keySet(){
                ArrayList<K> keys=new ArrayList<>();
                for(int i=0;i<buckets.length;i++){
                    LinkedList<Node> ll= buckets[i];
                    for (Node node : ll) {
                        keys.add(node.key);
                        
                    }
                }
                return keys;
                
            }
            public boolean isEmpty(){
                return n==0;
            }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> hm= new HashMap<>();
        //insert function 

        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        hm.put("Nepal", 5);
        ArrayList<String> keys=hm.keySet();
        for (String  key : keys) {
            System.out.println(key);
            
        }
        // System.out.println(hm);
        //  Set<String> keys=hm.keySet();
        //  System.out.println(keys);

        //  for (String k : keys) {
        //     System.out.println("keys="+k+" ,value= "+hm.get(k));
            
        //  }

        // // size
        // System.out.println(hm.size());
        // // get function

        // System.out.println(hm.get("India"));

        // //contains function  : tells if a key exists or not
        // System.out.println(hm.containsKey("ef"));

        // //remove operation
        // hm.remove("India");
        // System.out.println(hm);
        // //clear function
        // hm.clear();
        // System.out.println(hm);
        // System.out.println(hm.isEmpty());
        
    }
}