package com.wiktorkielar.service;

import com.wiktorkielar.model.System;

import java.util.List;

public interface SystemService {
    List<System> getSystems();

    System getSystemById(int id);

    void saveSystem(System system);
}
