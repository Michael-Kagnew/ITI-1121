public class Dictionary implements Map<String, Integer> {

    private final static int INITIAL_CAPACITY = 10;
    private final static int INCREMENT = 5;
    private int count;


    private Pair[] elems;

    public int getCount() {
      return count;
    }

    public int getCapacity() {
      return elems.length;
    }

    public Dictionary() {
        /* Your code here */
        elems = new Pair[INITIAL_CAPACITY];
        count = 0;

    }

    @Override
    public void put(String key, Integer value) {
        /* Your code here */
        elems[count] = new Pair(key, value);
        count++;
        increaseCapacity();

    }

    private void increaseCapacity() {
        /* Your code here.  Use this in put() where necessary. */
        if (elems[elems.length-1] != null){
          Pair[] temp = new Pair[elems.length + INCREMENT];
          for (int x = 0; x < elems.length; x++){
            temp[x] = elems[x];
          }
          elems = temp;
        }
        
    }

    @Override
    public boolean contains(String key) {
        /* Your code here. */
        for (Pair x : elems){
          if (x!=null && x.getKey().equals(key)){
            return true;
          }
        }
      return false;
    }

    @Override
    public Integer get(String key) {
        /* Your code here. */
        Integer val = 0;
        for (int x = elems.length-1; x >= 0; x--){
          if (elems[x] != null && elems[x].getKey().equals(key)){
            val = elems[x].getValue();
            break;
          }
        }
      return val;
    }

    @Override
    public void replace(String key, Integer value) {
        /* Your code here. */
      for (int x = elems.length-1; x >= 0; x--){
          if (elems[x] != null &&elems[x].getKey().equals(key)){
            elems[x].setValue(value);
            break;
      }
    }
  }

    @Override
    public Integer remove(String key) {
        /* Your code here. */
      Integer byeBye = null;
      for (int x = elems.length-1; x >= 0; x--){
          if (elems[x] != null && elems[x].getKey().equals(key)){
            byeBye = elems[x].getValue();
            elems[x] = null;
            count--;
            // System.out.println(count);
            break;
          }
    }
    return byeBye;
  }
    @Override
    public String toString() {
      String res;
      res = "Dictionary: {elems = [";
      for (int i = count-1; i >= 0 ; i--) {
          res += elems[i];
          if(i > 0) {
              res += ", ";
          }
      }
      return res +"]}";
    }

}