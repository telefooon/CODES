oimport java.util.*;
public class hash2{
     public static void majorityelement(int arr[]){
        HashMap<Integer,Integer> hm= new HashMap<>();
        for(int i=0;i<arr.length;i++){
            // if(hm.containsKey(arr[i])){
            //     hm.put(arr[i], hm.get(arr[i])+1);
            // }
            // else{
            //     hm.put(arr[i], 1);
            // }
            hm.put(arr[i],hm.getOrDefault(arr[i], 0)+1);

        }
        // Set<Integer> keySet=hm.keySet();
        for (Integer key : hm.keySet()) {
            if(hm.get(key)>arr.length/3){
                System.out.println(key);
            }
            
        }
}
       public static boolean Anagram(String s1, String s2){
        HashMap<Character,Integer> hm= new HashMap<>();
        for(int i=0;i<s1.length();i++){
            char ch= s1.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0)+1); //if it exists add 1 if it doesnt add 0 as deault value
        }
        for(int i=0;i<s2.length();i++){
            char ch= s2.charAt(i);
            if(hm.get(ch)!=null){
                if(hm.get(ch)==1){
                    hm.remove(ch);
                }
                else{
                    hm.put(ch,hm.get(ch)-1);
                }
            }else{
                return false;
            }
        }
        return hm.isEmpty();

       }
      
    public static HashSet<Integer> union(int arr1[], int arr2[]) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            hs.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            hs.add(arr2[i]);
        }
        return hs;
    }

    public static HashSet<Integer> intersection(int arr1[], int arr2[]) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            hs.add(arr1[i]);
        }

        HashSet<Integer> result = new HashSet<>();
        for (int i = 0; i < arr2.length; i++) {
            if (hs.contains(arr2[i])) {
                result.add(arr2[i]);
            }
        }
        return result;
    }
      public static String getStart(HashMap<String, String> tickets){ // stores from - to
        HashMap<String, String> revmap= new HashMap<>(); //stroes to - from
        for (String key : tickets.keySet()) {
            revmap.put(tickets.get(key),key);
            
        }
        for (String key : tickets.keySet()) {
            if(!revmap.containsKey(key)){
                return key; //starting point

            }
            
        }
        return null;

    }
    public static void subarray(int arr[]){ //O(n)
        HashMap<Integer,Integer> hm= new HashMap<>();
        int sum=0;
        int len=0;
        for(int j=0;j<arr.length;j++){
            sum+=arr[j];
            if(hm.containsKey(sum)){
                len=Math.max(len, j-hm.get(sum)); 
            }
            else{
                hm.put(sum, j);
            }

        }
        System.out.println("largest subarray with sum as 0="+ len);
    }


    public static void main(String args[]) {

        int arr[]={15,-2,2,-8,1,7,10,23};
        subarray(arr);
        //  HashMap<String, String> tickets= new HashMap<>();
        //  tickets.put("CHENNAI", "BENGALURU");
        //  tickets.put("MUMBAI", "DELHI");
        //  tickets.put("GOA", "CHENNAI");
        //  tickets.put("DELHI", "GOA");
        //  String start=getStart(tickets);
        //  System.out.print(start);
        //  for (String key : tickets.keySet()) {
        //     System.out.print("->"+tickets.get(start));
        //     start=tickets.get(start);// move to next start

        //     }
        //     System.out.println();
        // int arr1[] = {7, 3, 9};
        // int arr2[] = {6, 3, 9, 2, 9, 4};

        // HashSet<Integer> unionSet = union(arr1, arr2);
        // System.out.println("Union set: " + unionSet);

        // HashSet<Integer> intersectionSet = intersection(arr1, arr2);
        // System.out.println("Intersection set: " + intersectionSet);
    }

}

        // majorityelement(arr);
        // String s1="race";
        // String s2="care";
        // System.out.println(Anagram(s1, s2));
        
    
