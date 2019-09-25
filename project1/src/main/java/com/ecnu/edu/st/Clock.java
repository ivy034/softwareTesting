package com.ecnu.edu.st;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Clock implements Serializable {
    private String city;
    //与utc时间时间差
    private double jetLag;
    private LocalDateTime time;
}
