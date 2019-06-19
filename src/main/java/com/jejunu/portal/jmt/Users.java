package com.jejunu.portal.jmt;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
@Table(name = "Users")
@Data
@ToString
@Setter
@Getter
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 255)
    private String email;

    @Column(nullable = false,length = 255)
    private String username;

    @Column(nullable = false,length = 255)
    private String password;

}
