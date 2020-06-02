package com.wiktorkielar.service;

import com.wiktorkielar.model.System;
import com.wiktorkielar.repository.SystemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SystemServiceImpl implements SystemService{

    private static final Logger logger = LoggerFactory.getLogger(SystemServiceImpl.class);
    private SystemRepository systemRepository;

    @Autowired
    public SystemServiceImpl(SystemRepository systemRepository) {
        this.systemRepository = systemRepository;
    }

    @Override
    @Transactional
    public List<System> getSystems() {

        List<System> systems = systemRepository.getSystems();
        logger.info("Systems retrieved from the DB");

        return systems;
    }

    @Override
    public System getSystemById(int id) {
        System system = systemRepository.getSystemById(id);
        logger.info("System retrieved from DB: {}", system);

        return system;
    }

    @Override
    public void saveSystem(System system) {

        systemRepository.saveSystem(system);
        logger.info("System saved to DB: {}", system);
    }
}
