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
@Table(name = "manual")
@Getter
@Setter
@NoArgsConstructor
public class Manual {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "manual_id")
    private Long id;

    @NotNull
    @Column(name = "manual_name")
    private String name;

    @Column(name = "manual_date")
    private String date;

    @Column(name = "manual_image")
    private String image;

    @Column(name="manual_intro")
    private String introduction;

    @ManyToOne
    @JoinColumn(name="manual_author")
    private User user;

    @ManyToMany
    @JoinTable(name = "manual_tag", joinColumns = @JoinColumn(name = "manual_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "manual")
    private Set<Step> steps;

    public Manual(String name, String date, String introduction, User user, Set<Tag> tags) {
        this.name = name;
        this.date = date;
        this.introduction = introduction;
        this.user = user;
        this.tags = tags;
    }
}
