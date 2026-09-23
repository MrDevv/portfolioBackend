package com.mrdevv.portfolioBackend;

import com.mrdevv.portfolioBackend.config.TestContainerConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

@Import(TestContainerConfiguration.class)
@ActiveProfiles("test")
@SpringBootTest
class PortfolioBackendApplicationTests {

	@Test
	void contextLoads() {
	}

}
