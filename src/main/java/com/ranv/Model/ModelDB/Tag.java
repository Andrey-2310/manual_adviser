package com.ranv.Model.ModelDB;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.search.annotations.Field;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;



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
    private Set<Manual> manuals;

    public Tag(String name){
        this.name=name;
    }
}
