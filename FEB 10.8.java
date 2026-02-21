import java.util.*;

// Custom Exception
class BookUnavailableException extends Exception {
    public BookUnavailableException(String message) {
        super(message);
    }
}

// Book Class (Encapsulation)
class Book {
    private int id;
    private String title;
    private String author;
    private boolean isAvailable = true;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return isAvailable; }

    public void setAvailable(boolean status) {
        this.isAvailable = status;
    }

    @Override
    public String toString() {
        return id + " | " + title + " | " + author + 
               " | " + (isAvailable ? "Available" : "Issued");
    }
}

// Member Class
class Member {
    private int memberId;
    private String name;
    private Map<Book, Integer> issuedBooks = new HashMap<>(); // Book + days issued

    public Member(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public void issueBook(Book book, int days) {
        issuedBooks.put(book, days);
    }

    public int returnBook(Book book) {
        return issuedBooks.remove(book);
    }

    public String getName() {
        return name;
    }
}

// Main Library Class
public class LibraryManagementSystem {

    private static List<Book> books = new ArrayList<>();

    public static void issueBook(Book book, Member member, int days) 
            throws BookUnavailableException {

        if (!book.isAvailable()) {
            throw new BookUnavailableException("Book is currently unavailable!");
        }

        book.setAvailable(false);
        member.issueBook(book, days);
        System.out.println("Book issued successfully to " + member.getName());
    }

    public static void returnBook(Book book, Member member) {
        int days = member.returnBook(book);
        book.setAvailable(true);

        // Late fine calculation (7 days allowed)
        if (days > 7) {
            int fine = (days - 7) * 10;  // ₹10 per extra day
            System.out.println("Late fine: ₹" + fine);
        }

        System.out.println("Book returned successfully.");
    }

    public static void main(String[] args) {

        // Adding Books
        books.add(new Book(1, "Java Basics", "James Gosling"));
        books.add(new Book(2, "Python Guide", "Guido van Rossum"));
        books.add(new Book(3, "Data Structures", "Mark Allen"));

        Member member = new Member(101, "Anjali");

        try {
            issueBook(books.get(0), member, 10); // Issue for 10 days
            returnBook(books.get(0), member);

        } catch (BookUnavailableException e) {
            System.out.println(e.getMessage());
        }

        // Sorting by Title
        books.sort(Comparator.comparing(Book::getTitle));
        System.out.println("\nSorted by Title:");
        books.forEach(System.out::println);

        // Sorting by Author
        books.sort(Comparator.comparing(Book::getAuthor));
        System.out.println("\nSorted by Author:");
        books.forEach(System.out::println);
    }
}
