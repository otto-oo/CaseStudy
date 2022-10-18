package com.pureenergy.casestudy.dto;

import com.pureenergy.casestudy.enums.Operation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class LogDTO {

    private LocalDate logDate;
    private Operation operation;
    private String message;

}
