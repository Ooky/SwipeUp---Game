package Tools;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OwnFileReader {
	private BufferedReader bf;
	private FileReader fr;
	
	public String stringFromFile(String path){
		String returnString = "";
		String currentLine;
		try {
			fr = new FileReader(path);
			bf = new BufferedReader(fr);
			try {
				while ((currentLine = bf.readLine()) != null) {
					returnString += currentLine;
				}
			} catch (IOException ex) {
				Logger.getLogger(OwnFileReader.class.getName()).log(Level.SEVERE, null, ex);
			}
		} catch (FileNotFoundException ex) {
			Logger.getLogger(OwnFileReader.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
