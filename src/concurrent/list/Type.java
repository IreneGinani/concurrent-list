package concurrent.list;

import java.util.Random;

/**
 * Type enum.
 * 
 * @author  Gabriela Cavalcante and Irene Ginani
 * @version 20/05/2018
 */

public enum Type {
	B, I, R;

	/**
	 * Returns a random gender.
	 * @return random gender.
	 */
	public static Type getType()  {
		Random random = new Random();
	    return values()[random.nextInt(values().length)];
	} 
}