package myArrayList.test;

import java.util.Random;

import myArrayList.MyArrayList;
import myArrayList.util.Results;

public class MyArrayListTest {

	public void testMe(MyArrayList arrayList, Results results) {
		
		if(arrayList.size() == 0) {
			System.err.println("Array is empty");
			System.exit(0);
			return;
		}
		
		results.storeNewResult("\nThe sum of all the values in the array list is: " + arrayList.sum() + "\n\n");
		
		test1(arrayList.clone(), results);
		test2(arrayList.clone(), results);
		test3(arrayList.clone(), results);
		test4(arrayList.clone(), results);
		test5(arrayList.clone(), results);
		test6(arrayList.clone(), results);
		test7(arrayList.clone(), results);
		test8(arrayList.clone(), results);
		test9(arrayList.clone(), results);
		test10(arrayList.clone(), results);
		
		
		results.writeToFile();
	}

	private void test1(MyArrayList arrayList, Results results) {
		StringBuilder builder = new StringBuilder();
		builder.append("Test 1: \nArrayBefore : " + arrayList.toString());
		
		int sumBefore = arrayList.sum();
		int numbertoRemove = getRandomNumber(arrayList);
		arrayList.removeValue(numbertoRemove);
		int sumAfter = arrayList.sum();
		
		String testResult = "[failed]";
		if(sumBefore > sumAfter) {
			testResult = "[passed]";
		}
		
		builder.append("\nArrayAfter : " + arrayList.toString());
		builder.append("\nremoveValue - Sum before removal of " + numbertoRemove +" is greater then sum after removal \n" + testResult + "\n\n");
		results.storeNewResult(builder.toString());
	}

	private void test2(MyArrayList arrayList, Results results) {
		StringBuilder builder = new StringBuilder();
		builder.append("Test 2: \nArrayBefore : " + arrayList.toString());
		
		int number = getRandomNumber(arrayList);
		
		int index = arrayList.indexOf(number);
		
		int numAtIndex = arrayList.valueAtIndex(index);
		
		String testResult = "[failed]";
		if(number ==  numAtIndex) {
			testResult = "[passed]";
		}
		
		builder.append("\nArrayAfter : " + arrayList.toString());
		builder.append("\nindexOf - Index found using indexOf method for a number and then retreived the number using valueAtIndex method produce the same result \n" + testResult + "\n\n");
		results.storeNewResult(builder.toString());
	}

	private void test3(MyArrayList arrayList, Results results) {
		StringBuilder builder = new StringBuilder();
		builder.append("Test 3: \nArrayBefore : " + arrayList.toString());
	
		
		int sumBefore = arrayList.sum();
		int numbertoAdd = 12;
		arrayList.insertSorted(numbertoAdd);
		int sumAfter = arrayList.sum();
		
		String testResult = "[failed]";
		if(sumBefore < sumAfter) {
			testResult = "[passed]";
		}
		
		builder.append("\nArrayAfter : " + arrayList.toString());
		builder.append("\ninsertSorted - Sum before insertion of " + numbertoAdd +" is less then sum after removal \n" + testResult + "\n\n");
		results.storeNewResult(builder.toString());
	}

	private void test4(MyArrayList arrayList, Results results) {
		StringBuilder builder = new StringBuilder();
		builder.append("Test 4: \nArrayBefore : " + arrayList.toString());
	
		
		int sizeBefore = arrayList.size();
		int numbertoAdd = 10;
		arrayList.insertSorted(numbertoAdd);
		int sizeAfter = arrayList.size();
		
		String testResult = "[failed]";
		if(sizeBefore < sizeAfter) {
			testResult = "[passed]";
		}
		
		builder.append("\nArrayAfter : " + arrayList.toString());
		builder.append("\ninsertSorted with Size - Size before insertion of " + numbertoAdd + " is (" + sizeBefore + ") less then size after it ("+sizeAfter+") \n" + testResult + "\n\n");
		results.storeNewResult(builder.toString());
	}

	private void test5(MyArrayList arrayList, Results results) {
		StringBuilder builder = new StringBuilder();
		builder.append("Test 5: \nArrayBefore : " + arrayList.toString());
		
		int numberToAdd = 16;
		int numberOfTimesToAdd = 5;
		
	
		for (int i =0; i < numberOfTimesToAdd ; i++) {
			arrayList.insertSorted(numberToAdd);
		}
		
		
		int occurences = arrayList.removeValue(numberToAdd);
		
		String testResult = "[failed]";
		if(numberOfTimesToAdd >= occurences) {
			testResult = "[passed]";
		}
		
		builder.append("\nArrayAfter : " + arrayList.toString());
		builder.append("\nSize|Remove|Count  Inserted " + numberOfTimesToAdd + " Items " + " Removal returned " + occurences + " Items \n" + testResult + "\n\n");
		results.storeNewResult(builder.toString());
		
	
	}

