package io.github.iamraf.moviesrestapi.entities;

import javax.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @SequenceGenerator(name = "movie_sequence", sequenceName = "movie_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_sequence")
    private int id;
    private String title;
    @Column(length = 512)
    private String description;
    private int year;

    public Movie() {
    }

    public Movie(String title, String description, int year) {
        this.title = title;
        this.description = description;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getYear() {
        return year;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setYear(int year) {
        this.year = year;
    }
}