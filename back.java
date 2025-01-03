import java.util.Scanner;

public class back{
    static String[] keypad={" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};


public static void changearr(int arr[],int i, int val){
    if(i==arr.length){
        printarr(arr);
        return;
        }
        arr[i]=val;
        changearr(arr,i+1,val+1);//fnc calling step
        arr[i]=arr[i]-2;// backtracking line

}

public static void printarr(int arr[]){
    for(int i=0;i<arr.length;i++){
        System.out.print(" "+arr[i]);

    }
    System.out.println();
}
public static void findsubsets(String str, String ans, int i){
    if(i==str.length()){
        if(ans.length()==0){
            System.out.println("NULL");
        }
        else{
     System.out.println(ans);   
        }   
     return;
        
    } 
    //if choice is YES
    findsubsets(str, ans+str.charAt(i), i+1);
    //if choice is NO
    findsubsets(str, ans, i+1);
}
public static void permu(String str,String ans){
    //base casse
    if(str.length()==0){
        System.out.println(ans);
        return;
    }
    for(int i=0;i<str.length();i++){
        char curr=str.charAt(i);
        // "abcde"="ab"+"de"="abde"(remove c then fcking add the strings)
        String newstr=str.substring(0,i)+str.substring(i+1);//by default the last indexing is taken as n-1
        permu(newstr, ans+curr);
    }
    
}
public static void nqueens(char board[][],int row){ 
    if(row==board.length){
        printboard(board);
        return;
    }
    for(int j=0;j<board.length;j++){
       if( isSafe(board,row,j)){
        board[row][j]='Q';
        nqueens(board, row+1);
        board[row][j]='X';//backtracking step
    }
}

}
public static boolean isSafe(char board[][],int row, int col){
    //vertical up
    for(int i=row-1;i>=0;i--){
    if(board[i][col]=='Q'){
        return false;
    }
}
    //left diagonal
    for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
        if(board[i][j]=='Q'){
        return false;
    }

    }
    //right diagonal
    for(int i=row-1,j=col+1;i>=0&&j<board.length;i--,j++){
         if(board[i][j]=='Q'){
        return false;
    }

    }
    return true;
    }


public static void printboard(char board[][]){
    System.out.println("-----chess board-------");
     for(int i=0;i<board.length;i++){
        for(int j=0;j<board.length;j++){
            System.out.print(board[i][j]+" ");

        }
        System.out.println();
      
    }
}
public static int gridways(int i, int j, int rows, int columns){
    //base case
    if(i==rows-1 &&j==columns-1 ){//condition for last cell
        return 1;
    }
else if(i==rows || j==columns){
    return 0;
}
int w1=gridways(i+1, j, rows, columns);
int w2=gridways(i, j+1, rows, columns);
return w1+w2;
}
public static boolean issafe(int sudoku[][],int row,int col,int digits){
   //column
    for(int i=0;i<=8;i++){
        if(sudoku[i][col]==digits){
            return false;
        }
    }
    //row
        for(int j=0;j<=8;j++){
            if(sudoku[row][j]==digits){
                return false;
            }
        }
        //grid
    int sr=(row/3)*3;
    int sc=(col/3)*3;
    //3x3 grid
    for(int i=sr;i<sr+3;i++){
        for(int j=sc;j<sc+3;j++){
            if(sudoku[i][j]==digits){
                return false;
            }
        }
    }
    return true;
    

}
public static boolean sudokusolv(int sudoku[][],int row, int col){
    //base case
    if(row==9){
        return true;
    }
    
    
    //recursive case
    int nextrow=row;
    int nextcol=col+1;
    if(col+1==9){ // when column gets out of bounds
        nextrow=row+1;
        nextcol=0;
    }
    if(sudoku[row][col]!=0){// checks if digit present at the current cell is zero 
        return sudokusolv(sudoku, nextrow, nextcol);
    }
    for(int digit=1;digit<=9;digit++){ // code to place digit
        if(issafe(sudoku,row,col,digit)){// checks if digit can be placed at the current cell
        sudoku[row][col]=digit;// digit gets placed
        if(sudokusolv(sudoku, nextrow, nextrow)){// first row  gets fcking traversed,, onto next row
            return true;
        }
        sudoku[row][col]=0;
    }
}
return false;
}
public static void printsudoku(int sudoku[][]){
    for(int i=0;i<9;i++){
        for(int j=0;j<9;j++){
            System.out.print(sudoku[i][j]+" ");
        }
        System.out.println();
    }
}

public static boolean mazesolv(int maze[][],int x,int y,int sol[][]){
    if(x==maze.length-1&& y==maze.length-1&&maze[x][y]==1){
        sol[x][y]=1;
        return true;
    }
    if(issafee(maze,x,y)==true){
      if(maze[x][y]==0)
      return false;
      sol[x][y]=1;

        if(mazesolv(maze, x+1, y, sol))
    return true;
        
   if(mazesolv(maze, x, y+1, sol))
    return true;
   
    sol[x][y]=0;
    return false;
}
return false;
}
public static boolean issafee(int maze[][],int x,int y){
    return(x>=0 && x<maze.length && y>=0 && y<maze.length && maze[x][y]==1);

}
public static boolean mazeso(int maze[][]){
    int n=maze.length;
    int sol[][]=new int[n][n];
    if(mazesolv(maze, 0, 0, sol)==false){
        System.out.println("soln doesnt exist");
        return false;
    }
    printSolution(sol);
    return true;
}
public static void printSolution(int sol[][]) {
    for(int i=0;i<sol.length;i++) {
        for(int j=0;j<sol.length;j++) {
            System.out.print(" "+sol[i][j] +" ");
            
        }
            System.out.println();
        }
    
}
public static  void possiblewords(String s, String ans){
    if(s.length()==0){
        System.out.println(ans);
        return; 
    }
    String key=keypad[s.charAt(0)-48]; // key=t u v(characters at 8th index)
    for(int i=0;i<key.length();i++){
        
        possiblewords(s.substring(1), ans+key.charAt(i));
    }
}

public static void main(String[] args) {
    // int arr[]=new int[5];
    // // changearr(arr,0,1);
    // // printarr(arr);
    // String str="abc";
    // permu(str," ");
    // int n=4;
    // char board[][]=new char[n][n];// intializing a chess board
    // for(int i=0;i<n;i++){//creating a chess board
    //     for(int j=0;j<n;j++){
    //         board[i][j]='X'; 
    //     }
    // }
//    System.out.println( gridways(0, 0, 3, 3));
//    int sudoku[][]={{0,0,8,0,0,0,0,0,0},
//    {4,9,0,1,5,7,0,0,2},
//    {0,0,3,0,0,4,1,9,0},
//    {1,8,5,0,6,0,0,2,0},
//    {0,0,0,0,2,0,0,6,0},
//    {9,6,0,4,0,5,3,0,0},
//    {0,3,0,0,7,2,0,0,4},
//    {0,4,9,0,3,0,0,5,7},
//    {8,2,7,0,0,9,0,1,3}};
// if(sudokusolv(sudoku, 0,0)){
//     System.out.println("soln exists");
//     printsudoku(sudoku);
// }
// else { 
//     System.out.println("soln doesnt exists");
// }

// }
// int maze[][] = { { 1, 0, 0, 0 },
//                  { 1, 1, 0, 1 },
//                  { 0, 1, 0, 0 },
//                  { 1, 1, 1, 1 } };

// mazeso(maze);
Scanner sc=new Scanner(System.in);
String s=sc.next();
possiblewords(s, "");
}

}