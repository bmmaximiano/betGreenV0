package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DB;
import db.DbException;
import model.dao.AtendenteDao;
import model.entities.Atendente;
import model.entities.Manager;

public class AtendenteDaoJDBC implements AtendenteDao {
	
	private Connection conn;
	
	public AtendenteDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	@Override
	public void insert(Atendente obj) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(
					"INSERT INTO atendente"+
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
	public void upDate(Atendente obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer Id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Atendente findById(Integer Id) {
		// TODO Auto-generated method stub
		return null;
	}

}
