package com.ranv.model.DB;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.search.annotations.Field;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@Table(name = "tag")
@Getter
@Setter
@NoArgsConstructor
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tag_id")
    private Long id;

    @NotNull
    @Column(name = "tag_name")
    @Field
    private String name;


    @ManyToMany(mappedBy = "tags")
    private List<Manual> manuals;

    public Tag(String name){
        this.name=name;
    }
}
