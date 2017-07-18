package com.ranv.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Андрей on 13.07.2017.
 */

@Entity
@Table(name = "comment")
@Getter
@Setter
@NoArgsConstructor
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "content_id")
    private Long id;

    @NotNull
    @Column(name = "content_video")
    private byte[] video;

    @NotNull
    @Column(name = "content_image")
    private byte[] image;

    @NotNull
    @Column(name = "content_text")
    private String text;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="unit_id")
    private Unit unit;
}
