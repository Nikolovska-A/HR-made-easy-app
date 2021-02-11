package com.Nikolovska.spring.HRManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Nikolovska.spring.HRManagement.model.Items;
import com.Nikolovska.spring.HRManagement.repository.ItemsRepository;

@Service
public class ItemsService {

	@Autowired
	private ItemsRepository itemsRepository;
	
	public List<Items> getAllItems() {
		return itemsRepository.findAll();
	}
	
}
