public class Q3_SquareArray{
	

	public static int[] createArray(int size) {
	        int [] arr= new int [size];

			for (int x=0; x< arr.length; x++){
		    arr[x]=x*x;
			}

			return arr;
	}
    
    public static void main(String [] args){
           int[]arr=createArray(13);

           for (int x=0; x < arr.length; x++){
           	   System.out.println("The square of " + x + "is "  + arr[x]);
           } 

    }

}