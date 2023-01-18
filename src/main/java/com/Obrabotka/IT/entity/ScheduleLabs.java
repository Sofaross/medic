package com.Obrabotka.IT.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "ScheduleLabs")
public class ScheduleLabs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Time startTime;

    private Time endTime;

    private String date;


    @OneToMany
    private Set<Laboratory> laboratories;


    public ScheduleLabs(){

    }

    public ScheduleLabs(int id, Time startTime, Time endTime, String date) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
    }
}
