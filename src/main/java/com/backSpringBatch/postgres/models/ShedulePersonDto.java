package com.backSpringBatch.postgres.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShedulePersonDto
{
    List<GroupsScheduleDto>  groupsScheduleDtoList;

    public ShedulePersonDto() {
    }

    public List<GroupsScheduleDto> getGroupsScheduleDtoList() {
        return groupsScheduleDtoList;
    }

    public void setGroupsScheduleDtoList(List<GroupsScheduleDto> groupsScheduleDtoList) {
        this.groupsScheduleDtoList = groupsScheduleDtoList;
    }
}
