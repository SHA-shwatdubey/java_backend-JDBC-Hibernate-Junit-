package com.springboot.springbootbasic.service;

import com.springboot.springbootbasic.entity.College;
import com.springboot.springbootbasic.repository.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeService {

    @Autowired
    private CollegeRepository collegeRepository;

    public College saveCollege(College college) {
        return collegeRepository.save(college);
    }

    public List<College> getAllColleges() {
        return collegeRepository.findAll();
    }

    public College getCollegeById(Long id) {
        return collegeRepository.findById(id).orElse(null);
    }
}

