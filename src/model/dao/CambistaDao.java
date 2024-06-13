package model.dao;

import model.entities.Cambista;
import model.entities.Manager;

public interface CambistaDao {
	void insert (Cambista obj);
	void upDate (Cambista obj);
	void deleteById (Integer id);
	Cambista findByID(Integer Id);
	Cambista findByManagerId(Integer gerenteId);
}
