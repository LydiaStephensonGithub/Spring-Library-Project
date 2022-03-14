package com.lms.library.service;

import java.util.List;

public interface ServiceMethods<T> {
	
	//create
	T create(T t);
	
	//read by id
	T readById(long id);
	
	//read all
	List<T> readAll();
	
	//update
	T update(long id, T t);
	
	//delete
	boolean delete(long id);
	
}
