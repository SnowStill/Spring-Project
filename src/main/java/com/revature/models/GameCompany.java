package com.revature.models;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "game_companies")
@Component
public class GameCompany {

    //id is the primary key and will auto increment
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int companyId;

    private String name;

    //the location can be unknown
    private String location;

    public GameCompany() {
    }

    public GameCompany(int companyId, String name, String location) {
        this.companyId = companyId;
        this.name = name;
        this.location = location;
    }

    public GameCompany(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public int getId() {
        return companyId;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public void setId(int companyId) {
        this.companyId = companyId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "GameCompany{" +
                "id=" + companyId +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
