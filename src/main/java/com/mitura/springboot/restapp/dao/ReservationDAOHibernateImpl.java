package com.mitura.springboot.restapp.dao;

import com.mitura.springboot.restapp.entity.Reservation;
import com.mitura.springboot.restapp.entity.Room;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class ReservationDAOHibernateImpl implements  ReservationDAO{

    private EntityManager entityManager;

    @Autowired
    public ReservationDAOHibernateImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Reservation> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Reservation> query = currentSession.createQuery("from Reservation", Reservation.class);
        List<Reservation> reservations = query.getResultList();
        return reservations;
    }

    @Override
    public List<Reservation> findAll(LocalDateTime starts_time) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("from Reservation WHERE :starts_time BETWEEN starts AND ends");
        query.setParameter("starts_time",starts_time);
        return query.getResultList();
    }

    @Override
    public List<Reservation> findAll(LocalDateTime starts_time, LocalDateTime ends_time) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("from Reservation WHERE starts BETWEEN :starts_time AND :ends_time AND ends BETWEEN :starts_time AND :ends_time");
        query.setParameter("starts_time",starts_time);
        query.setParameter("ends_time",ends_time);
        return query.getResultList();
    }

    @Override
    public Reservation findByRoom(String name) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query query = currentSession.createQuery("from Reservation WHERE :name = room_name");
        query.setParameter("name",name);
        if (query.getResultList().isEmpty()){
            throw new RuntimeException("No room booked with name: "+name);
        }
        return (Reservation)query.getResultList().get(0);
    }

    @Override
    public Reservation findByRoom(String name, LocalDateTime starts_time) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query query = currentSession.createQuery("from Reservation WHERE :starts_time BETWEEN starts AND ends AND :name = room_name");
        query.setParameter("starts_time",starts_time);
        query.setParameter("name",name);
        if (query.getResultList().isEmpty()){
            throw new RuntimeException("No room booked with name: "+name);
        }
        return (Reservation)query.getResultList().get(0);

    }

    @Override
    public Reservation findByRoom(String name, LocalDateTime starts_time, LocalDateTime ends_time) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query query = currentSession.createQuery("from Reservation WHERE :starts_time AND :ends_time AND ends BETWEEN :starts_time AND :ends_time AND :name = room_name");
        query.setParameter("starts_time",starts_time);
        query.setParameter("ends_time",ends_time);
        query.setParameter("name",name);
        if (query.getResultList().isEmpty()){
            throw new RuntimeException("No room booked with name: "+name);
        }
        return (Reservation)query.getResultList().get(0);
    }

    @Override
    public Reservation findByUser(String login) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query query = currentSession.createQuery("from Reservation WHERE :login = user_login");
        query.setParameter("login",login);
        if (query.getResultList().isEmpty()){
            throw new RuntimeException("No room booked with name: "+login);
        }
        return (Reservation)query.getResultList().get(0);
    }

    @Override
    public Reservation findByUser(String login, LocalDateTime starts_time) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query query = currentSession.createQuery("from Reservation WHERE :starts_time BETWEEN starts AND ends AND :login = user_login");
        query.setParameter("starts_time",starts_time);
        query.setParameter("login",login);
        if (query.getResultList().isEmpty()){
            throw new RuntimeException("No room booked with name: "+login);
        }
        return (Reservation)query.getResultList().get(0);
    }

    @Override
    public Reservation findByUser(String login, LocalDateTime starts_time, LocalDateTime ends_time) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query query = currentSession.createQuery("from Reservation WHERE starts BETWEEN :starts_time AND :ends_time AND ends BETWEEN :starts_time AND :ends_time AND :login = user_login");
        query.setParameter("starts_time",starts_time);
        query.setParameter("login",login);
        if (query.getResultList().isEmpty()){
            throw new RuntimeException("No room booked with name: "+login);
        }
        return (Reservation)query.getResultList().get(0);
    }

    @Override
    public void save(Reservation reservation) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("from Reservation WHERE :starts_time BETWEEN starts AND ends OR :ends_time BETWEEN starts AND ends AND :name = room_name");
        query.setParameter("starts_time",reservation.getStarts());
        query.setParameter("ends_time",reservation.getEnds());
        query.setParameter("name",reservation.getRoom_name());
        if (query.getResultList().isEmpty())
        currentSession.saveOrUpdate(reservation);
        else
            throw new RuntimeException("This room is already booked at this time frame");
    }
}
