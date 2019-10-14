package com.mitura.springboot.restapp.rest;

import com.mitura.springboot.restapp.entity.Reservation;
import com.mitura.springboot.restapp.entity.Room;
import com.mitura.springboot.restapp.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ReservationRestController {
    private ReservationService reservationService;

    @Autowired
    public ReservationRestController(ReservationService reservationService){
        this.reservationService = reservationService;
    }

    @GetMapping("/reservations")
    public List<Reservation> findAll(){
        return reservationService.findAll();
    }

    @GetMapping("/reservations/{starts}")
    public List<Reservation> findAll(@PathVariable("starts")  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime starts){
        return reservationService.findAll(starts);
    }

    @GetMapping("/reservations/{starts}/{ends}")
    public List<Reservation> findAll(@PathVariable("starts")  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime starts,
                                     @PathVariable("ends")  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime ends){
        return reservationService.findAll(starts,ends);
    }

    @GetMapping("/reservations/rooms/{name}")
    public Reservation findByRoom(@PathVariable String name) {
        return reservationService.findByRoom(name);
    }

    @GetMapping("/reservations/rooms/{name}/{starts}")
    public Reservation findByRoom(@PathVariable String name,
                                  @PathVariable("starts")  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime starts) {
        return reservationService.findByRoom(name,starts);
    }

    @GetMapping("/reservations/rooms/{name}/{starts}/{ends}")
    public Reservation findByRoom(@PathVariable String name,
                                  @PathVariable("starts")  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime starts,
                                  @PathVariable("ends")  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime ends) {
        return reservationService.findByRoom(name,starts,ends);
    }

    @GetMapping("/reservations/users/{login}")
    public Reservation findByUser(@PathVariable String login) {
        return reservationService.findByUser(login);
    }

    @GetMapping("/reservations/users/{login}/{starts}")
    public Reservation findByUser(@PathVariable String login,
                                  @PathVariable("starts")  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime starts) {
        return reservationService.findByUser(login,starts);
    }

    @GetMapping("/reservations/users/{login}/{starts}/{ends}")
    public Reservation findByUser(@PathVariable String login,
                                  @PathVariable("starts")  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime starts,
                                  @PathVariable("ends")  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime ends) {
        return reservationService.findByUser(login,starts,ends);
    }

    @PostMapping("/reservations")
    public Reservation addReservation(@RequestBody Reservation reservation ){
        reservation.setId(0);
        reservationService.save(reservation);
        return reservation;
    }





}
