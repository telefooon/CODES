import java.util.*;
public class matrices{
    public static boolean search(int matrix[][] ,int key){
        
        for(int i=0;i<matrix.length;i++){
        for(int j=0;j<matrix[0].length;j++){
            if(matrix[i][j]==key){
                System.out.print("key found at " +i+ " " +j);
                return true;
            }
            
        }
        
       }
       System.out.println("key not found");
       return false;


    }
    public static void spiral(int matrix[][]) {
        int startr=0;
        int startc=0;
        int endr=matrix.length-1;
        int endc=matrix[0].length-1;
        while(startc<=endr && startc<=endc){
            //top
            for(int j=startc;j<=endc;j++){
                System.out.print(matrix[startr][j] +" ");
            }
            //right
            for(int i=startr+1;i<=endc;i++){
                System.out.print(matrix[i][endc] +" ");
            }
            //bottom
            for(int j=endc-1;j>=startc;j--){
                if(startr==endr){
                    break;
                }
                System.out.print(matrix[endr][j] + " ");
            }
            //left
            for(int i=endr-1;i>=startr+1;i--){
                if(startc==endc){
                    break;
                }
                System.out.print(matrix[i][startc] +" ");
            }
            startc++;
            startr++;
            endc--;
            endr--; 
        
        }
    }

    public static int diagonal (int matrix[][]){
        int sum=0;
        // for(int i=0;i<matrix.length;i++){
        //     for(int j=0;j<matrix[0].length;j++){
        //         if(i==j){
        //             sum+=matrix[i][j];
        //         }
        //         if(i+j==matrix.length-1){
        //             sum+=matrix[i][j];
        //         }
        //     }
        // }
        for(int i=0;i<matrix.length;i++){
            //primary diagonal
            sum+=matrix[i][i];
            if(i!=matrix.length-i-1);
            //secondary diagonal
            sum+=matrix[i][matrix.length-1-i];
        }
        return sum;
        

    }
    public static  boolean searchm(int matrix[][],int key){
        int row=matrix.length-1;;int col=0;
        while(row<matrix.length&&col>=0){
        if(key==matrix[row][col]){
            System.out.println("key found at " +row+col);
            return true;
        }
        else if(key<matrix[row][col]){
           row--;
        }
            else{
                col++;
            }


        }
        System.out.println("key not found");
        return false;

    } 
    public static void num(int matrix[][]){
        int col=3;
        int row=3;

       int[][] transpose=new int[col][row];
       for(int i=0; i<row; i++){
        for(int j=0;j<col;j++){
            transpose[j][i]=matrix[i][j];
                
        }
        
     
       }
       for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[0].length; j++){
        System.out.print(transpose[i][j]+" ");
    }
    System.out.println();
      
      
      
        

        
        
    }}
    public static void main(String args[]){
       int matrix[][]=new int [3][3];
       int n=matrix.length,m=matrix[0].length;
       Scanner sc= new Scanner(System.in) ;
    //    System.out.println("enter the key");
      
    //     int key=sc.nextInt();
          
     for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            matrix[i][j]=sc.nextInt();
             
        }
       
       }
      //spiral(matrix);
      //search(matrix,key);
     //System.out.println( diagonal(matrix));
     //searchm(matrix,key
     num(matrix);
  
    
     

}
}