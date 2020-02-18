
// Author: Michael Kagnew
// Student number: 300113347
// Course: ITI 1121-A
// Assignment: 1
/**
 * The class <b>TicTacToeGame</b> is the
 * class that implements the Tic Tac Toe Game.
 * It contains the grid and tracks its progress.
 * It automatically maintain the current state of
 * the game as players are making moves.
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 * @author Michael Kagnew, University of Ottawa	
 */
import java.util.Arrays;

public class TicTacToeGame {

	private CellValue[] board;

	/**
	 * level records the number of rounds that have been played so far.
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
	 * sizeWin is the number of cell of the same type that must be aligned to win
	 * the game
	 */
	private int sizeWin;

	/**
	 * default constructor, for a game of 3x3, which must align 3 cells
	 */

	public CellValue[] getBoard() {
		return board;
	}

	public TicTacToeGame() {

		gameState = GameState.PLAYING;
		level = 0;
		lines = 3;
		columns = 3;
		sizeWin = 3;
		board = new CellValue[3 * 3];

		for (int x = 0; x<board.length; x++){
			board[x] = CellValue.EMPTY;
		}
	}

	/**
	 * constructor allowing to specify the number of lines and the number of columns
	 * for the game. 3 cells must be aligned.
	 * 
	 * @param lines   the number of lines in the game
	 * @param columns the number of columns in the game
	 */
	public TicTacToeGame(int lines, int columns) {

		gameState = GameState.PLAYING;
		level = 0;
		this.lines = lines;
		this.columns = columns;
		sizeWin = 3;
		board = new CellValue[lines * columns];
		for (int x = 0; x<board.length; x++){
			board[x] = CellValue.EMPTY;
		}
	}

	/**
	 * constructor allowing to specify the number of lines and the number of columns
	 * for the game, as well as the number of cells that must be aligned to win.
	 * 
	 * @param lines   the number of lines in the game
	 * @param columns the number of columns in the game
	 * @param sizeWin the number of cells that must be aligned to win.
	 */
	public TicTacToeGame(int lines, int columns, int sizeWin) {

		gameState = GameState.PLAYING;
		level = 0;
		this.lines = lines;
		this.columns = columns;
		this.sizeWin = sizeWin;
		board = new CellValue[lines * columns];
		for (int x = 0; x<board.length; x++){
			board[x] = CellValue.EMPTY;
		}
	}

	/**
	 * getter for the variable lines
	 * 
	 * @return the value of lines
	 */
	public int getLines() {

		return lines;

	}

	/**
	 * getter for the variable columns
	 * 
	 * @return the value of columns
	 */
	public int getColumns() {

		return columns;

	}

	/**
	 * getter for the variable level
	 * 
	 * @return the value of level
	 */
	public int getLevel() {

		return level;

	}

	/**
	 * getter for the variable sizeWin
	 * 
	 * @return the value of sizeWin
	 */
	public int getSizeWin() {

		return sizeWin;

	}

	/**
	 * getter for the variable gameState
	 * 
	 * @return the value of gameState
	 */
	public GameState getGameState() {

		return gameState;

	}

	/**
	 * returns the cellValue that is expected next, in other word, which played (X
	 * or O) should play next. This method does not modify the state of the game.
	 * 
	 * @return the value of the enum CellValue corresponding to the next expected
	 *         value.
	 */
	public CellValue nextCellValue() {

		// If current level is even, return X as X plays on all even number, odd for O
		CellValue nextPlay;
		if (level % 2 == 0) {
			nextPlay = CellValue.X;
		} else {
			nextPlay = CellValue.O;
		}
		return nextPlay;
	}

	/**
	 * returns the value of the cell at index i. If the index is invalid, an error
	 * message is printed out. The behaviour is then unspecified
	 * 
	 * @param i the index of the cell in the array board
	 * @return the value at index i in the variable board.
	 */
	public CellValue valueAt(int i) {

		// YOUR CODE HERE
		CellValue pos;
		if (i < 0 || i >= board.length) {
			System.out.println("This move is invalid");
			pos = CellValue.EMPTY;
		} else {
			pos = board[i];
		}
		return pos;

	}

	/**
	 * This method is called when the next move has been decided by the next player.
	 * It receives the index of the cell to play as parameter. If the index is
	 * invalid, an error message is printed out. The behaviour is then unspecified
	 * If the chosen cell is not empty, an error message is printed out. The
	 * behaviour is then unspecified If the move is valide, the board is updated, as
	 * well as the state of the game. To faciliate testing, is is acceptable to keep
	 * playing after a game is already won. If that is the case, the a message
	 * should be printed out and the move recorded. the winner of the game is the
	 * player who won first
	 * 
	 * @param i the index of the cell in the array board that has been selected by
	 *          the next player
	 */
	public void play(int i) {

		// YOUR CODE HERE
		boolean winner;

		// Checks if selected cell is in the board, and if it is empty
		if (i < 0 || i > board.length - 1) {
			System.out.println("Value must be between " + 1 + "and " + board.length);

		} else if (board[i] != CellValue.EMPTY) {
			System.out.println("Please try again, position is taken");
		} else {
			// Puts the value that the user to put onto the board
			board[i] = nextCellValue();
			// Is checking if there are any winners, setting the gameState accordingly
			setGameState(i);

		}

	}

