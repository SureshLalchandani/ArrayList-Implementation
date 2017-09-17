package myArrayList.driver;

import myArrayList.MyArrayList;
import myArrayList.test.MyArrayListTest;
import myArrayList.util.FileProcessor;
import myArrayList.util.FileProcessor.Permission;
import myArrayList.util.Results;

public class Driver {

	public static void main(String[] args) {
		
		if(args == null || args.length != 2) {
			System.err.println("Please provide valid number of arguments. 2 Arguments are expected: \n1.Input File \n2.Output File");
			System.exit(0);
			return;
		}
		
		if(args[0].contains("${arg0}") || args[1].contains("${arg1}")) {
			System.err.println("Please provide valid number of arguments. 2 Arguments are expected: \n1.Input File \n2.Output File");
			System.exit(0);
			return;
		}
		
		String inputFile = args[0];
		String outputFile = args[1];
		
		
		//File Read and purge into ArrayList
		FileProcessor readFileProcessor = new FileProcessor(inputFile, Permission.READ);
		String line = null;
		
		MyArrayList arrayList = new MyArrayList();
		while((line = readFileProcessor.readLine()) != null) {
			try {
				
				if(line == null || line.trim().length() == 0) {
					continue;
				}
				
				int value = Integer.parseInt(line.trim());
				arrayList.insertSorted(value);
			} catch(NumberFormatException nfe) {
				System.err.println("Driver:main - Number Format Exception Occured :: "  + nfe.getLocalizedMessage());
				System.exit(0);
			}
		}
		
		//Result object for Output File
		Results results = new Results(outputFile);
		
		// Run test cases on array list object and store results in Result object
		MyArrayListTest test = new MyArrayListTest();
		test.testMe(arrayList, results);
	}

}
