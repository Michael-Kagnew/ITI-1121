public class Test{
	
	public static void main(String[] args){

	           OrderedList list = new OrderedList();

            list.add("A");
            list.add("B");
            list.add("C");
            System.out.println(list.size() + " hello " + list.get(1));

            list.remove(1);

	}
}