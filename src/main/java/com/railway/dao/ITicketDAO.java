package com.railway.dao;

import com.railway.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITicketDAO extends JpaRepository<Ticket, Long>
{
    List<Ticket> getTicketsByUserId(Long userId);

    Ticket getTicketByTicketId(Long ticketId);
}
