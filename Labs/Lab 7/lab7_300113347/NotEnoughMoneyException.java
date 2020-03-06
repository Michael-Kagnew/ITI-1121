public class NotEnoughMoneyException extends IllegalStateException{
	double bal;
	double draw;

	public NotEnoughMoneyException(double bal, double draw){
		super("You have not enough money to withdraw" + draw + "$");
		this.bal = bal;
		this.draw = draw;
		

	}

	public double getBalance(){
		return bal;
	}

	public double getAmount(){
		return draw;
	}

	public double getMissingAmount(){
		return (draw - bal);
	}
}