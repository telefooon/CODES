import java.util.*;
public class dnc{

    public static void mergesort(int arr[],int si, int ei){
        if(si>=ei){
            return;
        }
        int mid=si+(ei-si)/2;
        mergesort(arr, si, mid);
        mergesort(arr, mid+1, ei);
        merge(arr,si,mid,ei);
    }
public static void merge(int arr[], int si, int mid,int ei){
    int temp[]=new int[ei-si+1];
    int i=si;//;left part of the array
    int j=mid+1;// right part of the array
    int k=0;//temp array
    while(i<=mid && j<=ei){
        if(arr[i]<arr[j]){
        temp[k]=arr[i];
        i++;
    }
    else{
        temp[k]=arr[j];
        j++;
    }
      k++;
}
  
//leftover numbers from the left array
while(i<=mid){
    temp[k++]=arr[i++];
}
//leftover numbers from the right array
while(j<=ei){
    temp[k++]=arr[j++];
}
//copy temp to original array
for(k=0,i=si;k<temp.length;k++,i++){
    arr[i]=temp[k];
  }
}

    public static void printarr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");

        }
        System.out.println();
    }
public static void quicksort(int arr[],int si, int ei){
    if(si>=ei){
        return;
    }
int pivot=partition(arr,si,ei);
quicksort(arr, si,pivot-1);
quicksort(arr, pivot+1, ei);
}
public static int partition(int arr[],int si, int ei){
    int pivot=arr[ei];
    int i=si-1; // i=-1
    for(int j=si;j<ei;j++){
        if(arr[j]<=pivot){
            i++;
            int temp=arr[j];
            arr[j]=arr[i];
            arr[i]=temp;
        }
    }
        i++;
            int temp=pivot;
            arr[ei]=arr[i];
            arr[i]=temp;
            return i;
    
}

public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
    
    // System.out.println("enter number");
    // int n=sc.nextInt();
    System.out.println("enter array");
 int[] arr=new int[5];
 for(int i=0;i<5;i++){
    arr[i]=sc.nextInt();
 }
 quicksort(arr, 0, arr.length-1);
//   int key=sc.nextInt();
printarr(arr);
}}