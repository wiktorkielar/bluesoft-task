package com.wiktorkielar.service;

import com.wiktorkielar.model.Contract;

import java.util.List;

public interface ContractService {

    List<Contract> getContracts();

    List<Contract> getActiveContracts();

    Contract getContractById(int id);

    void saveContract(Contract contract);

    void saveExistingContract(Contract contract);

    void deleteContractById(int id);
}
