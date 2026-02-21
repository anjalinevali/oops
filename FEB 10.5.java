class Movie {
    private String movieName;
    private String showTime;

    public Movie(String movieName, String showTime) {
        this.movieName = movieName;
        this.showTime = showTime;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getShowTime() {
        return showTime;
    }
}
import java.util.*;

class Theatre {
    private int totalSeats;
    private Map<String, Integer> seatCategory;   // Category & available seats
    private Map<String, Double> pricing;         // Category & price
    private List<String> bookingHistory;         // Store booking records

    public Theatre() {
        seatCategory = new HashMap<>();
        pricing = new HashMap<>();
        bookingHistory = new ArrayList<>();

        // Seat categories
        seatCategory.put("VIP", 5);
        seatCategory.put("Premium", 10);
        seatCategory.put("Regular", 15);

        // Pricing
        pricing.put("VIP", 500.0);
        pricing.put("Premium", 300.0);
        pricing.put("Regular", 150.0);
    }

    // Synchronized method prevents overbooking
    public synchronized void bookTicket(String userName, String category, int seats) {

        if (!seatCategory.containsKey(category)) {
            System.out.println("Invalid category selected by " + userName);
            return;
        }

        int availableSeats = seatCategory.get(category);

        if (seats <= availableSeats) {
            seatCategory.put(category, availableSeats - seats);

            double totalPrice = seats * pricing.get(category);

            String record = userName + " booked " + seats + " "
                    + category + " seats. Total: ₹" + totalPrice;

            bookingHistory.add(record);

            System.out.println(record);
        } else {
            System.out.println("Booking failed for " + userName +
                    " (Not enough seats in " + category + ")");
        }
    }

    public void showBookingHistory() {
        System.out.println("\n📜 Booking History:");
        for (String record : bookingHistory) {
            System.out.println(record);
        }
    }
}
class User extends Thread {

    private Theatre theatre;
    private String userName;
    private String category;
    private int seats;

    public User(Theatre theatre, String userName, String category, int seats) {
        this.theatre = theatre;
        this.userName = userName;
        this.category = category;
        this.seats = seats;
    }

    @Override
    public void run() {
        theatre.bookTicket(userName, category, seats);
    }
}
public class MovieTicketBookingSystem {

    public static void main(String[] args) {

        Movie movie = new Movie("Pushpa 2", "7:00 PM");
        Theatre theatre = new Theatre();

        System.out.println("🎬 Movie: " + movie.getMovieName());
        System.out.println("🕒 Show Time: " + movie.getShowTime());
        System.out.println("--------------------------------");

        // Multiple users booking simultaneously
        User u1 = new User(theatre, "Anjali", "VIP", 2);
        User u2 = new User(theatre, "Rahul", "Premium", 5);
        User u3 = new User(theatre, "Kiran", "VIP", 4);
        User u4 = new User(theatre, "Sneha", "Regular", 6);

        u1.start();
        u2.start();
        u3.start();
        u4.start();

        // Wait for all threads to complete
        try {
            u1.join();
            u2.join();
            u3.join();
            u4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        theatre.showBookingHistory();
    }
}



