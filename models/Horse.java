package models;

import java.util.ArrayList;
import java.util.List;

public class Horse {

	public Horse() {
		name = "";
		age = 0;
		winNb = 0;
	}
	
	public Horse(String name) {
		this();
		this.name = name;
	}
	
	public Horse(String name,int age) {
		this();
		this.name = name;
		this.age = age;
		this.winNb = 0;
	}
	
	int winNb;
	int age;
	String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getWinNb() {
		return winNb;
	}
	public void setWinNb(int winNb) {
		this.winNb = winNb;
	}
}
