package com.workintech.jpaProject1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "burger" , schema = "fsweb")
public class Burger {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id ;

    @Column(name = "name")
    private String name ;

    @Column(name = "price")
    private Double price ;

    @Column(name = "is_vegan")
    private Boolean isVegan ;

    @Enumerated(EnumType.STRING)
    @Column(name = "bread_type")
    private BreadType breadType;

    @Column(name = "contents")
    private String contents;
}
