package com.mitura.springboot.restapp.dao;

import com.mitura.springboot.restapp.entity.Room;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class RoomDAOHibernateImpl implements RoomDAO {


    private EntityManager entityManager;

    @Autowired
    public RoomDAOHibernateImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Room> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Room> query = currentSession.createQuery("from Room", Room.class);
        List<Room> rooms = query.getResultList();
        return rooms;
    }

    @Override
    public Room findByName(String name) {
        Session currentSession = entityManager.unwrap(Session.class);

        Room room = currentSession.byNaturalId(Room.class)
                .using("name", name)
                .load();
        return room;
    }

    @Override
    public void save(Room room) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(room);
    }

    @Override
    public void deleteByName(String userName) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("delete from Room where name =: userName");
        query.setParameter("userName",userName);
        query.executeUpdate();
    }

}
