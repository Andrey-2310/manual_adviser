package com.ranv.model.DB;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.search.annotations.Field;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


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
    @Field
    private String username;


    @Column(name = "user_identity")
    private String identity;

    @Column(name = "user_image")
    private String image;

    @Column(name = "user_joined")
    private String date;

    @Column(name = "user_origin")
    private String origin;

    @Column(name = "user_sub")
    private String sub;

    @Column(name = "user_role")
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @ManyToMany
    @JoinTable(name = "user_medal", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "medal_id"))
    private List<Medal> medals;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Manual> manuals;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Comment> comments;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Rating> ratings;

//    @Transient
//    private CloudinaryService cloudinaryService;
//
//    @Autowired
//    public void setCloudinaryService(CloudinaryService cloudinaryService) {
//        this.cloudinaryService = cloudinaryService;
//    }

    public User(String username, UserRole role, String image, String sub) {
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.username = username;
        this.role = role;
        this.sub = sub;
        this.image = image;
        this.date = sdf.format(dt);
    }


}
