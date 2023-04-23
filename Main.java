import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main {

	public static void main(String[] args) 
	{
		try
		{
			BufferedReader datain = new BufferedReader(new InputStreamReader(System.in));
			char ans = 'y';
			while(ans == 'y' || ans == 'Y')
			{	System.out.println("MADE BY: SUAREZ, MARC EDISON D. BSIT - 2");
				System.out.println();
				System.out.print("C H O O S E  Y O U R  P R O G R A M ! \n\n[1] PLAY ROBOT MAP ENVIRONMENT - [2] STACK CONVERSIONS - [3] Exit");
				System.out.print("\n\nEnter your choice: ");
				int choice = Integer.parseInt(datain.readLine());
				switch(choice)
				{
				case 1:
					Robot.main(args);
					break;
				case 2:
					StackConversion.main(args);
					break;
				case 3:
					System.exit(0);
				default:
					System.out.println("\nChoose appropriate number!");
					break;
				}	
				System.out.print("\nProceed to Main Menu? [Y/N]: ");
				ans = datain.readLine().charAt(0);
			}
			
		}
		catch (Exception e)
		{
			System.out.println("Invalid Command!");
		}

	}

}
