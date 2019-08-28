package com.dj.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
public class DemoRestController {

	@GetMapping("/hello")
	String sayHello() {
		return "Hellooooo";
	}
}
