package model.entities;

import java.util.ArrayList;
import java.util.List;

public class Cambista extends Employ{
	private int gerenteId;
	private List<Apostador>apostadores = new ArrayList<>();
	public int getGerenteId() {
		return gerenteId;
	}
	public void setGerenteId(int gerenteId) {
		this.gerenteId = gerenteId;
	}
	public List<Apostador> getApostadores() {
		return apostadores;
	}
	public void setApostadores(List<Apostador> apostadores) {
		this.apostadores = apostadores;
	}
	
	
}
