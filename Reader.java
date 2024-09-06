package Library_Final_Project;

import java.util.ArrayList;
import java.util.List;

public class Reader {
    private int id;
    private String name;
    private List<String> books;

    public Reader(int id, String name) {
        this.id = id;
        this.name = name;
        this.books = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getBooks() {
        return books;
    }

    public void readBook(String title) {
        books.add(title);
    }

    @Override
    public String toString() {
        return "מספר זיהוי: " + id + ", שם הקורא: " + name;
    }
}
