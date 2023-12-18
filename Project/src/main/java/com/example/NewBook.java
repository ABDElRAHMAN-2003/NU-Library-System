package com.example;

public class NewBook {
    private String title;
    private String description;
    private String coverImageUrl;
    private String duedate;
    private int remainingBooks;

    // Constructor to set initial values for book properties
    public NewBook(String title, String description, String coverImageUrl, int remainingBooks,String duedate) {
        this.title = title;
        this.description = description;
        this.coverImageUrl = coverImageUrl;
        this.remainingBooks = remainingBooks;
        this.duedate=duedate;

    }

    // Getter for the title
    public String getTitle() {
        return title;
    }

    // Getter for the description
    public String getDescription() {
        return description;
    }

    // Getter for the cover image URL
    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    // Getter for the number of remaining books
    public int getRemainingBooks() {
        return remainingBooks;
    }

    public String getduedate(){
        return duedate;

    }

    // Setter for the number of remaining books
    public void setRemainingBooks(int remainingBooks) {
        this.remainingBooks = remainingBooks;
    }

    // Method to borrow a book, decrementing the remaining number
    public boolean borrowBook() {
        if (remainingBooks > 0) {
            remainingBooks--;
            return true; // Successfully borrowed
        }
        return false; // No more books left to borrow
    }
    
    // (Optional) Method to return a book, incrementing the remaining number
    public void returnBook() {
        remainingBooks++;
    }

    // (Optional) ToString method for displaying book information
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", coverImageUrl='" + coverImageUrl + '\'' +
                ", remainingBooks=" + remainingBooks +
                '}';
    }
}
