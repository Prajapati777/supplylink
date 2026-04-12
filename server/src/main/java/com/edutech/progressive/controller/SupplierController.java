package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Supplier;
import com.edutech.progressive.service.SupplierService;
import com.edutech.progressive.service.impl.SupplierServiceImplArraylist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {

  
    SupplierService supplierService;
    SupplierServiceImplArraylist supplierServiceImplArraylist;

    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        return new ResponseEntity<>(supplierService.getAllSuppliers(),HttpStatus.OK);
    }

    public ResponseEntity<Supplier> getSupplierById(int supplierId) {
        return new ResponseEntity<>(supplierService.getSupplierById(supplierId),HttpStatus.OK);
    }

    public ResponseEntity<Integer> addSupplier(Supplier supplier) {
        return new ResponseEntity<>(supplierService.addSupplier(supplier),HttpStatus.OK);
    }

    public ResponseEntity<Void> updateSupplier(Supplier supplier) {
        supplierService.updateSupplier(supplier);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteSupplier(int supplierId) {
        supplierService.deleteSupplier(supplierId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<List<Supplier>> getAllSuppliersFromArrayList() {

        return new ResponseEntity<>(supplierServiceImplArraylist.getAllSuppliers(),HttpStatus.OK);
    }

    public ResponseEntity<Integer> addSupplierToArrayList(Supplier supplier) {
        return new ResponseEntity<>(supplierServiceImplArraylist.addSupplier(supplier),HttpStatus.OK);
    }

    public ResponseEntity<List<Supplier>> getAllSuppliersSortedByNameFromArrayList() {
        return new ResponseEntity<>(supplierServiceImplArraylist.getAllSuppliersSortedByName(),HttpStatus.OK);
    }
}