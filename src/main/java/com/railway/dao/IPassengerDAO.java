package com.railway.dao;

import com.railway.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface IPassengerDAO extends JpaRepository<Passenger, Long>
{
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM passenger WHERE ticket_id = :ticketId", nativeQuery = true)
    public void deletePassengersByTicketId(Long ticketId);
}
