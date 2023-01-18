package com.Obrabotka.IT.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@Table(name = "laboratory")
public class Laboratory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int price;
    private String type_analysis;

    private int laboratory;

    @Getter
    @Setter
    @ManyToOne
    private ScheduleLabs scheduleLabsId;


    public Laboratory(){}
    public Laboratory(Long id, ScheduleLabs scheduleLabsId, String type_analysis, int price,int laboratory){
        this.id = id;
        this.scheduleLabsId = scheduleLabsId;
        this.type_analysis = type_analysis;
        this.price = price;
        this.laboratory=laboratory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



}
