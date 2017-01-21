/**
 * The class <b>A1Q1</b> implements a static function 
 * that counts the number of strictly positive integers
 * in an array
 *
 * @author Marcel Turcotte (turcotte@eecs.uottawa.ca)
 *
 */


public class A1Q1 {

	/** 
     * Returns the number of strictly positive elements in elems.
     * We assume that the list is not null.
     * 
     *   @param elems the list of integers
     *  @return the number of strictly positive elements in elems 
     */
 
    private static int countPositive(int[] elems) {

// REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION
    	int counter = 0;
		for (int item : elems){
			if (item > 0){
				counter++;
			}

		}

		return counter;

    }

 	/**
     * The main method of this program. Gets an array of
     * strings as input parameter. The array is assumed to
     * be non-null, and all the strings in the array are
     * parsable as integer.
     *
     * The function prints out the number of positive 
     * integers parsed in args
     * @param args space-separated list of strings parsable as integers
	 */    

 	public static void main(String[] args) {

// REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION
 		int n=args.length;

		int[] arr = new int[n];

		int q=0;

		for (String item : args){
			arr[q]=Integer.parseInt(item);
			q++;
		}
		
		System.out.println(countPositive(arr));

    }
}

