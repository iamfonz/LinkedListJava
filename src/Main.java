/**
 * Assignment 3
 * A self-implementation of a singly linked list.
 * 
 * @author Alfonzo Avila
 * @date Spring 2020
 * @Course CS-357 - Data Structures
 * @instructor Dr. Cheng
 * 
 * 
 * 
 */
import java.util.Scanner;


public class Main{

	private static MyLinkedList linkedList = new MyLinkedList();

	public static void main(String[] args) {

		printHeader();
		linkedListBuilderUi();

	}

	/**
	 * Where all the magic happens, per the specs of the assignment. 
	 * 
	 * First asks user to enter the size of the linked list. Next, user is asked to enter the values for each link.
	 * Then, the linked list is displayed. Next, user is asked to enter an int Id to find in the linked list. If found it is displayed,
	 * else user is told nothing is found. Next, the last link in the list is deleted and displayed to the user.
	 * Finally, a new link is inserted after a link of user specified linkId and the link is displayed again.
	 */
	private static void linkedListBuilderUi() {
		//scanner object to get input.
		Scanner in = new Scanner(System.in);
		
		makeUserLinkedList(in);

		//display the entire linked list
		displayLinkedList();

		System.out.println("\n--------------------\nEnter the Id of a link you wish to find: ");
		int findId = in.nextInt();

		MyLink foundLink = linkedList.findLink(findId);
		if(foundLink !=null) {
			System.out.println("Found link with Id: " + findId + " and data value of: " + foundLink.getData());
		}else {
			System.out.println("Link with key Id: " + findId + " not found.");
		}

		MyLink lastDelete = linkedList.deleteLast();
		System.out.println("\n--------------------\nDeleting last link\nDeleted the following link: " + lastDelete.toString());

		//display the entire linked list
		displayLinkedList();

		System.out.println("\n--------------------\nNow, let's insert a new link. Enter the id of the link you wish to enter the new one after: ");

		int afterId = in.nextInt();

		linkedList.insertAfter(getNewLinkFromUser(in, linkedList.getCounter()), afterId);
		//display the entire linked list
		System.out.println("\n--------------------\nThe Linked List:\n" + linkedList.displayList());

	}

	/**
	 * Makes the linked list by asking for user input. Asks user how many links total, then has user enter values for each node.
	 * @param in Scanner object for getting user input.
	 */
	private static void makeUserLinkedList(Scanner in) {

		System.out.println("Welcome to the Linked List builder!\nInput the desired number of links (you must inter a positive integer): ");
		
		int numberOfLinks = in.nextInt();
		System.out.println("You have entered " + numberOfLinks + ".\n");
		
		//enter values for each node
		for(int i = 0; i < numberOfLinks; i++) {

			linkedList.insert(getNewLinkFromUser(in, i+1));
		}
	}

	/**
	 * Gets input from user to create a new link of a linked list.
	 * @param input Scanner object to read in the values.
	 * @param linkNumber The place of the link that is being entered by the user.
	 * @return A MyLink object with values gather from user.
	 */
	private static MyLink getNewLinkFromUser(Scanner input, int linkNumber) {

		System.out.println("--------------------\nEnter the values for a new link number " + linkNumber +".\nFirst the Id value (must be integer): ");
		int idVal = input.nextInt();
		System.out.println("Next the data: ");
		Object dataVal = input.next();

		return new MyLink(idVal, dataVal);
	}

	/**
	 * Displays the linked list to the console window.
	 */
	private static void displayLinkedList() {
		//display the entire linked list
		System.out.println("\n--------------------\nThe Linked List:\n" + linkedList.displayList());
	}


	/**
	 * Prints a quick heading and description of the program.
	 */
	private static void printHeader() {
		System.out.print("Assignment 3\nA self-implementation of a singly linked list.\n\nAlfonzo Avila\nSpring 2020\nCS-357\nDr Cheng\n\n\n");
	}


}