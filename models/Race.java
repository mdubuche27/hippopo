package models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Race {

	List<Horse> horses;
	String name;
	LocalDateTime date;
	
	public Race() {
		horses = new ArrayList<Horse>();
		name ="";
		date = LocalDateTime.now();
	}
	
	public Race(String name, LocalDateTime date, List<Horse> horses) {
		this();
		this.name = name;
		this.horses = horses;
		this.date = date;
	}

	
	public List<Horse> getHorses() {
		return horses;
	}
	public void setHorses(List<Horse> horses) {
		this.horses = horses;
	}
	
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
