import java.util.*;

public class ooops{
    
    public static void main(String[] args) {
        // Student s1=new Student();
        // s1.name="faaeiz";
        // s1.roll=123;
        // s1.pass="abc";
        // s1.marks[0]=100;
        // s1.marks[1]=99;
        // s1.marks[2]=96;
        // Student s2=new Student(s1); //the copied values are passed here;
        // s2.pass="xyz";// changes made in s2 object
        // s1.marks[2]=100;
        // for(int i=0;i<3;i++){
            
        //     System.out.println(s2.marks[i]);
        // }
        // spy num= new spy();
        //  num.relation="Father of scunt";
        //  num.basespeed();
       //  System.out.println(num.relation);
    //    calculator calc= new calculator();
    //    System.out.println(calc.sum(1,2));
    //    System.out.println(calc.sum ((float)1.4, (float)3.7));
    //    System.out.println(calc.sum(4,7,9));
    
// horse h = new horse();
// h.eat();
// h.walk();
// chicken c=new chicken();

// c.eat();
// c.walk();
queen q= new queen();
q.moves();
    }
}
    class  Student{
        String name;
        int roll;
        String pass;
        int marks[];

        //copy constructor
        // Student(Student s1){
        //     this.name=s1.name;
        //     this.roll=s1.roll;
        //     this.marks=s1.marks;
            
        // }
        //deep  copy constructor
        Student(Student s1){
            marks=new int[3];
            this.name=s1.name; 
            this.roll=s1.roll;
            for(int i=0;i<3;i++){
                this.marks[i]=s1.marks[i]; // changes made to s2 will not reflect on s1 after being copied
            }

        }

        Student(){
            marks=new int[3];
            System.out.print("faaeiz");
        }
        Student(String name){
            marks=new int[3];
            this.name=name;

        }
        Student(int roll){
            marks=new int[3];
            this.roll=roll;
        }
    }
    class tf2{
        int speed;
        String name;
        String team;
        void basespeed(){
            System.out.println("class based");
        }
        void rocketjump(){
            System.out.print("can jump");
        }
        void invis(){
            System.out.print("can go invis");

        }
    }
class scunt extends tf2{
                int basespeed;
                void speed(){
                    System.out.println("fastest class");
                }
        }
     class spy extends scunt{
            String relation;

        }
     class calculator{   //method overloading . at compile time
        int sum(int a ,int b){
            return a+b;
        }
        float sum(float a, float b){
            return a+b;
        }
        int sum(int a, int b, int c){
            return a+b+c;
        }
     }
    abstract class Animals{
        void eat(){
            System.out.println("eats");
        }
    
        abstract void walk();
    }
        class horse extends Animals{
            void walk(){
            System.out.println("walks on 4 legs");
        }

    }
    class chicken extends Animals{
        void walk(){
            System.out.println("walks on two legs");
        }
    }
    interface  chessmoves{
        void moves();  // blueprint
    }
    class queen implements chessmoves{
        public void moves(){
    System.out.println( " left, right, up, down, right diagonal");
    }
}
    class king implements chessmoves{
        public void moves(){
        System.out.println("right, left, up, down, diagonal by 1 step");
         }}
    class rook implements chessmoves{
        public void moves(){
        System.out.println("up, down,left righ");
    }}
    


    

