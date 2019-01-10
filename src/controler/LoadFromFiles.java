package controler;

import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.nio.file.Files; 

public class LoadFromFiles implements Load {
	File file;
	BufferedReader br;
	
	@Override
	public ArrayList<Integer> getScore(String name) {
		file = new File("src/files/score.txt");
		ArrayList<Integer> list= new ArrayList<Integer>();
		try (BufferedReader br = new BufferedReader(new FileReader(file));){
			String[] score;
			String scores;
			while (((scores = br.readLine()) != null)&&(!scores.startsWith(name))){} 
			if(scores!=null){
				score=scores.split(";");
				for(int i=1;i<score.length;i++){
					list.add(Integer.parseInt(score[i]));
				}
			}else{
				list.add(0);
			}
		} catch (FileNotFoundException e) {
			try {
				file.createNewFile();
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void saveScore(String name,int s) {
		ArrayList<Integer> score = getScore(name);
		score.add(s);
		file = new File("src/files/score.txt");
		int k=0,i=0;
		
		
		
		try{
			String fileContent = name;
			for(int j=0;j<score.size();j++){
				fileContent=fileContent+";"+score.get(j);
			}
			
			List<String> lines = Files.readAllLines(file.toPath());
			
			for(i=0;i<lines.size();i++){
				if(lines.get(i).contains(name)){
					k=1;
					break;
				}
			}
			
			if(k!=0){
				lines.set(i,fileContent);
			}else{
				lines.set(0,fileContent);
			}
			Files.write(file.toPath(), lines);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
