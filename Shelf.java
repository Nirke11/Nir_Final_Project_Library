package Library_Final_Project;

import java.util.ArrayList;
import java.util.List;

public class Shelf {
    private List<Book> books;
    private boolean isShelfFull;

    public Shelf() {
        books = new ArrayList<>(5);
        isShelfFull = false;
    }

    public boolean isShelfFull() {
        return isShelfFull;
    }

    public void addBook(Book book) {
        if (books.size() < 5) {
            books.add(book);
            if (books.size() == 5) {
                isShelfFull = true;
            }
        } else {
            System.out.println("אין יותר מקום על המדף.");
        }
    }

    public void replaceBooks(int pos1, int pos2) {
        if (pos1 < 1 || pos1 > 5 || pos2 < 1 || pos2 > 5) {
            System.out.println("ניתן לבחור בין מקומות 1 ל-5 בלבד.");
            return;
        }
        if (pos1 > books.size() || pos2 > books.size()) {
            System.out.println("המקום פנוי.");
            return;
        }
        Book temp = books.get(pos1 - 1);
        books.set(pos1 - 1, books.get(pos2 - 1));
        books.set(pos2 - 1, temp);
    }

    public List<Book> getBooks() {
        return books;
    }
}
