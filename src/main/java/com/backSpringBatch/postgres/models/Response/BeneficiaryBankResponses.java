package com.backSpringBatch.postgres.models.Response;

import com.backRRHH.models.BeneficiaryBankDto;

import java.util.List;

public class BeneficiaryBankResponses
{


    private List<BeneficiaryBankDto> beneficiaryBankDtoList;
    private String message;

    public BeneficiaryBankResponses() {
    }


    public List<BeneficiaryBankDto> getBeneficiaryBankDtoList() {
        return beneficiaryBankDtoList;
    }

    public void setBeneficiaryBankDtoList(List<BeneficiaryBankDto> beneficiaryBankDtoList) {
        this.beneficiaryBankDtoList = beneficiaryBankDtoList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
