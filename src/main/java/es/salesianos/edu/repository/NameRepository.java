package es.salesianos.edu.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import es.salesianos.edu.model.Name;


	@Service
	public class NameRepository {
		
	public void insert(Name author) {
		ArrayList<Name> edu= new ArrayList<Name>();
			edu.add(author);
				}
	
	public List<Name> searchAll(Name author) {
		List<Name> list = new ArrayList();
		if (author.getName() != null) {
			Name author1 = new Name();
			author1.setName("Bat");
			author1.setSubname("Herrera");
			author1.setYearBorn(1);
			
			list.add(author1);
			
		}

		return list;
	}
	}
