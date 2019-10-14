package com.mitura.springboot.restapp.service;

import com.mitura.springboot.restapp.dao.RoomDAO;
import com.mitura.springboot.restapp.dao.UserDAO;
import com.mitura.springboot.restapp.entity.Room;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private RoomDAO roomDAO;

    public RoomServiceImpl(RoomDAO roomDAO){
        this.roomDAO = roomDAO;
    }


    @Override
    @Transactional
    public List<Room> findAll() {
        return roomDAO.findAll();
    }

    @Override
    @Transactional
    public Room findByName(String name) {
        return roomDAO.findByName(name);
    }

    @Override
    @Transactional
    public void save(Room room) {
        roomDAO.save(room);
    }

    @Override
    @Transactional
    public void deleteByName(String name) {
        roomDAO.deleteByName(name);
    }
}
