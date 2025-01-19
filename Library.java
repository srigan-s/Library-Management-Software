//Library.java//
import java.util.*;
import java.time.LocalTime;

public abstract class Library {
	//Class specific variables
	private String title;
	private String author;
	private int year;
	private int genre;
	private LocalTime time;
	private boolean available;

	//constructor initializes book object since it's abstract
	public Library(String userTitle, String userAuthor, int userYear, int userGenre, LocalTime userTime) {
		title = userTitle;
		author = userAuthor;
		year = userYear;
		genre = userGenre;
		time = userTime;
	}

	//Getter methods
	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public int getYear() {
		return year;
	}

	public int getGenre() {
		return genre;
	}

	public LocalTime getTime() {
		return time;
	}

	//Setter method
	public void changeTime(LocalTime newTime) {
		time = newTime;
	}

	//abstract method declare
	public abstract boolean getAvailable();

}
