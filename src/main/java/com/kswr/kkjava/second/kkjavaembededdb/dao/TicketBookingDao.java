package com.kswr.kkjava.second.kkjavaembededdb.dao;

import com.kswr.kkjava.second.kkjavaembededdb.model.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// dao as Data Access Object
@Repository
public interface TicketBookingDao extends CrudRepository<Ticket, Integer> {
}
