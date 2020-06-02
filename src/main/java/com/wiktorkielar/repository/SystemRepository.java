package com.wiktorkielar.repository;

import com.wiktorkielar.model.System;

import java.util.List;

public interface SystemRepository {
    List<System> getSystems();
    System getSystemById(int id);
    void saveSystem(System system);
}
