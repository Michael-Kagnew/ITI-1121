public class DynamicArrayStack<E> implements Stack<E> {

    // Instance variables

    private E[] elems;  // Used to store the elements of this ArrayStack
    private int top;    // Designates the first free cell
    private static final int DEFAULT_INC = 25;   //Used to store default increment / decrement

    @SuppressWarnings( "unchecked" )

    // Constructor
    public DynamicArrayStack( int capacity ) {
        // Your code here.
        if (capacity > 25){
            elems = (E[]) new Object[capacity+1];
        } else {
            elems = (E[]) new Object[DEFAULT_INC];
        }
    }

    // Gets current capacity of the array
    public int getCapacity() {
        return elems.length;
    }

    // Returns true if this DynamicArrayStack is empty
    public boolean isEmpty() {
        return ( top == 0 );
    }

    // Returns the top element of this ArrayStack without removing it
    public E peek() {
        if (top == 0){
            throw new java.util.EmptyStackException();
        }
        return elems[ top-1 ];
    }

    @SuppressWarnings( "unchecked" )

    // Removes and returns the top element of this stack
    public E pop() {
        // Your code here.
        if (top == 0){
            throw new java.util.EmptyStackException();
        }
       E topElem = elems[top - 1];
        elems[--top - 1] = null;

        if (elems.length-1-top == (DEFAULT_INC)){
            E[] temp = (E[]) new Object[elems.length - DEFAULT_INC];
            for (int x = 0; x < temp.length; x++){
                temp[x] = elems[x];
            }
            elems = temp;

        } 
        
        return topElem;
    }
    

    @SuppressWarnings( "unchecked" )

    // Puts the element onto the top of this stack.
    public void push( E element ) {
        // Your code here.

           elems[top] = element;
        top++;

        if (elems[elems.length-1] != null){ //This checks the last element
            E[] temp = (E[]) new Object[elems.length + DEFAULT_INC];
                for (int x = 0; x < elems.length; x++){
                    temp[x] = elems[x];
            }
            elems = temp;
        }
    }

    @SuppressWarnings( "unchecked" )

    public void clear() {
        // Your code here.
        elems = (E[]) new Object[DEFAULT_INC];
        top = 0;
    }
}