package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	Environment env;

	@Test
	void contextLoads() {
		assertThat(env).isNotNull();
	}

	@Test
	void testPath() {
		assertThat(Path.of("target/embedmongo")
					   .relativize(Path.of("target/embedmongo/test"))).isEqualTo(Path.of("test"));
		assertThat(Path.of("/target/embedmongo")
					   .relativize(Path.of("/target/embedmongo/test"))).isEqualTo(Path.of("test"));

	}
}
