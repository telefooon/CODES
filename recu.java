import java.util.*;
public class recu{
   
    
public static void dec(int n){
    if(n==1){
        System.out.println(n);
        return;
    }
    System.out.print(n+" ");
    dec(n-1);
}
public static void inc(int n){
    if(n==1){
        System.out.print(n+" ");
        return;
    }
    inc(n-1);
    System.out.print(n+" ");
}
public static int fac(int n){
    if(n==0){
       return 1;
    }
    int fnm1=fac(n-1);
    int fnm=n*fnm1;
    return fnm;
}
public static int sum(int n){
    if(n==1){
         return 1;
        
    }
    int Sn=sum(n-1);
    int Snn=n+Sn;
    return Snn;
}
public static int fibo(int n){
    if(n==0 || n==1){
        return n;
    }
    int fnm1=fibo(n-1);
    int fnm2=fibo(n-2);
    int fn=fnm1+fnm2;
    return fn;
}
public static boolean sortedarray(int arr[],int i){
    if(i==arr.length-1){
        return true;
    }
    if(arr[i]>arr[i+1]){
        return false;
    }
    return sortedarray(arr, i+1);
}
public static int firstocc(int arr[],int i, int key){
    
    if(i==arr.length-1){
        return -1;
    }
    
    if(arr[i]==key){
        return i;
    }
    return firstocc(arr, i+1, key);
}
public static int lastoccu(int arr[],int i, int key){
    
    if(i==0){
        return -1;
    }
    
    if(arr[i]==key){
        return i;
    }
    return firstocc(arr, i-1, key);
}
public static int power(int n,int p){
    if(p==0){
        return 1;
    }
    // int xnm1=power(n, p-1);
    // int xn=n*xnm1;
    // return xn;
     return n*power(n,p-1);
}
public static int optimizedpower(int n, int p){ //O(logn)
    if(p==0){
        return 1;
    }
    int halfsquarep=optimizedpower(n, p/2);
    int halfsquare=halfsquarep*halfsquarep;
    if(p%2!=0){
        halfsquare=n*halfsquare;
    }
    return halfsquare;
}
/// AMAZON
public static int tiling(int n){ // for (2 x n) size
    //base case
    if(n==1 || n==0){
        return 1;
    }
    //recursion
int verticalways=tiling(n-1);

int horizontalways=tiling(n-2);

int totalways=verticalways+horizontalways;
return totalways;
}
public static void removeduplicate(String str, int index, StringBuilder newstr, boolean map[]){
    if(index==str.length()){
        System.out.println(newstr);
        return ;
    }
    //kaam 
    char currchar=str.charAt(index);
    if(map[currchar-'a']==true){
        //duplicate
        removeduplicate(str, index+1, newstr, map);
    }
    else{
        map[currchar-'a']=true;
        removeduplicate(str, index, newstr.append(currchar), map);
    }

}
public static int pairs(int n){
    if(n==1||n==2){
        return n;
    
    }
    //single
    int single=pairs(n-1); // no of single ways
    //pair
    int single2=pairs(n-2);//no of pairs available
    int pairways=(n-1)*single2; // no of pairs available after a pair is formed
    int totalways=single+pairways;
    return totalways;
}
public static void binarystrings(int n, int lastplace, String str){
    if(n==0){
        System.out.println(str);
        return;
    }
    binarystrings(n-1,0,str+"0");
    if(lastplace==0){
        binarystrings(n-1,1,str+"1");
    }
}
public static void occurence(int arr[],int i,int key){
    if(i==arr.length){
        return;
    }
    if(arr[i]==key){
        System.out.print(i+" ");
        
    }
    occurence(arr, i+1, key);
}
public static void numbertostring(int n){

      String digits[]={"zero","one","two","three","four","five","six","seven","eight","nine"};

    if(n==0){
    
        return;
    }
    int lastdigit=n%10;
    numbertostring(n/10);
    System.out.print(digits[lastdigit]+" ");
    

}
public  static void hanoi(int n, String S, String H, String D){
    if(n==1){
        System.out.print(" transfer disc " +n+" from "+S+" to "+ D);
        return;

    }
    hanoi(n-1, S, D, S);
    System.out.println(" transfer disc " +n+" from "+S+" to "+D);
    hanoi(n-1, H, S, D);
    
    

}



public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
    
    System.out.println("enter number");
    int n=sc.nextInt();
    
    // binarystrings(n,0,"");
    
//     System.out.println("enter array");
//  int[] arr=new int[n];
//  for(int i=0;i<n;i++){
//     arr[i]=sc.nextInt();
//  }
//  System.out.println("enter key");
//  int key=sc.nextInt();
hanoi(n, "S", "H", "D");
// removeduplicate(n, 0,new StringBuilder(""), new boolean [26]);
    
}
}