package model.entities;

import java.util.ArrayList;
import java.util.List;

public class Cambista extends Employ{
	private int gerenteId;
	
	public int getGerenteId() {
		return gerenteId;
	}
	public void setGerenteId(int gerenteId) {
		this.gerenteId = gerenteId;
	}
	@Override
	public String toString() {
		return String.format("%d; %s, %d", super.getId(), super.getName(), getGerenteId());
	}
	
	
	
}
