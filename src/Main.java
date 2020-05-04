/**
 * @title Assignment 3 - Linked List
 * 
 * A self-implementation of a singly linked list.
 * 
 * The method linkedListBuilderUi() is the program that runs per the assignment's specs. For quick testing purposes, 
 * I created some test methods and used the values in the examples of the spec. It made it convenient so that instead of 
 * having to re-enter the inputs over and over again just to test code here and there. They are at the bottom of this.
 * They may be ignored/used as needed.
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
		
		//print the assignment header first
		printHeader();
		
		//scanner object to get input.
		Scanner in = new Scanner(System.in);
		
		//create the linkedList from user input
		makeUserLinkedList(in);

		//display the entire linked list
		displayLinkedList();
		
		//find link based on user input
		findLinkSection(in);

		//delete the last link in list
		deleteLastLinkSection();
		
		//display the entire linked list
		displayLinkedList();
		
		//inserts a new link after user specified link id.
		insertAfterSection(in);

		//display the entire linked list
		displayLinkedList();

	}
	
	
	/**
	 * Asks user for a linkId of which a new link will be inserted after it. User enters values for the new link to be inserted.
	 * @param in
	 */
	private static void insertAfterSection(Scanner in) {
		System.out.println("\n--------------------\nNow, let's insert a new link. Enter the id of the link you wish to enter the new one after: ");

		int afterId = in.nextInt();

		linkedList.insertAfter(getNewLinkFromUser(in, linkedList.getCounter()), afterId);
	}

	
	/**
	 * Deletes the last link in the list. Displays the data of the deleted link.
	 */
	private static void deleteLastLinkSection() {
		MyLink lastDelete = linkedList.deleteLast();
		System.out.println("\n--------------------\nDeleting last link\nDeleted the following link: " + lastDelete.toString());
	}
	
	
	/**
	 * Asks user to find a link based on linkId entered by the user.
	 * @param in Scanner object for user input
	 */
	private static void findLinkSection(Scanner in) {
		System.out.println("\n--------------------\nEnter the Id of a link you wish to find: ");
		int findId = in.nextInt();

		MyLink foundLink = linkedList.findLink(findId);
		if(foundLink !=null) {
			System.out.println("Found link with Id: " + findId + " and data value of: " + foundLink.getData());
		}else {
			System.out.println("Link with key Id: " + findId + " not found.");
		}

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

	
	
	
	/* 
	 * TESTING GROUNDS!
	 */
	/**
	 * Testing for example 1 of the assignment spec.
	 */
	private static void test1() {
		System.out.println("Start of test1 method!");
		linkedList.insertFirst(new MyLink(11, 1.9));
		linkedList.insertFirst(new MyLink(22, 2.9));
		linkedList.insertFirst(new MyLink(33, 3.9));
		linkedList.insertFirst(new MyLink(44, 4.9));
		displayLinkedList();
		System.out.println("Find ID 33:\n" + linkedList.findLink(33).toString());
		System.out.println("Delete Last Link: " + linkedList.deleteLast().toString());
		displayLinkedList();
		System.out.println("Insert after Id 44");
		linkedList.insertAfter(new MyLink(55, 5.9), 44);
		displayLinkedList();
		System.out.println("End of test1 method!");
		
	}
	
	/**
	 * Testing for example 2 of the assignment spec.
	 */
	private static void test2() {
		System.out.println("Start of test2 method!");
		linkedList.insertFirst(new MyLink(77, 7.9));
		linkedList.insertFirst(new MyLink(88, 8.9));
		linkedList.insertFirst(new MyLink(99, 9.9));
		displayLinkedList();
		if(linkedList.findLink(55) != null) {
			System.out.println("Find ID 55:\n" + linkedList.findLink(55).toString());
		}else {
			System.out.println("Can't find link with id 55");
		}
		System.out.println("Delete Last Link: " + linkedList.deleteLast().toString());
		displayLinkedList();
		System.out.println("Insert after Id 88");
		linkedList.insertAfter(new MyLink(100, 10.9), 88);
		displayLinkedList();
		
	}

}