public class HumanPlayer implements Player{
	

	public void play(TicTacToeGame o){
		
		int numPlay;  
		boolean flag = true;
		System.out.println("Player 1's turn");

		while (o.getGameState().equals(GameState.PLAYING)){

			System.out.println(o.toString());
			System.out.print(o.nextCellValue() + " to play: ");
			numPlay = Integer.parseInt(Utils.console.readLine()) - 1;

			if (numPlay < 0 || numPlay > o.columns*o.lines-1){
				System.out.println("Invalid input. Please try again");
			
			} else if (o.valueAt(numPlay) != CellValue.EMPTY){
				System.out.println("This is a taken position");
			}
			else{
				o.play(numPlay);
				return ;
			}
		}
        }
	}
