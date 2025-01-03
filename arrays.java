 import java.util.*;
 public class arrays {
    public static void main(String args[]) {
        int marks[]=new int[100];
        Scanner sc=new Scanner(System.in);
        marks[0]=sc.nextInt();
        marks[1]=sc.nextInt();
        marks[2]=sc.nextInt();

        System.out.println("physics"  +marks[0]);
        System.out.println("chem"  +marks[1]);
     System.out.println("bio"  +marks[2]);
    }
 }