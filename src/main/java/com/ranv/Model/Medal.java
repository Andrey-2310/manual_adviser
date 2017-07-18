package com.ranv.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;



@Entity
@Table(name = "medal")
@Getter
@Setter
@NoArgsConstructor
public class Medal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "medal_id")
    private Long id;

    @NotNull
    @Column(name = "medal_name")
    private String name;

    @NotNull
    @Column(name = "medal_text")
    private String text;

    @NotNull
    @Column(name = "medal_image")
    private byte[] image;

    @ManyToMany(mappedBy = "medals")
    private Set<User> users;

}
