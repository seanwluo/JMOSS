/**
 * 
 */
package fileService;

import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * @author alial
 *
 */
public class FileService {

	private String fileName = "jMoSS.txt";

	/*
	 * Create method to write on file
	 */
	
	// Parameters we can add them as we need 
	public void write(String theaterLocation, String movieName, String date, String time) {

		try {
			FileWriter fw = new FileWriter(fileName, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);

			pw.println(theaterLocation + "," + movieName + "," + date + "," + time);
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

	public String read() {
		File file = new File(fileName);
		String data="";
		try {

			Scanner inputStream = new Scanner(file);
			inputStream.nextLine(); // ignore the first line
			while (inputStream.hasNext()) {
				data = inputStream.nextLine();// gets a whole line

				System.out.println(data);

			}
			inputStream.close();
		} catch (IOException e) {
			System.out.println("File Not Found!!");
		}
		return data;
	}
}

