package com.demo.dao.impl;

import java.util.List;

import com.demo.bean.Message;
import com.demo.dao.MessageDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class MessageDaoImpl implements MessageDao {

	private NamedParameterJdbcTemplate jdbcTemplate;

	public NamedParameterJdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(NamedParameterJdbcTemplate	 jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Long insert(Message message) {
		try {
			String sql = "INSERT INTO message (`title`,`context`) VALUES (:title,:context)";
			// String sql =
			// "INSERT INTO message (id, `title`,`context`) VALUES ('',"
			// + message.getTitle() + "," + message.getContext() + ")";
			// // Map<String, Object> params = new HashMap<String, Object>();
			// // params.put("title", message.getTitle());
			// // params.put("context", message.getContext());

			KeyHolder keyHolder = new GeneratedKeyHolder();
			jdbcTemplate.update(sql.toString(),
					new BeanPropertySqlParameterSource(message), keyHolder);
			return keyHolder.getKey().longValue();

//			Map<String, Object> params = new HashMap<String, Object>();
//			params.put("title", "title");
//			params.put("context", "context");
//			KeyHolder keyHolder = new GeneratedKeyHolder();
//			jdbcTemplate.update(sql.toString(), params, keyHolder);
//			return keyHolder.getKey().longValue();

			// String sql =
			// "INSERT INTO message (`title`,`context`)  VALUES(?,?)";
			// jdbcTemplate.update(sql, message.getTitle(),
			// message.getContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Message> listAll() {
		String sql = "select * from message";
		List query = jdbcTemplate.query(sql, new BeanPropertyRowMapper(
				Message.class));
		return query;
	}

}
