package com.graphql.learn.college.controller;

import com.graphql.learn.college.dto.AddCollegeRequest;
import com.graphql.learn.college.dto.CollegeResponse;
import com.graphql.learn.college.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Controller
public class CollegeController {

    private final CollegeService collegeService;

    @Autowired
    public CollegeController(CollegeService collegeService) {
        this.collegeService = collegeService;
    }

    @MutationMapping("addCollege")
    public CollegeResponse addCollege(@Argument AddCollegeRequest request) {
        return collegeService.addCollege(request);
    }

    @MutationMapping
    public CollegeResponse updateCollege(@Argument @NotNull AddCollegeRequest request, @Argument("collegeId") @NotNull Long id) {
        return collegeService.updateCollege(request, id);
    }

    @MutationMapping
    public String deleteCollege(@Argument("collegeId") @NotNull Long id) {
        return collegeService.deleteCollege(id);
    }

    @QueryMapping("allCollege")
    public List<CollegeResponse> getAllCollege() {
        return collegeService.getAllCollege();
    }

    @QueryMapping
    public CollegeResponse getCollegeById(Long id) {
        return collegeService.getCollegeById(id);
    }


}
