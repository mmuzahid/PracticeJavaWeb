package org.my.services;

import org.springframework.stereotype.Service;

@Service
public class RootService {
	static{System.out.println("RootService");}
	public String getData() {
		return "RootService";
	}
}
