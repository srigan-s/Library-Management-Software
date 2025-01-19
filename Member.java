//Member.java//
import java.util.*;
import java.time.LocalTime;
class Member {
	//initialising variables
	private String name;
	private int memberID;
	private ArrayList<Book> borrowedBooks;
	private ArrayList<Book> userHistoryBooks;
	private static ArrayList<Member> totalMembers = new ArrayList<Member>();
	public static ArrayList<String> dueBooks;
	public static ArrayList<LocalTime> dueBooksTime;
	//these are accessed in Report.java
	private int dramaTotal;
	private int mysteryTotal;
	private int thrillerTotal;
	private int romanceTotal;
	private int sciTotal;

	//contructor
	public Member(String name, int memberID) {
		this.name = name;
		this.memberID = memberID;
		this.borrowedBooks = new ArrayList<>();
		this.userHistoryBooks = new ArrayList<>();
		this.dueBooks = new ArrayList<>();
		this.dueBooksTime = new ArrayList<>();
		dramaTotal = 0;
		mysteryTotal = 0;
		thrillerTotal = 0;
		romanceTotal = 0;
		sciTotal = 0;
	}

	//getter methods
	public int getDrama() {
		return dramaTotal;
	}

	public int getMystery() {
		return mysteryTotal;
	}

	public int getThriller() {
		return thrillerTotal;
	}

	public int getRomance() {
		return romanceTotal;
	}

	public int getSci() {
		return sciTotal;
	}

	public String getMemberName() {
		return name;
	}

	public int getMemberID() {
		return memberID;
	}

	public ArrayList<Book> getUserHistory() { //total user borrowed books of all time
		return userHistoryBooks;
	}

	public ArrayList<Book> getBorrowedBooks() {
		return borrowedBooks;
	}

	//Static methods
	public static void addMember(Member person) { //adding each user's member object to totalMembers
		totalMembers.add(person);
	}

	public static int findMember(String name, int memberID) {
		boolean j = true;
		int i = 0;
		int returner = -16;
		while (i<totalMembers.size() && j) {
			if (totalMembers.get(i).getMemberName().equals(name) && totalMembers.get(i).getMemberID()==memberID) { //checks if name and id in totalMembers are equivilant to the user input
				returner = i;
				j = false;
			}
			i++;
		}
		return returner;
	}

	public static Member returnMember(int x) {
		return totalMembers.get(x);
	}

	public static void overdueBooks(ArrayList<String> totalDue, ArrayList<LocalTime> totalDueTime) {    //Overdue books
		LocalTime timeNow = LocalTime.now();

		for (int i = 0; i < totalDue.size(); i++) {
			String book = totalDue.get(i);
			LocalTime borrowedTime = totalDueTime.get(i);
			LocalTime dueTime = borrowedTime.plusSeconds(60);

			if (timeNow.isAfter(dueTime)) {
				System.out.print("\nOverdue Book(s): ");
				System.out.print(book + " is overdue.");
			} else {
				System.out.print("\nNon-Overdue Book(s): ");
				System.out.print(book + " is not overdue.");
			}
		}
	}

	//Non-static methods
	public void borrowBook(Book newBook) {
		borrowedBooks.add(newBook);
		userHistoryBooks.add(newBook);
		dueBooks.add(newBook.getTitle());
		dueBooksTime.add(newBook.getTime());
	}

	public void popularGenres(int x) {	//iterates each genreTotal for specific user
		if (x == 1) {
			dramaTotal++;
		} else if (x == 2) {
			mysteryTotal++;
		} else if (x == 3) {
			thrillerTotal++;
		} else if (x == 4) {
			romanceTotal++;
		} else if (x == 5) {
			sciTotal++;
		}

	}

	public int findBorrowedBook(String userTitle, String userAuthor, int userYear, int userGenre) {
		boolean j = true;
		int i = 0;
		int returner = -16;
		while (i<borrowedBooks.size() && j) { //Similiar selection structure used to see if name and id match, except here it's checking if borrowedBook belongs
			if (borrowedBooks.get(i).getTitle().toLowerCase().equals(userTitle.toLowerCase()) && borrowedBooks.get(i).getAuthor().toLowerCase().equals(userAuthor.toLowerCase()) && borrowedBooks.get(i).getYear()==userYear && borrowedBooks.get(i).getGenre()==userGenre) {
				returner = i;
				j = false;
			}
			i++;
		}
		return returner;
	}

	public Book returnBorrowedBook(int x) {
		return borrowedBooks.get(x);
	}

	public void removeBorrowedBook(Book item) {
		borrowedBooks.remove(item);
	}

	public void returnBookTime(String title, LocalTime time) {
		dueBooks.remove(title);
		dueBooksTime.remove(time);
	}

}

