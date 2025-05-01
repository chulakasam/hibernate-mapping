package lk.ijse.onetomanyunidirectional.dao;





import lk.ijse.onetomanyunidirectional.entity.Course;
import lk.ijse.onetomanyunidirectional.entity.Instructor;
import lk.ijse.onetomanyunidirectional.entity.InstructorDetails;

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
    //above task doing with join query with fetch
    Instructor findInstructorByJoinFetch(int instructorId);

    void updateInstructor(Instructor instructor);

    Course findCourseById(int courseId);

    void updateSelectedCourse(Course selectedCourse);

    void deleteInstructorById(int id);
    void deleteCourseById(int id);

    void saveCourse(Course course);

    Course findCourseAndReviewById(int courseId);
    void deleteCourseAndReviewByCourseId(int courseId);
}
