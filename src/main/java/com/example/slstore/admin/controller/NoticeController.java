package com.example.slstore.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.slstore.admin.model.dto.NoticeForm;
import com.example.slstore.admin.model.entity.Notice;
import com.example.slstore.admin.repository.NoticeRepository;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin/notice")
public class NoticeController {

    @Autowired
    private NoticeRepository noticeRepository;

    // Chapter3 Lesson1 Section A
    @GetMapping("/index")
    public String list(Model model) {
        List<Notice> notices = noticeRepository.findAll();
        model.addAttribute("notices", notices);
        return "admin/notice/list";
    }

    // Chapter2 Lesson1 Section A
    // @GetMapping("/addform")
    // public String showAddForm(Model model) {
    // return "admin/notice/add-form";
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
    // String title = noticeForm.getTitle();
    // String content = noticeForm.getContent();

    // model.addAttribute("title", title);
    // model.addAttribute("content", content);
    // return "admin/notice/complete";
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

    @GetMapping("/editform/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Notice notice = noticeRepository.findById(id).get();
        NoticeForm noticeForm = new NoticeForm();
        noticeForm.setId(notice.getId());
        noticeForm.setTitle(notice.getTitle());
        noticeForm.setContent(notice.getContent());
        model.addAttribute("noticeForm", noticeForm);
        return "admin/notice/edit-form";
    }

    @PostMapping("/update")
    public String update(NoticeForm noticeForm) {
        Notice notice = new Notice();
        notice.setId(noticeForm.getId());
        notice.setTitle(noticeForm.getTitle());
        notice.setContent(noticeForm.getContent());
        noticeRepository.save(notice);
        return "redirect:/admin/notice/index";
    }

    @GetMapping("/deleteform/{id}")
    public String showDeleteForm(@PathVariable int id, Model model) {
        Notice notice = noticeRepository.findById(id).get();
        NoticeForm noticeForm = new NoticeForm();
        noticeForm.setId(notice.getId());
        noticeForm.setTitle(notice.getTitle());
        noticeForm.setContent(notice.getContent());
        model.addAttribute("noticeForm", noticeForm);
        return "admin/notice/delete-form";
    }

    @PostMapping("/delete")
    public String delete(NoticeForm noticeForm) {
        Notice notice = new Notice();
        notice.setId(noticeForm.getId());
        notice.setTitle(noticeForm.getTitle());
        notice.setContent(noticeForm.getContent());
        notice.setIsDeleted(1);
        noticeRepository.save(notice);
        return "redirect:/admin/notice/index";
    }

}
