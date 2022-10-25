package kr.inhatc.spring.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.inhatc.spring.test.dto.TestDto;

@RestController
public class TestController {
	
	@GetMapping(value = "/hello")
	public String hello() {
		return "Hello world";
	}
	@GetMapping(value = "/test")
	public TestDto test() {
		TestDto dto = new TestDto();
		dto.setAge(25);
		dto.setName("홍길동");
		return dto;
	}
}
