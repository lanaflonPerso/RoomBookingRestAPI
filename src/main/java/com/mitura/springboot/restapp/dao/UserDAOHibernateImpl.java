package com.mitura.springboot.restapp.dao;

import com.mitura.springboot.restapp.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDAOHibernateImpl implements UserDAO {

    private EntityManager entityManager;

    @Autowired
    public UserDAOHibernateImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<User> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<User> query = currentSession.createQuery("from User", User.class);

        List<User> users = query.getResultList();
        return users;
    }

    @Override
    public User findByLogin(String login) {
        Session currentSession = entityManager.unwrap(Session.class);

        User user = currentSession.byNaturalId(User.class)
                .using("login",login)
                .load();
        return user;
    }

    @Override
    public void save(User user) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(user);

    }

    @Override
    public void deleteByLogin(String userLogin) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("delete from User where login =: userLogin");
        query.setParameter("userLogin",userLogin);
        query.executeUpdate();
    }
}
