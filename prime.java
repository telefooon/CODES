import java.util.*;
public class prime{
    public static void main(String arfgs[]){
        Scanner sc=new Scanner(System.in);
        System.out.println(" Enter the number bruh");
        int n=sc.nextInt();
        System.out.println(" The entered number is " +n);
        boolean isprime=true;
        for(int i=2;i<=Math.sqrt(n);i++){ // Math.sqrt=less time taken to run the loop
            if(n%i==0){
                isprime=false;

            }

        }
        if(isprime=true){
            System.out.println( n+ " is a prime number" );
        }
            else{
                System.out.println("Not a prime number");
            }
        
    }
}