package concurrent.list;

/**
 * Main Class.
 * 
 * @author Gabriela Cavalcante and Irene Ginani
 * @version 24/05/2018
 */
public class Main {
	private static final int total = 10;

	public static void main(String[] args) {
		List list = new List();
		ConcurrentList list_c = new ConcurrentList(list);
		ThreadAccess[] threads = new ThreadAccess[total];
		
		threads[0] = new ThreadAccess("thread 0", list_c, Type.I, 0); 
		threads[1] = new ThreadAccess("thread 1", list_c, Type.I, 1); 	
		threads[2] = new ThreadAccess("thread 2", list_c, Type.I, 2); 
		threads[3] = new ThreadAccess("thread 3", list_c, Type.I, 3); 
		threads[4] = new ThreadAccess("thread 4", list_c, Type.I, 4); 
		  
		threads[5] = new ThreadAccess("thread 5", list_c, Type.B, 3); 
		threads[6] = new ThreadAccess("thread 6", list_c, Type.R, 3); 
  
		threads[7] = new ThreadAccess("thread 7", list_c, Type.B, 3); 
		threads[8] = new ThreadAccess("thread 8", list_c, Type.R, 3); 
		
	    for (int i = 0; i < 9; i++) {   
	    		threads[i].start(); 
	    } 
	}
}
