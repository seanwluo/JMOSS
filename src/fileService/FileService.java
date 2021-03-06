/**
 * 
 */
package fileService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author alial
 *
 */
public class FileService {

	private String fileName = "jMoSS.txt";
	
	public FileService() {}
	
	public FileService(String fileName) {
		this.fileName = fileName;		
	}

	/*
	 * Create method to write on file
	 */
	
	// Parameters we can add them as we need 
	public void write(String txt) {
		System.out.println(txt);
		try {
			FileWriter fw = new FileWriter(fileName); // true for append data
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(txt);
			bw.close();
			bw.flush();
//			PrintWriter pw = new PrintWriter(bw);
//
//			pw.println(txt);
//			pw.flush();
//			pw.close();

			System.out.println("File Saved");
			
		} catch (Exception e) {
			System.out.println("Information not saved");
		}
	}

	/*
	 * Create method to read from file
	 */

	public List<String> read() {
		File file = new File(fileName);
		List<String> dataArray = new ArrayList();
		try {

			BufferedReader input = new BufferedReader(new FileReader (fileName));
		    String data = input.readLine(); //ignore the first line
			do {
				data = input.readLine();
				if (data != null)
					dataArray.add(data);
			} while (data != null);
			input.close();
		} catch (IOException e) {
			System.out.println("File Reading Error!!");
			System.exit(0);
		}
		return dataArray;
	}
}

