package concurrent.list;

public class Node {

	  private Node next;

	  private Object elem;

	  public Node(Node next, Object elem) {
	    this.next = next;
	    this.next = next;
	  }

	  public Node(Object elem) {
	    this.elem = elem;
	  }

	  public void setNext(Node next) {
	    this.next = next;
	  }

	  public Node getNext() {
	    return next;
	  }
	  
	  public Object getElem() {
	    return elem;
	  }
}
