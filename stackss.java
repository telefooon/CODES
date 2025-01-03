import java.util.*;
public class stackss{
    public static void pushbottom(Stack<Integer> s,int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
int top=s.pop();
pushbottom(s,data);
s.push(top);
}
    public static String  reversestring(String str){
        Stack<Character> s= new  Stack<>();
        int idx=0;
        while(idx<str.length()){
          s.push(str.charAt(idx));
          idx ++;  
        }
        StringBuilder result=new StringBuilder(""); 
        while(!s.isEmpty()){ //character ko bahar nikalenge stack se fir stringbuilder mai daalenge
            char curr=s.pop();
            result.append(curr);
    }
    return result.toString();
}
public static void reversestack(Stack<Integer> s){
  if(s.isEmpty()){
    return;
  }
    int top=s.pop();
    reversestack(s);
    pushbottom(s, top);

}
public static void printstack(Stack<Integer> s){
    while(!s.isEmpty()){
        System.out.println(s.pop());
    }
}
public static void stockspan(int stocks[],int span[]){
    Stack<Integer> s=new Stack<>();
    span[0]=1;
    s.push(0);  
    for(int i=1;i<stocks.length;i++){
        int curr=stocks[i];
        while(!s.isEmpty() && curr>stocks[s.peek()]){ // find previous high
            s.pop();
        }
        if(s.isEmpty()){
            span[i]=i+1;
        }
        else{
            int prevhigh=s.peek();
            span[i]=i-prevhigh;
        }

        s.push(i);
    }

}
public static void nextgreater(int arr[]){
    Stack<Integer> s= new Stack<>();
    int nxtgreater []= new int[arr.length];
    for(int i=arr.length-1;i>=0;i--){
        //while condition to remove the elements from the stack
        while(!s.isEmpty() && arr[s.peek()]<=arr[i]){
            s.pop();
        }
        if(s.isEmpty()){
            nxtgreater[i]=-1;
        }
        else{
            nxtgreater[i]=arr[s.peek()];
        }
        s.push(i);

    } 
    for(int i=0;i<nxtgreater.length;i++){
        System.out.print(nxtgreater[i]+" ");
    }
    System.out.println();
}
public static boolean isvalid(String str){
    Stack<Character> s= new Stack<>();
    for(int i=0;i<str.length();i++){
        char curr=str.charAt(i);
// for opening
        if(curr=='{' || curr=='['||curr=='('){
            s.push(curr);

        }
        //closing
        else {
            if(s.isEmpty()){  // ex )))
                return false;

            }
            if((s.peek()=='{' && curr=='}') 
            ||(s.peek()=='[' && curr==']')  
            ||(s.peek()=='(' && curr==')')){
                s.pop();
                
            }
            else{
                return false;
            }



        }

    }
    if(s.isEmpty()){
        return true;
    }
    else{
        return false;

    }
}
public static boolean isDuplicate(String str) {
    Stack<Character> s = new Stack<>();

    for (int i = 0; i < str.length(); i++) {
        char ch = str.charAt(i);
        // closing
        if (ch == ')') {
            int count = 0;
            while (s.peek() != '(') {
                s.pop();
                count++;
            }
            if (count < 1) {
                return true; // duplicate exists
            } else {
                s.pop();
            }
        } else {
            s.push(ch);
        }
    }
    return false;
}
public static void mxarea(int arr[]){
    int maxarea=0;
    int nsr[]=new int[arr.length];
    int nsl[]=new int[arr.length];

    //next smaller right
    Stack<Integer> s= new Stack<>();
    for(int i=arr.length-1;i>=0;i--){
while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
    s.pop();

}
if(s.isEmpty()){
    nsr[i]=arr.length;
}
else{
 nsr[i]=s.peek();
}
s.push(i);
}
    //next smaller left
     s= new Stack<>(); //creating an empty stack
    for(int i=0;i<arr.length;i++){
while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
    s.pop();

}
if(s.isEmpty()){
    nsl[i]=-1;
}
else{
 nsl[i]=s.peek();
}
s.push(i);
 }
 //area= height *(i-j-1)
 for(int i=0;i<arr.length;i++){
    int height=arr[i];
    int width=nsr[i]-nsl[i]-1;
    int currarea=height*width;
    maxarea=Math.max(currarea, maxarea);
 }
 System.out.println(maxarea);


}


    public static void main(String args[]){

        int arr[]={2,1,5,6,2,3};
        mxarea(arr);
    //    String str="((a+b))";
    //   System.out.println( isDuplicate(str));
        // int stocks[]={100,80,60,70,60,85,100};
        // int span[]=new int[stocks.length];
        // stockspan(stocks,span);
        // for(int i=0;i<span.length;i++){
        //     System.out.println(span[i]+ " ");
        // }
        //  Stack<Integer> s=new Stack<>();
        //  s.push(1);
        //  s.push(2);
        //  s.push(3);
        //  printstack(s);
        //  reversestack(s);
        //  printstack(s);
        // // pushbottom(s,4);
        // // while(!s.isEmpty()){
        // //     System.out.println(s.pop());
        // // String str="abc";
        // // String result=reversestring(str);
        // // System.out.println(result);  

            

        }
    }
