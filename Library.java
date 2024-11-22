import java.util.*;
public class Library {
private List<Book> books;
private List<Student> students;
public Library() {
this.books = new ArrayList<>();
this.students = new ArrayList<>();
}
public void addBook(Book book) {
books.add(book);
System.out.println("Book added: " + book.getTitle());
}
public void addStudent(Student student) {
students.add(student);
System.out.println("Student added: " + student.getName());
}
public void borrowBook(int studentId, String title) {
Student student = findStudentById(studentId);
if (student == null) {
System.out.println("Student not found.");
return;
}
for(Book book : books) {
if (book.getTitle().equalsIgnoreCase(title) && book.isAvailable()) {
if (student.borrowBook(book)) {
book.setAvailable(false);
System.out.println(student.getName() + " borrowed: " + title);
} else {
System.out.println(student.getName() + " has reached the borrowing limit.");
}
return;
}
}
System.out.println("Book not available or does not exist.");
}
public void returnBook(int studentId, String title) {
Student student = findStudentById(studentId);
if (student == null) {
System.out.println("Student not found.");
return;
}
if (student.returnBook(title)) {
for (Book book : books) {
if (book.getTitle().equalsIgnoreCase(title)) {
book.setAvailable(true);
System.out.println(student.getName() + " returned: " + title);
return;
}
}
} else {
System.out.println("Book not found in " + student.getName() + "'s borrowed list.");
}
}
private Student findStudentById(int studentId) {
for (Student student : students) {
if (student.getId() == studentId) {
return student;
}
}
return null;
}
public void displayBooks() {
System.out.println("\nLibrary Books:");
for (Book book : books) {
book.displayDetails();
}
}
public void displayStudents() {
System.out.println("\nLibrary Students:");
for (Student student : students) {
System.out.println("ID: " + student.getId() + ", Name: " + student.getName());
}
}
}
