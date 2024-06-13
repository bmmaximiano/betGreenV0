package application;

import java.util.Scanner;

import model.dao.CambistaDao;
import model.dao.DaoFactory;
import model.dao.impl.CambistaDaoJDBC;
import model.entities.Cambista;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CambistaDao cambistaDao = DaoFactory.createCambistaDao();
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
		/*CambistaDao cambistaDao = DaoFactory.createCambistaDao();
		Cambista cambista = new Cambista();
		cambista.setName("CambistaVinicius");
		cambista.setGerenteId(3);
		cambistaDao.insert(cambista);
		System.out.println("Cambista in");
		
		*/
		
		//Atualizando cambista
		System.out.println("Enter ID to update");
		int idUpdate = sc.nextInt();		
		Cambista cambista = cambistaDao.findByID(idUpdate);
		System.out.println(cambista);
		}
	
}
