package concurrent.list;

import java.util.concurrent.Semaphore;

public class Concurrent_list {
	
	private Semaphore semaphore = new Semaphore (1,true);
	
	private List list;
	
	
	
	public Concurrent_list(List list) {
		super();
		this.list = list;
	}



	public void try_modify(Thread_Access t, int elem) throws InterruptedException{
		
		
		if (t.getType().equals("I")) {
			
			try {
				
				semaphore.acquire();
				list.add(elem);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaphore.release();
			}
				
		}else if (t.getType().equals("R")) {
			try {
				
				semaphore.acquire();
				list.remove(elem);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaphore.release();
			}
		}else if(t.getType().equals("B")) {
			list.search(elem);
		}
		
	}

}
