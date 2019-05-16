package com.simplemultidbsource.mdbs.repository.test_common;

import com.simplemultidbsource.mdbs.domain.model.TestCommon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TestCommonRepository extends JpaRepository<TestCommon, Integer> {

    Optional<TestCommon> findById(Integer id);

    List<TestCommon> findAll();
}
