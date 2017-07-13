package com.ranv.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Андрей on 13.07.2017.
 */

@Entity
@Table(name = "step")
@Getter
@Setter
@NoArgsConstructor
public class Step {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="manual_id")
    private Manual manual;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "step")
    private Set<Unit> units;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "step")
    private Set<Comment> comments;
}
