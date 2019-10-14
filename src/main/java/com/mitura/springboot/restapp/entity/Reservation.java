package com.mitura.springboot.restapp.entity;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name="reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private int id;

    @Column(name = "starts")
    private LocalDateTime starts;

    @Column(name = "ends")
    private LocalDateTime ends;

    @NotNull
    @NaturalId
    @Column(name = "user_login")
    private String user_login;

    @NotNull
    @NaturalId
    @Column(name = "room_name")
    private String room_name;

    public Reservation() {
    }

    public Reservation(LocalDateTime starts, LocalDateTime ends, String user_login, String room_name) {
        this.starts = starts;
        this.ends = ends;
        this.user_login = user_login;
        this.room_name = room_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getStarts() {
        return starts;
    }

    public void setStarts(LocalDateTime starts) {
        this.starts = starts;
    }

    public LocalDateTime getEnds() {
        return ends;
    }

    public void setEnds(LocalDateTime ends) {
        this.ends = ends;
    }

    public String getUser_login() {
        return user_login;
    }

    public void setUser_login(String user_login) {
        this.user_login = user_login;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    @Override
    public String toString() {
        return "reservation{" +
                "id=" + id +
                ", starts=" + starts +
                ", ends=" + ends +
                ", user_login='" + user_login + '\'' +
                ", room_name='" + room_name + '\'' +
                '}';
    }
}
