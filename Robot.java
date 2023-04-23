import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Robot 
{
	static BufferedReader datain = new BufferedReader(new InputStreamReader(System.in));
	static int row = 0;
	static int col = 0;

	class Node 
	{
		String data;
		Node prev;
		Node next;

		public Node(String data) 
		{
			this.data = data;
			this.prev = null;
			this.next = null;
		}
	}

	// Represent the head and tail of the singly linked list
	public Node head = null;
	public Node tail = null;
	static int len = 0;

	// addAtStart() will add a new node to the beginning of the list
	public void addAtStart(String data) 
	{
		// Create a new node
		Node newNode = new Node(data);

		// Checks if the list is empty
		if (head == null) 
		{
			// If list is empty, both head and tail will point to new node
			head = newNode;
			tail = newNode;
		} 
		else 
		{
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
	}

	public void display() 
	{
		// Node current will point to head
		Node current = tail;
		if (head == null) 
		{
			System.out.println("The array is empty!");
			return;
		}
		while (current != null) 
		{
			// Prints each node by incrementing pointer
			System.out.print("[" + current.data + "]" + "=> ");
			current = current.prev;
		}
		System.out.println();
	}

	public static void main(String[] args) 
	{
		String[][] map = new String[5][40];
		Robot List = new Robot();
		intMap(map);

		for (int i = 0; i < 10; i++) 
		{
			int x = (int) (Math.random() * 5);
			int y = (int) (Math.random() * 40);
			map[x][y] = "X";
		}
		for (int i = 0; i < 1; i++) 
		{
			row = (int) (Math.random() * 5);
			col = (int) (Math.random() * 40);
			map[row][col] = "R";

		}

		for (int i = 0; i < 1; i++) 
		{
			int x = (int) (Math.random() * 5);
			int y = (int) (Math.random() * 40);
			map[x][y] = "C";
		}

		char ans = 'y';
		while(ans == 'y' || ans == 'Y')
		{	
		
		showMap(map);
		boolean Game = false;
		while (!Game) 
		{
			try
			{
			System.out.print("\nEnter Command: ");
			String com = datain.readLine().toUpperCase();
			System.out.println();
			int step = Integer.parseInt(com.substring(1, 2));
			switch (com.substring(0, 1)) 
			{
			case "R":
				for (int i = 0; i < step; i++) 
				{
					if ((col + step) <= 39) 
					{
						map[row][col] = "+";
						col++;
						if (map[row][col] == "C") 
						{
							System.out.println("\nR E S C U E  S U C C E S S F U L !");
							Game = true;
						} 
						else if (map[row][col] == "X") 
						{
							System.out.println("\nR E S C U E   F A I L E D !");
							Game = true;
						} 
						else 
						{
							map[row][col] = "R";
						}
					} 
					else 
					{
						System.out.println("Y O U  A R E  O U T  O F  B O U N D S !");
					}
				}
				showMap(map);
				System.out.println("\nROBOT NAVIGATION: " + "[" + row + "]" + "[" + col + "]");
				List.addAtStart(com);
				List.display();
				break;

			case "L":
				for (int i = 0; i < step; i++) 
				{
					if ((col - step) >= 0) 
					{
						map[row][col] = "+";
						col--;
						if (map[row][col] == "C") 
						{
							System.out.println("\nR E S C U E  S U C C E S S F U L !");
							Game = true;
						} 
						else if (map[row][col] == "X") 
						{
							System.out.println("\nR E S C U E   F A I L E D !");
							Game = true;
						} 
						else 
						{
							map[row][col] = "R";
						}
					} 
					else 
					{
						System.out.println("Y O U  A R E  O U T  O F  B O U N D S !");
					}
				}
				showMap(map);
				System.out.println("\nROBOT NAVIGATION: " + "[" + row + "]" + "[" + col + "]");
				List.addAtStart(com);
				List.display();
				break;

			case "D":
				for (int i = 0; i < step; i++) 
				{
					if ((row + step) <= 4) 
					{
						map[row][col] = "+";
						row++;
						if (map[row][col] == "C") 
						{
							System.out.println("\nR E S C U E  S U C C E S S F U L !");
							Game = true;
						} 
						else if (map[row][col] == "X") 
						{
							System.out.println("\nR E S C U E   F A I L E D !");
							Game = true;
						} 
						else 
						{
							map[row][col] = "R";
						}
					} 
					else 
					{
						System.out.println("Y O U  A R E  O U T  O F  B O U N D S !");
					}
				}
				showMap(map);
				System.out.println("\nROBOT NAVIGATION: " + "[" + row + "]" + "[" + col + "]");
				List.addAtStart(com);
				List.display();
				break;

			case "U":
				for (int i = 0; i < step; i++) 
				{
					if ((row - step) >= 0) 
					{
						map[row][col] = "+";
						row--;
						if (map[row][col] == "C") 
						{
							System.out.println("\nR E S C U E  S U C C E S S F U L !");
							Game = true;
							break;
						} 
						else if (map[row][col] == "X") 
						{
							System.out.println("\nR E S C U E   F A I L E D !");
							Game = true;
							break;
						} 
						else 
						{
							map[row][col] = "R";
						}
					} 
					else 
					{
						System.out.println("Y O U  A R E  O U T  O F  B O U N D S !");
					}
				}
				
				showMap(map);
				System.out.println("\nROBOT NAVIGATION: " + "[" + row + "]" + "[" + col + "]");
				List.addAtStart(com);
				List.display();
				break;
				
			}
			System.out.println("\nTry again? [Y/N]: ");
			ans = datain.readLine().charAt(0);
			break;
			}
			catch (Exception e)
			{
				System.out.println("I N V A L I D   C O M M A N D !");
			}
		}
		}
	}

	public static void intMap(String m[][]) 
	{
		for (int i = 0; i < 5; i++) 
		{
			for (int j = 0; j < 40; j++) 
			{
				m[i][j] = "-";
			}
		}
	}

	public static void showMap(String m[][]) 
	{
		System.out.println("\nRESCUE ROBOT MAP ENVIRONMENT");
		for (int i = 0; i < 5; i++) 
		{
			for (int j = 0; j < 40; j++) 
			{
				System.out.print(m[i][j]);
			}
			System.out.println();
		}
	}
}