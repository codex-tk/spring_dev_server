package com.codex.devserver.domain.log.transport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class LoggerRegister {
	@JsonInclude(Include.NON_NULL)
	static public class Req{
		public String name;
		public String info;
		
		@Override
		public String toString() {
			return "Name : " + name +  ", Info : " + info;
		}
	}
	
	@JsonInclude(Include.NON_NULL)
	static public class Ack{
		public long id;
	}
}
