package com.mitura.springboot.restapp.service;

import com.mitura.springboot.restapp.entity.Room;

import java.util.List;

public interface RoomService {
    public List<Room> findAll();
    public Room findByName(String name);
    public void save(Room room);
    public void deleteByName(String name);
}
