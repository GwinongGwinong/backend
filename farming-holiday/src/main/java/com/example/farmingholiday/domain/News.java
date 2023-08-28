package com.example.farmingholiday.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class News {
    @Id
    private long id;

    @Column(length = 200)
    private String title;

    @Column(length = 1000)
    private String contents;

    @Column(length = 1000)
    private String link;
}