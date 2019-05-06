/*
 * Created by m.krasilnikov
 */

package ru.bellintegrator.organizationapi.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "user_doc")
public class UserDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;

    @Column(name = "doc_code", nullable = false)
    private String doc_code;

    @Column(name = "doc_number", nullable = false)
    private String doc_number;

    @Column(name = "user_id", nullable = false)
    private int user_id;

    @Column(name = "isIdentified", nullable = false)
    private boolean isIdentified;

    @Column(name = "doc_date", nullable = false)
    private Date doc_date;

}
