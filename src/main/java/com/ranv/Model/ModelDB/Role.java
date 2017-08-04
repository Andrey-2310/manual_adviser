package com.ranv.Model.ModelDB;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "role")
@Getter
@Setter
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private Long id;

    @NotNull
    @Column(name = "role_name")
    private String name;

    @OneToMany( mappedBy="role", cascade=CascadeType.ALL)
    private List<User> users;

    public Role(String name){
        this.name=name;
    }
}
