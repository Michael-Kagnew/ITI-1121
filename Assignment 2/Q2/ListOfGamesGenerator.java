// Author: Michael Kagnew
// Student number: 300113347
// Course: ITI 1121-A
// Assignment: 2
// Question 2
import java.util.LinkedList;

public class ListOfGamesGenerator {
	

   /**
	* generates all different games for the specified
	* parameters. Each game is recorded only once. 
	* once a game is finished, it is not extended further
	* @param lines
    *  the number of lines in the game
    * @param columns
    *  the number of columns in the game
    * @param sizeWin
    *  the number of cells that must be aligned to win.
    * @return
    * a list of lists of game instances, ordered by levels
  	*/
	public static LinkedList<LinkedList<TicTacToeGame>> generateAllGames(int lines, int columns, int winLength){

		//YOUR CODE HERE
    LinkedList<LinkedList<TicTacToeGame>> myList = new LinkedList<LinkedList<TicTacToeGame>> ();
    TicTacToeGame base = new TicTacToeGame(lines, columns, winLength);
    
    //Initial, zero level board
    LinkedList <TicTacToeGame> lvl0 = new LinkedList <TicTacToeGame>();
    lvl0.add(base);
    myList.add(lvl0);  

    //Creating sub array
    for (int x = 0; x < lines*columns; x++){
       //New subarray list
       LinkedList <TicTacToeGame> list = new LinkedList <TicTacToeGame> ();

       //Getting the previous level board, checking if they state is still playing
       for (int i = 0; i < myList.getLast().size(); i++){
         TicTacToeGame lastGame = myList.getLast().get(i);

         if (lastGame.getGameState() == GameState.PLAYING){

            
            for(int y = 0; y <lines*columns; y++){

                try{
                   boolean check = false;
                   TicTacToeGame curr = new TicTacToeGame(lastGame, y);
                    for (TicTacToeGame a: list){
                             if (a.equals(curr)){
                                check = true;
                      
                            }
                       }
                   if (check == false){
                    list.add(curr);
                   }

                } catch(IllegalArgumentException e){
                }
            }
         }   
       }
       if (list.size() == 0){
         break;
       }
       myList.add(list);
    }

    /*
    for (int x = 0; x < lines * columns; x++){ //To check the last item in the last list
        
        boolean flag = true;
        //TicTacToeGame copyB = new TicTacToeGame(myList.getLast(),x)

        list = new LinkedList <TicTacToeGame>();

        for (int i = 0; i <myList.getLast.size(); i++){//need to size the previous array
            TicTacToeGame copyB = new TicTacToeGame(myList.getLast(),i);
            list.add(copyB);

            //Need to check duplicates
            for ()
        }


        }*/

        return myList;
        }
    }


