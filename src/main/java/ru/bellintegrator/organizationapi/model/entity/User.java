package ru.bellintegrator.organizationapi.model.entity;

import lombok.Data;

import javax.persistence.*;

//TODO: Сделать foreign key
@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "secondName", nullable = false)
    private String secondName;

    @Column(name = "middleName")
    private String middleName;

    @Column(name = "phone", unique = true)
    private String phone;

    @Column(name = "citizenship", nullable = false)
    private String citizenship;

    @Column(name = "position", nullable = false)
    private int position;

    @Version
    private int version;
    
}
