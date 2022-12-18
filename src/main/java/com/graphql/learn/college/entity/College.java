package com.graphql.learn.college.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class College {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String collegeName;

    private String location;

    private String fee;
}
