package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class TaskDAO {
	private static final String FETCH_SQL_BY_PERSON_ID = "SELECT description FROM task WHERE person_id = :person_id";

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	public String getAllTasksForPerson(Long personId) {
		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("person_id", personId);
		ResultSetExtractor<String> rs = new ResultSetExtractor<String>() {
			StringBuilder result = new StringBuilder("");

			@Override
			public String extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					result.append(rs.getString("description") + "\n");
				}
				return result.toString();
			}
		};
		return jdbcTemplate.query(FETCH_SQL_BY_PERSON_ID, namedParameters, rs);
	}
}
