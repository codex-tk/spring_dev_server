package com.codex.devserver.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.codex.devserver.domain.log.transport.LoggerRegister;

@RestController
public class LogController {
	private final Logger logger = LoggerFactory.getLogger(LogController.class);
			
	@RequestMapping(value = "/log/logger_register" , method = RequestMethod.POST )
	public @ResponseBody LoggerRegister.Ack loggerRegister( @RequestBody LoggerRegister.Req req ) {
		logger.info(req.toString());
		LoggerRegister.Ack ack = new LoggerRegister.Ack();
		ack.id = 10;
		return ack;
	}
}
