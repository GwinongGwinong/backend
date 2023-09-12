package com.example.farmingholiday.domain;

import com.example.farmingholiday.dto.UserType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Setter
    @Column(nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private UserType userType = UserType.GUEST;
    /*김용빈 : 제 개인적인 견해로는 미래를 생각해서 이런식으로 host와 guest를 나누는 것보다 host와 user domain을 따로 만드는 것이 좋아보입니다.
    * 왜냐하면 리뷰 갯수나, 좋아요를 누른 패키지, 집 등등 유저 개인정보를 제외하곤 호스트와 겹치는 부분이 그렇게 많아 보이지 않습니다.
    */
    @Setter
    @Column(nullable = false, length = 50)
    private String email;

    @Setter
    @Column(nullable = false, length = 50)
    private String password;

    @Setter
    @Column(nullable = false, length = 50)
    private String name;

    @Setter
    @Column(nullable = false)
    private String birth;

    @Setter
    @Column(length = 50)
    private String phoneNumber;

    @Setter
    @Column(nullable = false, length = 50)
    private String address;

    @Setter
    @Column(length = 100)
    private String detailAddress;

    @Setter
    @Column(nullable = false, length = 200)
    private String imagePath;


    public Users(UserType userType, String email, String password, String name, String birth, String phoneNumber, String address, String detailAddress, String imagePath) {
        this.userType = userType;
        this.email = email;
        this.password = password;
        this.name = name;
        this.birth = birth;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.detailAddress = detailAddress;
        this.imagePath = imagePath;
    }

    public Users() {}

    public static Users of(UserType userType, String email, String password, String name, String birth, String phoneNumber, String address, String detailAddress, String imagePath) {
        return new Users(userType, email, password, name, birth, phoneNumber, address, detailAddress, imagePath);
    }
}