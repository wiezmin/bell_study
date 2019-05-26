package ru.bellintegrator.organizationapi.model.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

//TODO: Сделать foreign key
@Builder
@Data
@Entity
@Table(name = "office")
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone", unique = true)
    private String phone;

    @Column(name = "isActive", nullable = false)
    private boolean isActive;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "orgId", nullable = false)
    private int orgId;

    @Version
    private int version;

}
