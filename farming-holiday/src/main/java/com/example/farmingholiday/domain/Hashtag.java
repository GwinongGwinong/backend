package com.example.farmingholiday.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Entity
public class Hashtag {
    @Id
    private long id;

    @Setter
    @ManyToOne(optional = false)
    private Host hostId;

    // TODO : key Column은 무엇인지 파악하지 못함

    @Setter
    @Column(length = 200)
    private  String Content;
}
