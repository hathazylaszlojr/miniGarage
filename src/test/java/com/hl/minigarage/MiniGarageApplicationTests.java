package com.hl.minigarage;

import net.serenitybdd.jbehave.SerenityStories;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class MiniGarageApplicationTests extends SerenityStories {

	@Test
	public void contextLoads() {
	}

}
