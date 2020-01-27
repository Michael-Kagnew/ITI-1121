
import java.lang.StringBuilder;
import java.io.Console;

public class Test2{
	public  String toString(){
			String[] arr = new String[] {"h", "a", "b" , "c"};
		int col = 2;
		int row = 4;
		StringBuilder str=new StringBuilder();
				StringBuilder bigONE=new StringBuilder();

		for (int i = 0; i< (4*col-1); i++){
			str.append("-");
		}


		int count =0;
		for (int x=0; x <row; x++){
			//System.out.println( (col-1)*("    "+ "|") );

			if (x>0 && x<row){
			bigONE.append(str);	
			bigONE.append("\n");
			}
			
			for (int i = 0; i < col; i++){
				if (i != col-1){
					bigONE.append(" X " + "|");	
				} else {
					bigONE.append(" "+"X");
				}
				count++;
			}
			bigONE.append("\n");
		}
		return bigONE.toString();
	}

	public static void main(String[] args){
		      Console console = System.console();

/*
		System.out.println(bigONE);
			int myNum = Integer.parseInt(console.readLine());
				System.out.println((myNum));
				//myNum;
								System.out.println((myNum));

*/
	Test2 hi = new Test2();
							
	System.out.println(hi.toString());
	}


}