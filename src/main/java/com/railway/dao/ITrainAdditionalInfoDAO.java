package com.railway.dao;

import com.railway.entity.TrainAdditionalInfo;
import com.railway.entity.TrainAdditionalInfoCompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

public interface ITrainAdditionalInfoDAO extends JpaRepository<TrainAdditionalInfo, TrainAdditionalInfoCompositeKey>
{
    @Modifying
    @Transactional
    @Query(value = "UPDATE TrainAdditionalInfo t SET t.availableSeats = t.availableSeats - :noOfPassengers " +
            "WHERE t.trainAdditionalInfoCompositeKey.trainNo =:trainNo AND " +
            "t.trainAdditionalInfoCompositeKey.dateOfJourney =:dateOfJourney")
    void updateAvailableSeats(int noOfPassengers, Long trainNo, LocalDate dateOfJourney);
}
