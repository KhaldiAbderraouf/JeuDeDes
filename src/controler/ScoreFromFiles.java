package controler;

import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.nio.file.Files; 

public class ScoreFromFiles implements LoadScore {
	File file;
	BufferedReader br;
	
	@Override
	public ArrayList<Integer> getScore(String name) {
		file = new File("../../files/score.txt");
		ArrayList<Integer> list= new ArrayList<Integer>();
		try (BufferedReader br = new BufferedReader(new FileReader(file));){
			String[] score;
			String scores;
			while (((scores = br.readLine()) != null)&&(!scores.startsWith(name))){} 
			score=scores.split(";");
			for(int i=1;i<score.length;i++){
				list.add(Integer.parseInt(score[i]));
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
	public void saveScore(String name, int... score) {
		file = new File("../../files/score.txt");
		int i=0;
		
		try(BufferedReader br = new BufferedReader(new FileReader(file));){
			String scores;
			while (((scores = br.readLine()) != null)&&(!scores.startsWith(name))){i++;} 
		}catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try{
			String fileContent = name;
			for(int j=0;j<score.length;j++){
				fileContent=fileContent+";"+score[j];
			}
			
			List<String> lines = Files.readAllLines(file.toPath());
			lines.set(i,fileContent);
			Files.write(file.toPath(), lines);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
