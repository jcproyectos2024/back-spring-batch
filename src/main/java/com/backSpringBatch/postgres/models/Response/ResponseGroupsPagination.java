package com.backSpringBatch.postgres.models.Response;


import com.backRRHH.Util.GroupsObject;

import java.util.List;

public class ResponseGroupsPagination {

    private List<GroupsObject> groups;
    private String message;
    private int totalRegister;


    public List<GroupsObject> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupsObject> groups) {
        this.groups = groups;
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
