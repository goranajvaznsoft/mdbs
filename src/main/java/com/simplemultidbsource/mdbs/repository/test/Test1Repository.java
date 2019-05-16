package com.simplemultidbsource.mdbs.repository.test;

import com.simplemultidbsource.mdbs.domain.model.Test1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Test1Repository extends JpaRepository<Test1, Integer> {

    Optional<Test1> findById(Integer id);

    List<Test1> findAll();
}
