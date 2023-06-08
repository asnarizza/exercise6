package exercise6;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * This program demonstrate writing data as byte-based using DataOutputStream.
 * 
 * @author Rose Asnarizza Nahar
 *
 */

public class RainfallInput {
	
	public static void main(String[] args) {

		//1. Identify the destination
		String fileName = "rainfall.txt";
		
		//2. List the data in array
		 String[][] rainfallDatas = {
	                {"2421003", "Simpang Ampat", "Alor Gajah", "0", "4", "1", "0", "6", "19"},
	                {"2322006", "Melaka Pindah", "Alor Gajah", "0", "0", "0", "0", "2", "18"},
	                {"2324033", "Hospital Jasin", "Jasin", "0", "0", "14", "0", "11", "15"},
	                {"2225044", "Chohong", "Jasin", "0", "0", "21", "0", "39", "14"},
	                {"2223023", "Sg. Duyong", "Melaka Tengah", "0", "0", "3", "0", "43", "26"},
	                {"2222006", "Cheng (Taman Merdeka)", "Melaka Tengah", "0", "0", "3", "0", "42", "10"}};
		
		try (
			
			//3. Create an output stream to read data
			DataOutputStream output = new DataOutputStream(new FileOutputStream(fileName))) {
			
			//4. Insert the data into the file
			for (String[] rainfallData : rainfallDatas) {
				
				 String stationId = rainfallData[0];
	                String stationName = rainfallData[1];
	                String districtName = rainfallData[2];
	                String[] rainfalls = {rainfallData[3], rainfallData[4], rainfallData[5],rainfallData[6], rainfallData[7], rainfallData[8]};
				
	                output.writeUTF(stationId);
	                output.writeUTF(stationName);
	                output.writeUTF(districtName);
			
	            for (String rainfall : rainfalls) {
	            	output.writeInt(Integer.parseInt(rainfall));
	            }
			}
				
			//5. Flush the stream
			output.flush();
			
			//6. Close the stream
			output.close();
			
			//indicate if the program is success
			System.out.println("Rainfall data has been recorded to the file: " + fileName);

		} catch (IOException e) {
			
			//if there are error, it will display this message
			System.out.println("An error occurred while writing the rainfall data to the file: " + e.getMessage());
		}

	}
}