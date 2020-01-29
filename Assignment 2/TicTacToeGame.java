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
import  java.util.Arrays;


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

	public CellValue[] getBoard(){
		return board;
	}
	public TicTacToeGame(){

		// YOUR CODE HERE 
		gameState = GameState.PLAYING;
		level = 0;
		lines = 3;
		columns = 3;
		 sizeWin = 3;
		board=new CellValue[3*3];
		Arrays.fill(board, CellValue.EMPTY);



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
		Arrays.fill(board, CellValue.EMPTY);	
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
		Arrays.fill(board, CellValue.EMPTY);

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
		if (level % 2 == 0){
			nextPlay = CellValue.X;
		} else {
			nextPlay = CellValue.O;
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
		CellValue pos;
		if ( i<0 || i>=board.length){
				System.out.println("This move is invalid");
				pos = CellValue.EMPTY;
		} else{
			pos = board[i];
		}	
		return pos;
		
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

		//Checks if selected cell is in the board, and if it is empty
		//System.out.println(toString());
		if ( i < 0 || i > board.length-1) {
			System.out.println("Please try again, not a valid index");

		} else if (board[i] != CellValue.EMPTY) {
			System.out.println("Please try again, position is taken");
		} else {
			CellValue pos = valueAt(i); //Idk if this is needed
			board[i] = nextCellValue(); //Puts the value that the user to put onto the board
			setGameState(i); //Is checking if there are any winners, setting the gameState accordingly
			System.out.println(getGameState());

		}

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


	private void setGameState(int i)  {

		// YOUR CODE HERE 
		//Whoever wins, set the win to that person
		if (verticalWin(i) == true || horizontalWin(i) == true || FDiagonalWin(i) == true|| BDiagonalWin(i)== true){
			gameState = whoWins();

		
		} else if (Arrays.asList(board).contains(CellValue.EMPTY) == false){
			gameState = GameState.DRAWN;
			System.out.println("The game is a draw");
		
		} else {
			gameState = GameState.PLAYING;
		}
		level++;
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
		
		/*StringBuilder str=new StringBuilder();
		StringBuilder mainStr=new StringBuilder();

		for (int i = 0; i< (4*columns-1); i++){
			str.append("-");
		}

		int count = 0;
		for (int x=0; x < lines; x++){
			if (x>0 && x<lines){
			mainStr.append(str);
			mainStr.append("\n");

			}
			
			for (int i = 0; i < columns; i++){
				if (i != columns- 1){ //This is to make sure that last column doesn't have | in it
					if (board[count] == CellValue.EMPTY){
						//mainStr.append("   " + "|");
						mainStr.append("EMP" + "|");
					}else{
						mainStr.append(" " + board[count].name()+ " " + "|");
					}
				
				} else {
					if (board[count] == CellValue.EMPTY){
						mainStr.append(" ");

					} else{
						mainStr.append(" "+ board[count].name());

					}

				}
				count++;	
			}
			mainStr.append("\n");
		}
		return mainStr.toString();*/
		String myStr= "";
		boolean flag = true;
		int counter = 0;
		while (counter<board.length){
			for (int x = 0; x<columns; x++){
			if (x != columns- 1){
				myStr+=board[counter] + "|";
			} else{
				myStr+=board[counter]+ "  ";

			}
			counter++;

			}

			myStr+= "\n";

			if (counter/columns != lines ){ //To not add the extra line at the bottom
				for (int i = 0; i < 4*columns-1; i++){
					myStr+="-";
			}
			myStr+="\n";
			}
			
	    }
		
		return myStr;
	}

	

	//Implement winning functions here, will be put in play function utilizing i index for position
	private boolean verticalWin(int i){
		int counter = 1;
		CellValue currPlayer = nextCellValue();
		boolean flag = true;
		int x = 1; //Use this to go up vetically
		int y = 1; // Use this to go down vertically
		//for (int x = 1; x < columns+1; i++){
		while (flag){
			//This checks if the position above is not the top row, and if same value for run
			if (i / columns - x >= 0 && board[ i - x*columns] == currPlayer){
				counter++;
				x++;

			} else if (i / columns + y < lines && board[i + y*columns] == currPlayer){
				counter++;
				y++;
			}
			 else {
				flag = false;
			}
		}

			//while (x* (i - columns) != )
			//(i % col - x >= 0 )  

		
			
		return counter == sizeWin;
	}

	private boolean horizontalWin(int i){
		int counter = 1;
		CellValue currPlayer = nextCellValue();
		boolean flag = true;
		int x = 1; //Use this to go up vetically
		int y = 1;

		while (flag){
			//This checks if the position above is not the top row, and if same value for run
			if (i % columns - x >= 0 && board[ i - x] == currPlayer){
				counter++;
				x++;

			} else if (i % columns + y < columns && board[i + y] == currPlayer){
				counter++;
				y++;
			 } else {
				flag = false;
			}
		}
		return counter == sizeWin;
	}

	private boolean FDiagonalWin(int i){
		int counter = 1;
		CellValue currPlayer = nextCellValue();
		boolean flag = true;
		int x = 1; //Use this to go up vetically
		int y = 1;

		while (flag){
			if (i/ columns - x >= 0    &&    i % columns + x < columns   &&   board[i - x*(columns-1)] == currPlayer){
			 //Checks if column to the right exists, and row above, as well as value
				counter++;
				x++;
			
			} else if (i / columns + y < lines   &&   i% columns - y >= 0   && board[i + y*(columns-1)] == currPlayer){
				counter++;
				y++;
			
			} else {
				flag = false;
			}
		}
		return counter == sizeWin;	
	}

	private boolean BDiagonalWin(int i){

		int counter = 1;
		CellValue currPlayer = nextCellValue();
		boolean flag = true;
		int x = 1; //Use this to go up vetically
		int y = 1;

		while (flag){
			if (i/ columns - x >= 0    &&    i % columns - x >= 0   &&   board[i - x*(columns+1)] == currPlayer){
			 //Checks if column to the left exists, and row above, as well as value
				counter++;
				x++;
				
			} else if (i / columns + y < lines   &&   i% columns + y < columns  && board[i + y*(columns+1)] == currPlayer){
				counter++;
				y++;
			
			} else {
				flag = false;
			}
		}
		return counter == sizeWin;			

	}

	//This method is simply to decide if X won or O won
	private GameState whoWins(){
		GameState winner;
		if (level % 2 == 0){
			winner = GameState.XWIN;
		} else {
			winner = GameState.OWIN;
		}
		return winner;
	}



}