package com.backSpringBatch.postgres.models.Response;

import com.backRRHH.Util.ScheduleObject;

import java.util.List;

public class ResponseSchedulePagination {

    private List<ScheduleObject> Schedule;
    private String message;
    private int totalRegister;

    public List<ScheduleObject> getSchedule() {
        return Schedule;
    }

    public void setSchedule(List<ScheduleObject> schedule) {
        Schedule = schedule;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getTotalRegister() {
        return totalRegister;
    }

    public void setTotalRegister(int totalRegister) {
        this.totalRegister = totalRegister;
    }
}
