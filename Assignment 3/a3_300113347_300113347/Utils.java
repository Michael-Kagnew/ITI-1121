// Author: Michael Kagnew
// Student number: 300113347
// Course: ITI 1121-A
// Assignment: 3
import java.util.Random;
import java.io.Console;

public class Utils {
	public static final Random generator = new Random();
	public static final Console console = System.console();
	public static final String NEW_LINE = System.getProperty("line.separator");


    /**
     * This method rotates array of size lines * columns referenced
     * by transformedBoard by 90 degree clockwise. For example, the
     * 3*3 game
     *
     * 1 | 2 | 3
     * ----------
     * 4 | 5 | 6
     * ----------
     * 7 | 8 | 9
     *
     * for which lines = 3 and columns = 3 is represented by the array
     * transformedBoard = {1,2,3,4,5,6,7,8,9}
     *
     * the method rotates it into the game
     *
     * 7 | 4 | 1
     * ----------
     * 8 | 5 | 2
     * ----------
     * 9 | 6 | 3
     *
     * that is, after the method, transformedBoard = {7,4,1,8,5,2,9,6,3}
     *
     * @param lines
     *  the number of lines in the game
     * @param columns
     *  the number of columns in the game
     * @param transformedBoard
     *  Reference to a 1 dimentional array of size columns x lines
     */


    public static void rotate(int lines, int columns, int[] transformedBoard){


            // YOUR CODE HERE
        if (transformedBoard == null){
            throw new IllegalStateException("cannot have a null board to rotate");
        }
        if (Math.sqrt(transformedBoard.length) != lines){
            throw new IllegalArgumentException("no point in rotating non square board");
        }
        if (lines<1 || columns<1){
            throw new IllegalStateException("Cannot have negative lines or columns");
        }

        int[] temp= new int[transformedBoard.length];

        for (int x = 0; x < lines; x++){

            for(int i = 0; i< columns; i++){
                temp[(x+1)*columns - i -1] = transformedBoard[x + columns*i];
            }
        }

         for (int i= 0; i<transformedBoard.length; i++){
            transformedBoard[i] = temp[i];

        }
    }

    /**
     * This method does an horizontal symmetry on array of size lines * columns referenced
     * by transformedBoard. For example, the
     * 3*3 game
     *
     *
     * 1 | 2 | 3
     * ----------
     * 4 | 5 | 6
     * ----------
     * 7 | 8 | 9
     *
     * for which lines = 3 and columns = 3 is represented by the array
     * transformedBoard = {1,2,3,4,5,6,7,8,9}
     *
     * the method transforms it into the game   
     *
     * 7 | 8 | 9
     * ----------
     * 4 | 5 | 6
     * ----------
     * 1 | 2 | 3
     *
     * that is, after the method, transformedBoard = {7,8,9,4,5,6,1,2,3}
     *
     * @param lines
     *  the number of lines in the game
     * @param columns
     *  the number of columns in the game
     * @param transformedBoard
     *  Reference to a 1 dimentional array of size columns x lines
     */

    public static  void horizontalFlip(int lines, int columns, int[] transformedBoard){

        // YOUR CODE HERE
        if (transformedBoard == null){
            throw new IllegalStateException("cannot have a null board to rotate");
        }
        if  (lines<1 || columns<1){
            throw  new IllegalStateException("Cannot have negative lines or columns");
        }


        for(int x = 0; x < lines/2; x++){

            for(int i = 0; i < columns; i++){
                int tpNum = transformedBoard[(lines-1-x)*columns + i]; //Holds unumber at bottom half
                transformedBoard[(lines-1-x) * columns + i] = transformedBoard[x*columns + i];
                transformedBoard[x*columns + i]= tpNum;
            }

        }

  
    }

   /**
     * This method does an vertical symmetry on array of size lines * columns referenced
     * by transformedBoard. For example, the
     * 3*3 game
     *
     * 1 | 2 | 3
     * ----------
     * 4 | 5 | 6
     * ----------
     * 7 | 8 | 9
     *
     * for which lines = 3 and columns = 3 is represented by the array
     * transformedBoard = {1,2,3,4,5,6,7,8,9}
     *
     * the method transforms it into the game   
     *
     * 3 | 2 | 1
     * ----------
     * 6 | 5 | 4
     * ----------
     * 9 | 8 | 7
     *
     * that is, after the method, transformedBoard = {3,2,1,6,5,4,9,8,7}
     *
     * @param lines
     *  the number of lines in the game
     * @param columns
     *  the number of columns in the game
     * @param transformedBoard
     *  Reference to a 1 dimentional array of size columns x lines
     */

    public static  void verticalFlip(int lines, int columns, int[] transformedBoard){
 
        // YOUR CODE HERE
        if (transformedBoard == null){
            throw new IllegalStateException("cannot have a null board to rotate");
        }
        if (lines<1 || columns<1){
            throw new IllegalStateException("Cannot have negative lines or columns");
        }

        for(int x = 0; x < columns/2; x++){

            for (int i = 0; i < lines; i++){
                int tpNum = transformedBoard[((i+1)*columns - x -1)]; //This holds number that is on right side
                transformedBoard[((i+1)*columns - x -1)]= transformedBoard[x + columns*i]; //replace right side by left side
                transformedBoard[x + columns*i] = tpNum;

            }
        }

    }
    private static void test(int lines, int columns){
    	int[] test;
    	test = new int[lines*columns];
    	for(int i = 0 ; i < test.length; i++){
    		test[i] = i;
    	}
    	System.out.println("testing " + lines + " lines and " + columns + " columns.");
    	System.out.println(java.util.Arrays.toString(test));
    	horizontalFlip(lines,columns,test);
    	System.out.println("HF => " + java.util.Arrays.toString(test));
    	horizontalFlip(lines,columns,test);
    	System.out.println("HF => " + java.util.Arrays.toString(test));
    	verticalFlip(lines,columns,test);
    	System.out.println("VF => " + java.util.Arrays.toString(test));
    	verticalFlip(lines,columns,test);
    	System.out.println("VF => " + java.util.Arrays.toString(test));
    	if(lines == columns){
    		for(int i = 0; i < 4; i++) {
		    	rotate(lines,columns,test);
		    	System.out.println("ROT => " + java.util.Arrays.toString(test));    			
    		}
    	}
    }

    public static void main(String[] args){
    	int[] test;
    	int lines, columns;

    	test(2,2);
    	test(2,3);
    	test(3,3);
    	test(4,3);
    	test(4,4);


    }
}