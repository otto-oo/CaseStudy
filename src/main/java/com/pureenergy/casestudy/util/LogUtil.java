package com.pureenergy.casestudy.util;

import com.pureenergy.casestudy.entity.Log;
import com.pureenergy.casestudy.enums.Operation;
import com.pureenergy.casestudy.repository.LogRepository;
import org.springframework.stereotype.Component;

@Component
public class LogUtil {

    private LogRepository logRepository;

    public LogUtil(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public void createLog(Operation operation, String message){
        Log log = new Log(operation, message);
        logRepository.save(log);
    }
}
