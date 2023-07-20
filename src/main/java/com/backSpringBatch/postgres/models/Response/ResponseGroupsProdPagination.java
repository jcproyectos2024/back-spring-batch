package com.backSpringBatch.postgres.models.Response;


import com.backRRHH.Util.GroupsProdObject;

import java.util.List;

public class ResponseGroupsProdPagination {

    private List<GroupsProdObject> groups;
    private String message;
    private int totalRegister;


    public List<GroupsProdObject> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupsProdObject> groups) {
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
