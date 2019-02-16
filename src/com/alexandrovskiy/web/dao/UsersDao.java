package com.alexandrovskiy.web.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
//import org.springframework.jdbc.core.JdbcTemplate;

@Component("usersDao")
public class UsersDao {
	
	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource dataSrc){
		this.jdbc = new NamedParameterJdbcTemplate(dataSrc);
	}

	@Transactional
	public boolean create (User user){
		
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);
		
		jdbc.update("insert into users(username, password, email, enabled) values(:username, :password, :email, :enabled)", params);
		
		return jdbc.update("insert into authorities (username, authority) values (:username, :authority)", params) == 1;
	}
	
	
/**
	private JdbcTemplate jdbc;

	@Autowired
	public void setJdbc(DataSource dataSrc) {
		this.jdbc = new JdbcTemplate(dataSrc);
	}
	
	public List<Offer> getOffers(){
		String sql = "SELECT * FROM offers"; 
		return jdbc.query(sql, new RowMapper<Offer>(){

			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer offer = new Offer();
				offer.setId(rs.getInt("id"));
				offer.setName(rs.getString("name"));
				offer.setEmail(rs.getString("email"));
				offer.setText(rs.getString("text"));
				return offer;
			}
		
		});
	}
*/
}
