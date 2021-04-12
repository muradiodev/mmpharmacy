package com.mmpharmacy.mmpharmacy.service.impl;

import com.mmpharmacy.mmpharmacy.entity.User;
import com.mmpharmacy.mmpharmacy.repo.RepoUser;
import com.mmpharmacy.mmpharmacy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final RepoUser repoUser;

    @Override
    public void findAllByIsActive(Model md) {
        List<User> users = repoUser.findAllByIsactive("1");
        for (User user : users) {
            md.addAttribute("user", users);
        }
    }

    @Override
    public void deleteUserById(int id) {
        User user = repoUser.getOne(id);
        user.setIsactive("0");
        repoUser.save(user);
    }

    @Override
    public void updateUser(int id, String name, String surname, String email, String phonenumber) {
        User user = repoUser.getOne(id);
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setPhonenumber(phonenumber);
        System.out.println("Setted");
        repoUser.save(user);
    }

    @Override
    public void addUser(String name, String surname, String email, String phonenumber) {
        User user = new User(name, surname, phonenumber, email, "1");
        repoUser.save(user);
    }
}
