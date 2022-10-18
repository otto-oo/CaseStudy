package com.pureenergy.casestudy.service.implementation;

import com.pureenergy.casestudy.dto.ReservationDTO;
import com.pureenergy.casestudy.entity.Reservation;
import com.pureenergy.casestudy.enums.Operation;
import com.pureenergy.casestudy.enums.Status;
import com.pureenergy.casestudy.exception.NoSuchMovieException;
import com.pureenergy.casestudy.exception.NoSuchReservationException;
import com.pureenergy.casestudy.repository.MovieRepository;
import com.pureenergy.casestudy.repository.ReservationRepository;
import com.pureenergy.casestudy.service.ReservationService;
import com.pureenergy.casestudy.util.LogUtil;
import com.pureenergy.casestudy.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ReservationServiceImplementation implements ReservationService {

    private ReservationRepository reservationRepository;
    private MapperUtil mapperUtil;
    private LogUtil logUtil;
    private MovieRepository movieRepository;

    public ReservationServiceImplementation(ReservationRepository reservationRepository, MapperUtil mapperUtil, LogUtil logUtil, MovieRepository movieRepository) {
        this.reservationRepository = reservationRepository;
        this.mapperUtil = mapperUtil;
        this.logUtil = logUtil;
        this.movieRepository = movieRepository;
    }

    @Override
    public List<ReservationDTO> getReservationsByMovieId(Long movieId) {
        if (!movieRepository.findById(movieId).isPresent()){
            throw new NoSuchMovieException(movieId);
        }
        List<Reservation> reservationList = reservationRepository.findByMovieId(movieId);
        log.info("Reservations that depends on movie id " + movieId + " are retrieved.");
        logUtil.createLog(Operation.READ, "Reservations that depends on movie id " + movieId + " are retrieved.");
        return reservationList
                .stream()
                .map(reservation -> mapperUtil.convert(reservation, new ReservationDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public ReservationDTO createReservation(ReservationDTO reservationDTO) {
        if (!movieRepository.findById(reservationDTO.getMovieId()).isPresent()){
            throw new NoSuchMovieException(reservationDTO.getMovieId());
        }
        log.info("Reservation is created.");
        logUtil.createLog(Operation.CREATE, "Reservation is created.");
        Reservation reservation = mapperUtil.convert(reservationDTO, new Reservation());
        reservationRepository.save(reservation);
        return reservationDTO;
    }

    @Override
    public ReservationDTO deleteReservation(Long id) throws Exception {
        if (!reservationRepository.findById(id).isPresent()){
            throw new NoSuchReservationException(id);
        }
        log.info("Reservation is canceled depends on reservation id " + id + ".");
        logUtil.createLog(Operation.DELETE, "Reservation is canceled depends on reservation id " + id + ".");
        Reservation reservation = reservationRepository.findById(id).get();
        reservation.setReservationStatus(Status.PASSIVE);
        reservationRepository.save(reservation);
        return mapperUtil.convert(reservation, new ReservationDTO());
    }
}
