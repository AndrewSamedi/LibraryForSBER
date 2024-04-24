package com.bookStore.bookStore_Component.entity;


import jakarta.persistence.*;

@Entity
@Table(name="book_rep")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String author;
    private String genre;
    private String price;


    public Book(int id, String name,String author, String genre, String price){
        super();
        this.id = id;
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.price = price;
    }
    public Book(){
        super();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre(){return genre;}

    public String getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public void setGenre(String genre){this.genre = genre;}

    public void setPrice(String price) {
        this.price = price;
    }
}
