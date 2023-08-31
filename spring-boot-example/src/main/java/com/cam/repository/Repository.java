package com.cam.repository;

import java.util.List;

public interface Repository <T> {
	
	public List<T> find(T arg);
	
	public List<T> findAll(T arg);
	
	public void add(T arg);
	
	public void add(List<T> args);
	
	public void update(T arg);
	
	public void delete(int id);

}
