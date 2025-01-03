import java.util.*;
public class bits{
public static void oddeven(int n){
   int bitmask=1;
   if((n&bitmask)==0){
    System.out.println("even");

}
else
System.out.println("odd");
    }
public static int setbit(int n, int i){
        int bitmask=1<<i;
        if((n&bitmask)==0){
            return 0;
        }
            else{
                return 1;
            }
        }
        public static int getit(int n,int i){
            int bitmask=1<<i;
            return n|bitmask;   
        }
        public static int clearbit(int n, int i){
            int bitmask=~(1<<i);
            return n&bitmask;
        }
public static int updatebit(int n, int i, int update){
    if(update==0){
        return clearbit(n, i);
    }
    else{
       return setbit(n, i);
    }
}
    public static int clearbits(int n , int i){
        int bitmask=-1<<i;
        return n&bitmask;
    }
public static int  clearrange(int n, int i, int j){
    int a=(-1<<(j+1));
    int b=(1<<i)-1;
    int bitmask =a|b;
    return n&bitmask;
}
public static boolean poweroftwo(int n){
    return (n&(n-1))==0;
}
public static int countbit(int n){
    int count=0;
    while(n>0){
        if((n&1)!=0){// checks LSB 
            count++;
        }
        n=n>>1;// right shift
    }
    return count;
}
public static int expo(int a, int n){
    int ans=1;
    while(n>0){
        if((n&1)!=0){
            ans=ans*a;

        }
        a=a*a;
        n=n>>1;
    }
    return ans;
}
public static void swap(int a,int b){
    System.out.println(("before swapping"+a+","+b));
    a=a^b;
    b=a^b;
    a=a^b;
    System.out.println("after swapping "+a+","+b);

}
public static void uppertolower(){
    for( char ch='A';ch<='Z';ch++){
        System.out.print((char)(ch|' '));
    }

}
public static void main(String[] args) {
    uppertolower();
    
   // oddeven(n);
    
}
}
