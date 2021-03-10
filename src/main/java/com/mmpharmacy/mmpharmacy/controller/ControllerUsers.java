package com.mmpharmacy.mmpharmacy.controller;


import com.mmpharmacy.mmpharmacy.entity.User;
import com.mmpharmacy.mmpharmacy.repo.RepoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class ControllerUsers {

    @Autowired
    private RepoUser repoUser;

    @RequestMapping("/users")
    public String getAllUsers(Model md) {
        List<User> users = repoUser.findAll();
        for (User usr : users) {
            md.addAttribute("user", users);
        }
        return "admin/users.html";
    }

    // todo updateUser, addUser)

//    @GetMapping("/deleteUser")
//    public String deleteUserById(@RequestParam("id") int id) {
//        User user = repoUser.findUserByUser_id(id);
//        user.setIsActive("0");
//        repoUser.save(user);
//        return "admin/users.html";
//    }

//    @GetMapping("/updateUser")
//    public String updateUserById(@RequestParam("id") int id) {
//        User user = repoUser.findUserByUser_id(id);
//        user.setIsActive("0");
//        repoUser.save(user);
//        return "admin/users.html";
//    }


//    @PostMapping("update/{id}")
//    public void updateUser(Userinfos u) {
//        User userFromDb = userRepository.findById(u.getid());
//        // crush the variables of the object found
//        userFromDb.setFirstname("john");
//        userFromDb.setLastname("dew");
//        userFromDb.setAge(16);
//        userRepository.save(userFromDb);
//    }

//    @GetMapping("signup")
//    public String showSignUpForm(User user) {
//        return "add-user";
//    }
//
//    @PostMapping("add")
//    public String addUser(@Valid User user, BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            return "add-user";
//        }
//
//        RepoUser.save(user);
//        return "redirect:users";
//    }

//    @GetMapping("edit/{id}")
//    public String showUpdateForm(@PathVariable("id") int id, Model model) {
//        User user = RepoUser.findByUser_id(id);
//        model.addAttribute("user", user);
//        return "update-user";
//    }



//    @GetMapping("delete/{id}")
//    public String deleteUser(@PathVariable("id") int id, Model model) {
//        User user = RepoUser.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
//        RepoUser.delete(user);
//        model.addAttribute("students", RepoUser.findAll());
//        return "index";
//    }

}
