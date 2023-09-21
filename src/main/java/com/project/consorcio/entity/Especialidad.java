package com.project.consorcio.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_especialidad")
public class Especialidad {
	
	@Id
	@Column(name="cod_espe")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	@Column(name="nom_espe")
	private String nombre;
	
	@JsonIgnore
	@OneToMany(mappedBy = "espe")
	private List<Medico> listaEspecialidad;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Medico> getListaEspecialidad() {
		return listaEspecialidad;
	}

	public void setListaEspecialidad(List<Medico> listaEspecialidad) {
		this.listaEspecialidad = listaEspecialidad;
	}
	
	
}
