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
	 * 
	 * @param t
	 * @param elem
	 * @throws InterruptedException
	 */
	public void try_modify(ThreadAccess t, int elem) throws InterruptedException{
		if (t.getType() == Type.I) {
			try { 
				semaphore.acquire(); 
				list.add(elem);
				System.out.println(t.getName() + " | Type > " + t.getType().name() + " | Value > " + elem + ""
						+ " list > " + list.toString());
			}  finally {
				semaphore.release();
			} 
		} else if (t.getType() == Type.R) {
			try {
				semaphore.acquire();
				list.remove(elem); 
				System.out.println(t.getName() + " | Type > " + t.getType().name() + " | Index > " + elem + ""
						+ " list > " + list.toString());
			} catch (IndexOutOfBoundsException e) {
				System.out.println(t.getName() + " | Type > " + t.getType().name() + " | Index > " + elem + ""
						+ " list > " + list.toString());
				System.out.println(" ERROR: " + e.getMessage());
			} finally {
				semaphore.release();
			}
		} else if (t.getType() == Type.B) {
			try {
				Node n = list.searchNode(elem);
				System.out.println(t.getName() + " | Type > " + t.getType().name() + " | Index > " + elem + ""
						+ " Value > " + n.getValue());
			} catch (IndexOutOfBoundsException e) {
				System.out.println(t.getName() + " | Type > " + t.getType().name() + " | Index > " + elem);
				System.out.println(" ERROR: " + e.getMessage());
			}
		} 
	} 
}
