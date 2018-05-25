package concurrent.list;

import java.util.Random;

public class Thread_Access extends Thread{
	
	private Type type; 
	private Concurrent_list list;
	private int time;
	
	int elem = 8;
	
	
	
	public Thread_Access(String name, Concurrent_list list) {
		super(name);
		this.type = Type.getType();
		this.list = list;
		
		Random random = new Random();
		this.time = random.nextInt(5);
	}

	
	@Override
	public void run() {   
		try {
			list.try_modify(this, elem);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		try {
			Thread.sleep ((long) (this.time) * 1000);
		} catch (InterruptedException e) { 
			e.printStackTrace();
		}   
	}

	public Type getType() {
		return type;
} 

}
