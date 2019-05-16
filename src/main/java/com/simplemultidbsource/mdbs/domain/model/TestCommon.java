package com.simplemultidbsource.mdbs.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "TestCommon")
@Table(name = "test_common")
public class TestCommon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @Column(length = 16)
    private String name;

    public TestCommon() {
    }

    public TestCommon(String name) {
        this.name = name;
    }
}
