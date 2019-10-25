package com.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.app.bo.EmployeeBO;

public class EmployeeDAO {
	private static final String GET_EMP_NAME_QUERY="SELECT ENAME FROM EMP20 WHERE EMPNO=:empno";
	private static final String GET_EMP_DETAILS_BY_NO_QUERY="SELECT EMPNO, ENAME JOB,SAL FROM EMP20 WHERE EMPNO=:empno";
	private static final String GET_EMP_INSERT_QUERY="INSERT INTO EMP20 (EMPNO, ENAME,JOB ,SAL  ) VALUES(:eno,:ename,:job,:salary)";
	
	private NamedParameterJdbcTemplate njt;

	public void setNjt(NamedParameterJdbcTemplate njt) {
		this.njt = njt;
	}
 
	
	public String findName(int empno) {
	  //find prepare value
		String name=null;
		try {
			
	  Map<String, Object> map=new HashMap<String, Object>();
	  map.put("empno",empno);
	  //execute query
	   name=njt.queryForObject(GET_EMP_NAME_QUERY, map, String.class);
		}
		catch(EmptyResultDataAccessException e) {
			e.printStackTrace();
			
		}
		return name;
  }
	
	
	public EmployeeBO findEmpDetails(int empno) { 
		//prepare param value
		MapSqlParameterSource params=new MapSqlParameterSource ();
		params.addValue("empno",empno);
		//execute query
		EmployeeBO bo=njt.queryForObject(GET_EMP_DETAILS_BY_NO_QUERY, params,new EmpRowMapper());
		
		return bo;
		
	}
	
	private static final class EmpRowMapper implements RowMapper<EmployeeBO>
	{

		@Override
		public EmployeeBO mapRow(ResultSet rs, int pos) throws SQLException {
			
			//store resultset object into bo class
			EmployeeBO bo=new EmployeeBO(rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getFloat(4));
			return bo;
		}
		
	}
	public int insertRecored(EmployeeBO bo) {
		//prepare param value
		BeanPropertySqlParameterSource params=new BeanPropertySqlParameterSource(bo);
		int result=njt.update(GET_EMP_INSERT_QUERY, params);
		return result;
		
	}
}
