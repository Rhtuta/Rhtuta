package com.cfs.BookMyShow.repository;

import com.cfs.BookMyShow.model.Show;
import com.cfs.BookMyShow.model.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TheaterRepository extends JpaRepository<Theater,Long> {
    List<Theater> findByCity(String city);
}