package es.salesianos.edu.service;


import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;

import es.salesianos.edu.model.Name;
import es.salesianos.edu.repository.NameRepository;


@Service
public class NameService {
	@Autowired
	NameRepository repository;
	
	public boolean insertService(Name name) {
		repository.insert(name);
			return true;
	}
	public List<Name> ListName(Name name) {
		return repository.searchAll(name);
		
	}


}
