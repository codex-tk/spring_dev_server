package com.codex.devserver;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DevServerApplicationTests {
	@Test
	public void contextLoads() {
	}
	
	static public class TypeTrait <T> {
		private Type type;
		
		public TypeTrait() {
			type = ((ParameterizedType)this.getClass()
					.getGenericSuperclass())
					.getActualTypeArguments()[0];
		}
		
		public Type getType() {
			return type;
		}
	}

	
	@Test
	public void doSomething() {
		System.out.println(realType( new TypeTrait<List<String>>() {}  ));
	}

	public <T> Type realType( TypeTrait<T> tt ) {
		return tt.getType();
	}

}
