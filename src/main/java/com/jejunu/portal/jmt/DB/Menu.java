package com.jejunu.portal.jmt.DB;


import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@Data
@ToString
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String menuname;

    @Column(length = 255)
    private String explain;

    @Column(length = 255)
    private Long price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member writer;

    public Menu(String menuname, String explain, Long price) {
        this.menuname = menuname;
        this.explain = explain;
        this.price = price;
    }
}
