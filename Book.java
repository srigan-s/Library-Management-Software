//Book.java//
import java.util.*;
import java.time.LocalTime;

//abstract extension from Library.java
public class Book extends Library {
    private boolean available;
    private static ArrayList<Book> bookCollection = new ArrayList<Book>();
    
    //constructor
    public Book(String userTitle, String userAuthor, int userYear, int userGenre, LocalTime userTime, boolean userAvailable) {
        super(userTitle, userAuthor, userYear, userGenre, userTime);
        available = userAvailable;
    }
    
    //getter method
    public static ArrayList getBookCollection() {
        return bookCollection;
    }
    
    //Setter method
    public void setAvailability(boolean x) {
        available = x;
    }
    
    //abstract method extended from Library.java
    public boolean getAvailable() {
        return available;
    }
    
    //static method
    public static void addBook(Book item) {
       bookCollection.add(item);
    }
    
    public static void removeBook(Book item) {
       bookCollection.remove(item); 
    }
    public static int findBook(String userTitle, String userAuthor, int userYear, int userGenre) {
        boolean x = true;
        int i = 0;
        int returner = -16;
        while (i<bookCollection.size() && x) {
            if (bookCollection.get(i).getTitle().toLowerCase().equals(userTitle.toLowerCase()) && bookCollection.get(i).getAuthor().toLowerCase().equals(userAuthor.toLowerCase()) && bookCollection.get(i).getYear()==userYear && bookCollection.get(i).getGenre()==userGenre) {
                returner = i;
                x = false;
            }
            i++;
        }
        return returner;
    }
    
    public static Book returnBook(int x) {
        return bookCollection.get(x);
    }
    
    public static ArrayList<Book> findAllTitles(String title) {
        ArrayList<Book> bookTitles = new ArrayList<Book>();
        for (int i=0; i<bookCollection.size(); i++) {
            if (title.toLowerCase().equals(bookCollection.get(i).getTitle().toLowerCase())) {
                bookTitles.add(bookCollection.get(i));
            }
        }
        return bookTitles;
    }
    
    public static ArrayList<Book> findAll(String author) {
        ArrayList<Book> bookAuthors = new ArrayList<Book>();
        for (int i=0; i<bookCollection.size(); i++) {
            if (author.toLowerCase().equals(bookCollection.get(i).getAuthor().toLowerCase())) {
                bookAuthors.add(bookCollection.get(i));
            }
        }
        return bookAuthors;
    }
    
    public static ArrayList<Book> findAll(int genre) {
        ArrayList<Book> bookGenres = new ArrayList<Book>();
        for (int i=0; i<bookCollection.size(); i++) {
            if (genre==bookCollection.get(i).getGenre()) {
                bookGenres.add(bookCollection.get(i));
            }
        }
        return bookGenres;
    }
    
}

