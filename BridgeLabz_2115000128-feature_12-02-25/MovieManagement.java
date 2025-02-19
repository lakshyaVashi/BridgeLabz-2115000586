class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie next;
    Movie prev;

    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MovieDoublyLinkedList {
    private Movie head;
    private Movie tail;

    public void addAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    public void addAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    public void addAtPosition(String title, String director, int year, double rating, int position) {
        if (position <= 0) {
            addAtBeginning(title, director, year, rating);
            return;
        }
        Movie newMovie = new Movie(title, director, year, rating);
        Movie temp = head;
        for (int i = 1; temp != null && i < position; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            addAtEnd(title, director, year, rating);
            return;
        }
        newMovie.next = temp.next;
        newMovie.prev = temp;
        if (temp.next != null) {
            temp.next.prev = newMovie;
        }
        temp.next = newMovie;
        if (newMovie.next == null) {
            tail = newMovie;
        }
    }

    public void removeByTitle(String title) {
        Movie temp = head;
        while (temp != null && !temp.title.equals(title)) {
            temp = temp.next;
        }
        if (temp == null) return;
        if (temp.prev != null) temp.prev.next = temp.next;
        if (temp.next != null) temp.next.prev = temp.prev;
        if (temp == head) head = temp.next;
        if (temp == tail) tail = temp.prev;
    }

    public void searchByDirectorOrRating(String director, Double rating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.director.equals(director) || temp.rating == rating) {
                System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.year + ", Rating: " + temp.rating);
            }
            temp = temp.next;
        }
    }

    public void updateRating(String title, double newRating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equals(title)) {
                temp.rating = newRating;
                return;
            }
            temp = temp.next;
        }
    }

    public void displayForward() {
        Movie temp = head;
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.year + ", Rating: " + temp.rating);
            temp = temp.next;
        }
    }

    public void displayReverse() {
        Movie temp = tail;
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.year + ", Rating: " + temp.rating);
            temp = temp.prev;
        }
    }
}

public class MovieManagement {
    public static void main(String[] args) {
        MovieDoublyLinkedList list = new MovieDoublyLinkedList();
        list.addAtEnd("Inception", "Christopher Nolan", 2010, 8.8);
        list.addAtBeginning("Interstellar", "Christopher Nolan", 2014, 8.6);
        list.addAtPosition("The Dark Knight", "Christopher Nolan", 2008, 9.0, 1);
        list.displayForward();
        list.updateRating("Inception", 9.0);
        list.displayForward();
        list.removeByTitle("Interstellar");
        list.displayReverse();
    }
}