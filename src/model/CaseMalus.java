package model;

public class CaseMalus extends Case {

	public CaseMalus() {
		super(Couleur.rouge);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int[] Action() {
		int[] res={0,-20};
		return res;

	}

}
