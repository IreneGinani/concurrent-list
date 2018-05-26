package concurrent.list;
 

/**
 * Class to represent the Linked list.
 * @author  Gabriela Cavalcante and Irene Ginani
 * @version 24/05/2018
 */
public class List {
	private Node first;
	private Node last;
	private int size;  
	
	
	/**
	 * Return the element at the specified position in this list.	
	 * @param index index of the element to return
	 * @return the element at the specified position in this list
	 */
	public Node searchNode(int index) {
		if(index >= this.size) 
	        throw new IndexOutOfBoundsException("Node doesn't exist");
		
		Node now = first;
		for (int i = 0; i < index; i++) {
		    now = now.getNext();
		}
		return now;    
	} 
	
	/**
	 * Add the specified node to the end of this list.
	 * @param value element to be appended to this list
	 */
	public void add(int value) {
		 Node new_node = new Node(value);
		 
		 if (this.first == null) {
			 this.first = new_node;
			 this.last = new_node;
			 this.size++;
		 } else { 
			 this.last.setNext(new_node);
			 this.last = new_node;
			 this.size++;
		 }
	}
	
	/**
	 * Removes the node at the specified position.
	 * @param index the index of the node to be removed.
	 * @return the node that was removed from the list.
	 */
	public Node remove(int index) {  
		if(index >= this.size) 
	        throw new IndexOutOfBoundsException("Node doesn't exist");
		
		Node node = this.searchNode(index);
		Node before = this.searchNode(index - 1);
		before.setNext(node.getNext());
	    this.size--; 
	    return node;
	} 
	
	/**
	 * Search and return the element at the specified position in this list.	
	 * @param value
	 * @return a node or null if the node doesn't exists.
	 */
	public Node search(int value) {
		Node now = first;
		for (int i = 0; i < this.size - 1; i++) {
		    now = now.getNext();
		    if (now.getValue() == value) {
		    		return now;
		    }
		}
		return null;
	} 
	
	/**
	 * Method to return all values as string.
	 */
	public String toString() {
		if (this.size == 0){
			return "[]";
		}
		  
		StringBuilder builder = new StringBuilder("[");
		Node now = first;

		for (int i = 0; i < this.size - 1; i++) {
		    builder.append(now.getValue());
		    builder.append(", ");
		    now = now.getNext();
		}

		builder.append(now.getValue());
		builder.append("]");
		  
		return builder.toString();
	} 
}
