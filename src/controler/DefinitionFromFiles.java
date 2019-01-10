package controler;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DefinitionFromFiles implements Definition {

	@Override
	public ArrayList<String> getDefinition() {
		ArrayList<String> defenition = new ArrayList<String>();
		Random rn = new Random();
		String defs="";
		File file = new File("src/files/def.txt");
		try {
			List<String> lines = Files.readAllLines(file.toPath());
			int r =rn.nextInt(lines.size());
			defs=lines.get(r);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String[]d = defs.split(";");
		defenition.add(d[0]);
		defenition.add(d[1]);
		return defenition;
	}

}
