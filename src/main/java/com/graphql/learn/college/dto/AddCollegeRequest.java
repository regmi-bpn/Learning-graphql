package com.graphql.learn.college.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddCollegeRequest {

    private String collegeName;

    private String location;

    private String fee;
}
