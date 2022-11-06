package com.example.coursework.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "LESSONS")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "teachers_name")
    private String teachers_name;

    @Column(name = "teachers_lastname")
    private String teachers_lastname;

    @Column(name = "teachers_patronymic")
    private String teachers_patronymic;
}


