package com.bookclub.model;

import org.springframework.data.annotation.Id;

import jakarta.validation.constraints.NotEmpty;

public class BookOfTheMonth {
    @Id
    private String id;

    private Integer month;

    @NotEmpty(message = "ISBN is a required field")
    private String isbn;

    /**
     * @return String return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return Integer return the month
     */
    public Integer getMonth() {
        return month;
    }

    /**
     * @param month the month to set
     */
    public void setMonth(Integer month) {
        this.month = month;
    }

    /**
     * @return String return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "BookOfTheMonth{id= " + id + ", isbn=" + isbn + ", month=" + month + "}";
    }
}
