import java.io.IOException;
import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;


public class PrintDiffDataCSV {
	private String path_to_file_1;
    private String path_to_file_2;
    private String path_to_output_file;
	public PrintDiffDataCSV(String path_to_file_1, String path_to_file_2, String path_to_output_file){
		this.path_to_file_1=path_to_file_1;
		this.path_to_file_2=path_to_file_2;
		this.path_to_output_file=path_to_output_file;
		// Store the result to arraylist
		List<String> result = new ArrayList<>();
		// Read the csv line by line, and store in arraylist for future comparison
		List<String> firstfile = new ArrayList<>();
		Path PathToFirstFile = Paths.get(this.path_to_file_1);
		// System.out.println(" pathToFile :" + pathToFile);
		try (BufferedReader br = Files.newBufferedReader(PathToFirstFile, StandardCharsets.US_ASCII)) {
			String line = br.readLine();
			while (line != null) {
				firstfile.add(line.trim());
				line = br.readLine();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		
		Path PathToSecondFile = Paths.get(this.path_to_file_2);
		try (BufferedReader br = Files.newBufferedReader(PathToSecondFile, StandardCharsets.US_ASCII)) {
			String SecondFileLine = br.readLine();
			while (SecondFileLine != null) {
				// Check if the first file contains this line
				if (firstfile.contains(SecondFileLine)) {
					firstfile.remove(SecondFileLine);
				}
				else{
					// If not contained, add this line to the result
					result.add(SecondFileLine+"\n");

				}
				// Iterate next line
				SecondFileLine = br.readLine();
			}
			for (String i:firstfile){
				result.add(i+"\n");
			}
			// System.out.println(result);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}


		// Write to csv file
		try (PrintWriter writer = new PrintWriter(new File(this.path_to_output_file))) {
			for (String lines: result){
				writer.write(lines);
			}

          } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
          }
      
	}
	public static void main(String... args) {
		PrintDiffDataCSV result = new PrintDiffDataCSV("sample_file_1.csv","sample_file_3.csv","result.csv");
	}
	
	
}



	
		