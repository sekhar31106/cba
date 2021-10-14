import java.lang.IllegalArgumentException;
import java.io.FileNotFoundException; 
import java.io.IOException; 
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileWriter;
import java.io.File;
import com.aspose.cells.*;

public class TestFileParser {

	public static void main( String[] args ) throws IllegalArgumentException,FileNotFoundException,IOException,Exception {
		System.out.println("Welcome to TestFileParser");
		if (args.length == 1) {
			// parse file and get records
			List<Map<String,String>> records = parseInput(args[0]);
			// write to CSV and Excel
			writeOut(records);
		} else {
			throw new IllegalArgumentException("TestFileParser takes only one argument (path to test file)");
		}
		System.out.println("Thank you for using TestFileParser");
	}

	public static List parseInput(String inputFile) throws FileNotFoundException {
		System.out.println("...Parsing input file");
		// Read input file
		File file = new File(inputFile);
		Scanner sc = new Scanner(file);
		// Parse input
		List<Map<String,String>> records = new ArrayList<Map<String,String>>();
		Map<String,String> map = new HashMap<String,String>();
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			Pattern pattern = Pattern.compile("([a-z0-9\\_]+)[ ]+\"(.*)\"");
			Matcher matcher = pattern.matcher(line);
			// Check if current line has any key to parse
			// Ignore if line has [record
			if (matcher.find() && !line.contains("[record")) {
				String key = matcher.group(1);
				String value = matcher.group(2);
				//System.out.println("Line: "+line);
				//System.out.println(key+":"+value);
				map.put(key, value);
			}
			// Check for end of transaction OR file
			if (line.contains("]SZ") || !sc.hasNextLine()) {
				// add map to records
	  			records.add(map);
	  			// reset map
	  			map = new HashMap<String,String>();
			}
		}
		// Return parsed records
		return records;
	}

	public static void writeOut(List<Map<String,String>> records) throws FileNotFoundException,IOException,Exception {
		// get all keys
		List<String> keys = new ArrayList<String>(getAllKeys(records));
		// prepare output - CSV
		System.out.println("...Writing CSV file (./out.csv)");
		FileWriter csvFile = new FileWriter("out.csv");
		// set header for CSV
		csvFile.write("\""+listToString(keys,"\",\"")+"\"\n");
		// write content for CSV
		for (Map<String,String> map : records) {
			String csvRow = "";
			for (String key: keys) {
				String val = "";
				if (map.containsKey(key)) val = map.get(key);
				if (csvRow.isEmpty()) csvRow = "\""+val+"\"";
				else csvRow = csvRow+",\""+val+"\"";
			}
			csvFile.write(csvRow+"\n");
		}
		csvFile.close();
		// prepare output - Excel
		System.out.println("...Writing XLSX file (./out.xlsx)");
		LoadOptions loadOptions = new LoadOptions(FileFormatType.CSV);
		Workbook workbook = new Workbook("out.csv", loadOptions);
		workbook.save("out.xlsx" , SaveFormat.XLSX);
	}

	public static Set getAllKeys(List<Map<String,String>> records) {
		Set<String> keys = new HashSet<String>();
		for (Map<String,String> map : records) {
			keys.addAll(map.keySet());
		}
		return keys;
	}

	public static String listToString(List<String> list, String separator) {
		String result = "";
		for (String s: list) {
			if (result.isEmpty()) result = s;
			else result  = result+separator+s;
		}
		return result;
	}
}