// { Driver Code Starts
import java.util.*;
 
class RLEncoding
{
   public static void main(String[] args) 
   {
 
      Scanner sc = new Scanner(System.in);
    
	  int T = sc.nextInt();
	  sc.nextLine();
	  while(T>0)
	  {
		  
		String str = sc.nextLine();
		
		GfG g = new GfG();
		System.out.println(g.encode(str));
		
      
        T--;
	  }
   }
}

// } Driver Code Ends


class GfG
 {
	String encode(String str)
	{
        int count = 0;
        String newStr = new String("");
        char ch = str.charAt(0);
        for(int i=0; i< str.length(); i++) {
            if(ch == str.charAt(i)) {
                count ++;
            } else {
                newStr += ch;
                newStr += count;
                count = 1;
                ch = str.charAt(i);
            }
            if(i == str.length()-1) {
                newStr += ch;
                newStr += count;
            }
        }
        return newStr;
	}
	
 }