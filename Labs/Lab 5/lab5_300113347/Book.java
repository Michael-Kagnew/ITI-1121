public class Book {

    // Your variables declaration here

     private String author;  
    private String title;
    private int year;

    public Book (String author, String title, int year) {
        // Your code here
        this.author = author;
        this.title = title;
        this.year = year;

    }

    public String getAuthor() {
        // Your code here
        return author;
    }

    public String getTitle() {
        // Your code here
        return title;
    }

    public int getYear() {
        // Your code here
        return year;
    }

    public boolean equals(Object other) {
        // Your code here
        if (other == null){
            return false;
        }

        //Should check the constructor of the object
        if (!(other instanceof Book)){
            return false;
        }

        Book o = (Book) other;


        //Need to check this, because can't do .equals() on a null object
        if (author == null || title == null){
            return (o.author == null || o.title == null);
        }

    return (author.equals(o.author) && title.equals(o.title) && year == o.year);

    }

    public String toString() {
        // Your code here
        return (author + ": " + title + "(" + String.valueOf(year) + ")");

    }
}