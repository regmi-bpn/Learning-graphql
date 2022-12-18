package com.graphql.learn.college.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CollegeResponse {

    private Long id;

    private String collegeName;

    private String location;

    private String fee;
}
