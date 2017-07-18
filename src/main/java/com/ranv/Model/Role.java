package com.ranv.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by Андрей on 13.07.2017.
 */
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
    private Set<User> users;

    public Role(String name){
        this.name=name;
    }
}
