public class SinglyLinkedList<E> implements List<E>{
	
	private static class Node<T>{
		private T value;
		private Node<T> next;
		private Node(T value, Node<T> next)	{
			this.value = value;
			this.next = next;
		}

	private Node <E> head;

	public SinglyLinkedList(){
		head = null;
	}

	public int size(){
		int size;
		Node<E> p;
		p = head;

		while (p != null){ //No need to check p.next, when setting  at the last one, would be null
			size++;
			p = p.next;
		}
		return size;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}

	public void addFirst(E o){

		if( o == null){
			throw new NullPointerException("No null reference");
		}

		Node<E> newNode = new Node<E> (o, null); //The 

		head = new Node <E> (E, head); // Creates in object that is linked to head, making it become the 
					
										// the new first element, then have head point to the new object
	}

	public void add(E o	) { //Adds to ed of 
			if( o == null){
			throw new NullPointerException("No null reference");
		}

		Node<E> newNode = new Node<E>(o, null);

		Node<E> p = head;

		if(p == null){
			head = newNode; //Need 
		} else {
			while(p.next!=null){
				p = p.next;
			}
			p.next = newNode;
		}
	}

	public E removeFirst() {
		//	throw new UnsupportedOperationException("no implementation") //This is for no implementation
	}

	public boolean remove (E o){
		if (o == null) {
			return false; //Not an exception in this case
		}

		if(isEmpty()){

		}
		while(!p.next.value.equals(o)){
			return true;
		}
		return false;
	}
	public E removeLast(){
		if (isEmpty()){ //When empty, so head = null
			throw new IllegalStateExceptions("Can't remove empty ");
		}

		E temp;

		//Covers one element
		if (head.next == null){
			temp = head.value;
			head = null;
		
		} else {
			Node<E> p;
			p = head;
			//Goal is to stop when at current element, its next AND next doesn't have an element
			while(p.next.next !=null){ //CHECKS if the object after is null (the furter down element)
				p = p.next
			}
			tmp = p.next.value;
			p.next = null;
		}

		return temp;
	}

		public E get(int pos){

			i
		}
	}
}