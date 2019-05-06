package ru.bellintegrator.organizationapi.model.entity.classifiers;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "title")
public class Title {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;

    @Column(name = "title_name", nullable = false)
    private String title_name;

}
