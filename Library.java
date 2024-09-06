package Library_Final_Project;

import java.util.ArrayList;
import java.util.List;

public class Library {
            private List<Shelf> shelves;
        private List<Reader> readers;

        public Library() {
            shelves = new ArrayList<>();
            readers = new ArrayList<>();
            // Initialize 3 shelves
            for (int i = 0; i < 3; i++) {
                shelves.add(new Shelf());
            }
        }

        public boolean isTherePlaceForNewBook() {
            for (Shelf shelf : shelves) {
                if (!shelf.isShelfFull()) {
                    return true;
                }
            }
            return false;
        }

        public void addNewBook(Book book) {
            for (Shelf shelf : shelves) {
                if (!shelf.isShelfFull()) {
                    shelf.addBook(book);
                    return;
                }
            }
            System.out.println("אין מקום בספרייה לספר נוסף.");
        }

        public void deleteBook(String title) {
            for (Shelf shelf : shelves) {
                for (Book book : shelf.getBooks()) {
                    if (book.getTitle().equalsIgnoreCase(title)) {
                        shelf.getBooks().remove(book);
                        System.out.println("הספר בשם '" + title + "' הוסר מרשומות הספריה.");
                        return;
                    }
                }
            }
            System.out.println("הספר בשם '" + title + "' לא נמצא בספריה.");
        }

        public void registerReader(int id, String name) {
            readers.add(new Reader(id, name));
            System.out.println("הקורא '" + name + "' נרשם בהצלחה.");
        }

        public void removeReader(String name) {
            for (Reader reader : readers) {
                if (reader.getName().equalsIgnoreCase(name)) {
                    readers.remove(reader);
                    System.out.println("הקורא '" + name + "' הוסר בהצלחה.");
                    return;
                }
            }
            System.out.println("הקורא '" + name + "' לא נמצא ברשימות הספריה.");
        }

        public List<String> searchByAuthor(String author) {
            List<String> bookTitles = new ArrayList<>();
            for (Shelf shelf : shelves) {
                for (Book book : shelf.getBooks()) {
                    if (book.getAuthor().equalsIgnoreCase(author)) {
                        bookTitles.add(book.getTitle());
                    }
                }
            }
            return bookTitles;
        }

        public void displayAllBooks() {
            System.out.println("אלו כל הספרים בספריה:");
            for (Shelf shelf : shelves) {
                for (Book book : shelf.getBooks()) {
                    System.out.println(book);
                }
            }
        }

        public void displayAllReaders() {
            System.out.println("רשימת הקוראים הרשומים בספריה:");
            for (Reader reader : readers) {
                System.out.println("מספר זיהוי: " + reader.getId() + ", שם קורא: " + reader.getName());
            }
        }
    }
