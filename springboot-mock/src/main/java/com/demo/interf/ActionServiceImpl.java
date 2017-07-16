package com.demo.interf;

import org.springframework.stereotype.Service;

@Service
public class ActionServiceImpl implements ActionService {

	@Override
	public String doSay(String name) {
		// TODO Auto-generated method stub
		return name;
	}

}
