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
			list.performOperation(this, elem);
		} catch (InterruptedException e1) { 
			e1.printStackTrace();
		}  
	}

	public Type getType() {
		return type;
	}  
}
