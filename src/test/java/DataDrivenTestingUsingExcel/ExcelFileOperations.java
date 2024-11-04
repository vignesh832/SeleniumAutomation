package DataDrivenTestingUsingExcel;

import java.io.IOException;
import java.util.Arrays;

public class ExcelFileOperations {

	public static void main(String[] args) throws IOException {
		// Reading data from the file
		String dir = System.getProperty("user.dir");
		String[][] data = ExcelUtils.readingData(dir+"\\testdata\\bookdetailsdata.xlsx", "sheet1");
		for(int i=0;i<data.length;i++) {
			System.out.println(Arrays.toString(data[i]));
		}
		
		// Writing data to the file
		ExcelUtils.writingData(dir+"\\testdata\\bookdetailsdata.xlsx", "sheet1");
		data = ExcelUtils.readingData(dir+"\\testdata\\bookdetailsdata.xlsx", "sheet1");
		for(int i=0;i<data.length;i++) {
			System.out.println(Arrays.toString(data[i]));
		}
	}

}
