package com.backSpringBatch.postgres.models.Relation;

import com.backRRHH.Util.GetPersonDTO;

import java.util.List;

public class GroupsPersonDTO {


    List<GetPersonDTO> personGroup;

    List <GetPersonDTO> personNotGroup;


    public List<GetPersonDTO> getPersonGroup() {
        return personGroup;
    }

    public void setPersonGroup(List<GetPersonDTO> personGroup) {
        this.personGroup = personGroup;
    }

    public List<GetPersonDTO> getPersonNotGroup() {
        return personNotGroup;
    }

    public void setPersonNotGroup(List<GetPersonDTO> personNotGroup) {
        this.personNotGroup = personNotGroup;
    }
}
