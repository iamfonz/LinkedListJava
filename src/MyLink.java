/**
 * MyLink.java 
 * 
 * A class implementation of a link in a singly linked list.
 * 
 * @author Alfonzo Avila
 *
 */


public class MyLink {

	/*
	 * Private class variables
	 */
	private int linkId;
	private Object data;
	private MyLink nextLink;


	/*
	 * Constructors
	 */
	public MyLink(int linkId, Object data){
		nextLink = null;
		this.data = data;
		this.linkId = linkId;
	}

	public MyLink(Object data, MyLink nextLink) {
		this.nextLink = nextLink;
		this.data = data;
	}



	/*
	 * Setters and getters
	 */

	public int getLinkId() {
		return this.linkId;

	}

	public void setLinkId(int newId) {
		this.linkId = newId;
	}

	public Object getData() {
		return this.data;
	}


	public void setData(Object data) {
		this.data = data;
	}


	public MyLink getNextLink() {
		return nextLink;
	}

	public void setNextlink(MyLink nextLink) {
		this.nextLink = nextLink;
	}


	/*
	 * Class Methods
	 */

	public String toString() {
		return "{linkId:"+ this.linkId + ", linkData:" + this.data + "}";

	}

}
