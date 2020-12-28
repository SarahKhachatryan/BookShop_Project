package Products;

import ProductTypes.Product;

public final class Book extends Product {
    private int year;
    private String author;
    private String language;//the language of book
    private int pages;


    @Override
    public String toString() {
        StringBuilder sb= new StringBuilder();
        sb.append(super.toString()).append("--").append(getAuthor()).append("--").append(getLanguage()).append("--").append(getYear()).append("--").append(getPages());
        return sb.toString();
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String  language) {
        this.language = language;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
