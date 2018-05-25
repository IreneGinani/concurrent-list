package concurrent.list;

public class Main {
	
	private static final int total = 10;

	public static void main(String[] args) {
		List list = new List();
		Concurrent_list list_c = new Concurrent_list(list);
	    Thread_Access[] folk = new Thread_Access[total];
	    
	    for (int i = 0; i < total; i++) { 
	    		folk[i] = new Thread_Access("person " + i, list_c);   
	    		folk[i].start();
} 

	}

}
