package com.bookclub.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class WishlistItem {
    @NotNull
    @NotEmpty(message = "ISBN is a required field")
    private String isbn;

    @NotNull
    @NotEmpty(message = "title is a required field")
    private String title;

    public WishlistItem() {
    }

    public WishlistItem(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
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

    /**
     * @return String return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "WishlistItem{isbn=" + isbn + ", title=" + title + "}";
    }

}
