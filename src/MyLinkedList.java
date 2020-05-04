/**
 * Class to represent a self-implemented singly linked list.
 * 
 * @author Alfonzo Avila
 *
 */
public class MyLinkedList {
	/*
	 * Private class variables
	 */
	private MyLink head;
	private int linkCounter;

	/*
	 * Constructors
	 * 
	 */
	public MyLinkedList() {
		head = null;
		linkCounter = 0;
	}

	public MyLinkedList(MyLink head) {
		this.head = head;
		linkCounter = 1;
	}

	/*
	 * Setters and Getters
	 * 
	 */

	public void setHeadlink(MyLink head) {
		this.head = head;
	}

	public MyLink getHeadLink() {
		return this.head;
	}
	
	public int getCounter() {
		return this.linkCounter;
	}

	/*
	 * Class Methods
	 */


	/**
	 * Inserts a new link at the end of the linked list.
	 * @param linkToInsert New link to be inserted at the end of the linked list.
	 */
	public void insert(MyLink linkToInsert) {



		//make sure head link is not null
		if(head != null) {
			MyLink currentlink = head;
			//traverse through the linked list to get to the end
			while(currentlink.getNextLink() != null) {
				currentlink = currentlink.getNextLink();
			}

			//set the last links nextLink to the inserted link
			currentlink.setNextlink(linkToInsert);
		}else {
			//else if head is null, set inserted link as the head
			head = linkToInsert;
		}

		incrementCounter();

	}


	/** 
	 * Inserts a new link at the beginning of the linked list.
	 * @param link New link to be set as the first
	 */
	public void insertFirst(MyLink newlink) {
		//get the original head link
		MyLink originalHead = head;

		//set the head link of the link to the new passed in link
		this.head = newlink;

		//set nextLink of the newlink to the original head
		this.head.setNextlink(originalHead);

		incrementCounter();
	}


	/**
	 * Inserts a new link after a specified link id
	 * @param linkToInsert The new link that will be inserted.
	 * @param linkId The Id of the existing link of which the new link will be inserted after.
	 */
	public void insertAfter(MyLink linkToInsert, int linkId) {
		//check that list is not empty.
		if(!isEmpty()) {
			//start from head link
			MyLink currentlink = head;

			//traverse the link
			while(currentlink.getNextLink()!=null) {

				//check if linkId is the same as passed in Id
				if(currentlink.getLinkId() == linkId) {

					//set nextLink of passed in insert link to the nextLink of the found link
					linkToInsert.setNextlink(currentlink.getNextLink());

					//sent currentlink.nextHead to be the passed in link
					currentlink.setNextlink(linkToInsert);			
				}
				//go to next link if not matching
				currentlink = currentlink.getNextLink();
			}

			incrementCounter();

		}

	}


	/**
	 * Finds a link with a passed in Id of a link.
	 * @param linkId The Id of the link to be found.
	 * @return The found link in the linked list. If no link is found, returns null.
	 */
	public MyLink findLink(int linkId) {

		//check that linked list is not empty
		if(!isEmpty()) {
			//start from head to traverse
			MyLink currentlink = head;

			//check that head is not null
			if(currentlink != null) {
				//traverse the link
				while(currentlink.getNextLink() != null) {
					//check if link Id's match
					if(currentlink.getLinkId() == linkId) {
						return currentlink;
					}
					// go to next link if nothing found
					currentlink = currentlink.getNextLink();
				}
			}

			//return null if nothing found.
			return null;
		}else {
			return null;
		}
	}


/**
 * Deletes the last link in the linked list.
 * 
 * @return The MyLink object that has been deleted.
 */
	public MyLink deleteLast() {

		//check that linked list is not empty
		if(!isEmpty()){

			if(linkCounter >2 ) {

				//variable to keep track of position
				int currentPlace = 1;

				//traverse through link
				MyLink currentlink = head;
				
				
				while(currentlink.getNextLink() != null) {

					if(currentPlace == linkCounter - 1) {
						//check if at the second to last position in the link to delete nextLink reference
						MyLink deletedLink = currentlink.getNextLink();
						currentlink.setNextlink(null);
						decrementCounter();
						return deletedLink;

					}else {//continue traversing
						currentlink = currentlink.getNextLink();
						currentPlace++;
					}


				}

			}else {
				//if the linked list is not greater than two, that means the nextLink reference of the head can be set to null.
				MyLink deletedLink = head.getNextLink();
				head.setNextlink(null);
				decrementCounter();
				return deletedLink;
			}
		}
		return null;
	}

	/**
	 * Checks if the linked list is empty.
	 * @return
	 */
	public boolean isEmpty() {
		if(linkCounter == 0) {
			return true;
		}else{
			return false;
		}

	}


	/**
	 * Displays linked list as a concatenated string of each link's toString() method.
	 * @return Linked list as a string.
	 */
	public String displayList() {

		String display = "First --> Last: ";
		//start from beginning link
		MyLink currentlink = head;
		display += currentlink.toString();
		
		//traverse through the link
		while(currentlink.getNextLink() !=null) {
			
			currentlink = currentlink.getNextLink();
			display += currentlink.toString();
		}

		return display;
	}


	/*
	 * Private Methods
	 */

	private void incrementCounter() {
		this.linkCounter++;
	}

	private void decrementCounter() {
		this.linkCounter--;
	}

}



