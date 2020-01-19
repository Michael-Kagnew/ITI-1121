public class Q3_ArrayInsertionDemo{

	public static int[] insertIntoArray(int[] beforeArray, int indexToInsert, int valueToInsert){
		int n_size = beforeArray.length + 1;
		int [] AfterArray = new int [n_size];

		System.out.println("Array before insertion");
		for (int x: beforeArray){
			System.out.println(x);
		}

		AfterArray[indexToInsert] = valueToInsert;

		for (int x = 0; x< n_size; x++){
			if (x < indexToInsert){
				AfterArray[x] = beforeArray[x];
			} else if (x == indexToInsert) {
			}else {
				AfterArray[x] = beforeArray[x-1];
			}
	}
	return AfterArray;
}
	public static void main(String[] args){

		int[] arr = insertIntoArray(new int[] {1,2,3,4}, 1, 5);
		System.out.println("Array after insertion");
		
		for (int x: arr){
			System.out.println(x);
		}
	}
}