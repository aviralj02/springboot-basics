package com.demo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Pdemo {
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String pwd = "demo@123";
		String encodedPwd = encoder.encode(pwd);
		
		System.out.println("EncodedPwd: "+encodedPwd);
		
		System.out.println(encoder.matches(pwd, encodedPwd));
		System.out.println(encoder.matches(pwd, "$2a$10$JOjueR26JhpZVmYIqdKodu1Oq5eGFE.WT8UM5KrkcFWPjsvEVAAxO"));
		System.out.println(encoder.matches(pwd, "$2a$10$.KHH/tBblriAEr8xYyAhSOah0kg.v.XaZoIZOc8wFT5urnwqMCpim"));
		
		
	}
}
