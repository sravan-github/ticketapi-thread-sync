package com.example.ticketapi.controller;

import com.example.ticketapi.service.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/{username}")
    public ResponseEntity<String> createTicket(@PathVariable String username) {
        ticketService.createTicket(username);
        return ResponseEntity.ok("Ticket request received for user: " + username);
    }
}