	private void test6(MyArrayList arrayList, Results results) {
		StringBuilder builder = new StringBuilder();
		builder.append("Test 6: \nArrayBefore : " + arrayList.toString());
		
		
		int numberToAdd = 16;
		int numberOfTimesToAdd = 5;
		
		for (int i =0; i < numberOfTimesToAdd ; i++) {
			arrayList.insertSorted(numberToAdd);
		}
		
		int sizeAfterAdding = arrayList.size();
		
		int occurences = arrayList.removeValue(numberToAdd);
		
		int sizeAfterRemoving = arrayList.size();
		
		String testResult = "[failed]";
		if(sizeAfterRemoving == (sizeAfterAdding - occurences)) {
			testResult = "[passed]";
		}
		
		builder.append("\nArrayAfter : " + arrayList.toString());
		builder.append("\nSizeAfterRemoving isEqual to (sizeAfterAdding - ocurrenceOfRemovedItem)  \n" + testResult + "\n");
		results.storeNewResult(builder.toString());
	
	
	}

	private void test7(MyArrayList arrayList, Results results) {
		StringBuilder builder = new StringBuilder();
		builder.append("Test 7: \nArrayBefore : " + arrayList.toString());
		
		
		
		// Number doesn't exist
		int numberToRemove = -10;
		
		int occurences = arrayList.removeValue(numberToRemove);
		
		String testResult = "[failed]";
		if(occurences > 0) {
			testResult = "[passed]";
		}
		
		
		
		builder.append("\nArrayAfter : " + arrayList.toString());
		builder.append("\nRemove a number that doen't exist in array " + numberToRemove + " Result : \n" + testResult + "\n\n");
		results.storeNewResult(builder.toString());
	
	}


	private void test8(MyArrayList arrayList, Results results) {
		StringBuilder builder = new StringBuilder();
		builder.append("Test 8: \nArrayBefore : " + arrayList.toString());
		
		
		int size = arrayList.size();
		
		int numberOfTimesToAdd = 100;
		
		for(int i = 0; i < numberOfTimesToAdd; i++) {
			Random random = new Random();
			int numtoAdd = random.nextInt((10000 - 0) + 1) - 0;
			arrayList.insertSorted(numtoAdd);
		}
		
		int newsize = arrayList.size();
		
		String testResult = "[failed]";
		
		if(newsize > size) {
			testResult = "[passed]";
		}
		
		builder.append("\nArrayAfter : " + arrayList.toString());
		builder.append("\nTesting if array size is getting increased by 50% new size " + newsize +  "- Result \n" + testResult + "\n\n");
		results.storeNewResult(builder.toString());
	
		
	}

	private void test9(MyArrayList arrayList, Results results) {
		StringBuilder builder = new StringBuilder();
		builder.append("Test 9: \nArrayBefore : " + arrayList.toString());
		
		
		int numberToAdd1 = 10;
		int numberToAdd2 = 9;

		arrayList.insertSorted(numberToAdd1);

		int indexOfNum1BeforeAddingNum2 = arrayList.indexOf(numberToAdd1);

		arrayList.insertSorted(numberToAdd2);

		int indexOfNum1AfterAddingNum2 = arrayList.indexOf(numberToAdd1);

		String testResult = "[failed]";

		if(indexOfNum1AfterAddingNum2 > indexOfNum1BeforeAddingNum2) {
			testResult = "[passed]";
		}

		builder.append("\nArrayAfter : " + arrayList.toString());
		builder.append("\nTesting if array is sorted after insertion Result- \n" + testResult + "\n\n");
		results.storeNewResult(builder.toString());
	
		

	}


	private void test10(MyArrayList arrayList, Results results) {
		StringBuilder builder = new StringBuilder();
		builder.append("Test 10: \nArrayBefore : " + arrayList.toString());
		
		
		int numberToRemove = getRandomNumber(arrayList);

		int count = arrayList.removeValue(numberToRemove);
		int countAfter = arrayList.removeValue(numberToRemove);

		

		String testResult = "[failed]";

		if(count != 0 && countAfter != 0) {
			testResult = "[passed]";
		}

		builder.append("\nArrayAfter : " + arrayList.toString());
		builder.append("\nTesting value once removed, all occurences will be removed. Trying again to remove the value. \n" + testResult + "\n\n");
		results.storeNewResult(builder.toString());
	
		

	}
	
	private int getRandomNumber(MyArrayList arrayList) {
		Random rand = new Random();
		int index  = rand.nextInt(arrayList.size());
		return arrayList.valueAtIndex(index);
	}



}
