package com.ranv.Model.ModelDB;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;



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

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="manual_id")
    private Manual manual;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "step")
    private Set<Unit> units;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "step")
    private Set<Comment> comments;
}
