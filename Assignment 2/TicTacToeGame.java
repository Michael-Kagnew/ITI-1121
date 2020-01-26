/**
 * The class <b>TicTacToeGame</b> is the
 * class that implements the Tic Tac Toe Game.
 * It contains the grid and tracks its progress.
 * It automatically maintain the current state of
 * the game as players are making moves.
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 			Michael Kagnew, Univeristy of Ottawa

 */
import Java.Util.Arrays;

public class TicTacToeGame {

// FINISH THE VARIABLE DECLARATION
   /**
	* The board of the game, stored as a one dimension array.
	*/
	private CellValue[] board;


   /**
	* level records the number of rounds that have been
	* played so far. 
	*/
	private int level;

   /**
	* gameState records the current state of the game.
	*/
	private GameState gameState;


   /**
	* lines is the number of lines in the grid
	*/
	private int lines;

   /**
	* columns is the number of columns in the grid
	*/
	private int columns;


   /**
	* sizeWin is the number of cell of the same type
	* that must be aligned to win the game
	*/
	private int sizeWin;


   /**
	* default constructor, for a game of 3x3, which must
	* align 3 cells
	*/
	public TicTacToeGame(){

		// YOUR CODE HERE 
		gameState = GameState.PLAYING;
		level = 0;
		lines = 3;
		columns = 3;
		int sizeWin = 3;
		board=new CellValue[3*3];
		Arrays.fill(board, CellValue.EMPTY)



	}

   /**
	* constructor allowing to specify the number of lines
	* and the number of columns for the game. 3 cells must
	* be aligned.
   	* @param lines
    *  the number of lines in the game
    * @param columns
    *  the number of columns in the game
  	*/
	public TicTacToeGame(int lines, int columns){

		// YOUR CODE HERE 
		gameState = GameState.PLAYING;
		level = 0;
		this.lines = lines;
		this.columns = columns;
		sizeWin = 3;
		board = new CellValue[lines*columns];

	}

   /**
	* constructor allowing to specify the number of lines
	* and the number of columns for the game, as well as 
	* the number of cells that must be aligned to win.
   	* @param lines
    *  the number of lines in the game
    * @param columns
    *  the number of columns in the game
    * @param sizeWin
    *  the number of cells that must be aligned to win.
  	*/
	public TicTacToeGame(int lines, int columns, int sizeWin){

		// YOUR CODE HERE 
		gameState = GameState.PLAYING;
		level = 0;
		this.lines = lines;
		this.columns = columns;
		this.sizeWin = sizeWin;
		board = new CellValue[lines*columns];

	}



   /**
	* getter for the variable lines
	* @return
	* 	the value of lines
	*/
	public int getLines(){

		return lines;

	}

   /**
	* getter for the variable columns
	* @return
	* 	the value of columns
	*/
	public int getColumns(){

		// YOUR CODE HERE 
		return columns;

	}

   /**
	* getter for the variable level
	* @return
	* 	the value of level
	*/
	public int getLevel(){

		// YOUR CODE HERE 
		return level;

	}

  	/**
	* getter for the variable sizeWin
	* @return
	* 	the value of sizeWin
	*/
	public int getSizeWin(){

		// YOUR CODE HERE 
		return sizeWin;

	}

   /**
	* getter for the variable gameState
	* @return
	* 	the value of gameState
	*/
	public GameState getGameState(){

		// YOUR CODE HERE 
		return gameState;

	}

   /**
	* returns the cellValue that is expected next,
	* in other word, which played (X or O) should 
	* play next.
	* This method does not modify the state of the
	* game.
	* @return 
    *  the value of the enum CellValue corresponding
    * to the next expected value.
  	*/
	public CellValue nextCellValue(){

		// YOUR CODE HERE 

		//If current level is even, return X as X plays on all even number, odd for O
		CellValue nextPlay;
		if (level % 2){
			nextPlay = GameState.X;
		} else {
			nextPlay = GameState.O;
		}
		return nextPlay;
	}

   /**
	* returns the value  of the cell at
	* index i.
	* If the index is invalid, an error message is
	* printed out. The behaviour is then unspecified
   	* @param i
    *  the index of the cell in the array board
    * @return 
    *  the value at index i in the variable board.
  	*/
	public CellValue valueAt(int i) {

		// YOUR CODE HERE 
		if (board[i] != null){
				System.out.println("This move is invalid, already played");
			}
			
		return board[i];
	}

   /**
	* This method is called when the next move has been
	* decided by the next player. It receives the index
	* of the cell to play as parameter.
	* If the index is invalid, an error message is
	* printed out. The behaviour is then unspecified
	* If the chosen cell is not empty, an error message is
	* printed out. The behaviour is then unspecified
	* If the move is valide, the board is updated, as well
	* as the state of the game.
	* To faciliate testing, is is acceptable to keep playing
	* after a game is already won. If that is the case, the
	* a message should be printed out and the move recorded. 
	* the  winner of the game is the player who won first
   	* @param i
    *  the index of the cell in the array board that has been 
    * selected by the next player
  	*/
	public void play(int i) {


		// YOUR CODE HERE 
		boolean winner;

		CellValue pos = CellValue(i);
		if (!(0 <= i <= lines*columns)) {
			System.out.println("Please try again, not a valid index");
		} else if (pos != CellValue.EMPTY) {
			System.out.println("Please try again, position is taken");
		} else {
			board[i] = nextCellValue();

		}

		if ((verticalWin(i) || horizontal )


		
		



	
	}


   /**
	* A helper method which updates the gameState variable
	* correctly after the cell at index i was just set in
	* the method play(int i)
	* The method assumes that prior to setting the cell
	* at index i, the gameState variable was correctly set.
	* it also assumes that it is only called if the game was
	* not already finished when the cell at index i was played
	* (i.e. the game was playing). Therefore, it only needs to 
	* check if playing at index i has concluded the game, and if
	* set the oucome correctly
	* 
   	* @param i
    *  the index of the cell in the array board that has just 
    * been set
  	*/


	private void setGameState(int i){

		// YOUR CODE HERE 




	}



   /**
	* Returns a String representation of the game matching
	* the example provided in the assignment's description
	* 
   	* @return
    *  String representation of the game
  	*/

	public String toString(){

		// YOUR CODE HERE 

	}

	//Implement winning functions here, will be put in play function utilizing i index for position
	private boolean verticalWin(int i){
		int counter = 0;
		CellValue currPlayer = nextCellValue();

		for (int x = 1; x < columns+1; i++){
			//while (x* (i - columns) != )
			//(i % col - x >= 0 )  

			//This checks if the position above is not the top row, and if same value for run
			if (i % col - x <= 0 && board[x * (i - columns)] == currPlayer){
				counter++;
			} else {
				break;
			}
		}
		return counter == sizeWin;
	}

	private boolean horizontalWin(int i){

	}

	private boolean LRDiagonalWin(int i){
		
	}


	// FOr diagonals, make it check if it hits the side/top/bottom 


}