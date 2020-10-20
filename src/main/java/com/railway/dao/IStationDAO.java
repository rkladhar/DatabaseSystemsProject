package com.railway.dao;

import com.railway.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IStationDAO extends JpaRepository<Station, Long>
{
    List<Station> findStationsByStationNameStartsWith(String searchText);
}
