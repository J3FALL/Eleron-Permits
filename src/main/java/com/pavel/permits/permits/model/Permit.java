package com.pavel.permits.permits.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * Created by Pavel on 21.08.2017.
 */
@Data
@Entity
@Table(name = "permit")
public class Permit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "permit_code",
            joinColumns = @JoinColumn(name = "permit_id"),
            inverseJoinColumns = @JoinColumn(name = "code_id")
    )
    private List<Code> codes;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "pass_id")
    private Pass pass;

    @Column(name = "issue_date")
    private Date issueDate;

    @Column(name = "expired_date")
    private Date expiredDate;

    @Column(name = "agreed_date")
    private Date agreedDate;
}
