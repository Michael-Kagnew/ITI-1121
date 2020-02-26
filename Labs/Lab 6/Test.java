public class Test{
	
	public static void main(String[] args){


	       Dictionary ages = new Dictionary();
      ages.put("Mary", 25);
      ages.put("John", 20);
      ages.put("Mary", 15);

      int ret = ages.remove("Mary");

}
}