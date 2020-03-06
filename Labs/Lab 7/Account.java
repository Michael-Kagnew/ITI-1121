public class Account{
    
    private double balance;

    public Account(){
        balance = 0;
    }

    public void deposit(double num){
        balance += num;
        System.out.println("new balance=" + balance + "$");
    }

    public void withdraw(double num){
        if (num > balance){
            throw new NotEnoughMoneyException(balance, num);
        }

        balance-= num;
        System.out.println("new balance=" + balance + "$");
    }

    public double getBalance(){
        return balance;
    }

}