package com.example.slstore.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.slstore.admin.model.dto.BrandForm;
import com.example.slstore.admin.model.entity.Brand;
import com.example.slstore.admin.repository.BrandRepository;

@Controller
@RequestMapping("/admin/brand")
public class BrandController {

    @Autowired
    private BrandRepository brandRepository;

    // Chapter3 Lesson1 Section A
    @GetMapping("/index")
    public String list(Model model) {
        List<Brand> brands = brandRepository.findAll();
        model.addAttribute("brands", brands);
        return "admin/brand/list";
    }

    // Chapter2 Lesson1 Section A
    // @GetMapping("addform")
    // public String showAddForm() {
    // return "admin/brand/add-form";
    // }

    // Chapter2 Lesson1 Section B
    @GetMapping("addform")
    public String showAddForm(Model model) {
        BrandForm brandForm = new BrandForm();
        model.addAttribute("brandForm", brandForm);
        return "admin/brand/add-form";
    }

    // Chapter2 Lesson1 Section B
    // @PostMapping("/store")
    // public String add(BrandForm brandForm, Model model) {

    //     String name = brandForm.getName();
    //     String description = brandForm.getDescription();

    //     model.addAttribute("name", name);
    //     model.addAttribute("description", description);
    //     return "admin/brand/complete";
    // }

    // Chapter2 Lesson1 Section C
    // String name = brandForm.getName();
    // String description = brandForm.getDescription();

    // model.addAttribute("name", name);
    // model.addAttribute("description", description);
    // return "admin/brand/complete";
    // }

    // Chapter2 Lesson1 Section C
    // @PostMapping("/store")
    // public String add(BrandForm brandForm, Model model) {
    // String name = brandForm.getName();
    // String description = brandForm.getDescription();

    // Brand brand = new Brand();
    // brand.setName(name);
    // brand.setDescription(description);

    // brandRepository.save(brand);

    // model.addAttribute("brand", brand);
    // return "admin/brand/complete";
    // }

    // Chapter2 Lesson2 Section A
    // @PostMapping("/store")
    // public String add(BrandForm brandForm, Model model) {
    // String name = brandForm.getName();
    // String description = brandForm.getDescription();

    // if (name.equals("")) {
    // model.addAttribute("errorMessage", "何か入力してください");
    // return "admin/brand/add-form";
    // }

    // Brand brand = new Brand();
    // brand.setName(name);
    // brand.setDescription(description);

    // brandRepository.save(brand);

    // model.addAttribute("brand", brand);
    // return "admin/brand/complete";
    // }

    // Chapter2 Lesson2 Section B
    // @PostMapping("/store")
    // public String add(BrandForm brandForm, Model model) {
    // String name = brandForm.getName();
    // String description = brandForm.getDescription();

    // if (name.equals("") || name.equals(" ") || name.equals(" ")) {
    // model.addAttribute("errorMessage", "空文字・スペースでは入力しないでください");
    // return "admin/brand/add-form";
    // }

    // if (name.length() >= 0 && name.length() <= 3) {
    // model.addAttribute("errorMessage", "4文字以上で入力してください");
    // return "admin/brand/add-form";
    // }

    // Brand brand = new Brand();
    // brand.setName(name);
    // brand.setDescription(description);

    // brandRepository.save(brand);

    // model.addAttribute("brand", brand);
    // return "admin/brand/complete";
    // }

    // Chapter2 Lesson2 Section C
    @PostMapping("/store")
    public String add(BrandForm brandForm, Model model) {
        String name = brandForm.getName();
        String description = brandForm.getDescription();


        if (name.equals("") || name.equals(" ") || name.equals("　")) {
            model.addAttribute("errorMessage", "ブランド名を入力してください");
            return "admin/brand/add-form";
        } else if (name.length() >= 0 && name.length() <= 3) {
            model.addAttribute("errorMessage", "20文字未満で入力してください");
            return "admin/brand/add-form";
        }

        Brand brand = new Brand();
        brand.setName(name);
        brand.setDescription(description);

        brandRepository.save(brand);

        model.addAttribute("brand", brand);
        return "admin/brand/complete";
    }

}
