package Utility;

import java.io.Reader;
import java.util.ArrayList;

public class getDatafromExcel {
	static Xls_Reader reader;

	public static ArrayList<Object[]> getData() {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();

		try {
			reader = new Xls_Reader("C://Users/om/eclipse-workspace/TestNGBasics/TestData.xlsx");
		} catch (Exception e) {
			e.getStackTrace();
		}

		for (int rowCnt = 2; rowCnt <= reader.getRowCount("TestData"); rowCnt++) {
			String Name = reader.getCellData("TestData", "Name", rowCnt);
			String Year = reader.getCellData("TestData", "Year", rowCnt);
			String Month = reader.getCellData("TestData", "Month", rowCnt);
			String Date = reader.getCellData("TestData", "Date", rowCnt);
			String Time = reader.getCellData("TestData", "Time", rowCnt);
			String Place = reader.getCellData("TestData", "Place", rowCnt);

			Object obj[] = { Name, Year, Month, Date, Time, Place };
			myData.add(obj);

		}
	
		return myData;
	}
}