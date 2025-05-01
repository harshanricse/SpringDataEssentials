package com.infy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoSpringOrmApplicationTests {

	@Test
	void contextLoads() {
		
		Object actual = new Object();
		Assertions.assertNotNull(actual);
		
	}

}
