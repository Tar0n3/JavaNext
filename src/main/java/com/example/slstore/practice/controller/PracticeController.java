package com.example.slstore.practice.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.slstore.customer.model.User;
import com.example.slstore.practice.model.Person;
import com.example.slstore.security.LoginUserDetails;

@Controller
@RequestMapping("/practice")
public class PracticeController {

    // Chapter1 Lesson1 Section A
    @GetMapping("/helloworld")
    public String helloWorld() {
        return "practice/helloworld";
    }

    // Chapter1 Lesson1 Section B
    // @GetMapping("/variable")
    // public String variable(Model model) {
    // // String str = "Hello World";
    // // int number = 1234;

    // String str = "Hello SLShopping";
    // int number = 5678;

    // model.addAttribute("str", str);
    // model.addAttribute("number", number);
    // return "practice/variable";
    // }

    // Chapter1 Lesson1 Section C
    @GetMapping("/variable")
    public String variable(Model model) {
        // テキストにあわせた演算を行う
        String str = "Hello SLShopping" + " Let's enjoy shopping";
        int number = 5678 + 4322;

        model.addAttribute("str", str);
        model.addAttribute("number", number);
        return "practice/variable";
    }

    // Chapter1 Lesson2 Section A
    // @GetMapping("/person")
    // public String displayPerson(Model model) {
    //     Person personA = new Person();

    //     personA.setName("Alice");
    //     personA.setAge(22);

    //     String nameA = personA.getName();
    //     int ageA = personA.getAge();

    //     model.addAttribute("name", nameA);
    //     model.addAttribute("age", ageA);

    //     return "practice/display-person";
    // }

    // Chapter1 Lesson2 Section B
    // @GetMapping("/person")
    // public String displayPerson(Model model) {
    //     Person personA = new Person();

    //     personA.setName("Alice");
    //     personA.setAge(22);

    //     String nameA = personA.getName();
    //     int ageA = personA.getAge();

    //     model.addAttribute("name", nameA);
    //     model.addAttribute("age", ageA);

    //     String introduceA = personA.introduce();
    //     model.addAttribute("introduce", introduceA);

    //     return "practice/display-person";
    // }

    // Chapter1 Lesson2 Section C
    // @GetMapping("/person")
    // public String displayPerson(Model model) {
    //     Person personA = new Person("Alice", 22);

    //     String nameA = personA.getName();
    //     int ageA = personA.getAge();

    //     model.addAttribute("name", nameA);
    //     model.addAttribute("age", ageA);

    //     String introduceA = personA.introduce();
    //     model.addAttribute("introduce", introduceA);

    //     return "practice/display-person";
    // }
    
    // Chapter1 Lesson3 Section A
    @GetMapping("/profile")
    public String userProfile(@AuthenticationPrincipal LoginUserDetails userDetails, Model model) {
        User loginUser = userDetails.getUser();
        String fullName = loginUser.getLastName() + " " + loginUser.getFirstName();

        model.addAttribute("name", fullName);
        return "practice/profile";
    }

    // Chapter1 Lesson3 Section B
    @GetMapping("/person")
    public String displayPerson(Model model) {
        Person personA = new Person("Alice", 22);

        model.addAttribute("person", personA);
        
        String introduceA = personA.introduce();
        model.addAttribute("introduce", introduceA);

        return "practice/display-person";
    }

}
