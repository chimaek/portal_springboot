package com.jejunu.portal.jmt.DB;


import lombok.*;

import javax.persistence.*;

@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    @Column(nullable = false, length = 255)
    private String menuname;

    @Column(length = 255)
    private Long price;

    @Column(length = 255)
    private String content;

    public Menu(String menuname, Long price, String content) {
        this.menuname = menuname;
        this.price = price;
        this.content = content;
    }
}
