 public class Test{
      Book myBook = new Book("Shakespeare", "Hamlet", 1600);
      Book myBook2 = new Book("Author", "Hamlet", 1600);
      Library myLibrary = new Library();
      myLibrary.addBook(myBook);
      myLibrary.addBook(myBook2);
      myLibrary.sort();

}

