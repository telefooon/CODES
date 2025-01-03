 import java.util.*;
 public class arrayss {
    public static void update (int marks[]){
        for(int i=0;i<marks.length;i++)
      {
        marks[i]=marks[i]+1;
      }
    }
    //public static void main(String args[]) {
       // int marks[]=new int[100];
        //Scanner sc=new Scanner(System.in);
        //marks[0]=sc.nextInt();
        //marks[1]=sc.nextInt();
        //marks[2]=sc.nextInt();

        //System.out.println("physics"  + marks[0]);
        //System.out.println("chem"  + marks[1]);
     //System.out.println("bio"  + marks[2]);
     public static void main(String args[]){
        int marks[]={45,34,65};
        update(marks);

        //print our marks
        for(int i=0;i<marks.length;i++)
        {
            System.out.print(marks[i] +" ");
        }
        System.out.println();
    }
}

        
     
    
 