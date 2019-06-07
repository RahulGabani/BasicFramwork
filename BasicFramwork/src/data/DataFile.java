package data;

import utilities.Xls_Reader;

public class DataFile {

	
		
		// to read and write from excel file we require jars. we require apache.poi
		
		
		
		Xls_Reader d = new Xls_Reader("C:\\NikulSirFiles\\NikulTest.xlsx");
		
		
		
		public String correctEmail = d.getCellData("Data1", 0, 14);
	
		public String wrongEmail = d.getCellData("Data1",1	, 14);
		public String passwordErr = d.getCellData("Data1", 4, 14);
		public String emailErr = d.getCellData("Data1", 3, 14);
		public String password = d.getCellData("Data1", 2, 14);
		
		
		
		
		
		
		
	

}
