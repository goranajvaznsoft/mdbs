package com.simplemultidbsource.mdbs.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "Test2")
@Table(name = "test2")
public class Test2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @Column(length = 16)
    private String name;

    public Test2() {
    }

    public Test2(String name) {
        this.name = name;
    }
}
