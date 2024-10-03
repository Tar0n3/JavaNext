package com.example.slstore.customer.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.slstore.customer.model.dto.Account;
import com.example.slstore.customer.model.entity.User;
import com.example.slstore.security.LoginUserDetails;


@Controller
public class UserController {

    @GetMapping("/customer/login")
    public String login() {
        return "customer/account/login-form";
    }

    // Chapter1 Lesson1 Section A
    // @GetMapping("/mypage")
    // public String myPage(Model model) {
    //     return "customer/account/mypage";
    // }

    // Chapter1 Lesson1 Section B
    // @GetMapping("/mypage")
    // public String myPage(Model model) {
    //     String name = "鈴木太郎";
    //     int points = 3200;

    //     model.addAttribute("name", name);
    //     model.addAttribute("points", points);
    //     return "customer/account/mypage";
    // }

    // Chapter1 Lesson1 Section C
    // @GetMapping("/mypage")
    // public String myPage(Model model) {
    //     String name = "鈴木太郎";
    //     int points = 3200;

    //     name = "名前:" + name;
    //     points = points + 1000;
    //     String pointsStr = "保有ポイント： " + points + "pt(初回プレゼント1000ポイント含)";

    //     model.addAttribute("name", name);
    //     model.addAttribute("pointsStr", pointsStr);
    //     return "customer/account/mypage";
    // }

    // Chapter1 Lesson2 Section A
    // @GetMapping("/mypage")
    // public String myPage(Model model) {
    //     Account account = new Account();
    //     account.setName("鈴木太郎");
    //     account.setPoints(3200);
    //     String name = account.getName();
    //     String pointsStr = "保有ポイント： " + account.getPoints() + "pt(初回プレゼント1000ポイント含)";

    //     model.addAttribute("name", name);
    //     model.addAttribute("points", pointsStr);

    //     return "customer/account/mypage";
    // }

    // Chapter1 Lesson2 Section A
    // @GetMapping("/mypage")
    // public String myPage(Model model) {
    //     Account account = new Account();
    //     account.setName("鈴木太郎");
    //     account.setPoints(3200);
    //     String name = account.getName();
    //     String pointsStr = "保有ポイント： " + account.getPoints() + "pt(初回プレゼント1000ポイント含)";

    //     String greeting = account.greeting();

    //     model.addAttribute("name", name);
    //     model.addAttribute("points", pointsStr);
    //     model.addAttribute("greeting", greeting);

    //     return "customer/account/mypage";
    // }

    // Chapter1 Lesson2 Section C
    @GetMapping("/mypage")
    public String myPage(Model model) {
        Account account = new Account("田中太郎", 5000);
        String name = account.getName();
        String pointsStr = "保有ポイント： " + account.getPoints() + "pt(初回プレゼント1000ポイント含)";

        String greeting = account.greeting();

        model.addAttribute("name", name);
        model.addAttribute("points", pointsStr);
        model.addAttribute("greeting", greeting);

        return "customer/account/mypage";
    }

    // Chapter1 Lesson3 Section A
    // @GetMapping("/mypage")
    // public String myPage(Model model, @AuthenticationPrincipal LoginUserDetails userDetails) {

    //     User loginUser = userDetails.getUser();
    //     String fullName = loginUser.getLastName() + " " + loginUser.getFirstName();

    //     model.addAttribute("fullName", fullName);

    //     return "customer/account/mypage";
    // }

    // Chapter1 Lesson3 Section B
    @GetMapping("/mypage")
    public String myPage(Model model, @AuthenticationPrincipal LoginUserDetails userDetails) {

        User loginUser = userDetails.getUser();

        model.addAttribute("loginUser", loginUser);

        return "customer/account/mypage";
    }
}
