package com.pluralsight;

import java.util.Scanner;

public class NeighborhoodLibrary {
    private Book[] books;

    public NeighborhoodLibrary() {
        // Our inventory for 5 books
        books = new Book[5];
        books[0] = new Book(1, "978-0134685912", "Effective Brain");
        books[1] = new Book(2, "978-0596009253", "Thinking, Fast and Slow");
        books[2] = new Book(3, "978-1491950345", "Predictably Irrational");
        books[3] = new Book(4, "978-0134494184", "The Power of Habit");
        books[4] = new Book(5, "978-0134694723", "Emotional Intelligence");
    }

    public void showAvailableBooks() {
        System.out.println("Available books:");
        // for-each to see the list
        for (Book book : books) {
            if (!book.isCheckedOut()) {
                System.out.println("ID: " + book.getId() + ", Title: " + book.getTitle() + ", ISBN: " + book.getIsbn());
            }
        }
    }

    public void showCheckedOutBooks() {
        System.out.println("Checked out books:");
        for (Book book : books) {
            if (book.isCheckedOut()) {
                System.out.println("ID: " + book.getId() + ", Title: " + book.getTitle() + ", Checked out to: " + book.getCheckedOutTo());
            }
        }
    }

    public void checkOutBook(int bookId, String userName) {
        for (Book book : books) {
            if (book.getId() == bookId) {
                book.checkOut(userName);
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void checkInBook(int bookId) {
        for (Book book : books) {
            if (book.getId() == bookId) {
                book.checkIn();
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public static void main(String[] args) {
        NeighborhoodLibrary library = new NeighborhoodLibrary();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Welcome to the Neighborhood Library!");
            System.out.println("1. Show Available Books");
            System.out.println("2. Show Checked Out Books");
            System.out.println("3. Check Out a Book");
            System.out.println("4. Check In a Book");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // New line to consume enter

            // Switch for multi optional choices
            switch (choice) {
                case 1:
                    library.showAvailableBooks();
                    break;
                case 2:
                    library.showCheckedOutBooks();
                    break;
                case 3:
                    System.out.print("Enter the book ID to check out: ");
                    int checkOutId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter your name: ");
                    String userName = scanner.nextLine();
                    library.checkOutBook(checkOutId, userName);
                    break;
                case 4:
                    System.out.print("Enter the book ID to check in: ");
                    int checkInId = scanner.nextInt();
                    library.checkInBook(checkInId);
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting the library system.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}