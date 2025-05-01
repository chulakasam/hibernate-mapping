package com.example.demo.dao;

import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetails;

import java.util.List;

public interface AppDAO {
    void save(Instructor instructor);

    List<Instructor> findAll();

    Instructor findById(int id);

    void deleteById(int id);

    void updateSelectInstructor(int id,Instructor instructor);

    InstructorDetails findInstructorDetailsById(int id);

    void deleteInstructorDetailsById(int id);

}
