package com.mitura.springboot.restapp.entity;


import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="room")
public class Room {

    //user fields
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column(name = "name", unique = true)
    @NotNull
    @NaturalId
    @Size(max = 50 , message = "Invalid Name")
    private String name;

    @Column(name = "location")
    @Size(max = 256 , message = "Invalid location")
    private String location;

    @Column(name = "seats")
    @Max(100)
    private int seats;

    @Column(name = "projector",columnDefinition = "boolean default false")
    private boolean projector;

    @Column(name = "phone")
    @Size(max = 100 , message = "Invalid phone")
    private String phone;


    public Room() {
    }

    public Room(String name, String location, int seats, boolean projector, String phone) {
        this.name = name;
        this.location = location;
        this.seats = seats;
        this.projector = projector;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public boolean isProjector() {
        return projector;
    }

    public void setProjector(boolean projector) {
        this.projector = projector;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", seats=" + seats +
                ", projector=" + projector +
                ", phone='" + phone + '\'' +
                '}';
    }
}
