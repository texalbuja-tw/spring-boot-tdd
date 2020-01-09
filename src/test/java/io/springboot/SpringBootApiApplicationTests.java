package io.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.text.NumberFormat;

@SpringBootTest
class SpringBootApiApplicationTests {

	@Autowired
	private ApplicationContext ctx;

	@Autowired
	@Qualifier("defaultCurrencyFormat")
	private NumberFormat nf;

	@Test
	public void defaultConcurrency(){
		double amount = 12345678.901234;
		NumberFormat detschNF = ctx.getBean("germanCurrencyFormat", NumberFormat.class);
		System.out.println(nf.format(amount));
	}

	@Test
	void contextLoads() {
		int count = ctx.getBeanDefinitionCount();
		System.out.println("There are " + count + " beans in the " +
				"application context");
	}

}
