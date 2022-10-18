package com.pureenergy.casestudy.service;

import com.pureenergy.casestudy.dto.LogDTO;

import java.time.LocalDate;
import java.util.List;

public interface LogService {

    List<LogDTO> getAllLogsByDate(LocalDate date);

    List<LogDTO> getAllLogs();
}
