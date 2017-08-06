package com.ranv.model.DB;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.search.annotations.Field;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "step")
@Getter
@Setter
@NoArgsConstructor
public class Step {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "step_id")
    private Long id;

    @Column(name="step_name")
    @Field
    private String name;

    @Column(name="step_order")
    private int order;

    @ManyToOne
    @JoinColumn(name="manual_id")
    private Manual manual;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "step")
    private List<Unit> units;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "step")
    private List<Comment> comments;
}
