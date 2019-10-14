package com.mitura.springboot.restapp.rest;

import com.mitura.springboot.restapp.entity.Room;
import com.mitura.springboot.restapp.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoomRestController {
    private @Value("${custom.password}")
    String pass;
    private RoomService roomService;

    @Autowired
    public RoomRestController(RoomService roomService){
        this.roomService = roomService;
    }

    @GetMapping("/rooms")
    public List<Room> findAll(){
        return roomService.findAll();
    }

    @GetMapping("/rooms/{roomName}")
    public Room findByName(@PathVariable String roomName){
        Room room = roomService.findByName(roomName);
        if (room == null){
            throw new RuntimeException("Room with name: "+ roomName+" wasn't found");
        }
        return room;
    }

    @PostMapping("/rooms/{password}")
    public Room addRoom(@RequestBody Room room, @PathVariable String password){


        if (password.equals(pass)) {
            room.setId(0);
            roomService.save(room);
            return room;
        }

        throw new RuntimeException("unauthorised access");
    }

    @PutMapping("/rooms/{password}")
    public Room updateRoom(@RequestBody Room room,@PathVariable String password){
        if (password.equals(pass)) {
            roomService.save(room);
            return room;
        }
        throw new RuntimeException("unauthorised access");
    }

    @DeleteMapping("/rooms/{roomName}/{password}")
    public String deleteUser(@PathVariable String roomName, @PathVariable String password){
        Room room = roomService.findByName(roomName);

        if (room==null){
            throw new RuntimeException("Room with name: "+roomName+" not found");
        }
        if (password.equals(pass)) {
            roomService.deleteByName(roomName);
            return "Deleted room - " + roomName;
        }
        throw new RuntimeException("unauthorised access");
    }

}
