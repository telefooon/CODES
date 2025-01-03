import java.util.*;
public class factoriall{
    public static void main(String arfgs[]){
        Scanner sc=new Scanner(System.in);
    int number;
    int fact=1;
    System.out.println("Enter the number");
    number =sc.nextInt();
    for(int i=1;i<number;i++){
        fact *=i;
    }
 System.out.println("Factorial " +fact);
 
 
    }
}