package application;

import model.dao.AtendenteDao;
import model.dao.CambistaDao;
import model.dao.DaoFactory;
import model.dao.ManagerDao;
import model.entities.Atendente;
import model.entities.Cambista;
import model.entities.Manager;

public class Program {

	public static void main(String[] args) {
		
		/*Inserindo novo gerente ao banco de dados
		ManagerDao managerDao = DaoFactory.creatManagerDao();
		Manager manager = new Manager();
		manager.setName("GerenteVinicius");
		managerDao.insert(manager);
		
		//Inserindo novo Atendente
		AtendenteDao atendenteDao = DaoFactory.createAtendendeDao();
		Atendente atendente = new Atendente();
		atendente.setName("Ronaldo");
		atendenteDao.insert(atendente);
		*/
		//Inserindo novo Atendente
		CambistaDao cambistaDao = DaoFactory.createCambistaDao();
		Cambista cambista = new Cambista();
		cambista.setName("CambistaVinicius");
		cambista.setGerenteId(3);
		cambistaDao.insert(cambista);
		System.out.println("Cambista in");
		}
	
}
