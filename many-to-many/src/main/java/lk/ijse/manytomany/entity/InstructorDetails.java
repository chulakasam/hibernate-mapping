package lk.ijse.manytomany.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="instructor_detail")
@NoArgsConstructor
@AllArgsConstructor

public class InstructorDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name ="youtube_channel")
    private String youTubeChannel;
    @Column(name = "hobby")
    private String hobby;

    @OneToOne(mappedBy = "instructorDetails",cascade = CascadeType.ALL)
    private Instructor instructor;
    //this field add to solve unidirectional issues (to bi directional)




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYouTubeChannel() {
        return youTubeChannel;
    }

    public void setYouTubeChannel(String youTubeChannel) {
        this.youTubeChannel = youTubeChannel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    }
