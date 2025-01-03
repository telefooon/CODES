import java.util.*;
public class linear {
public  static int linearsearch(int number[],int key){
 for (int i=0;i<number.length;i++)
{
   // if(number[i]==key){
      //  return i;
    //}
 }
return -1;

//}
//public static void main(String args[])
//{
  //  int number[]={2,3,4,6,8,10};
    //int key=10;
    //int index=linearsearch(number,key);
    //if(index==-1) {
    //System.out.println("not found");
   // }
    //else {
     //   System.out.println("number found at " + (index+1));
    //}
//}
//}
public static int largest(int number[]){
int largest =Integer.MIN_VALUE; //-infinity
for(int i=0;i<number.length;i++)
if(largest<number[i]){
  largest=number[i];
}    
return largest;
}
//public static void main(String args[]){
   // int number[]={1,3,4,5,6,7};
    //System.out.println("largest is" + largest(number));
//}
//}
public static int binarysearch(int number[],int key)
{
    int start =0; 
    int end=number.length-1;
    while (start <=end)
    {
        int mid=start+end/2;
         //comparisons
         if(number[mid]==key){
            return key;
         }
         if(number[mid]<key) {
            //right
            start=mid+1;
         }
         else{
            //left
            end=mid-1;
         }
    }
    return -1;
}
public static void reverse(int number[]){
   int start=0;
   int end=number.length-1;
   while(start<end){
      int temp=number[end];
      number[end]=number[start];
   number[start]=temp;  
   start++;
   end--;
   
 }

}

public static void main(String args[]) {
    int number[]={2,4,5,6,7,8};
    
    reverse(number);
    for (int i=0;i<number.length;i++){
      System.out.print(number[i]+ " ");
    }
    System.out.println("");
}
}






