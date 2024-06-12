package model.dao;

import model.entities.Atendente;

public interface AtendenteDao {
	void insert(Atendente obj);
	void upDate(Atendente obj);
	void deleteById(Integer Id);
	Atendente findById(Integer Id);
}
