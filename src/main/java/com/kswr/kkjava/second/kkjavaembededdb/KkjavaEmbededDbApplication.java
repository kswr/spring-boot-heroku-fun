package com.kswr.kkjava.second.kkjavaembededdb;

import com.kswr.kkjava.second.kkjavaembededdb.model.Ticket;
import com.kswr.kkjava.second.kkjavaembededdb.service.TicketBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.sql.DataSource;
import java.util.Date;

@SpringBootApplication
public class KkjavaEmbededDbApplication implements CommandLineRunner {

    @Autowired
    private TicketBookingService ticketBookingService;

    @Autowired
    private DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(KkjavaEmbededDbApplication.class, args);
//        ConfigurableApplicationContext applicationContext = SpringApplication.run(KkjavaEmbededDbApplication.class, args);
//        TicketBookingService ticketBookingService = applicationContext.getBean("ticketBookingService", TicketBookingService.class);
    }

    @Override
    public void run(String... args) throws Exception {
        Ticket ticket = new Ticket();
        ticket.setBookingDate(new Date());
        ticket.setDestStation("Silicon Valley");
        ticket.setSourceStation("Warsaw");
        ticket.setEmail("jon.doe@gmail.com");
        ticket.setPassengerName("Jon Doe");

        ticketBookingService.createTicket(ticket);

        System.out.println("Data source: " + dataSource.getConnection());
    }
}
