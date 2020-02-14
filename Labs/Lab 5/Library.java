import java.util.ArrayList;

public class Library {

    private ArrayList<Book> library = new ArrayList<Book>();

    public Book getBook(int i) {
      return library.get(i);
    }

    public int getSize() {
      return library.size();
    }

    public void addBook (Book b) {
        // Your code here
        library.add(b);
    }

    public void sort() {
        // Your code here
        BookComparator comp = new BookComparator();
        library.sort(comp);

        /*int check = 0;

        boolean flag = true;
        while (flag){
            flag = false;
        }
        for (int x = 0; x<library.size()-1; x++){
            Book  book1Comp = library.get(x);

            Book temp1 = library.get(x+1); //Starting off the selection sort

            for (int i = 0; i < library.size()-1; i++){
                if (comp.compare(temp1, library.get(i)) > 0){
                    temp1 = library.get(i);
              }   
            }
            
            check = comp.compare(book1Comp, temp1);

            if (check == 1){
                //temp = library.get(x);
                library.set(x+1, book1Comp); 
                library.set(x, temp1);
                flag = true; 
       */ }

            

    


    public void printLibrary() {
        // Your code here
        for (Book x: library){
            System.out.println(x);
        }
    }
}