	/**
	 * A helper method which updates the gameState variable correctly after the cell
	 * at index i was just set in the method play(int i) The method assumes that
	 * prior to setting the cell at index i, the gameState variable was correctly
	 * set. it also assumes that it is only called if the game was not already
	 * finished when the cell at index i was played (i.e. the game was playing).
	 * Therefore, it only needs to check if playing at index i has concluded the
	 * game, and if set the oucome correctly
	 * 
	 * @param i the index of the cell in the array board that has just been set
	 */

	private void setGameState(int i) {

		// YOUR CODE HERE
		// Whoever wins, set the win to that person

		if (verticalWin(i) == true || horizontalWin(i) == true || FDiagonalWin(i) == true || BDiagonalWin(i) == true) {
			if (gameState == GameState.PLAYING){
				gameState = whoWins();
			}
		
		}else{
			boolean flag = true;
			for (CellValue x: board){
				if (x == CellValue.EMPTY){
					flag = false;
				}
			}
			if (flag == true){
				gameState = GameState.DRAWN;
			}
		}
			
		
		level++;
	
    }
    


	/**
	 * Returns a String representation of the game matching the example provided in
	 * the assignment's description
	 * 
	 * @return String representation of the game
	 */

	public String toString() {

		String myStr = "";
		boolean flag = true;
		int counter = 0;

		// Loops through the enitre array, creating number of squares based off
		// Counter variable that is incremented
		while (counter < board.length) {
			// This for loop creates the rows
			for (int x = 0; x < columns; x++) {
				if (x != columns - 1) {

					if (board[counter] == CellValue.EMPTY) {
						myStr += "  " + " |";

					} else {
						myStr += " " + board[counter] + " |";
					}

				} else {
					if (board[counter] == CellValue.EMPTY) {
						myStr += "   ";

					} else {
						myStr += board[counter] + "  ";
					}
				}

				counter++;

			}

			myStr += "\n";

			// For loop that creates the lines,
			// If statement o not add the extra line at the bottom of grid
			if (counter / columns != lines) {
				for (int i = 0; i < 4 * columns - 1; i++) {
					myStr += "-";
				}
				myStr += "\n";
			}

		}

		return myStr;
	}

	// Section to implement winning functions here,
	// will be put in play() function utilizing i index for position

	private boolean verticalWin(int i) {
		int counter = 1;
		CellValue currPlayer = nextCellValue();
		boolean flag = true;
		int x = 1; // Use this to go up vetically
		int y = 1; // Use this to go down vertically
		while (flag) {

			// This checks if the position above and below exists, and if same value for run
			if (i / columns - x >= 0 && board[i - x * columns] == currPlayer) {
				counter++;
				x++;

			} else if (i / columns + y < lines && board[i + y * columns] == currPlayer) {
				counter++;
				y++;
			} else {
				flag = false;
			}
		}

		return counter >= sizeWin;
	}

	private boolean horizontalWin(int i) {
		int counter = 1;
		CellValue currPlayer = nextCellValue();
		boolean flag = true;
		int x = 1; // Use this to go up vetically
		int y = 1;

		// This checks if the position to right and left exists, and if same value for
		// run
		while (flag) {
			if (i % columns - x >= 0 && board[i - x] == currPlayer) {
				counter++;
				x++;

			} else if (i % columns + y < columns && board[i + y] == currPlayer) {
				counter++;
				y++;

			} else {
				flag = false;
			}
		}
		return counter >= sizeWin;
	}

	// Forward diagonal
	private boolean FDiagonalWin(int i) {
		int counter = 1;
		CellValue currPlayer = nextCellValue();
		boolean flag = true;
		int x = 1; // Use this to go up vetically
		int y = 1;

		// Checks if column to the right exists, and row above, and vice versa, as well
		// as value
		while (flag) {
			if (i / columns - x >= 0 && i % columns + x < columns 
				    && board[i - x * (columns - 1)] == currPlayer) {
				counter++;
				x++;

			} else if (i / columns + y < lines && i % columns - y >= 0 
					&& board[i + y * (columns - 1)] == currPlayer) {
				counter++;
				y++;

			} else {
				flag = false;
			}
		}
		return counter >= sizeWin;
	}

	// Backwards diagonal
	private boolean BDiagonalWin(int i) {

		int counter = 1;
		CellValue currPlayer = nextCellValue();
		boolean flag = true;
		int x = 1; // Use this to go up vetically
		int y = 1;

		// Checks if column to the left exists, and row above, as well as value
		while (flag) {
			if (i / columns - x >= 0 && i % columns - x >= 0 &&
				 board[i - x * (columns + 1)] == currPlayer) {
				x++;
				counter++;
			} else if (i / columns + y < lines && i % columns + y < columns
					&& board[i + y * (columns + 1)] == currPlayer) {
				counter++;
				y++;

			} else {
				flag = false;
			}
		}
		return counter >= sizeWin;

	}

	// This method is simply to decide if X won or O won
	private GameState whoWins() {
		GameState winner;
		if (level % 2 == 0) {
			winner = GameState.XWIN;
		} else {
			winner = GameState.OWIN;
		}
		return winner;
	}

}