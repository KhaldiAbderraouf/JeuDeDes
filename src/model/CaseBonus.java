package model;

public class CaseBonus extends Case {

	public CaseBonus() {
		super(Couleur.vert);
	}

	@Override
	public int[] Action() {
		int[] res={2,20};
		return res;

	}

}
