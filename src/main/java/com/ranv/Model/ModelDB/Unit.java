package com.ranv.Model.ModelDB;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "step_id")
    private Step step;

    @Column(name="step_order")
    private int order;

    @Column(name = "unit_type")
    @Enumerated(EnumType.STRING)
    private UnitType type;

    @Column(name="unit_content")
    private String content;

}
