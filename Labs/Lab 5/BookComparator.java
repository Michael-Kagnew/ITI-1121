import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    // Implement the comparator method for books.
    public int compare (Book book1, Book book2){
    	int comp;
    	if (book1.getAuthor().equals(book2.getAuthor()) == false){
    		if (book1.getAuthor().compareTo(book2.getAuthor()) > 0) {
    			comp = 1;
    		} else{
    			comp = -1;
    		}

    	} else if (book1.getTitle().equals(book2.getTitle()) == false){
    		if (book1.getTitle().compareTo(book2.getTitle()) > 0) {
    			comp = 1;
    		} else{
    			comp = -1;
    		}
    	
    	} else if (book1.getYear() != book2.getYear()){
    		if (book1.getYear() > book2.getYear()){
    			comp = 1;
    		} else {
    			comp = -1;
    		}
    	
    	} else {
    		comp = 0;
    	}
    return comp;
    } 

}