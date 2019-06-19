package com.jejunu.portal.jmt;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Data
@Entity(name = "users")
@Getter
@Setter
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255,nullable = false)
    private String username;

    @Column(length = 255,nullable = false)
    private String email;

    @Column(length = 255,nullable = false)
    private String password;

}
