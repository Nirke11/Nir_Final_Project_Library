package Library_Final_Project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // ספרים מוגדרים מראש כדוגמא
        library.addNewBook(new Book("ג. ר. ר. טולקין", "ההוביט", 10));
        library.addNewBook(new Book("ק. ס. לואיס", "האריה, המכשפה וארון הבגדים", 11));
        library.addNewBook(new Book("ג. ר. ר. טולקין", "שר הטבעות", 12));
        library.addNewBook(new Book("ק. ס. לואיס", "הנסיך כספיאן", 13));
        library.addNewBook(new Book("מ. בולגקוב", "האמן ומרגריטה", 14));
        library.addNewBook(new Book("ו. נבוקוב", "לוליטה", 15));

        // קוראים מוגדרים מראש כדוגמא
        library.registerReader(1, "ניר קדם");
        library.registerReader(2, "ישראל ישראלי");
        library.registerReader(3, "זה מהטלוויזיה");

        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 9) {
            System.out.println("תפריט ראשי:");
            System.out.println("1. להוספת ספר לחץ 1");
            System.out.println("2. למחיקת ספר לחץ 2");
            System.out.println("3. להצגת כל הספרים לחץ 3");
            System.out.println("4. לחיפוש ספר לפי מחבר לחץ 4");
            System.out.println("5. להוספת קורא חדש לחץ 5");
            System.out.println("6. להסרת קורא לחץ 6");
            System.out.println("7. להצגת כל הקוראים לחץ 7");
            System.out.println("9. ליציאה לחץ 9");

            System.out.print("הקש את בחירתך: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // הוספת ספר חדש
                    System.out.print("הכנס את שם מחבר הספר: ");
                    String author = scanner.nextLine();
                    System.out.print("הכנס את שם הספר: ");
                    String title = scanner.nextLine();
                    System.out.print("הכנס את מספר העמודים: ");
                    int numOfPages = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline
                    Book newBook = new Book(author, title, numOfPages);
                    library.addNewBook(newBook);
                    break;

                case 2:
                    // מחקית ספר קיים
                    System.out.print("הכנס את שם הכותר למחיקה: ");
                    String titleToDelete = scanner.nextLine();
                    library.deleteBook(titleToDelete);
                    break;

                case 3:
                    // הצגת כל הספרים
                    library.displayAllBooks();
                    break;

                case 4:
                    // חיפוש לפי שם מחבר
                    System.out.print("הכנס את שם המחבר: ");
                    String authorToSearch = scanner.nextLine();
                    System.out.println("ספרים שנכתבו על ידי " + authorToSearch + ":");
                    for (String bookTitle : library.searchByAuthor(authorToSearch)) {
                        System.out.println(bookTitle);
                    }
                    break;

                case 5:
                    // הוספת קורא לרשימה
                    System.out.print("הכנס מספר זיהוי של הקורא: ");
                    int readerId = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline
                    System.out.print("הכנס את שם הקורא: ");
                    String readerName = scanner.nextLine();
                    library.registerReader(readerId, readerName);
                    break;

                case 6:
                    // הסרת קורא מהרשימה
                    System.out.print("הכנס את שם הקורא להסרה: ");
                    String readerNameToRemove = scanner.nextLine();
                    library.removeReader(readerNameToRemove);
                    break;

                case 7:
                    // הצגת כל הקוראים
                    library.displayAllReaders();
                    break;

                case 9:
                    // יציאה מהתכנית
                    System.out.println("יציאה מהתכנית.");
                    break;

                default:
                    System.out.println("בחירה בלתי אפשרית. בחר מספר מהרשימה.");
            }

            System.out.println();
        }

        scanner.close();
    }
}
