import java.util.*;
public class integers{
    public static void main(String arfgs[]){
        Scanner sc=new Scanner(System.in);
        int choice;
        int number;
        int even=0;
        int odd=0;
        do{
            System.out.println("Enter the number");
            number=sc.nextInt();
            if(number%2==0)
            even=1+number;
            else{
                odd=1+number;

            }
            System.out.println("do u want to continue?");
            choice=sc.nextInt();


        }
        while (choice==1);
System.out.println("Sum of even numbers" +even);
System.out.println("Sum of odd numbers is" +odd);


    }
}