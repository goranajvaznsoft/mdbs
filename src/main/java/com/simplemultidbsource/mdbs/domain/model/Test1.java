package com.simplemultidbsource.mdbs.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "Test1")
@Table(name = "test1")
public class Test1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @Column(length = 16)
    private String name;

    public Test1() {
    }

    public Test1(String name) {
        this.name = name;
    }
}
