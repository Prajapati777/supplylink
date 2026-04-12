package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Warehouse;
import com.edutech.progressive.service.WarehouseService;
import com.edutech.progressive.service.impl.WarehouseServiceImplArraylist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/warehouses")
public class WarehouseController {

    
    WarehouseService warehouseService;
   

    public ResponseEntity<List<Warehouse>> getAllWarehouses() {
        return new ResponseEntity<>(warehouseService.getAllWarehouses(),HttpStatus.OK);
    }

    public ResponseEntity<Warehouse> getWarehouseById(int warehouseId) {
        return new ResponseEntity<>(warehouseService.getWarehouseById(warehouseId),HttpStatus.OK);
    }

    public ResponseEntity<Integer> addWarehouse(Warehouse warehouse) {
        return new ResponseEntity<>(warehouseService.addWarehouse(warehouse),HttpStatus.OK);
    }

    public ResponseEntity<Void> updateWarehouse(int warehouseId, Warehouse warehouse) {
        warehouseService.updateWarehouse(warehouse);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteWarehouse(int warehouseId) {
        warehouseService.deleteWarehouse(warehouseId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    public ResponseEntity<List<Warehouse>> getWarehousesBySupplier(int supplierId) {
        return new ResponseEntity<>(warehouseService.getWarehouseBySupplier(supplierId),HttpStatus.OK);
    }
}
