package lk.ijse.manytomany.dao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import lk.ijse.manytomany.entity.Course;
import lk.ijse.manytomany.entity.Instructor;
import lk.ijse.manytomany.entity.InstructorDetails;
import lk.ijse.manytomany.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class AppDAOImpl implements AppDAO {
    private EntityManager entityManager;
    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public List<Instructor> findAll() {
        List<Instructor> instructorList = entityManager.createQuery(" from Instructor", Instructor.class).getResultList();
        return instructorList;
    }

    @Override
    public Instructor findById(int id) {
        Instructor instructor = entityManager.find(Instructor.class, id);
        return instructor;

    }

    @Override
    public void deleteById(int id) {
        entityManager.remove(entityManager.find(Instructor.class, id));
    }

    @Override
    public void updateSelectInstructor(int id,Instructor instructor) {
        Instructor instructor1 = entityManager.find(Instructor.class, id);
        instructor1.setFirstName(instructor.getFirstName());
        instructor1.setLastName(instructor.getLastName());
        instructor1.setEmail(instructor.getEmail());

    }

    @Override
    public InstructorDetails findInstructorDetailsById(int id) {
        return entityManager.find(InstructorDetails.class, id);
    }

    @Override
    public void deleteInstructorDetailsById(int id) {
        InstructorDetails instructorDetails = entityManager.find(InstructorDetails.class, id);
        entityManager.remove(instructorDetails);
    }

    @Override
    public void saveCourseWithInstructor(Course course) {
        entityManager.persist(course);
    }

    @Override
    public List<Course> findAllCourses() {
        List<Course> fromCourse = entityManager.createQuery("from Course", Course.class).getResultList();
        return fromCourse;
    }

    @Override
    public Instructor findInstructorWithCourses(int instructorId) {
        Instructor instructor = entityManager.find(Instructor.class, instructorId);
        return instructor;
    }

    @Override
    public List<Course> findCoursesByInstructorId(int instructorId) {
        TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id=:data", Course.class);
        query.setParameter("data", instructorId);
        List<Course> resultList = query.getResultList();

        return resultList;
    }

    @Override
    public Instructor findInstructorByJoinFetch(int instructorId) {

        TypedQuery<Instructor> query = entityManager.createQuery(
                "SELECT i FROM Instructor i JOIN FETCH i.courses WHERE i.id = :data",
                Instructor.class
        );
        query.setParameter("data", instructorId);

        return query.getSingleResult();

    }

    @Override
    public void updateInstructor(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    public Course findCourseById(int courseId) {
        Course course = entityManager.find(Course.class, courseId);
        return course;
    }

    @Override
    public void updateSelectedCourse(Course selectedCourse) {
        entityManager.merge(selectedCourse);
    }

    @Override
    public void deleteInstructorById(int id) {
        Instructor temp_instructor = entityManager.find(Instructor.class, id);
        List<Course> courses = temp_instructor.getCourses();
        for (Course course : courses) {
            course.setInstructor(null);
        }
        entityManager.remove(temp_instructor);
    }

    @Override
    public void deleteCourseById(int id) {
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }

    @Override
    public void saveCourse(Course course) {
        entityManager.merge(course);
    }

    @Override
    public Course findCourseAndReviewById(int courseId) {
        TypedQuery<Course> query = entityManager.createQuery(
                "SELECT c FROM Course c JOIN FETCH c.reviews WHERE c.id = :courseId",
                Course.class
        );
        query.setParameter("courseId", courseId);
        Course singleResult = query.getSingleResult();
        return singleResult;
    }

    @Override
    public void deleteCourseAndReviewByCourseId(int courseId) {
        entityManager.remove(findCourseAndReviewById(courseId));
    }

    @Override
    public void createStudentAndCourse(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Course findCourseAndStudentByCourseId(int courseId) {
        TypedQuery<Course> query = entityManager.createQuery("select c from Course c join fetch c.students where c.id = :data", Course.class);
        query.setParameter("data", courseId);
        Course singleResult = query.getSingleResult();



        return singleResult;
    }

    @Override
    public Student findStudentAndCourseByStudentId(int studentId) {
        TypedQuery<Student> query = entityManager.createQuery("select s from Student s join fetch s.courses where s.id = :data", Student.class);
        query.setParameter("data", studentId);
        Student result =  query.getSingleResult();

        return  result;
    }
}
