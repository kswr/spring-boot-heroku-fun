package com.kswr.kkjava.second.kkjavaembededdb.controller;

import com.kswr.kkjava.second.kkjavaembededdb.model.Ticket;
import com.kswr.kkjava.second.kkjavaembededdb.service.TicketBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class TicketBookingController {

    @Autowired
    private TicketBookingService ticketBookingService;

    @PostMapping("/ticket")
    public Ticket createTicket(@RequestBody Ticket ticket) {
        return ticketBookingService.createTicket(ticket);
    }

    @GetMapping("/ticket/{id}")
    public Ticket getTicketById(@PathVariable("id") Integer id) {
        return ticketBookingService.getTicketById(id);
    }

    @GetMapping("/ticket")
    public Iterable<Ticket> getAllTickets() {
        return ticketBookingService.getAllTickets();
    }

    @DeleteMapping("/ticket/{id}")
    public void deleteTicketById(@PathVariable("id") Integer id) {
        ticketBookingService.deleteTicketById(id);
    }

    @PutMapping("ticket/{id}/{newEmail:.+}")
    public Ticket updateTicketById(@PathVariable("id") Integer id, @PathVariable("newEmail") String newEmail) {
        return ticketBookingService.updateTicket(id, newEmail);
    }
}
