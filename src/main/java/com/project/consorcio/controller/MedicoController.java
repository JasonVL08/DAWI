package com.project.consorcio.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.consorcio.entity.Distrito;
import com.project.consorcio.entity.Especialidad;

import com.project.consorcio.entity.Medico;
import com.project.consorcio.entity.Sede;
import com.project.consorcio.services.DistritoServices;
import com.project.consorcio.services.EspecialidadServices;
import com.project.consorcio.services.MedicoServices;
import com.project.consorcio.services.SedeServices;

@Controller
@RequestMapping("/medico")
public class MedicoController {

	@Autowired
	private MedicoServices servicioMed;
	
	@Autowired
	private DistritoServices servicioDis;
	
	@Autowired
	private SedeServices servicioSede;
	
	@Autowired
	private EspecialidadServices servicioEspe;
	
	@RequestMapping("/lista")
	
	public String index(Model model) {
		model.addAttribute("medicos",servicioMed.listarTodos());
		model.addAttribute("distrito",servicioDis.listarTodos());
		model.addAttribute("sede",servicioSede.listarTodos());
		model.addAttribute("especialidad",servicioEspe.listarTodos());
		return "medico";
	}
	
	@RequestMapping("/grabar")
	public String guardar(@RequestParam("codigo") Integer cod,
							@RequestParam("nombre") String nom,
							@RequestParam("apellido") String ape,
							@RequestParam("fecha") String fec,
							@RequestParam("sexo") String sex,
							@RequestParam("estadoCiv") String est,
							@RequestParam("dni") String dni,
							@RequestParam("sueldo") double sueld,
							@RequestParam("especialidad") int espe,
							@RequestParam("sede") int sede,
							@RequestParam("direccion") String direccion,
							@RequestParam("distrito") int dist,
							RedirectAttributes redirect) {
		try {
			Medico med=new Medico();
			med.setNombre(nom);
			med.setApellido(ape);
			med.setFecha(LocalDate.parse(fec));
			med.setSexo(sex);
			med.setEstadoCiv(est);
			med.setDni(dni);
			med.setSueldo(sueld);
			med.setDireccion(direccion);
			
			
			Especialidad esp=new Especialidad();
			Sede sd=new Sede();
			Distrito dis=new Distrito();
			
			esp.setCodigo(espe);
			sd.setCodigo(sede);
			dis.setCodigo(dist);
			
			
			med.setEspe(esp);
			med.setSede(sd);
			med.setDist(dis);
			
			if (cod==0) {
				//Invocar metodo registrar 
				servicioMed.registrar(med);
				//Crear atirbuto de tipo flash
				redirect.addFlashAttribute("MENSAJE","Medico Registrado");
			}
			else {
				//setear atributo "codigo"
				med.setCodigo(cod);
				servicioMed.actualizar(med);
				redirect.addFlashAttribute("MENSAJE","Medico Actualizado");

			}
			
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/medico/lista";
	}
	
	@RequestMapping("/buscar")
	@ResponseBody
	public Medico buscar(@RequestParam("codigo") Integer cod) {
		return servicioMed.buscarPorID(cod);
}
	
	
}
