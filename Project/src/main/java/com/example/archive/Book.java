package com.example.archive;
import java.time.LocalDate;

public class Book {
    private static int nextId = 1;

    private int id;
    private String name;
    private String category;
    private boolean borrowed;
    private int borrowingPeriod;
    private LocalDate borrowingDate;

    public Book(String name, String category) {
        this.id = nextId++;
        this.name = name;
        this.category = category;
        this.borrowed = false;
        this.borrowingPeriod = 0;
        this.borrowingDate = null;
        // done
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public int getBorrowingPeriod() {
        return borrowingPeriod;
    }

    public LocalDate getBorrowingDate() {
        return borrowingDate;
    }

    public LocalDate getReturnDate() {
        return borrowingDate.plusDays(borrowingPeriod);
    }

    public void borrowBook(LocalDate returnDate) {
        borrowed = true;
        borrowingPeriod = (int) LocalDate.now().until(returnDate).getDays();
        borrowingDate = LocalDate.now();
    }

    public void returnBook() {
        borrowed = false;
        borrowingPeriod = 0;
        borrowingDate = null;
    }
}