package com.backSpringBatch.postgres.models.Response;

import com.backRRHH.models.ContractTypeDTO;

import java.util.List;

public class ResponseContractTypePagination {

    private List<ContractTypeDTO> contract;
    private String message;
    private int totalRegister;


    public List<ContractTypeDTO> getContract() {
        return contract;
    }

    public void setContract(List<ContractTypeDTO> contract) {
        this.contract = contract;
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
