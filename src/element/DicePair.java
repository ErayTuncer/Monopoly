package element;

import java.util.Random;

public class DicePair {
	
	public static int[] roll(){
		Random rgen = new Random();
		int[] dicePair = {rgen.nextInt(6), rgen.nextInt(6)};
		return dicePair;
	}
}
