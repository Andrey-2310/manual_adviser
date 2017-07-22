package com.ranv.Model.ModelDB;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "unit")
@Getter
@Setter
@NoArgsConstructor
public class Unit {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "unit_id")
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="step_id")
    private Step step;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "unit")
    private Set<Content> contents;

}
