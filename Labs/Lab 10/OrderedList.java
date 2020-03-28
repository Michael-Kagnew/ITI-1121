import java.util.NoSuchElementException;

public class OrderedList implements OrderedStructure {

    // Implementation of the doubly linked nodes (nested-class)

    private static class Node {

      	private Comparable value;
      	private Node previous;
      	private Node next;

      	private Node ( Comparable value, Node previous, Node next ) {
      	    this.value = value;
      	    this.previous = previous;
      	    this.next = next;
      	}
    }

    // Instance variables

    private Node head;

    // Representation of the empty list.

    public OrderedList() {
        // Your code here.
        head = new Node (null,null, null);
        head.next = head;
        head.previous = head;
    }

    // Calculates the size of the list

    public int size() {

      	// Remove line below and add your implementation.
        int counter = 0;

        Node temp = head.next;

        while(temp.value != null){
          counter++;
          temp = temp.next;
        }
        return counter;
    }


    public Object get( int pos ) {
        // Remove line below and add your implementation.

      if (pos < 0 || pos >= size()){
        throw new IndexOutOfBoundsException("Not in list index");
      
     }


      Node p = head.next;

      for (int x=0; x < pos; x++){
        p = p.next;

      }
      return p.value;
    }

    // Adding an element while preserving the order

    public boolean add( Comparable o ) {
        // Remove line below and add your implementation.

      if(o == null){
        throw new IllegalArgumentException("null");
      }

        //Want to skip past dummy node
      if (head.next.value == null){
        Node temp = new Node(o, head, head.next);
       // head.next = new Node(o, head, head);
        head.next = temp;
        System.out.println("checking if the first element added AT ALL" + head.next.value);

        
      }

   
      /*  while(o.compareTo(p.value) > 0){
          p = p.next;
          
        }*/
        else{
            Node p = head.next;
           while(p.value != null){

            if(o.compareTo(p.value) < 0){
            // p.next = new Node(o, p, p.next);
           // p.previous.next = new Node(o, p.previous, p);
            Node newNode = new Node(o, p.previous, p);
            p.previous = newNode;
            newNode.previous.next = newNode;
            break;

          }  if (p.next.value == null){
            p.next = new Node(o, p, p.next);
            break;
          }
           else{
            p = p.next;
          }
           
          }
       }
        return true;
       
    }

    //Removes one item from the position pos.

    public void remove( int pos ) {
      // Remove line below and add your implementation.


       if (pos < 0 || size() == 0){
        throw new IndexOutOfBoundsException("neg Number or empty list");
      }
      if (pos >= size()){
        throw new IndexOutOfBoundsException("Bigger position than size of list");
      }

      if (pos == 0 && size() > 1){
        //Make the element right after the first one point back to head
        head.next.next.next = head;

        head.next = head.next.next;
        
      }

      else if (pos == 0){
        head.next = head;
        head.previous = head;
      }


    
      else{
          Node p = head.next;

        for (int x = 0; x < pos-1; x++){
             p = p.next;
          }
            p.next.next.previous = p;
            p.next = p.next.next;

          }
      

    }

    // Knowing that both lists store their elements in increasing
    // order, both lists can be traversed simultaneously.

    public void merge( OrderedList other ) {
      // Remove line below and add your implementation.
        if(other == null){
        throw new IllegalArgumentException("null");
      }

      for(int i = 0; i < other.size(); i++){
        this.add((Comparable)other.get(i));
      }



      // Remove line below and add your implementation.
      //throw new UnsupportedOperationException( "not implemented yet!" );
    }

    
}