package com.example.slstore.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.slstore.admin.model.dto.NoticeForm;
import com.example.slstore.admin.model.entity.Notice;
import com.example.slstore.admin.repository.NoticeRepository;

@Controller
@RequestMapping("/admin/notice")
public class NoticeController {

    @Autowired
    private NoticeRepository noticeRepository;

    // Chapter2 Lesson1 Section A
    // @GetMapping("/addform")
    // public String showAddForm(Model model) {
    //     return "admin/notice/add-form";
    // }

    // Chapter2 Lesson1 Section B
    @GetMapping("/addform")
    public String showAddForm(Model model) {
        NoticeForm noticeForm = new NoticeForm();
        model.addAttribute("noticeForm", noticeForm);
        return "admin/notice/add-form";
    }

    // Chapter2 Lesson1 Section B
    // @PostMapping("/store")
    // public String add(NoticeForm noticeForm, Model model) {
    //     String title = noticeForm.getTitle();
    //     String content = noticeForm.getContent();

    //     model.addAttribute("title", title);
    //     model.addAttribute("content", content);
    //     return "admin/notice/complete";
    // }

        // Chapter2 Lesson1 Section C
        @PostMapping("/store")
        public String add(NoticeForm noticeForm, Model model) {
            String title = noticeForm.getTitle();
            String content = noticeForm.getContent();
    
            Notice notice = new Notice();
            notice.setTitle(title);
            notice.setContent(content);
            noticeRepository.save(notice);
    
            model.addAttribute("notice", notice);
            return "admin/notice/complete";
        }
}
