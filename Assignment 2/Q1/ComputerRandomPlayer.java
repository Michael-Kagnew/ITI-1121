public class ComputerRandomPlayer implements Player{

	//Clarify part about each random choice having equal chance
		public void play(TicTacToeGame o){
		
		int numPlay;  
		boolean flag = true;
		System.out.println("Player 2's turn");
		while (o.getGameState().equals(GameState.PLAYING)){
			numPlay = Utils.generator.nextInt(o.columns*o.lines);
			if (numPlay < 0 || numPlay > o.columns*o.lines-1){
				//Invalid 
			
			} else if (o.valueAt(numPlay) != CellValue.EMPTY){
				//Another invalid choice
			}
			 else{

				o.play(numPlay);
				return ;
			}
		}
        }
	}
