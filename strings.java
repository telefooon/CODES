import java.util.*; // strings are IMMUTABLE
import java.lang.Math;
import java.util.Arrays;
    public class strings{
public static boolean palin(String str){
        for(int i=0;i<str.length()/2;i++){
            if(str.charAt(i)!=str.charAt(str.length()-1-i)){
            return false;
        }
    }
        return true;
    }
    public static float path(String path){
        int x=0;
        int y=0;
        for(int i=0;i<path.length();i++){
            char dir=path.charAt(i);// will determine the route
            if(dir=='S'){
                y--;
            }
            else if(dir=='N'){
                y++;
            }
            else if(dir == 'E'){
                x++;
            }
            else{
                x--;
            }
        }
        int X2=x*x;
        int Y2=y*y;
        return (float)Math.sqrt(X2+Y2);
    }
    
public static String compress(String str) {
          if (str.length() <= 1) {
            return str;
          }
          StringBuilder sb = new StringBuilder(str.length() + 1);
          char currChar = str.charAt(0);
          int currCount = 1;
          for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == currChar) {
              currCount++;
            } else {
              sb.append(currChar);
              sb.append(currCount);
              if(sb.length() > str.length()) {
                return str;
              }
              currChar = str.charAt(i);
              currCount = 1;
            }
          }
          sb.append(currChar);
          sb.append(currCount);
          return sb.toString();
        }
public static void anagrams(String str1, String str2){
          str1=str1.toLowerCase();
          str2=str2.toLowerCase();
          
          if(str1.length()==str2.length()){
            char[] str1charArray=str1.toCharArray();
            char[] str2charArray=str2.toCharArray();
              Arrays.sort(str1charArray);
              Arrays.sort(str2charArray);
boolean result=Arrays.equals(str1charArray,str2charArray);
 if(result) {
  System.out.print("STRINGS ARE ANAGRAMS");

}
 else  {
  System.out.print("STRINGS ARE NOT ANAGRAMS");
}
          }
        }
 

public static void main(String args[]) {
         System.out.println( path("NNSWE"));
            // System.out.println(compress("aabcccccaaa"));
//            Scanner sc=new Scanner(System.in);
//            String str;
//            String str2;
//            System.out.println("Enter the strings");
//            str=sc.nextLine();
//            str2=sc.nextLine();
// anagrams(str,str2);
          //  int count =0;
          //  for(int i=0; i<str.length();i++){
          //   char ch=str.charAt(i);
          //   if(ch=='a' || ch== 'e' || ch=='i' || ch=='o' || ch=='u'){
          //     count++;
          //   }
          //  }
          //  System.out.println(count);
          }
        }
        
        

    

    
    
        // String str[]={"mango","apple","banana"};
        // String largest=str[0];
        // for(int i=0;i<str.length;i++){
        //    if(largest.compareTo(str[i])<0){
        //     largest=str[i]; 
        //    }
        // }
        // System.out.println(largest);
   // System.out.println("ENTER STRING");
 //    for(char ch='a';ch<'z';ch++){
 //     sb.append(ch);
    //    }
    //    System.out.println(sb);
    
        
      
            

        
    