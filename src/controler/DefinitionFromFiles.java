package controler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class DefinitionFromFiles implements Definition {

	@Override
	public ArrayList<String> getDefinition() {
		ArrayList<String> defenition = new ArrayList<String>();
		Random rn = new Random();
		int cpt=0;
		
		File file = new File("../../defenitions");  
		File[] files = file.listFiles();  
		String defs="";
		for (File f:files)  
		{  
			int r =rn.nextInt(100);
			if(r>50){
				try(BufferedReader br = new BufferedReader(new FileReader(file));){
					
					int i=0;
					String line=br.readLine();
					while(i<r && line!=null){
						i++;
						defs=line;
						line=br.readLine();
					}
					
				}catch (FileNotFoundException e){
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		String[]d = defs.split(";");
		defenition.add(d[0]);
		defenition.add(d[1]);
		defenition.add(d[2]);
		return defenition;
	}

}
