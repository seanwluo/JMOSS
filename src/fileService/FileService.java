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

	private static String fileName = "jMoSS.txt";

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

	public String read() {
		
		String data="";
		try {
			BufferedReader input=new BufferedReader(new FileReader (fileName));
			data=input.readLine(); 
			while (data != null) {
				System.out.println(data);
				data=input.readLine();
								
			}
			input.close();
		} catch (IOException e) {
			System.out.println("File Reading Error!!");
			System.exit(0);
		}
		return data;
	}
}

