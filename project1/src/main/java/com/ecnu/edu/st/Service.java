package com.ecnu.edu.st;

import com.ecnu.edu.st.utils.CollectionsUtil;
import lombok.Data;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class Service {
    private LocalDateTime phoneTime;
    //酒店与utc时间差
    private double jetLag;

    public Service(LocalDateTime phoneTime,double jetLag){
        this.phoneTime=phoneTime;
        this.jetLag=jetLag;
    }

    public void setClockTime(List<Clock> clocks){

        for (Clock clock:clocks){
            long minutes=(long)(jetLag-clock.getJetLag())*60;
            clock.setTime(phoneTime.minusMinutes(minutes));
        }
    }
}
