package com.pluralsight;

public class Book {
    // Variables
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;

    // Constructor
    public Book(int id, String isbn, String title) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = false; // right now default
        this.checkedOutTo = "";    // right now default
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    // checkOut method
    public void checkOut(String userName) {
        if (!isCheckedOut) {
            this.isCheckedOut = true;
            this.checkedOutTo = userName;
            System.out.println(title + " checked out to " + userName);
        } else {
            System.out.println(title + " is already checked out.");
        }
    }

    // checkIn method
    public void checkIn() {
        if (isCheckedOut) {
            this.isCheckedOut = false;
            this.checkedOutTo = "";
            System.out.println(title + " has been checked in.");
        } else {
            System.out.println(title + " is not checked out.");
        }
    }
}
