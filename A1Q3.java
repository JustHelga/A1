/**
 * The class <b>A1Q3</b> implements a static function 
 * that counts the number of positive integers
 * in an array
 *
 * @author Marcel Turcotte (turcotte@eecs.uottawa.ca)
 *
 */


public class A1Q3 {

	/** 
     * Returns the longest run of consecutive identical elements in elems.
     * We assume that the list is not null.
     * 
     *   @param elems the list of integers
     *   @return size of the longest run
     */
 
    private static int getLongestRun(int[] elems) {

// REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION
        int i = 0;
        int maxLength = 0;

        while (i < elems.length - 1){
            
            int length = 1;
            
            while (i < elems.length - 1 && elems[i] == elems[i + 1]){
                length++;
                i++;
            }

            if (length > maxLength){
                maxLength = length;
            }

            i++;

        }

        return maxLength;

    }

 	/**
     * The main method of this program. Gets an array of
     * strings as input parameter. The array is assumed to
     * be non-null, and all the strings in the array are
     * parsable as integer.
     *
     * The function prints out the longest run of consecutive 
     * identical integers parsed in args
     * @param args space-separated list of strings parsable as integers
	 */    

 	public static void main(String[] args) {

// REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION
        int n = args.length;
        int[] arr;

        if (n > 0){
            arr = new int[n];
            int q = 0;

            for (String item : args){
                arr[q] = Integer.parseInt(item);
                q++;
            }

        } else {
            
            arr = new int[0];
        }
        

        
        
        System.out.println(getLongestRun(arr));

    }
}

