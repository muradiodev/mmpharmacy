package com.mmpharmacy.mmpharmacy.controller;


import com.mmpharmacy.mmpharmacy.entity.Category;
import com.mmpharmacy.mmpharmacy.entity.Type;
import com.mmpharmacy.mmpharmacy.repo.RepoCategory;
import com.mmpharmacy.mmpharmacy.repo.RepoType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class ControllerCategories {

    @Autowired
    private RepoType repoType;

    @Autowired
    private RepoCategory repoCategory;


    @RequestMapping("/categories")
    public String openAdminPage(Model md) {

        List<Category> category = repoCategory.findAll();


        for (Category cat : category) {
            md.addAttribute("category", category);
        }


        return "admin/categories.html";
    }

    @RequestMapping("/getCategories")
    @ResponseBody
    public ResponseEntity<List<String>> getCategories() {

        System.out.println("Controllere girdi");
        List<Category> category = repoCategory.findAll();

        List<String> myCatArray = new ArrayList<>();

        for (int i = 0; i < category.size(); i++) {
            Category cat = category.get(i);
            myCatArray.add(cat.getName());
        }

        return ResponseEntity.status(HttpStatus.OK).body(myCatArray);
    }

    @RequestMapping("/getTypes")
    @ResponseBody
    public ResponseEntity<List<String>> getTypes() {

        System.out.println("Controllere girdi");
        List<Type> types = repoType.findAll();

        List<String> myTypeArray = new ArrayList<>();

        for (int i = 0; i < types.size(); i++) {
            Type type = types.get(i);
            myTypeArray.add(type.getName());
        }

        return ResponseEntity.status(HttpStatus.OK).body(myTypeArray);
    }

//    @GetMapping("/deleteCategory")
//    public String deleteTicketByViewGuid(@RequestParam("id") String category_id) {
//        Category category = repoCategory.findTicketsByviewGuid(category_id);
//        category.setIsActive(0);
//        repoCategory.save(ticket);
//        return "redirect:/tickets";
//    }
//    public String getAll(){
//
//        return
//    }
    //todo: getAllTables, edit, delete as update

}
