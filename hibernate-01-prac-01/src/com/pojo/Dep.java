package com.pojo;

import java.util.HashSet;
import java.util.Set;

public class Dep {
	
	private int depId;
	private String depName;
	private Set<Emp> em = new HashSet();
	
	
	public Set<Emp> getEm() {
		return em;
	}


	public void setEm(Set<Emp> em) {
		this.em = em;
	}


	public Dep() {
		// TODO Auto-generated constructor stub
	}


	public int getDepId() {
		return depId;
	}


	public void setDepId(int depId) {
		this.depId = depId;
	}


	public String getDepName() {
		return depName;
	}


	public void setDepName(String depName) {
		this.depName = depName;
	}
	
	
	

}
