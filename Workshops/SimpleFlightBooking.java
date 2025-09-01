package workshops;

import java.util.*;

public class SimpleFlightBooking {
    static String[] flights = {
        "AI101 Delhi to Mumbai",
        "AI102 Delhi to Chennai",
        "AI103 Mumbai to Delhi",
        "AI104 Chennai to Delhi"
    };

    static List<String> bookings = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Search Flights");
            System.out.println("2. Book Flight");
            System.out.println("3. View Bookings");
            System.out.println("4. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt(); sc.nextLine();

            if (choice == 1) {
                System.out.print("From: ");
                String from = sc.nextLine();
                System.out.print("To: ");
                String to = sc.nextLine();
                searchFlights(from, to);
            } else if (choice == 2) {
                System.out.print("Enter Flight Number: ");
                String flight = sc.nextLine();
                System.out.print("Enter Your Name: ");
                String name = sc.nextLine();
                bookings.add(name + " booked " + flight);
                System.out.println("Flight booked successfully!");
            } else if (choice == 3) {
                if (bookings.isEmpty()) {
                    System.out.println("No bookings yet.");
                } else {
                    for (String booking : bookings) {
                        System.out.println(booking);
                    }
                }
            } else if (choice == 4) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }

    static void searchFlights(String from, String to) {
        boolean found = false;
        for (String flight : flights) {
            if (flight.toLowerCase().contains(from.toLowerCase()) &&
                flight.toLowerCase().contains(to.toLowerCase())) {
                System.out.println(flight);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No flights found.");
        }
    }
}

