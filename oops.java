import java.util.*;
public class oops{
    public static void main(String[] args) {
         student1 s1=     new student1(" FAAEIZ");// created a pen object called p1
         System.out.println(s1.name);
        // p1.setcolor("BLUE");
        // System.out.println(p1.color);
        // p1.setTip(5);
        // System.out.println( p1.tip);
        // p1.color="YELLOW";
        //         System.out.println(p1.color);
        //         // bank myacc= new bank();
        //         // myacc.username="faaeiz";
        //         // myacc.setpass("hesoyam");
        // p1.setcolor("BLUE");
        // System.out.println(p1.getcolor());
        // p1.setTip(5);
        // System.out.println(p1.gettip());



    }
}
class bank{
    public String username;
    private String password;
    public void setpass(String newpassword){
        password=newpassword;
    }

}
    class Pen{
       private String color;
       private int tip;


       String getcolor(){  //getters
        return this.color;
       }
       int gettip(){   //getters
        return this.tip;

       }
        void setcolor(String color){    //setters
            this.color=color;
        }
       
        
        void setTip(int tip){  //setters
            this.tip=tip;
        }
    
    }
    class Student{
        String name;
        int age;
        float perc;
        void perce(int phy, int chem, int math){
            perc=phy+chem+math/3;
        }
    }
    class student1{
        int rollno;
        String name;
        student1(String name){  // constructor
            this.name=name;
        }
    }

    




