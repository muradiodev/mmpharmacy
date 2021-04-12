package com.mmpharmacy.mmpharmacy.service;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;


public interface SupplierService {

    void findAllByIsActive(Model md);

    void deleteSupplierById(HttpServletRequest request);

    void addSupplier(int countryid, String name, String email, String phonenumber, String address);

    void updateSupplier(int id, int countryid, String name, String email, String phonenumber, String address);
}
