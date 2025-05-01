package lk.ijse.manytomany.entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructor")
@NoArgsConstructor
@AllArgsConstructor
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    // this is the foreign key column in instructor
    @OneToOne(cascade = CascadeType.ALL )
    @JoinColumn(name="instructor_detail_id")
    private InstructorDetails instructorDetails;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "instructor", cascade = {CascadeType.DETACH,CascadeType.MERGE,
            CascadeType.REFRESH,CascadeType.PERSIST})
    private List<Course> courses ;

    // add convenience method for bi directional
    public void add(Course course){
        if(courses == null){
            courses = new ArrayList<>();
        }
        courses.add(course);
        course.setInstructor(this);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public InstructorDetails getInstructorDetails() {
        return instructorDetails;
    }

    public void setInstructorDetails(InstructorDetails instructorDetails) {
        this.instructorDetails = instructorDetails;
    }

}
