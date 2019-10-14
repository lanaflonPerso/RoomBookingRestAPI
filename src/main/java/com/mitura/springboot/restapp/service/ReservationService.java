package com.mitura.springboot.restapp.service;

import com.mitura.springboot.restapp.entity.Reservation;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationService {
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
