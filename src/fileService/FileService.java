/**
 * 
 */
package fileService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

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

		try {
			FileWriter fw = new FileWriter(fileName, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);

			pw.println(txt);
			pw.flush();
			pw.close();

			JOptionPane.showMessageDialog(null, "Information saved");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Information not saved");

		}
	}

	/*
	 * Create method to read from file
	 */

	public List<String> read() {
		File file = new File(fileName);
		List<String> dataArray = new ArrayList();
		try {

			Scanner inputStream = new Scanner(file);
			inputStream.nextLine(); // ignore the first line
			while (inputStream.hasNext()) {
//				data = inputStream.nextLine();// gets a whole line
//				System.out.println(data);
				dataArray.add(inputStream.nextLine());
			}
			inputStream.close();
		} catch (IOException e) {
			System.out.println("File Not Found!!");
		}
		return dataArray;
	}
}

