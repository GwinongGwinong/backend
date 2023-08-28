package com.example.farmingholiday.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Entity
public class Hashtag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Setter
    @ManyToOne(optional = false)
    private Host host;

    // TODO : key Column은 무엇인지 파악하지 못함 -> 실수로 들어간 것입니다 ^^; ERD에서 삭제했습니다.

    @Setter
    @Column(length = 200)
    private  String Content;
}
