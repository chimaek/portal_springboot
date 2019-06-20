package com.jejunu.portal.jmt.DB;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255, unique = true)
    private String uid;

    @Column(nullable = false, length = 255)
    private String username;

    @Column(nullable = false, length = 255)
    private String password;

    @Builder
    public Member(String uid, String password,String username) {
        this.uid = uid;
        this.password = password;
        this.username=username;
    }
    @Builder
    public Member(String uid){
        this.uid=uid;
    }
}


