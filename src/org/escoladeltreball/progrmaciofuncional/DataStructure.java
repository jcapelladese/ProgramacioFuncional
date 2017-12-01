/**
 * 
 */
package org.escoladeltreball.progrmaciofuncional;

import java.util.Iterator;
import java.util.function.Function;

import javax.print.event.PrintEvent;

/**
 * @author iaw47941842
 *
 */
public class DataStructure {
	// Create an array
    private final static int SIZE = 15;
    private static int[] arrayOfInts = new int[SIZE];
     
    public DataStructure() {
        // fill the array with ascending integer values
        for (int i = 0; i < SIZE; i++) {
            arrayOfInts[i] = i;
        }
    }
    
    /* 
     * Exercici 2.1: Defineix un mètodo dit print(DataStructureIterator iterator). 
     * Invoca aquest mètode amb una instància de la classe EvenIterator per tal de què 
     * es comporti igual que el mètode printEven.
     *  
     */
    public void print(DataStructureIterator iterator) {
    	while (iterator.hasNext() ) {
    		System.out.print(iterator.next() + " ");
    	}
    	System.out.println();
    }    
    
    /*
     * Exercici 2.3: 3. Defineix un mètode nomenat 
     * print(java.util.Function<Integer, Boolean> iterator)
     * que faci la mateixa funció que print(DataStructureIterator iterator). 
     * Invoca aquest mètode amb una expressió lambda per a imprimir elements 
     * que tinguin un índex de valor par. Invoca aquest mètode un altre cop 
     * amb una expressió lambda per a imprimir elements que tinguin un índex impar.
     */    
    public void print(Function<Integer, Boolean> iterator) {
    	for (int i = 0; i < SIZE; i++) {
    		if (iterator.apply(i)) {
    			System.out.print(i + " ");
    		}
    	}   
    	System.out.println();
    }
     
    public void printEven() {
        // Print out values of even indices of the array
        DataStructureIterator iterator = this.new EvenIterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
     
    interface DataStructureIterator extends java.util.Iterator<Integer> { }
 
    // Inner class implements the DataStructureIterator interface,
    // which extends the Iterator<Integer> interface
     
    private class EvenIterator implements DataStructureIterator {
        // Start stepping through the array from the beginning
        private int nextIndex = 0;
         
        public boolean hasNext() {
            // Check if the current element is the last in the array
            return (nextIndex <= SIZE - 1);
        }    	
         
        public Integer next() {
            // Record a value of an even index of the array
            Integer retValue = Integer.valueOf(arrayOfInts[nextIndex]);
             
            // Get the next even element
            nextIndex += 2;
            return retValue;
        }
    }
     
    public static void main(String s[]) {
        // Fill the array with integer values and print out only
        // values of even indices
        DataStructure ds = new DataStructure();
        ds.printEven(); 
        
        //2.1
        ds.print(ds.new EvenIterator());
        
        //2.2
        ds.print(new DataStructureIterator() {
        	private int nextIndex = 1;

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return (nextIndex <= SIZE - 1);
			}

			@Override
			public Integer next() {
				// TODO Auto-generated method stub
				Integer retValue = Integer.valueOf(arrayOfInts[nextIndex]);
	             
	            // Get the next even element
	            nextIndex += 2;
	            return retValue;
			}        	
        });   
        
        // 2.3        
        ds.print(
        		i -> i % 2 == 0
        		);
        ds.print(
        		i -> i % 2 != 0
        		);
        
    }
}
