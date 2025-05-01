package lk.ijse.manytomany.dao;



import lk.ijse.manytomany.entity.Course;
import lk.ijse.manytomany.entity.Instructor;
import lk.ijse.manytomany.entity.InstructorDetails;
import lk.ijse.manytomany.entity.Student;

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

    void createStudentAndCourse(Course course);

    Course findCourseAndStudentByCourseId(int courseId);

    Student findStudentAndCourseByStudentId(int studentId);

    void updateStudent(Student student);

    void deleteStudentByStudentId(int studentId);
}
