package com.mmpharmacy.mmpharmacy.controller;


import com.mmpharmacy.mmpharmacy.repo.RepoUser;
import com.mmpharmacy.mmpharmacy.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class ControllerUsers {

    private final RepoUser repoUser;
    private final UserServiceImpl userService;

    @RequestMapping("/users")
    public String findAllByIsActive(Model md) {
        userService.findAllByIsActive(md);
        return "admin/users.html";
    }

    @RequestMapping("/deleteUser")
    @ResponseBody
    public ResponseEntity deleteUserById(@RequestParam(value = "id") int id) {
        userService.deleteUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body("deleted");
    }

    @RequestMapping("/updateUser")
    public String updateUser(@RequestParam(value = "id") int id, @RequestParam(value = "name", required = false) String name, @RequestParam(value = "surname", required = false) String surname, @RequestParam(value = "email", required = false) String email, @RequestParam(value = "phonenumber", required = false) String phonenumber) {
        userService.updateUser(id, name, surname, email, phonenumber);
        return "redirect:/admin/users";
    }

    @RequestMapping("/addUser")
    public String addUser(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "surname", required = false) String surname, @RequestParam(value = "email", required = false) String email, @RequestParam(value = "phonenumber", required = false) String phonenumber) {
        userService.addUser(name, surname, email, phonenumber);
        return "redirect:/admin/suppliers";
    }
}
