package model.dao;

import db.DB;
import model.dao.impl.AtendenteDaoJDBC;
import model.dao.impl.CambistaDaoJDBC;
import model.dao.impl.ManagerDaoJDBC;

public class DaoFactory {

	public static ManagerDao creatManagerDao() {
		return new ManagerDaoJDBC(DB.getConnection());
	}
	
	public static AtendenteDao createAtendendeDao() {
		return new AtendenteDaoJDBC(DB.getConnection());
	}
	
	public static CambistaDao createCambistaDao() {
		return new CambistaDaoJDBC(DB.getConnection());
	}
	
	public static ApostadorDao createApostadorDao() {
		return null;
	}
}
