package com.alexandrovskiy.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("offersDao")
public class OffersDao {
	
	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource dataSrc){
		this.jdbc = new NamedParameterJdbcTemplate(dataSrc);
	}
	
	public Offer getOffer(int id){
		
		MapSqlParameterSource params = new MapSqlParameterSource("id", id);
		
		return jdbc.queryForObject("select * from offers where id = :id", params, new RowMapper<Offer>() {

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
	
	public boolean create (Offer offer){
		
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
		
		return jdbc.update("insert into offers (name, email, text) values (:name, :email, :text)", params) == 1;
	}
	
	@Transactional
	public int[] create(List<Offer> offers) {
		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(offers.toArray());
		
		return jdbc.batchUpdate("insert into offers (name, email, text) values (:name, :email, :text)", params);
	}
	
	
	public boolean update (Offer offer){
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
		
		return jdbc.update("update offers set name=:name, email=:email, text=:text where id=:id", params) == 1;
	}
	
	
	public boolean delete(int id){
		
		MapSqlParameterSource params = new MapSqlParameterSource("id", id);
		
		return jdbc.update("delete from offers where id = :id", params) == 1;
	}
	
	
	public List<Offer> getOffers(){
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		
		return jdbc.query("select * from offers", params, new RowMapper<Offer>() {

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
	
	
/*
 	// first way of implementation - using JdbcTemplate;
 
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
