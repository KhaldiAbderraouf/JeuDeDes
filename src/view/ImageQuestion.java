package view;

import controler.Iimages;
import controler.ImagesFromFiles;

public class ImageQuestion extends QuestionView {
	private Iimages Iimgs;
	@Override
	public int[] showQuestion() {
		int[] res ={0,0};
		Iimgs= new ImagesFromFiles();
		// show dialog with those images
		return res;
	}

}
