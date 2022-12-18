package com.graphql.learn.college.service;

import com.graphql.learn.college.dto.AddCollegeRequest;
import com.graphql.learn.college.dto.CollegeResponse;

import java.util.List;

public interface CollegeService {


    CollegeResponse addCollege(AddCollegeRequest request);

    CollegeResponse updateCollege(AddCollegeRequest request, Long id);

    String deleteCollege(Long id);

    List<CollegeResponse> getAllCollege();

    CollegeResponse getCollegeById(Long id);
}
