package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="instructor_detail")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class InstructorDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name ="youtube_channel")
    private String youTubeChannel;

    @Column(name = "hobby")
    private String hobby;

}
