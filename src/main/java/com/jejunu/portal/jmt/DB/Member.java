package com.jejunu.portal.jmt.DB;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
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


    public Member(String username, String uid, String password) {
        this.uid = this.uid;
        this.password = this.password;
        this.username = this.username;
    }

    public Member(String uid) {
        this.uid = uid;
    }

}


