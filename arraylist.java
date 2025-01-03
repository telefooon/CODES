import java.util.ArrayList;
import java.util.*;
public class arrayList{
    public static int container(ArrayList<Integer>height){
        int maxwaterr=0;
        for(int i=0;i<height.size();i++){
            for(int j=i+1;j<height.size();j++){
                int ht=Math.min(height.get(i),height.get(j));
                int width=j-i;
                int currwater=ht*width;
                 maxwaterr=Math.max(maxwaterr,currwater);
            }
        }
        return maxwaterr;
    }
    public static int containeroptimized(ArrayList<Integer>height){ // 2 pointer approach
        int LP=0;
        int RP=height.size()-1;
        int maxwater=0;
        while(LP<RP){
            int ht=Math.min(height.get(LP),height.get(RP));
            int width=RP-LP;
             int volume=ht*width;
            maxwater=Math.max(maxwater,volume);

            if(height.get(LP)<height.get(RP)){
                LP++;
            }
            else{
                RP--;
            }
            

        }
        return maxwater;
    }
    public static boolean parisum(ArrayList<Integer>list,int target){
        int lp=0;
        int rp=list.size()-1;
        while(lp!=rp){
            if(list.get(rp)+list.get(lp)==target){
                return true;
            }
            else if(list.get(rp)+list.get(lp)<target){
                lp++;
            }
            else{
                rp--;
            }
           
               
            }

        
return false;
    }
    public static boolean pairsum2(ArrayList<Integer>list,int target){
        int bp=-1;//initializing breaking point
        int n=list.size();

        for(int i=0;i<n;i++){ //finding breaking point
            if(list.get(i)>list.get(i+1)){
                bp=i;
                break;
            }
        }
    int lp=bp+1;//smallest
    int rp=bp;//largest
    while(lp!=rp){
        if(list.get(rp)+list.get(lp)==target){
            return true;
        }
        else if(list.get(rp)+list.get(lp)<target){
            lp=(lp+1)%n;
        }
        else{
            rp=(n+rp-1)%n;
        }

    }
    System.out.print(lp+" "+rp);
return false;
    }

    public static boolean monotoneA(ArrayList<Integer>List){
   boolean inc=true;
   boolean dec=true;     
        
        for(int i=0;i<List.size()-1;i++){
            if(List.get(i)<List.get(i+1)){
                dec=false;
            }
            if(List.get(i)>List.get(i+1)){
                inc=false;
            }
        }
        return inc||dec;
}
public static int lonelynumber(ArrayList<Integer>List){
    Collections.sort(List);
    for(int i=1;i<List.size()-1;i++){ 
        if(List.contains(i-1)==List.get(i-1) && List.contains(i+1)==List.get(i+1)){

        }
    }
}
    public static void main(String[] args) {
        ArrayList<Integer>list=new ArrayList<>();// Java collection framework   
      
        list.add(1);
         list.add(2);
          list.add(3);
          
        

        
        System.out.println(monotoneA(list));
        
            
        }      
    
        
}

