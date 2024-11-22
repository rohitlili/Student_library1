import java.util.*;
public class Student {
private String name;
private int id;
private List<Book> borrowedBooks;
public Student(String name, int id) {
this.name = name;
this.id = id;
this.borrowedBooks = new ArrayList<>();
}
public String getName() {
return name;
}
public int getId() {
return id;
}
public List<Book> getBorrowedBooks() {
return borrowedBooks;
}
public boolean borrowBook(Book book) {
if (borrowedBooks.size() < 5) {
borrowedBooks.add(book);
return true;
}
return false;
}
public boolean returnBook(String title) {
for (Book book : borrowedBooks) {
if (book.getTitle().equalsIgnoreCase(title)) {
borrowedBooks.remove(book);
return true;
}
}
return false;
}
public void displayBorrowedBooks() {
System.out.println("Borrowed Books for " + name + ":");
if (borrowedBooks.isEmpty()) {
System.out.println("No books borrowed.");
} else {
for (Book book : borrowedBooks) {
book.displayDetails();
}
}
}
}
