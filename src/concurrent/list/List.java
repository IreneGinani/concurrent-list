package concurrent.list;

public class List {
	
	private Node first;

	private Node last;
	
	private int size;
	    
	public void add(Object elem) {
		 Node new_node = new Node(elem);
		 this.last.setNext(new_node);
		 this.last = new_node;
		 this.size++;
	}
	public void remove(int pos){
		Node now = first;
		for (int i = 0; i < this.size - 2; i++) {
		    now = now.getNext();
		  }
		    Node beforelast = now;
		    beforelast.setNext(null);
		    this.last = beforelast;
		    this.size--;
	}
	public boolean search(Node data) {
		Node now = first;
		for (int i = 0; i < this.size - 1; i++) {
		    now = now.getNext();
		    if (now.getElem() == data.getElem()) {
		    	return true;
		    }
		  }
		return false;
		}
	public int size() {
		return this.size;
	}
	
	public String toString() {

		  if(this.size == 0){
		    return "[]";
		  }
		  
		  StringBuilder builder = new StringBuilder("[");
		  Node now = first;

		  for (int i = 0; i < this.size - 1; i++) {
		    builder.append(now.getElem());
		    builder.append(", ");
		    now = now.getNext();
		  }

		  builder.append(now.getElem());
		  builder.append("]");
		  
		  return builder.toString();
		}

}
