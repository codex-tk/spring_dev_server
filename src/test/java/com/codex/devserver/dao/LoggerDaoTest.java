package com.codex.devserver.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.codex.devserver.domain.log.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoggerDaoTest {
	
	@Autowired
	private LoggerDao loggerDao;
	
	@Test
	public void findLoggerByid() {
		Logger logger = new Logger();
		logger.setId(100);
		logger.setInfo("TestInfo");
		logger.setName("TestLogger");
		loggerDao.save( logger );
		/*
		logger = loggerDao.findLoggerByid((long) 100);

		Assert.isTrue(logger.getId() == 100);
		Assert.isTrue(logger.getName().equals("TestInfo"));
		Assert.isTrue(logger.getInfo().equals("TestLogger"));*/
	}

}
