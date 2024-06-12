package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.ManagerDao;
import model.entities.Manager;

public class ManagerDaoJDBC implements ManagerDao{
	private Connection conn;
	
	public ManagerDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	@Override
	public void insert(Manager obj) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(
					"INSERT INTO gerente"+
					"(Name) VALUES (?)",
					PreparedStatement.RETURN_GENERATED_KEYS
					);
			st.setString(1,obj.getName());
			st.executeUpdate();
			ResultSet rs = st.getGeneratedKeys();
			int id = rs.getInt(1);
			obj.setId(id);
			
			DB.closeResultSet(rs);
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void upDate(Manager obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Manager findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Manager> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
