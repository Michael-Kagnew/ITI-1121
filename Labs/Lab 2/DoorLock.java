public class DoorLock {

    // Constant.
    public static final int MAX_NUMBER_OF_ATTEMPTS = 3;

    // Instance variables.
    private Combination combination;
    private boolean open;
    private boolean activated;
    private int numberOfAttempts;

    // Constructor.
    public DoorLock( Combination combination ) {
        // Your code here
        this.combination = combination;
        open = false;
        activated = true;
        numberOfAttempts = 0;
    }

    // Access methods.

    public boolean isOpen() {

        return open;
    }

    public boolean isActivated() {
        return activated;
    }

    // Notice that numberOfAttempts is compared to
    // MAX_NUMBER_OF_ATTEMPTS only when its value has been
    // incremented, Also, numberOfAttempts should be set to zero when
    // activated is false.  Problems related to the combined action of
    // these two variables have caused problems for some students.

    public boolean open( Combination combination ) {

        // Put your code here, then remove the line below.
        if (activated == true){ 
            if (this.combination.equals(combination)){
                open = true;
                numberOfAttempts = 0;

           } else if (numberOfAttempts == MAX_NUMBER_OF_ATTEMPTS - 1){
            activated = false;
           // numberOfAttempts = 0;
            //return activated;


           } else {
                numberOfAttempts++;
            }
            
        //This is when the doorlock is deactivated after failed attempts. No idea what to do?
        //Stating the door is still locked
        } else {
            return false;

        }
        return false;
    }

    public void activate( Combination c ) {
        // Put your code here, then remove this comment.
        if (combination.equals(c)){
            activated = true;
        }
    }

   /* public static void main(String[] args){
        Combination attempt = new Combination(4,3,1);
        Combination lock = new Combination (1,2,3);
        DoorLock door = new DoorLock(lock);
        //System.out.println(door.isOpen());
        System.out.println(door.open(attempt));
        attempt.setLock(1,2,6);
        System.out.println(door.open(attempt));
        System.out.println(door.isOpen()+ "" + door.isActivated());
        attempt.setLock(1,2,3);
        System.out.println(door.open(attempt) + "attempting to open");
        attempt.setLock(3,4,6);
        System.out.println(door.open(attempt) + "attempting to open");

        System.out.println(door.isOpen()+ "" + door.isActivated());
        System.out.println(door.open(attempt) + "attempting to open");
        System.out.println(door.isOpen()+ "" + door.isActivated());
        System.out.println(door.open(attempt) + "attempting to open");
        System.out.println(door.isOpen()+ "" + door.isActivated());
                System.out.println(door.open(attempt) + "attempting to open");
        System.out.println(door.isOpen()+ "" + door.isActivated());


        //System.out.println(door.open(attempt) + "attempting to open");
    }*/

}