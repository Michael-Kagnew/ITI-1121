public class Utils {

    /**
     * Returns a copy of the array 'in' where each word occurring in the array
     * 'what' has been replaced by the word occurring in the same position
     * in the array 'with'.
     *
     * @param in an array of Strings;
     * @param what an array of words to be replaced;
     * @param with an array of replacement words;
     * @return a new array idententical to 'in' except that all the occurrences of words
     * found in 'what' have been replaced by the corresponding word from 'with'.
     */

    public static String[] findAndReplace( String[] in, String[] what, String[] with ) {

        String[] out = null; // The new array to be returned
	      boolean valid = true; // True if the pre-conditions are satistified

      	// Testing pre-condition

      	if ( in == null || what == null || with == null ) {
      	    valid = false;
      	} else {
            for (int x = 0; x <in.length; x++){
              if (in[x] == null){
                valid = false;
                break;
              }
            }
            for (int x = 0; x < what.length; x++){
              if (what.length != with.length || what[x] == null || with[x] == null){
                valid = false;
              }

            }
      	}

        //Continuing on with replacement algorithm
      	if ( valid ) {
      	    out = new String[ in.length ];
      	    for ( int i=0; i<in.length; i++ ) {
                out[i] = in[i];
              for (int x=0; x<what.length;x++){
                
                if (out[i].equals(what[x])){
                  what[x] = with[x]; //Replacing the same index of what with with
                  out[i] = what[x];
                }
              }
             
      	    }

      	}
        // Returning a reference to the newly created array that
        // contains the same entries as 'in' except that all the
        // occurrences of words from 'what' have been replaced by
        // their corresponding occurrence from 'with'.

        return out;
    }
}