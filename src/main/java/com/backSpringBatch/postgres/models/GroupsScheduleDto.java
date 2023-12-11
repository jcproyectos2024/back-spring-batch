package com.backSpringBatch.postgres.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;


@JsonIgnoreProperties(ignoreUnknown = true)
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