package com.simplemultidbsource.mdbs.controller;

import com.simplemultidbsource.mdbs.application.DbConfigDto;
import com.simplemultidbsource.mdbs.application.Test2Dto;
import com.simplemultidbsource.mdbs.domain.model.DbConfig;
import com.simplemultidbsource.mdbs.domain.model.Test1;
import com.simplemultidbsource.mdbs.domain.model.Test2;
import com.simplemultidbsource.mdbs.domain.model.TestCommon;
import com.simplemultidbsource.mdbs.repository.test_common.DbConfigRepository;
import com.simplemultidbsource.mdbs.repository.test1.Test1Repository;
import com.simplemultidbsource.mdbs.repository.test2.Test2Repository;
import com.simplemultidbsource.mdbs.repository.test_common.TestCommonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SimpleController {

    private final Test1Repository test1Repository;
    private final Test2Repository test2Repository;
    private final TestCommonRepository testCommonRepository;
    private final DbConfigRepository dbConfigRepository;

    @Autowired
    public SimpleController(Test1Repository test1Repository, Test2Repository test2Repository, TestCommonRepository testCommonRepository, DbConfigRepository dbConfigRepository) {
        this.test1Repository = test1Repository;
        this.test2Repository = test2Repository;
        this.testCommonRepository = testCommonRepository;
        this.dbConfigRepository = dbConfigRepository;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/string")
    public String loadString() {
        return "Simple string";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/test1")
    public List<Test1> loadTest1() {

        return test1Repository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/test2")
    public List<Test2> loadTest2() {
        return test2Repository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/testCommon")
    public List<TestCommon> loadTestCommon() {
        return testCommonRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/dbConfig")
    public List<DbConfig> loadDbConfig() {
        return dbConfigRepository.findAll();
    }
}
