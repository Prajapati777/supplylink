package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.entity.Warehouse;
import com.edutech.progressive.service.WarehouseService;

public class WarehouseServiceImplJpa implements WarehouseService {

    @Override
    public List<Warehouse> getAllWarehouses() {
        return new ArrayList<>();
    }

    @Override
    public int addWarehouse(Warehouse warehouse) {
       return -1;
    }

    @Override
    public List<Warehouse> getWarehousesSortedByCapacity() {
       return new ArrayList<>();
    }

}