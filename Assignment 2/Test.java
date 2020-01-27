
import java.lang.StringBuilder;
public class Test{

	public static void main(String[] args){

		String[] arr = new String[] {"h", "a", "b" , "c"};
		int col = 3;
		int row = 5;
		StringBuilder str=new StringBuilder();
		for (int x=0; x<col; x++){
			str.append("   |");
		}

		for (int x=0; x <row; x++){
			//System.out.println( (col-1)*("    "+ "|") );
			System.out.println(str);

			for (int i = 0; i< (col*row-1); i++){
				if (x==(row-1)){
					break;
				}
				System.out.print("-");
			
			}
			System.out.println();
		}
	}
}