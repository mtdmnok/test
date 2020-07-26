package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.dto.LoginDto;

@Service
public class LoginDao implements LoginRepository {
	@Autowired
	LoginRepository loginRepository;
	
	@Override
	public List<LoginDto> findAll() {
		return loginRepository.findAll();
	}
	
}
