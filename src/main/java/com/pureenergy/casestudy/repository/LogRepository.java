package com.pureenergy.casestudy.repository;

import com.pureenergy.casestudy.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface LogRepository extends JpaRepository<Log, Long> {

    List<Log> findByLogDate(LocalDate date);

}
