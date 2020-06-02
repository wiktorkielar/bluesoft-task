package com.wiktorkielar.service;

import com.wiktorkielar.model.Contract;
import com.wiktorkielar.model.System;
import com.wiktorkielar.repository.ContractRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {

    private static final Logger logger = LoggerFactory.getLogger(ContractServiceImpl.class);
    private ContractRepository contractRepository;
    private SystemService systemService;

    @Autowired
    public ContractServiceImpl(ContractRepository contractRepository, SystemService systemService) {
        this.contractRepository = contractRepository;
        this.systemService = systemService;
    }

    @Override
    public List<Contract> getContracts() {

        List<Contract> contracts = contractRepository.getContracts();
        logger.info("Contracts retrieved from the DB");

        return contracts;
    }

    @Override
    public List<Contract> getActiveContracts() {

        List<Contract> activeContracts = contractRepository.getActiveContracts();
        logger.info("Active contracts retrieved from the DB");

        return activeContracts;
    }

    @Override
    public Contract getContractById(int id) {

        Contract contract = contractRepository.getContractById(id);
        logger.info("Contract retrieved from DB: {}", contract);

        return contract;
    }

    @Override
    public void saveContract(Contract contract) {

        System system = systemService.getSystemById(contract.getSystem().getId());
        contract.setSystem(system);

        contractRepository.saveContract(contract);
        logger.info("Contract saved to DB: {}", contract);
    }

    @Override
    public void saveExistingContract(Contract contract) {

        System systemDb = systemService.getSystemById(contract.getSystem().getId());

        Contract contractDb = contractRepository.getContractById(contract.getId());
        contractDb.setContractNumber(contract.getContractNumber());
        contractDb.setStartDate(contract.getStartDate());
        contractDb.setEndDate(contract.getEndDate());
        contractDb.setAmount(contract.getAmount());
        contractDb.setBillingPeriod(contract.getBillingPeriod());
        contractDb.setActive(contract.isActive());
        contractDb.setSystem(systemDb);

        saveContract(contractDb);
    }

    @Override
    public void deleteContractById(int id) {

        Contract contract = contractRepository.getContractById(id);

        contractRepository.deleteContractById(id);
        logger.info("Contract deleted from DB: {}", contract);
    }
}
