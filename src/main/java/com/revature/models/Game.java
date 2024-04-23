package com.revature.models;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "games")
@Component
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gameId;

    private String name;
    private String genre;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "companyId")
    private GameCompany company;

    private int year;

    public Game() {
    }

    public Game(int gameId, String name, String genre, GameCompany company, int year) {
        this.gameId = gameId;
        this.name = name;
        this.genre = genre;
        this.company = company;
        this.year = year;
    }

    public int getId() {
        return gameId;
    }
    public void setId(int gameId) {
        this.gameId = gameId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public GameCompany getCompany() {
        return company;
    }
    public void setCompany(GameCompany company) {
        this.company = company;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

}
