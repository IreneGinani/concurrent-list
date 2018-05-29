package concurrent.list; 

/**
 * 
 * @author  Gabriela Cavalcante and Irene Ginani
 * @version 24/05/2018
 */
public class ThreadAccess extends Thread {
	private Type type; 
	private ConcurrentList list; 
	int elem; 
	
	public ThreadAccess(String name, ConcurrentList list, Type type, int elem) {
		super(name);
		this.type = type;
		this.list = list; 
		this.elem = elem;
	} 
	
	@Override
	public void run() {   
		try {
			if (this.type == Type.I) { 
				list.performInsertion(this, elem);
			} else if (this.type == Type.R) { 
				list.performRemoval(this, elem);
			} else if (this.type == Type.B) { 
				list.performSearch(this, elem);
			}  
		} catch (InterruptedException e1) { 
			e1.printStackTrace();
		}  
	}

	public Type getType() {
		return type;
	}  
}
