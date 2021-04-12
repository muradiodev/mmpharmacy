package com.mmpharmacy.mmpharmacy.service;

import org.springframework.ui.Model;

public interface UserService {

    void findAllByIsActive(Model md);

    void deleteUserById(int id);

    void updateUser(int id, String name, String surname, String email, String phonenumber);

    void addUser(String name, String surname, String email, String phonenumber);
}
