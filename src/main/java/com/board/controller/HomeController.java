package com.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	// http://localhost:9090
	@RequestMapping("/")		// 여기 '/' 부른 이후 다른 곳에서 동일한 주소('/')를 호출해선 안됨 -> 부딪힘
	public String home() {
		return "home";
	}
	
}
