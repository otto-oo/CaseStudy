package com.pureenergy.casestudy.service.implementation;

import com.pureenergy.casestudy.dto.LogDTO;
import com.pureenergy.casestudy.entity.Log;
import com.pureenergy.casestudy.repository.LogRepository;
import com.pureenergy.casestudy.service.LogService;
import com.pureenergy.casestudy.util.MapperUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LogServiceImplementation implements LogService {

    private LogRepository logRepository;
    private MapperUtil mapperUtil;

    public LogServiceImplementation(LogRepository logRepository, MapperUtil mapperUtil) {
        this.logRepository = logRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<LogDTO> getAllLogsByDate(LocalDate date) {
        List<Log> logList = logRepository.findByLogDate(date);

        return logList
                .stream()
                .map(logDate -> mapperUtil.convert(logDate, new LogDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public List<LogDTO> getAllLogs() {
        return logRepository.findAll()
                .stream()
                .map(log -> mapperUtil.convert(log, new LogDTO()))
                .collect(Collectors.toList());
    }
}
