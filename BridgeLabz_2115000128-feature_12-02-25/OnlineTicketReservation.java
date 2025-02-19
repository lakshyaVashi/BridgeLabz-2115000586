class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    int seatNumber;
    String bookingTime;
    Ticket next;

    public Ticket(int ticketId, String customerName, String movieName, int seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketReservationSystem {
    private Ticket last;
    private int ticketCount;

    public TicketReservationSystem() {
        this.last = null;
        this.ticketCount = 0;
    }

    public void addTicket(int ticketId, String customerName, String movieName, int seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (last == null) {
            last = newTicket;
            last.next = last;
        } else {
            newTicket.next = last.next;
            last.next = newTicket;
            last = newTicket;
        }
        ticketCount++;
    }

    public void removeTicket(int ticketId) {
        if (last == null) return;
        Ticket current = last.next, prev = last;
        do {
            if (current.ticketId == ticketId) {
                if (current == last && current.next == last) {
                    last = null;
                } else {
                    prev.next = current.next;
                    if (current == last) {
                        last = prev;
                    }
                }
                ticketCount--;
                return;
            }
            prev = current;
            current = current.next;
        } while (current != last.next);
    }

    public void displayTickets() {
        if (last == null) return;
        Ticket current = last.next;
        do {
            System.out.println("Ticket ID: " + current.ticketId + ", Customer: " + current.customerName + ", Movie: " + current.movieName + ", Seat: " + current.seatNumber + ", Time: " + current.bookingTime);
            current = current.next;
        } while (current != last.next);
    }

    public Ticket searchTicket(String query) {
        if (last == null) return null;
        Ticket current = last.next;
        do {
            if (current.customerName.equalsIgnoreCase(query) || current.movieName.equalsIgnoreCase(query)) {
                return current;
            }
            current = current.next;
        } while (current != last.next);
        return null;
    }

    public int getTotalTickets() {
        return ticketCount;
    }
}

public class OnlineTicketReservation {
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();
        system.addTicket(1, "Alice", "Inception", 10, "12:00 PM");
        system.addTicket(2, "Bob", "Interstellar", 15, "2:00 PM");
        system.displayTickets();
        system.removeTicket(1);
        system.displayTickets();
        System.out.println("Total Tickets: " + system.getTotalTickets());
    }
}
