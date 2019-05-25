package com.projeto.generico.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.generico.domain.Categoria;
import com.projeto.generico.repositories.CategoriaRepository;
import com.projeto.generico.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	// Vai ser automaticamente instaciada pelo spring
	private CategoriaRepository repo;

	public Categoria find(Integer id) {

		Optional<Categoria> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não entrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

	public Categoria insert(Categoria obj){
		obj.setId(null);
		return repo.save(obj);
	}

	public Categoria update(Categoria obj){
		find(obj.getId());
		return repo.save(obj);
	}
}
