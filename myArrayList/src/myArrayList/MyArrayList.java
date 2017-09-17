package myArrayList;

import myArrayList.util.Constants;

/**
 * Data Structure class which replicates the behavior of 
 * Java's ArrayList 
 * @author suresh
 *
 */
public class MyArrayList implements Cloneable{
	
	private int[] array = new int[Constants.MIN_ARRAY_SIZE]; 
	private int currentIndex = -1;
	
	public MyArrayList() {
		currentIndex = -1;
		array = new int[Constants.MIN_ARRAY_SIZE];
	}
	
	/**
	 *Increase the size of array from 50 to 75(50% increase)
	 */
	private void increaseArraySize() {
		int nextLevelSize = (int)(array.length * Constants.GROWTH_RATE);
		int[] temp = new int[nextLevelSize];
		
		for (int i = 0; i < array.length; i++) {
			temp[i] = array[i];
		}
		
		array = temp;
	}
	
	/**
	 * @void
	 */
	private void sort() {
		for (int i = 0; i <= currentIndex; i++)
	    {
	        for (int j = i + 1; j <= currentIndex; j++)
	        {
	            if (array[i] > array[j])
	            {
	                int temp =  array[i];
	                array[i] = array[j];
	                array[j] = temp;
	            }
	        }
	    }
	}
	
	/**
	 * Insert a value into array by maintaining the sorted order of array
	 * @param newValue
	 */
	public void insertSorted(int newValue) {
		checkForSize();
		
		currentIndex += 1;
		
		array[currentIndex] = newValue;
		
		sort();
		
		
	}
	
	
	/**
	 * Remove all occurrences of given value from array by maintaining the sorted order
	 * @param value
	 * @return <b>Count</b> of occurrence if value is valid otherwise <b> 0 </b>
	 */
	public int removeValue(int value) {
		int count = 0;
		
		if(currentIndex == -1) {
			return count;
		}
		
		int k = 0;
		while(k < currentIndex) {
			for(int i = 0; i <= currentIndex; i++) {
				if (array[i] == value) {

					// Shift values after removal
					for(int j = i; j <= currentIndex; j++) {
						array[j] = array[j+1];		
						array[j+1] = 0;
					}
					++count;
				}
			}

			if (count > 0) {
				//sort();
			}
			++k;
		}
		
		//Point the current index to the last position after removing values
		currentIndex -= count; 
		
		return count;
	}
	
	public int valueAtIndex(int index) {
		if (index < 0 || index > currentIndex) {
			System.err.println("Array index out of bound for size = " + size() + " Index is " + index);
			return -1;
		}
		
		return array[index];
	}

	
	
	/**
	 *  If the size of array is 50 and need more space and then call increase.
	 */
	private void checkForSize() {
		if (array.length == currentIndex + 1) {
			increaseArraySize();
		}
	}
	
	/**
	 * Find the first index of a value in array
	 * @param value
	 * @return <b>index</b> of value if present otherwise <b>-1</b>
	 */
	public int indexOf(int value) {
		
		if(currentIndex == -1) {
			return -1;
		}
		
		for(int i = 0; i <= currentIndex; i++) {
			if (array[i] == value) {
				return i;
			}
		}
		return -1;
	}
	
	
	/**
	 * Returns the size of array list
	 * @return size
	 */
	public int size() {
		return currentIndex+1;
	}
	
	/**
	 * Returns the sum of all the values in array
	 * @return sum
	 */
	public int sum() {
		int sum = 0;
		
		for(int i = 0; i <= currentIndex; i++) {
			sum += array[i];
		}
		
		return sum;
	}

	
	@Override
	public String toString() {
		StringBuilder builder = new  StringBuilder();
		builder.append("[");
		
		for(int i = 0; i <= currentIndex; i++) {
			if (i != 0) {
				builder.append(",");
			}
			builder.append(array[i]);
		}
		
		builder.append("]");
		return builder.toString();
	}
	
	
	
	@Override
	public MyArrayList clone()  {
		MyArrayList arrayList = new MyArrayList();
		arrayList.array = this.array.clone();
		arrayList.currentIndex = this.currentIndex;
		return arrayList;
	}
	
}
