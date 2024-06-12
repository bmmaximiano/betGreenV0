package model.dao;

import model.entities.Apostador;

public interface ApostadorDao {
	void insert(Apostador obj);
	void upDate(Apostador obj);
	void deletebyId(Integer id);
	Apostador findById(Integer id);
}
