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
@Table(name = "medal")
@Getter
@Setter
@NoArgsConstructor
public class Medal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @ManyToMany(mappedBy = "medal")
    private Set<User> users;

}
