package ua.nure.nikonova.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="books")
public class Book implements Serializable{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "author")
    private String author;
    @Column(name = "price")
    private Double price;



    public Book() {

    }

    public Book(String name, String author, Double price) {
        this.name=name;
        this.author=author;
        this.price=price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Book " + name + " by " + author;
    }


}