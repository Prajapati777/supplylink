package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Warehouse;
import com.edutech.progressive.repository.WarehouseRepository;
import com.edutech.progressive.service.WarehouseService;

@Service
public class WarehouseServiceImplJpa implements WarehouseService {

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Override
    public List<Warehouse> getAllWarehouses() {
        return warehouseRepository.findAll();
    }

    @Override
    public int addWarehouse(Warehouse warehouse) {
       return warehouseRepository.save(warehouse).getWarehouseId();
    }

    @Override
    public List<Warehouse> getWarehousesSortedByCapacity() {
       List<Warehouse> warehouses = warehouseRepository.findAll();
       Collections.sort(warehouses, Comparator.comparingInt(Warehouse::getCapacity));
       return warehouses;
    }

    //Do not implement these methods in WarehouseServiceImplArraylist.java class
    @Override
    public void updateWarehouse(Warehouse warehouse) {
        warehouseRepository.save(warehouse);
    }

    @Override
    public void deleteWarehouse(int warehouseId) {
        warehouseRepository.deleteByWarehouseId(warehouseId);
    }

    @Override
    public Warehouse getWarehouseById(int warehouseId) {
        return warehouseRepository.findByWarehouseId(warehouseId);
    }

    //Do not implement these methods in WarehouseServiceImplArraylist.java and WarehouseServiceImplJdbc.java class
    @Override
    public List<Warehouse> getWarehouseBySupplier(int supplierId) {
        return warehouseRepository.findBySupplierId(supplierId);
    }
}
