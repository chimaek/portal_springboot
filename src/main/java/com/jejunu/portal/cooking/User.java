package com.jejunu.portal.cooking;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@Setter
@ToString
@Getter
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;

    @Column(name = "name")
    @NotEmpty(message = "이름을 입력해주세요!")
    private String name;

    @Column(name = "email")
    @Email(message = "이메일을 입력해주세요!")
    @NotEmpty(message = "이메일을 확인해주세요!")
    private String email;

    @Transient
    @NotEmpty(message = "비밀번호를 확인해주세요!")
    @Length(min = 4, message = "적어도 4글자 이상 입력해주세요!")
    @Column(name = "password")
    private String password;

    @Column(name = "active")
    private int active;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;


}
