package lk.ijse.mappingonetomany.dao;



import lk.ijse.mappingonetomany.entity.Course;
import lk.ijse.mappingonetomany.entity.Instructor;
import lk.ijse.mappingonetomany.entity.InstructorDetails;

import java.util.List;

public interface AppDAO {
    void save(Instructor instructor);

    List<Instructor> findAll();

    Instructor findById(int id);

    void deleteById(int id);

    void updateSelectInstructor(int id,Instructor instructor);

    InstructorDetails findInstructorDetailsById(int id);

    void deleteInstructorDetailsById(int id);

    void saveCourseWithInstructor(Course course);

    List<Course> findAllCourses();

    Instructor findInstructorWithCourses(int instructorId);


    List<Course> findCoursesByInstructorId(int instructorId);

}
