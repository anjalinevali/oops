class Book {

    // Encapsulation (private variables)
    private String title;
    private boolean isIssued;

    // Constructor
    public Book(String title) {
        this.title = title;
        this.isIssued = false; // book is available initially
    }

    // Issue book method
    public void issueBook() {
        if (isIssued == true) {
            System.out.println("Cannot issue. Book is already issued.");
        } else {
            isIssued = true;
            System.out.println("Book issued successfully.");
        }
    }

    // Return book method
    public void returnBook() {
        if (isIssued == false) {
            System.out.println("Book was not issued.");
        } else {
            isIssued = false;
            System.out.println("Book returned successfully.");
        }
    }

    // Display book status
    public void displayStatus() {
        System.out.println("Title: " + title);
        System.out.println("Issued: " + isIssued);
    }
}

// Main class
public class LibraryTest {
    public static void main(String[] args) {

        Book b1 = new Book("Java Basics");

        b1.issueBook();   // First time issue
        b1.issueBook();   // Prevent issuing twice

        b1.returnBook();  // Return
        b1.returnBook();  // Prevent returning twice
    }
}


