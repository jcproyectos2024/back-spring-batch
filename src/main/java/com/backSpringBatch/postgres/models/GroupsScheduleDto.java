package com.backSpringBatch.postgres.models;


import lombok.Data;

import java.io.Serializable;


@Data
public class GroupsScheduleDto implements Serializable {
    private  ScheduleDTO schedule;

    public GroupsScheduleDto() {
    }

    public ScheduleDTO getSchedule() {
        return schedule;
    }

    public void setSchedule(ScheduleDTO schedule) {
        this.schedule = schedule;
    }
}