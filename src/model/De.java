package model;

import java.util.Random;

public class De {
	public int lancer(){
		Random rn = new Random();
		return 1+rn.nextInt(5);
	}
}
