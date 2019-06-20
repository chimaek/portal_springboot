package com.jejunu.portal.jmt.DB;


import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Menu {

    private final String menuName;
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

    @Builder
    public Menu(String menuName, String menuname, Member writer) {
        this.menuName = menuName;
        this.menuname = menuname;
        this.writer = writer;
    }

    public Menu(String menuName, String explain, Long price) {

        this.menuName = menuName;
        this.explain = explain;
        this.price = price;
    }
}
