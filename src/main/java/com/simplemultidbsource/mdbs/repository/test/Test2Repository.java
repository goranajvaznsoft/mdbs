package com.simplemultidbsource.mdbs.repository.test;

import com.simplemultidbsource.mdbs.domain.model.Test2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Test2Repository extends JpaRepository<Test2, Integer> {

    Optional<Test2> findById(Integer id);

    List<Test2> findAll();
}
