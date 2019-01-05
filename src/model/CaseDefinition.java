package model;

import view.DefenitionQuestion;

public class CaseDefinition extends CaseQuestion {

	public CaseDefinition() {
		super(Couleur.bleu);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int[] Action() {
		int [] res=(new DefenitionQuestion().showQuestion());
		return res;

	}

}
