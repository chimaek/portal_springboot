package com.jejunu.portal.jmt.DB;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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


}
