/*
 * Created by m.krasilnikov
 */

package ru.bellintegrator.organizationapi.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_office")
public class UserOffice {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "user_id", nullable = false)
    private int user_id;

    @Column(name = "office_id", nullable = false)
    private int office_id;

    @Column(name = "primary_office", nullable = false)
    private boolean primary_office;


}
