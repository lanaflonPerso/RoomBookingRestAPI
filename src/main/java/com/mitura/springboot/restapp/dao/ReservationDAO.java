package com.mitura.springboot.restapp.dao;

import com.mitura.springboot.restapp.entity.Reservation;
import com.mitura.springboot.restapp.entity.Room;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationDAO {
    public List<Reservation> findAll();
    public List<Reservation> findAll(LocalDateTime starts);
    public List<Reservation> findAll(LocalDateTime starts,LocalDateTime ends);
    public Reservation findByRoom(String name);
    public Reservation findByRoom(String name,LocalDateTime starts);
    public Reservation findByRoom(String name,LocalDateTime starts,LocalDateTime ends);
    public Reservation findByUser(String login);
    public Reservation findByUser(String login,LocalDateTime starts);
    public Reservation findByUser(String login,LocalDateTime starts,LocalDateTime ends);
    public void save(Reservation reservation);
}
