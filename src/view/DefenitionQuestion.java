package view;

import controler.Definition;
import controler.DefinitionFromFiles;

public class DefenitionQuestion extends QuestionView {
	private Definition def;
	@Override
	public int[] showQuestion() {
		int[] res ={0,0};
		def=new DefinitionFromFiles();
		//show the definition
		return res;
	}

}
