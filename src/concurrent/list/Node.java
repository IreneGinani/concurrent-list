package concurrent.list;

/**
 * Class to represents the node list.
 * @author  Gabriela Cavalcante and Irene Ginani
 * @version 24/05/2018
 */
public class Node {
	  private Node next;
	  private int value;

	  public Node(Node next, int elem) {
		  this.next = next; 
	  }

	  public Node(int value) {
		  this.value = value;
		  this.next = null;
	  }

	  /**
	   * Set the next node in current node.
	   * @param next node
	   */
	  public void setNext(Node next) {
		  this.next = next;
	  }

	  /**
	   * Get next node of current node.
	   * @return next node
	   */
	  public Node getNext() {
		  return next;
	  }
	  
	  /**
	   * Get value of current node.
	   * @return value
	   */
	  public int getValue() {
		  return value;
	  }
}
