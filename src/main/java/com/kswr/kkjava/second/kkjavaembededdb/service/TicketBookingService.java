package com.kswr.kkjava.second.kkjavaembededdb.service;

import com.kswr.kkjava.second.kkjavaembededdb.dao.TicketBookingDao;
import com.kswr.kkjava.second.kkjavaembededdb.exception.ResourceNotFoundException;
import com.kswr.kkjava.second.kkjavaembededdb.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketBookingService {

    @Autowired
    TicketBookingDao ticketBookingDao;

    public Ticket createTicket(Ticket ticket) {
        return ticketBookingDao.save(ticket);
    }

    public Ticket getTicketById(Integer id) {
        return ticketBookingDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ticket " + id + " not found"));
    }

    public Iterable<Ticket> getAllTickets() {
        return ticketBookingDao.findAll();
    }

    public void deleteTicketById(Integer id) {
        ticketBookingDao.deleteById(id);
    }

    public Ticket updateTicket(Integer id, String newEmail) {
        Ticket originalTicket = ticketBookingDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ticket " + id + " not found"));
        originalTicket.setEmail(newEmail);
        return ticketBookingDao.save(originalTicket);
    }
}
