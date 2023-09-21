package com.project.consorcio.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_medico")
public class Medico {

	@Id
	@Column(name="cod_med")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	@Column(name="nom_med")
	private String nombre;
	@Column(name="ape_med")
	private String apellido;
	@Column(name="fec_nac_med")
	private LocalDate fecha;
	@Column(name="sexo_med")
	private String sexo;
	@Column(name="est_civ_med")
	private String estadoCiv;
	@Column(name="dni_med")
	private String dni;
	@Column(name="sue_med")
	private double sueldo;
	@Column(name="dir_emp")
	private String direccion;
	
	
	@ManyToOne
	@JoinColumn(name="cod_espe")
	private Especialidad espe;
	@ManyToOne
	@JoinColumn(name="cod_sede")
	private Sede sede;
	@ManyToOne
	@JoinColumn(name="cod_dis")
	private Distrito dist;
	
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEstadoCiv() {
		return estadoCiv;
	}
	public void setEstadoCiv(String estadoCiv) {
		this.estadoCiv = estadoCiv;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public double getSueldo() {
		return sueldo;
	}
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Especialidad getEspe() {
		return espe;
	}
	public void setEspe(Especialidad espe) {
		this.espe = espe;
	}
	public Sede getSede() {
		return sede;
	}
	public void setSede(Sede sede) {
		this.sede = sede;
	}
	public Distrito getDist() {
		return dist;
	}
	public void setDist(Distrito dist) {
		this.dist = dist;
	}
	
	
}
