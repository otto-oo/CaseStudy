package com.pureenergy.casestudy.service;

import com.pureenergy.casestudy.dto.ReservationDTO;

import java.util.List;

public interface ReservationService {

    List<ReservationDTO> getReservationsByMovieId(Long movieId);

    ReservationDTO createReservation(ReservationDTO reservationDTO);

    ReservationDTO deleteReservation(Long id) throws Exception;
}
