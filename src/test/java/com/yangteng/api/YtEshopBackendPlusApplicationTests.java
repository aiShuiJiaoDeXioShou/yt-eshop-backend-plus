package com.yangteng.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

@SpringBootTest
class YtEshopBackendPlusApplicationTests {

	@Test
	void contextLoads() {
		final String s = DigestUtils.md5DigestAsHex("123456".getBytes());
		System.out.println(s.equals(DigestUtils.md5DigestAsHex("123456".getBytes())));
		System.out.println(s);
	}

}
