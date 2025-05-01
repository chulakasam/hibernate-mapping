package lk.ijse.mappingonetomany;

import lk.ijse.mappingonetomany.dao.AppDAO;
import lk.ijse.mappingonetomany.entity.Course;
import lk.ijse.mappingonetomany.entity.Instructor;
import lk.ijse.mappingonetomany.entity.InstructorDetails;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class MappingOneToManyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MappingOneToManyApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(AppDAO appDAO) {
        return runner -> {
            //createInstructorWithCourses(appDAO);
            //getAllCoursesWithInstructor(appDAO);
            //findInstructorWithCourses(appDAO);
            //findCoursesByInstructorId(appDAO);
            //findInstructorWithCoursesJoinFetch(appDAO);//this method run in join query with fetch
            //updateInstructor(appDAO);

            //updateCourse(appDAO);
            deleteSpecificInstructor(appDAO);
        };
    }

    private void deleteSpecificInstructor(AppDAO appDAO) {
        appDAO.deleteInstructorById(1);
    }

    private void updateCourse(AppDAO appDAO) {
        int courseId = 10;
        Course selected_course = appDAO.findCourseById(courseId);
        selected_course.setTitle("enjoy simple things");
        appDAO.updateSelectedCourse(selected_course);
    }

    private void updateInstructor(AppDAO appDAO) {
        int id=1;
        Instructor temp_instructor = appDAO.findById(id);
        temp_instructor.setLastName("tester");
        temp_instructor.setFirstName("paul");
        appDAO.updateInstructor(temp_instructor);
    }

    private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
        int instructorId = 1;
        Instructor temp_instructor = appDAO.findInstructorByJoinFetch(instructorId);
        System.out.println("the  associated courses :"+temp_instructor.getCourses());
    }

    private void findCoursesByInstructorId(AppDAO appDAO) {
        int instructorId = 1;
        Instructor instructorWithCourses = appDAO.findInstructorWithCourses(instructorId);
        List<Course> coursesByInstructorId = appDAO.findCoursesByInstructorId(instructorId);
        instructorWithCourses.setCourses(coursesByInstructorId);
        System.out.println("courses"+instructorWithCourses.getCourses());
    }

    private void findInstructorWithCourses(AppDAO appDAO) {
        int instructorId = 1;
        Instructor instructorWithCourses = appDAO.findInstructorWithCourses(instructorId);
        System.out.println(instructorWithCourses);
        //System.out.println(instructorWithCourses.getCourses());--->lazy fetch karala tibboth courses retrieve karanne na.denne parent table eka witarai.
        //eager fetching dila tibboth courses tikath retrieve karanawa.parent and their all children.

    }

    private void getAllCoursesWithInstructor(AppDAO appDAO) {
        List<Course> allCourses = appDAO.findAllCourses();
        for (Course course : allCourses) {
            System.out.println("Course ID: " + course.getId()+' '+course.getTitle()+' '+course.getInstructor());
        }
    }

    private void createInstructorWithCourses(AppDAO appDAO) {
        InstructorDetails details = new InstructorDetails();
        details.setYouTubeChannel("youtube.com/john");
        details.setHobby("Guitar");


        Instructor instructor = new Instructor();
        instructor.setFirstName("John");
        instructor.setLastName("Doe");
        instructor.setEmail("john.doe@example.com");
        instructor.setInstructorDetails(details);

        Course course = new Course();
        course.setTitle("Music training");
        course.setInstructor(instructor);

        appDAO.saveCourseWithInstructor(course);

    }

}
