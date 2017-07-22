package com.ranv.Model.ModelDB;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;


@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @NotNull
    @Column(name = "user_name")
    private String username;

    @NotNull
    @Column(name = "user_identity")
    private String identity;

    @ManyToOne
    @JoinColumn(name="role_id", nullable=false)
    private Role role;

    @ManyToMany
    @JoinTable(name = "user_medal", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "medal_id"))
    private Set<Medal> medals;

    @OneToMany( mappedBy = "user", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private  Set<Manual> manuals;

    @OneToMany( mappedBy = "user", cascade=CascadeType.ALL)
    private  Set<Comment> comments;

    public User(String username, String identity, Role role) {
        this.username = username;
        this.identity = identity;
        this.role = role;
    }
}
