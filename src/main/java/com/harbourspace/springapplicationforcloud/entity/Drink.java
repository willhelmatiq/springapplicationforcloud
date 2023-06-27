package com.harbourspace.springapplicationforcloud.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "drink")
@Data
public class Drink {
    @Id
    @SequenceGenerator(name = "drinkSeq", sequenceName = "drink_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "drinkSeq")
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "priority")
    private int priority;

}
