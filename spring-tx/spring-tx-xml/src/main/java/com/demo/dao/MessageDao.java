package com.demo.dao;

import java.util.List;

import com.demo.bean.Message;

public interface MessageDao {

	Long insert(Message message);

	List<Message> listAll();
}
