package model;

import java.util.Random;

public class CaseSaut extends Case {

	public CaseSaut() {
		super(Couleur.orange);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int[] Action() {
		Random rn = new Random();
		int[] res={rn.nextInt(20),0};
		return res;

	}

}
