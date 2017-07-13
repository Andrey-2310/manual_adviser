package com.ranv.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.Set;

/**
 * Created by Андрей on 13.07.2017.
 */

@Entity
@Table(name = "manual")
@Getter
@Setter
@NoArgsConstructor
public class Manual {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "manual_name")
    private String name;

    @Column(name = "manual_date")
    private Date date;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="manual_author")
    private User user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "manual")
    private Set<Step> steps;
}
