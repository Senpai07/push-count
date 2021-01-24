package ru.test.project.pushcount.exceptions;

import lombok.Data;

import java.util.Date;

@Data
public class CounterError {
    private int status;
    private String message;
    private Date timestamp;

    public CounterError(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = new Date();
    }
}
