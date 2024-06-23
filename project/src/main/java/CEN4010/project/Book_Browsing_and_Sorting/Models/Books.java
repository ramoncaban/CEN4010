package CEN4010.project.Book_Browsing_and_Sorting.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String title;
    private String author;
    private String genre;
    private double rating;
    private double price;
    private long ISBN;
    private String Description;
    private int soldcopies;
    private String Publisher;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getISBN() {
        return ISBN;
    }

    public void setISBN(long iSBN) {
        this.ISBN = iSBN;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public int getSoldcopies() {
        return soldcopies;
    }

    public void setSoldcopies(int soldcopies) {
        this.soldcopies = soldcopies;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        this.Publisher = publisher;
    }


    


}
