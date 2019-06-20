package com.jejunu.portal.jmt.DB;


import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false,length = 255)
    String menuname;

    @Column(length = 255)
    String explain;

    @Column(length = 255)
    Long price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member writer;

    @Builder
    public  Menu(String menuname,Member writer){
        this.menuname = menuname;
        this.writer = writer;
    }

}
