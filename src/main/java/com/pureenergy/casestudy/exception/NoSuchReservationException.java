package com.pureenergy.casestudy.exception;

public class NoSuchReservationException extends RuntimeException{
        public NoSuchReservationException(Long id){
            super("There is no reservation belongs to id " + id);
        }
}
