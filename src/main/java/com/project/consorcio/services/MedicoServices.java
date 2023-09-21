package com.project.consorcio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.consorcio.entity.Medico;
import com.project.consorcio.repository.MedicoRepository;

@Service
public class MedicoServices {

	@Autowired
	private MedicoRepository repo;
	
	public void registrar(Medico med) {
		repo.save(med);
	}
	public void actualizar(Medico med) {
		repo.save(med);
	}
	public void eliminarPorID(Integer cod) {
		repo.deleteById(cod);
	}
	public Medico buscarPorID(Integer cod){
		return repo.findById(cod).orElse(null);
	}
	public List<Medico> listarTodos(){
		return repo.findAll();
	}
}
