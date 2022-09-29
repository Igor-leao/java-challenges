package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.List;

@Entity
@EntityListeners(EntityListeners.class)
public class acceleration {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @NotNull
    @Size(max = 100)
    private  String name;

    @NotNull
    @Size(max =50)
    private String slug;

    @NotNull
    @CreatedDate
    private Timestamp createdAt;

    @ManyToOne
    public challenge challenge;

    @OneToMany
    public List<candidate> candidates;
}
