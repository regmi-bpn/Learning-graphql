package com.graphql.learn.college.service.impl;

import com.graphql.learn.college.dto.AddCollegeRequest;
import com.graphql.learn.college.dto.CollegeResponse;
import com.graphql.learn.college.entity.College;
import com.graphql.learn.college.repository.CollegeRepository;
import com.graphql.learn.college.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CollegeServiceImpl implements CollegeService {

    private final CollegeRepository collegeRepository;

    @Autowired
    public CollegeServiceImpl(CollegeRepository collegeRepository) {
        this.collegeRepository = collegeRepository;
    }

    @Override
    public CollegeResponse addCollege(AddCollegeRequest request) {
        College college = new College();
        college.setCollegeName(request.getCollegeName());
        college.setFee(request.getFee());
        college.setLocation(request.getLocation());
        College save = collegeRepository.save(college);
        return prepareCollegeResponse(save);
    }

    @Override
    public CollegeResponse updateCollege(AddCollegeRequest request, Long id) {
        College college = collegeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("The college id is not valid "));
        if (request.getCollegeName() != null) {
            college.setCollegeName(request.getCollegeName());
        }
        if (request.getFee() != null) {
            college.setFee(request.getFee());
        }
        if (request.getLocation() != null) {
            college.setLocation(request.getLocation());
        }
        College save = collegeRepository.save(college);
        return prepareCollegeResponse(save);
    }

    @Override
    public String deleteCollege(Long id) {
        College college = collegeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("The college id is not valid "));
        collegeRepository.delete(college);
        return "The college with id" + id + "has been deleted ";
    }

    @Override
    public List<CollegeResponse> getAllCollege() {
        List<College> college = collegeRepository.findAll();
        List<CollegeResponse> collegeResponses = new ArrayList<>();
        college.forEach(colleges -> collegeResponses.add(prepareCollegeResponse(colleges)));
        return collegeResponses;
    }

    @Override
    public CollegeResponse getCollegeById(Long id) {
        College college = collegeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("The college id is not valid "));
        return prepareCollegeResponse(college);
    }

    private CollegeResponse prepareCollegeResponse(College colleges) {
        return CollegeResponse.builder()
                .id(colleges.getId())
                .collegeName(colleges.getCollegeName())
                .fee(colleges.getFee())
                .location(colleges.getLocation())
                .build();
    }


}
