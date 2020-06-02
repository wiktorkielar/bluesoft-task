package com.wiktorkielar.repository;

import com.wiktorkielar.model.Contract;

import java.util.List;

public interface ContractRepository {

    List<Contract> getContracts();

    List<Contract> getActiveContracts();

    Contract getContractById(int id);

    void saveContract(Contract contract);

    void deleteContractById(int contractId);
}
