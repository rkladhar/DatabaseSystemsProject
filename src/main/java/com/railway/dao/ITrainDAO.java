package com.railway.dao;

import com.railway.entity.Train;
import com.railway.vo.TrainResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;

public interface ITrainDAO extends JpaRepository<TrainResult, Long>
{

//    @Query(value = "from Train t join TrainAdditionalInfo ta on t.trainNo = ta.trainAdditionalInfoCompositeKey.trainNo " +
//            "where t.arrivalStationId= :arrivalStationId And t.departureStationId=:departureStationId " +
//            "And ta.trainAdditionalInfoCompositeKey.dateOfJourney = :dateOfJourney")
//    List<TrainResult>getTrains(Long departureStationId, Long arrivalStationId, LocalDate dateOfJourney);

    @Query(value = "SELECT t.*, ta.available_seats, ta.date_of_journey, ta.ticket_price from train t join " +
            "trainadditionalinfo ta on t.train_no = ta.train_no where t.arrival_station_id=:arrivalStationId " +
            "And t.departure_station_id=:departureStationId And ta.date_of_journey = :dateOfJourney", nativeQuery = true)
    List<TrainResult>getTrains(Long departureStationId, Long arrivalStationId, LocalDate dateOfJourney);
}
