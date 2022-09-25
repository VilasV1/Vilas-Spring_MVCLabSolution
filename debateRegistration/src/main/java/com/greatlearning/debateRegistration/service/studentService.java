package com.greatlearning.debateRegistration.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greatlearning.debateRegistration.entity.student;

@Service

public interface studentService {
	public List<student> findAll();

	public void save(student theStudent);

	public void deleteById(int theId);

	public student findById(int theId);

}
