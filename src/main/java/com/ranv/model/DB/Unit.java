package com.ranv.model.DB;

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

    @ManyToOne
    @JoinColumn(name = "step_id")
    private Step step;

    @Column(name="unit_order")
    private int order;

    @Column(name = "unit_type")
    @Enumerated(EnumType.STRING)
    private UnitType type;

    @Column(name="unit_content")
    private String content;

}
