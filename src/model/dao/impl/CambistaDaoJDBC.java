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
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("UPDATE cambista SET"+
									   "(Name, gerenteId) VALUES (?, ?)"
									   + "WHERE Id = ?");
			st.setString(1, obj.getName());
			st.setInt(2, obj.getGerenteId());
			st.setInt(3, obj.getId());
			
			st.executeUpdate();
			
			int rowsAffected =st.executeUpdate();
			System.out.println("Update rows: " + rowsAffected);
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
	}
	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cambista findByID(Integer Id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"SELECT * FROM cambista WHERE Id = ?"				
					);
			st.setInt(1, Id);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				Cambista cambista = new Cambista();
				cambista.setId(rs.getInt("Id"));
				cambista.setName(rs.getString("Name"));
				cambista.setGerenteId(rs.getInt("gerenteId"));
				DB.closeResultSet(rs);
				return cambista;				
			}
			return null;
		}
		catch (SQLException e) {
			throw new DbException (e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			
		}
		
	}
	@Override
	public Cambista findByManagerId(Integer gerenteId) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"SELECT FROM cambista WHERE gerenteId = ?"
					);
			st.setInt(1, gerenteId);			
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				Cambista cambista = new Cambista();
				cambista.setGerenteId(rs.getInt("Id"));
				cambista.setName(rs.getString("Name"));
				cambista.setGerenteId(rs.getInt("gerenteId"));
				return cambista;
			}
			return null;
		}
		catch (SQLException e) {
			throw new DbException (e.getMessage());
		}
	}

	
}
