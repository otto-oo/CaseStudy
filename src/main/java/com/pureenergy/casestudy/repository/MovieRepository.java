package com.pureenergy.casestudy.repository;

import com.pureenergy.casestudy.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
