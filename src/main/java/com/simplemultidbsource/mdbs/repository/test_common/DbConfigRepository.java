package com.simplemultidbsource.mdbs.repository.test_common;

import com.simplemultidbsource.mdbs.domain.model.DbConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DbConfigRepository extends JpaRepository<DbConfig, Integer> {

    Optional<DbConfig> findById(Integer id);

    List<DbConfig> findAll();
}
