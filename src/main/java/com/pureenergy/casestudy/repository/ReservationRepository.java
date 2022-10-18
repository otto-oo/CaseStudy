package com.pureenergy.casestudy.repository;

import com.pureenergy.casestudy.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findByMovieId(Long movieId);

}
