package com.ranv.model.DB;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@Table(name = "manual")
@Getter
@Setter
@NoArgsConstructor
@Indexed

public class Manual {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "manual_id")
    private Long id;

    @NotNull
    @Column(name = "manual_name")
    @Field
    private String name;

    @Column(name = "manual_date")
    private String date;

    @Column(name = "manual_image")
    private String image;

    @Column(name="manual_intro")
    @Field
    private String introduction;

    @Column(name="manual_published")
    boolean published;

    @Column(name="manual_rating")
    int rating;

    @ManyToOne
    @JoinColumn(name="manual_author")
    @IndexedEmbedded
    private User user;

    @ManyToMany
    @JoinTable(name = "manual_tag", joinColumns = @JoinColumn(name = "manual_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    @IndexedEmbedded
    private List<Tag> tags;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "manual")
    @IndexedEmbedded
    private List<Step> steps;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "manual")
    private List<Rating> ratings;

    public Manual(String name, String date, String introduction, User user, List<Tag> tags, String image) {
        this.name = name;
        this.date = date;
        this.introduction = introduction;
        this.user = user;
        this.tags = tags;
        this.image=image;
    }
}
