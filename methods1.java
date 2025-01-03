import java.util.*;
public class methods1 {
    public static void helloworld() {
    System.out.println ("wassup");
    System.out.println ("wassup");

}
public static int calculatesum(int num1, int num2) { // int a , int b is used to let the calculatesum define the parameters,, known as parameters or formal parameters
int sum=num1+num2;
System.out.println ("Sum is " +sum);
return sum;

}
//public static void main(String args[]){
   // int a=3;
    //int b=4;
    //System.out.println(calculatesum(a,b));
 //}

 
 public static int multi(int a, int b){
    int product=a*b;
    return product;
 }

 public static int fact(int a) {
    int f=1;
      for (int i=1;i<=a;i++){
        f=f*i;
        
      }
      return f;

    }
    //      public static void main (String args[]){
    //    System.out.println(fact(4));
      //}
 
public static int bino(int a, int r){
  int fact_n=fact(a); // takes the factorial function from above and uses it here
     int fact_r=fact(r);
     int fact_rn=fact(a-r);
     int bino=fact_n /(fact_r*fact_rn);
     return bino;
}
//public static void main (String args[]) {
  //  System.out.println(bino(7,5));
//}

public static int  summ(int a,int b) {
    return a+b;
}
public static int summ(int a, int b, int c) {
    return a+b+c;
    }
   // public static void main (String args[]){
     //   System.out.println( summ(2,4));
       // System.out.println( summ(2,4,5));

    //}
    public static void  bintoDec(int num){
   int mynum=num;
   int pow=0;
   int deci=0;
    while (num>0){
      int lastdigit=num%10;
      deci= deci + (lastdigit *(int)Math.pow(2,pow));
      pow ++;
      num=num/10;
    }
      System.out.println("the conversion of " +   mynum +" = "  + deci );
  }

    
   // public static void main (String args[]){
     // bintoDec(1000);
    //}
    public static void dectoBin(int n){
      int mynum=n;
      int pow=0;
      int bin=0;

      int dec=0;
      while (n>0){
        int rem=n%2;
       bin=bin + ( rem * (int)Math.pow(10,pow));
        pow ++;
        n=n/2;



      }
      System.out.println (  +bin );


    }
    public static void main(String args[]){
      dectoBin(11);
    }
    }
    




