package com.example.testing;

import com.example.testing.contoller.TestController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
class TestingApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void main() {
		TestingApplication.main(new String[]{});
	}

}
