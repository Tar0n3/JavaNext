package com.example.slstore.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.slstore.admin.model.entity.Notice;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Integer> {
    
}
