package com.codex.devserver.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoggerDaoTest {
	
	@Autowired
	private LoggerDao loggerDao;
	
	@Test
	public void findLoggerByid() {
		
	}

}
