package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.CambistaDao;
import model.entities.Cambista;
import model.entities.Manager;

public class CambistaDaoJDBC implements CambistaDao{
	private Connection conn;
	
	public CambistaDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	@Override
	public void insert(Cambista obj) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(
					"INSERT INTO cambista"+
					"(Name, gerenteId) VALUES (?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS
					);
			st.setString(1,obj.getName());
			st.setInt(2,obj.getGerenteId());
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
	public void upDate(Cambista obj) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Cambista findByManager(Manager manager) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
