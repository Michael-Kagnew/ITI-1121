/* *
 * Use static array for NewsFeed
 * with constant MAX_SIZE
 * */

public class NewsFeed {

    private Post[] messages;
    private int size;
    public static final int MAX_SIZE = 25;

    public NewsFeed() {
    	// Your code here.
      size = 0;
      messages = new Post[MAX_SIZE];

    }

    public void add(Post message) {
      // Your code here.
    /*  for (int x = 0; x < messages.length; x++){
        if (messages[x] == null){
          messages[x] = message;
          size++;
        }
      }*/
      for (int x = 0; x < messages.length; x++){
        if (messages[x] == null){
          messages[x] = message;
          size++;
          break;
        }
      }
    }

    public Post get(int index) {
	     return messages[index];
    }

    public int size() {
	     return size;
    }

	  public void sort(){
			int i, j, argMin;
			Post tmp;
			for (i = 0; i < size - 1; i++) {
				argMin = i;
				for (j = i + 1; j < size(); j++) {
					if (messages[j].compareTo(messages[argMin]) < 0) {
						argMin = j;
					}
				}

  			tmp = messages[argMin];
  			messages[argMin] = messages[i];
  			messages[i] = tmp;
		  }

	  }

  	public NewsFeed getPhotoPost(){
  		// Your code here
      NewsFeed photoObj = new NewsFeed();
      for (Post x : messages){
        if (x instanceof PhotoPost){
          photoObj.add(x);
        }
      }

      return photoObj;
  	}

  	public NewsFeed plus(NewsFeed other){

  	  // Your code here
      NewsFeed combFeed = new NewsFeed();

    //  Post[] comPost = combFeed.messages;

      for (int x = 0; x < combFeed.messages.length; x++){
          Post temp1 = messages[x];
          Post temp2 = other.messages[x];

          //This adds to the new array. Combines the array of the two newsFeed. 
          //Has to check if null so that size counter doesn't increase
          if (temp1 != null){
             combFeed.add(temp1);  
          }

          if (temp2 != null){
            combFeed.add(temp2);
          }
        
      }

      combFeed.sort();
      return combFeed;
  	}

}
