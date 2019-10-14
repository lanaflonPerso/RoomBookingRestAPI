package com.mitura.springboot.restapp.service;

import com.mitura.springboot.restapp.dao.ReservationDAO;

import com.mitura.springboot.restapp.dao.RoomDAO;
import com.mitura.springboot.restapp.entity.Reservation;
import com.mitura.springboot.restapp.entity.Room;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    private ReservationDAO reservationDAO;

    public ReservationServiceImpl(ReservationDAO reservationDAO){
        this.reservationDAO = reservationDAO;
    }

    @Override
    @Transactional
    public List<Reservation> findAll() {
        return reservationDAO.findAll();
    }

    @Override
    public List<Reservation> findAll(LocalDateTime starts) {
        return reservationDAO.findAll(starts);
    }

    @Override
    public List<Reservation> findAll(LocalDateTime starts, LocalDateTime ends) {
        return reservationDAO.findAll(starts,ends);
    }

    @Override
    @Transactional
    public Reservation findByRoom(String name) {
        return reservationDAO.findByRoom(name);
    }

    @Override
    public Reservation findByRoom(String name, LocalDateTime starts) {
        return reservationDAO.findByRoom(name,starts);
    }

    @Override
    public Reservation findByRoom(String name, LocalDateTime starts, LocalDateTime ends) {
        return reservationDAO.findByRoom(name,starts,ends);
    }

    @Override
    @Transactional
    public Reservation findByUser(String login) {
        return reservationDAO.findByUser(login);
    }

    @Override
    public Reservation findByUser(String login, LocalDateTime starts) {
        return reservationDAO.findByUser(login,starts);
    }

    @Override
    public Reservation findByUser(String login, LocalDateTime starts, LocalDateTime ends) {
        return reservationDAO.findByUser(login,starts,ends);
    }

    @Override
    @Transactional
    public void save(Reservation reservation) {
        reservationDAO.save(reservation);
    }
}
