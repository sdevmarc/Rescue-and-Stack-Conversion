import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StackConversion
{
	static BufferedReader datain = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args)
    {
    	try
    	{        
    		char ans = 'y';
            while (ans == 'y')
            {
                String exp;
                String[] c = new String[86];
                for(int i = 0; i < 86; i++)
                {
                	c[i] = "=";
                }
                System.out.println("C H O O S E   O N E    O F   T H E S E    C H O I C E S ! \n\n[1]Infix To Postfix - [2]Postfix To Infix - [3]Prefix To Postfix - [4]Postfix To Prefix");
                for(int i = 0; i < 86; i++)
                {
                	System.out.print(c[i]);
                }
                System.out.print("\n\nEnter the number: ");
    			int choice = Integer.parseInt(datain.readLine());
                switch (choice) 
                {
                	case 1:
                		System.out.print("\nEnter Expression: ");
                		exp = datain.readLine();
                        System.out.println("Infix to Postfix: " + InfiPost(exp));
                        break;
                    case 2:
	                    System.out.print("\nEnter Expression: ");
	                    exp = datain.readLine();
	                    System.out.println("Postfix to Infix: " + PostInfi(exp));
	                    break;
                    case 3:
	                    System.out.print("\nEnter Expression: ");
	                    exp = datain.readLine();
	                    System.out.println("Prefix to Postfix:" + PrefPost(exp));
	                    break;
                    case 4:
	                    System.out.print("\nEnter Expression: ");
	                    exp = datain.readLine();
	                    System.out.println("Postfix to Prefix: " + PostPref(exp));  
	                    break;
                    default:
                        System.out.println("Invalid Command!");
                }       	         	        	
                		System.out.print("\nT R Y  A G A I N ? [Y/N]: ");
                		ans = datain.readLine().charAt(0);
           }
	    }
    	catch(Exception e)
	    {
	    		System.out.println("E R R O R  E N C O U N T E R E D !");
	    }                     
    }

	    public static String InfiPost(String a) 
	    {
	    	StackClass stack = new StackClass(0);
	        String output = new String("");
	        stack = new StackClass(a.length());
	        for (int i = 0; i < a.length(); ++i) 
	        {
	            char b = a.charAt(i);
	            if (Character.isLetterOrDigit(b))
	            {
	            	output = output + b;
	            }
	            else if (b == '(')
	            {
	                stack.pushCha(b);
	            }
	            else if (b == ')') 
	            {
	                while (!stack.isEmpty() && !(stack.peek()).equals("("))
	                {
	                	output = output + stack.pop();
	                }
	                if (!stack.isEmpty() && !(stack.peek()).equals("("))
	                {
	                    return "Invalid Expression";
	                }
	                else
	                {
	                    stack.pop();
	                }
	            } 
	            else 
	            {
	                while (!stack.isEmpty() && Operank(b) <= Operank((stack.peek()).charAt(0)))
	                {
	                	output = output + stack.pop();
	                }
	                stack.pushCha(b);
	            }
	        }
	        while (!stack.isEmpty())
	        {
	        	output += stack.pop();
	        }
	        return output;
	    }
	
	    public static String PostInfi(String a) 
	    {
	    	StackClass stack = new StackClass(0);
	    	String output = new String("");
	    	stack = new StackClass(a.length());
	    	for (int i = 0; i < a.length(); i++) 
	    	{
	            char c = a.charAt(i);
	
	            if (Ope(c)) 
	            {
	                String e = stack.peek();
	                stack.pop();
	                String j = stack.peek();
	                stack.pop();
	                String exp = "(" + j + c + e + ")";
	                stack.push(exp);
	            } 
	            else 
	            {
	            	stack.push(c + "");
	            }
	        }
	        output = stack.peek();
	        return output;
	    }
	  
	    public static String PrefPost(String a) 
	    {
	    	StackClass stack = new StackClass(0);
	    	stack = new StackClass(a.length());
	        int length = a.length();
	        for (int i = length - 1; i >= 0; i--) 
	        {
	            if (Ope(a.charAt(i))) 
	            {
	                String e = stack.peek();
	                stack.pop();
	                String j = stack.peek();
	                stack.pop();
	                String exp = e + j + a.charAt(i);
	                stack.push(exp);
	            } 
	            else 
	            {
	            	stack.push(a.charAt(i) + "");
	            }
	        }
	        return stack.peek();
	    }
	
	    public static String PostPref(String a) 
	    {
	    	StackClass stack = new StackClass(0);
	    	stack = new StackClass(a.length());
	        for (int i = 0; i < a.length(); i++) 
	        {
	            char c = a.charAt(i);
	            if (Ope(c)) 
	            {
	                String e = stack.peek();
	                stack.pop();
	                String j = stack.peek();
	                stack.pop();
	                String temp = a.charAt(i) + j + e;
	                stack.push(temp);
	            } 
	            else 
	            {
	            	stack.push(a.charAt(i) + "");
	            }
	        }
	        return stack.peek();
	    }
	    public static boolean Ope(char x) 
	    {
	    	if(x == '+' || x == '=' || x == '/' || x == '*' || x == '^')
	    	{
	    		return true;
	    	}
	    	else
	    	{
	    		return false;
	    	}
	    }
	
	    public static int Operank(char x) 
	    {
	    	if(x == '+' || x == '-')
	    	{
	    		return 1;
	    	}
	    	else if(x == '*' || x == '/')
	    	{
	    		return 2;
	    	}
	    	else if(x == '^')
	    	{
	    		return 3;
	    	}
	    	else
	    	{
	    		return -1;
	    	}
	    }
	
	}
	class StackClass 
	{
		static String[] exp;
		static int Size; 
		static int top; 
		
		public StackClass(int a)
		{
			exp = new String[a];
			Size = a; 
	        top = -1; 
		}
		public boolean isEmpty()
		{
			return top == -1;
		}
		public void push(String a)
		{
			if (top == Size - 1) 
			{ 
	            System.out.println("Error has been encountered"); 
	            System.exit(0);
	        }
			exp[++top] = a;
		}
		public void pushCha(char a)
		{
			if (top == Size - 1) 
			{ 
	            System.out.println("Error has been encountered"); 
	            System.exit(0);
	        }
			exp[++top] = Character.toString(a);
		}
		public String peek()
		{
			 if (top == -1) 
			 { 
				 System.out.println("Error has been encountered"); 
		         System.exit(0); 
		     } 
		        return exp[top]; 
		}
		
		public String pop()
		{
			if (top == -1) 
			{ 
	            System.out.println("Error has been encountered"); 
	            System.exit(0); 
	        } 
			return exp[top--]; 
		}
		
	}
	
