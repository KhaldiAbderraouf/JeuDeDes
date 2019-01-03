package model;

import view.ImageQuestion;

public class CaseImage extends CaseQuestion {
	
	
	public CaseImage() {
		super(Couleur.rose);
		
	}

	@Override
	public int[] Action() {
		
		int [] res=(new ImageQuestion().showQuestion());
		return res;

	}

}
