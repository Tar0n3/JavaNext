// package com.example.slstore.admin.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;

// import com.example.slstore.admin.model.Entity.Notice;
// import com.example.slstore.admin.model.form.NoticeForm;
// import com.example.slstore.admin.repository.NoticeRepository;

// @Controller
// @RequestMapping("/admin/notice")
// public class NoticeController {

//     @Autowired
//     private NoticeRepository noticeRepository;

//     @GetMapping("/add")
//     public String showAddForm(Model model) {
//         NoticeForm noticeForm = new NoticeForm();
//         model.addAttribute("noticeForm", noticeForm);
//         return "admin/notice/add-form";
//     }

//     @PostMapping("/add")
//     public String add(NoticeForm noticeForm, Model model) {
//         String content = noticeForm.getContent();

//         Notice notice = new Notice();
//         notice.setContent(content);
//         noticeRepository.save(notice);

//         model.addAttribute("content", content);
//         return "admin/notice/complete";
//     }
// }
