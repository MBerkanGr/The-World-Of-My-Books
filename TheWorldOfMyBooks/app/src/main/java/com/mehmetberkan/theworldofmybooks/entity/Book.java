package com.mehmetberkan.theworldofmybooks.entity;

public class Book {
    private int id;
    private String name;
    private String author;
    private int numberofsize;
    private String category;
    private boolean owned;
    private boolean read;

    public Book(int id, String name, String author, int numberofsize, String category, boolean owned, boolean read) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.numberofsize = numberofsize;
        this.category = category;
        this.owned = owned;
        this.read = read;
    }

    public Book(String name, String author, int numberofsize, String category, boolean owned, boolean read) {
        this.name = name;
        this.author = author;
        this.numberofsize = numberofsize;
        this.category = category;
        this.owned = owned;
        this.read = read;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumberofsize() {
        return numberofsize;
    }

    public void setNumberofsize(int numberofsize) {
        this.numberofsize = numberofsize;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isOwned() {
        return owned;
    }

    public void setOwned(boolean owned) {
        this.owned = owned;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }
}
