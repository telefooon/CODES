import java.util.*;
import java.util.Arrays;
import java.util.Collections;
public class sorting{

public static void printarr(int arr[]){
    for(int i=0;i<arr.length;i++){
    System.out.print(arr[i]+" ");
    }
    System.out.println();
}


    public static void bubblesort(int arr[]){
        for(int turn=0;turn<arr.length-1;turn++){
            for(int j=0;j<arr.length-1-turn;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }


public static void selection(int arr[]){
    for(int i=0;i<arr.length-1;i++){
        int minpos=i;
        for(int j=i+1;j<arr.length;j++){
            if(arr[minpos]>arr[j]){
                minpos=j;
            }

        }
        int temp=arr[minpos];
        arr[minpos]=arr[i];
        arr[i]=temp;
    }
}
public static void insertion(int arr[]){
    for(int i=1;i<arr.length-1;i++){
        int key=arr[i];
        int j=i-1;
        while(j>=0&& arr[j]>key){
            arr[j+1]=arr[j];
            j--;
        }
        arr[j+1]=key;
    }
}
 public static void main(String[] args) { 
    int arr[]={5,1,6,2,8};
    // insertion(arr);
    Arrays.sort(arr);
  //Arrays.sort(arr,0,3); // 0 means 0th index ,,, 3 means 2nd index 
//Arrays.sort(arr[,0,3,] Collections.reverseOrder(null)); (to run this command int needs to be converted into Integer as it is not a primitive type)
        printarr(arr);

    
}
}
