package com.julianotorquato07.gastos;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class GastosApplicationTests {
//
//	@Test
//	public void contextLoads() {
//	}
//
//}
import org.springframework.test.context.web.WebAppConfiguration;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = GastosApplication.class)
@WebAppConfiguration
public class GastosApplicationTests {

    @Test
    public void contextLoads() {
    }

}