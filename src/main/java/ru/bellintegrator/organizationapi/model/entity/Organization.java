package ru.bellintegrator.organizationapi.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "organization")
public class Organization {

    @Id
    @SequenceGenerator(name="seq_PK",sequenceName="ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_PK")
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "inn", length = 12, nullable = false)
    private String inn;

    @Column(name = "isActive", nullable = false)
    private boolean isActive;

    @Column(name = "fullName", nullable = false)
    private String fullName;

    @Column(name = "kpp", length = 9, nullable = false)
    private String kpp;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phone", unique = true)
    private String phone;

    @Version
    private int version;


}
