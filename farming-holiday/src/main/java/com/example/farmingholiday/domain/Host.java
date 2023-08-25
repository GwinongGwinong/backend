package com.example.farmingholiday.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Entity
public class Host {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Setter
    @Column(nullable = false, length = 50)
    private String username;

    @Setter
    @OneToMany(orphanRemoval = false)
    private List<Hashtag> hashtags;

    @Setter
    @OneToMany
    private List<House> houses;

    @Setter
    @Column(name = "review_count")
    private long reviewCount;

    @Setter
    @Column(length = 10000)
    private String detail;
}
