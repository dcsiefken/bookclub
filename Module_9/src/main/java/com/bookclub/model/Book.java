package com.bookclub.model;

public class Book {
    private String isbn;
    private String title;
    private String description;
    private String infoUrl;
    private int numOfPages;

    public Book() {
    }

    public Book(String isbn, String title, String description, String infoUrl, int numOfPages) {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.infoUrl = infoUrl;
        this.numOfPages = numOfPages;
    }

    @Override
    public String toString() {
        return String.format("Book{isbn=%s, title=%s, description=%s, infoUrl=%s, numOfPages=%d}",
                isbn, title, description, infoUrl, numOfPages);
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

    /**
     * @return String return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return int return the numOfPages
     */
    public int getNumOfPages() {
        return numOfPages;
    }

    /**
     * @param numOfPages the numOfPages to set
     */
    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }

    /**
     * @return String return the infoUrl
     */
    public String getInfoUrl() {
        return infoUrl;
    }

    /**
     * @param infoUrl the infoUrl to set
     */
    public void setInfoUrl(String infoUrl) {
        this.infoUrl = infoUrl;
    }

}
