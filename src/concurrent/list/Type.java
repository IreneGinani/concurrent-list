package concurrent.list;

import java.util.Random;

/**
 * Type enum.
 * 
 * @author  Gabriela Cavalcante and Irene Ginani
 * @version 24/05/2018
 */

public enum Type {
	B, I, R;

	/**
	 * Returns a random action.
	 * @return random action.
	 */
	public static Type getType()  {
		Random random = new Random();
	    return values()[random.nextInt(values().length)];
	} 
}