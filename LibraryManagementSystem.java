import java.util.*;
public class LibraryManagementSystem{
public static void main(String[] args) {
Library library = new Library();
Scanner scanner = new Scanner(System.in);
library.addBook(new Book("Java Programming", "James Gosling"));
library.addBook(new Book("Effective Java", "Joshua Bloch"));
library.addBook(new Book("Clean Code", "Robert Martin"));
library.addStudent(new Student("Alice", 1));
library.addStudent(new Student("Bob", 2));
while (true) {
System.out.println("\nLibrary Management System");
System.out.println("1. Display Books");
System.out.println("2. Display Students");
System.out.println("3. Add Book");
System.out.println("4. Add Student");
System.out.println("5. Borrow Book");
System.out.println("6. Return Book");
System.out.println("7. Exit");
System.out.print("Choose an option: ");
int choice = scanner.nextInt();
scanner.nextLine();
switch (choice) {
case 1:
library.displayBooks();
break;
case 2:
library.displayStudents();
break;
case 3:
System.out.print("Enter book title: ");
String title = scanner.nextLine();
System.out.print("Enter book author: ");
String author = scanner.nextLine();
library.addBook(new Book(title, author));
break;
case 4:
System.out.print("Enter student name: ");
String name = scanner.nextLine();
System.out.print("Enter student ID: ");
int id = scanner.nextInt();
library.addStudent(new Student(name, id));
break;
case 5:
System.out.print("Enter student ID: ");
int borrowId = scanner.nextInt();
scanner.nextLine();
System.out.print("Enter book title to borrow: ");
String borrowTitle = scanner.nextLine();
library.borrowBook(borrowId, borrowTitle);
break;
case 6:
System.out.print("Enter student ID: ");
int returnId = scanner.nextInt();
scanner.nextLine(); 
System.out.print("Enter book title to return: ");
String returnTitle = scanner.nextLine();
library.returnBook(returnId, returnTitle);
break;
case 7:
System.out.println("Exiting the system. Goodbye!");
scanner.close();
System.exit(0);
default:
System.out.println("Invalid choice. Please try again.");
}
}
}
}
