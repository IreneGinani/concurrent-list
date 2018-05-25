package concurrent.list;

public class List {
	
	private Node first;

	private Node last;
	
	private int size;
	
	private Node search_node(int pos) {
		  Node now = first;
		  for (int i = 0; i < pos; i++) {
		    now = now.getNext();
		  }
		  return now;
		}
	public Object elem(int pos) {
		  return this.search_node(pos).getElem();
		}   
	public void add(Object elem) {
		 Node new_node = new Node(elem);
		 this.last.setNext(new_node);
		 this.last = new_node;
		 this.size++;
	}
	public void removeEnd(){
		Node now = first;
		for (int i = 0; i < this.size - 2; i++) {
		    now = now.getNext();
		  }
		    Node beforelast = now;
		    beforelast.setNext(null);
		    this.last = beforelast;
		    this.size--;
	}
	public void remove_pos(int pos) {
		   if (pos == this.size - 1) {
		    this.removeEnd();
		  } else {
		    Node before = this.search_node(pos - 1);
		    Node now = before.getNext();
		    Node next = now.getNext();
		    
		    before.setNext(next);
		    
		    this.size--;
		  }
		}
	public void remove(Object elem) {
		
		Node now = first;
		  for (int i = 0; i < size; i++) {
			  if (elem == now.getElem()) {
				  remove_pos(i);
			  }
		  }
		   
		}
	public boolean search(Object data) {
		Node now = first;
		for (int i = 0; i < this.size - 1; i++) {
		    now = now.getNext();
		    if (now.getElem() == data) {
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
