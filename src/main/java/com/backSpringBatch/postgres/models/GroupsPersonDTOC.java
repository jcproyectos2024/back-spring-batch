package com.backSpringBatch.postgres.models;
import lombok.Data;

import java.io.Serializable;

/**

 */
@Data
public class GroupsPersonDTOC implements Serializable {
    private  Long id;
    private  GroupsDTOC groups;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GroupsDTOC getGroups() {
        return groups;
    }

    public void setGroups(GroupsDTOC groups) {
        this.groups = groups;
    }
}