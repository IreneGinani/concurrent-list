package concurrent.list;

import java.util.concurrent.Semaphore;

/**
 * 
 * @author  Gabriela Cavalcante and Irene Ginani
 * @version 24/05/2018
 */
public class ConcurrentList {
	private Semaphore semaphore = new Semaphore (1, true);
	private List list; 
	 
	public ConcurrentList(List list) {
		super();
		this.list = list;
	}
 
	/**
	 * Perform search operation.
	 * @param thread 
	 * @param index index to rearch  
	 */
	public void performSearch(ThreadAccess t, int index) {
		try {
			Node n = list.searchNode(index);
			System.out.println(t.getName() + " | Type > " + t.getType().name() + " | Index > " + index + ""
					+ " Value > " + n.getValue());
		} catch (IndexOutOfBoundsException e) {
			System.out.println(t.getName() + " | Type > " + t.getType().name() + " | Index > " + index + " >> ERROR: " + e.getMessage() + " << "); 
		}
	}

	/**
	 * Perform removal operation.
	 * @param thread 
	 * @param index index to remove  
	 */
	public void performRemoval(ThreadAccess t, int index) throws InterruptedException {
		try {
			semaphore.acquire();
			list.remove(index); 
			System.out.println(t.getName() + " | Type > " + t.getType().name() + " | Index > " + index + ""
					+ " list > " + list.toString());
		} catch (IndexOutOfBoundsException e) {
			System.out.println(t.getName() + " | Type > " + t.getType().name() + " | Index > " + index + ""
					+ " list > " + list.toString());
			System.out.println(" ERROR: " + e.getMessage());
		} finally {
			semaphore.release();
		}
	}

	/**
	 * Perform insertion operation.
	 * @param thread 
	 * @param value value to insert  
	 */
	public void performInsertion(ThreadAccess t, int value) throws InterruptedException {
		try { 
			semaphore.acquire(); 
			list.add(value);
			System.out.println(t.getName() + " | Type > " + t.getType().name() + " | Value > " + value + ""
					+ " list > " + list.toString());
		}  finally {
			semaphore.release();
		}
	} 
}
