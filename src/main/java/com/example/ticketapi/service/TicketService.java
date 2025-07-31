package com.example.ticketapi.service;

import com.example.ticketapi.entity.Ticket;
import com.example.ticketapi.repository.TicketRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class TicketService {

    private final AtomicInteger counter = new AtomicInteger(1000);
    private final Object lock = new Object();
    private final TicketRepository repository;

    public TicketService(TicketRepository repository) {
        this.repository = repository;
    }

    @Async
    public void createTicket(String username) {
        synchronized (lock) {
            int ticketNumber = counter.getAndIncrement();
            Ticket ticket = new Ticket(username, ticketNumber);
            repository.save(ticket);
            System.out.println("Ticket created for " + username + " with ID: " + ticketNumber);
        }
    }
}
