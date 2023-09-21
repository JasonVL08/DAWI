package com.project.consorcio.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.consorcio.entity.Medicamento;
import com.project.consorcio.entity.TipoMedicamento;
import com.project.consorcio.services.MedicamentoServices;
import com.project.consorcio.services.TipoMedicamentoServices;



//Anotaciòn que indica que la clase es un controlador, por lo tanto
//permite recibir peticiones de los clientes y envia respuesta
@Controller
//permite crear una direccion URL o RUTA para accede al controlador 
@RequestMapping("/medicamento")
public class MedicamentoController {
	@Autowired
	private MedicamentoServices servicioMed;
	
	
	@Autowired
	private TipoMedicamentoServices servicioTipo;
	
	
	@RequestMapping("/lista")
	//Model es una interfaz que permite crear atributos que luego seràn enviados
	//a la pagina
	public String index(Model model) {
		model.addAttribute("medicamentos",servicioMed.listarTodos());
		model.addAttribute("tipos",servicioTipo.listarTodos());
		return "medicamento";
	}
	
	
	//@RequestMapping, permite recuperar valores que se encuentran en los controles
	//del formulario (cajas, checkbox,radio,etc)
	@RequestMapping("/grabar")
	public String grabar(@RequestParam("codigo") Integer cod,
						 @RequestParam("nombre") String nom,
						 @RequestParam("descripcion") String des, 
						 @RequestParam("stock") int stock,
						 @RequestParam("precio") Double pre,
						 @RequestParam("fecha") String fec,
						 @RequestParam("tipo") int codTipo,
						 RedirectAttributes redirect) {
		try {
			//Crear objeto de la entidad Medicamento 
			Medicamento med= new Medicamento();
			//setear atributos del objeto "med" co nlos parametros 
			med.setNombre(nom);
			med.setDescripcion(des);
			med.setStock(stock);
			med.setPrecio(pre);
			med.setFecha(LocalDate.parse(fec));
			//Crear objeto de la entidad TipoMedicamento
			TipoMedicamento tm=new TipoMedicamento();
			//setear atributo "codigo" del objeto tm con el parametro codTipo
			tm.setCodigo(codTipo);
			
			//Invocar al metodo setTipo y enviar el objeto "tm"
			med.setTipo(tm);
			
			//Validar parametro "cod"
			if (cod==0) {
				//Invocar metodo registrar 
				servicioMed.registrar(med);
				//Crear atirbuto de tipo flash
				redirect.addFlashAttribute("MENSAJE","Medicamento Registrado");
			}
			else {
				//setear atributo "codigo"
				med.setCodigo(cod);
				servicioMed.actualizar(med);
				redirect.addFlashAttribute("MENSAJE","Medicamento Actualizado");

			}
			
			
		
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/medicamento/lista";
	}
	
	//Crear ruta o direccion URL para buscar medicamento segùn código 
	@RequestMapping("/buscar")
	@ResponseBody
	public Medicamento buscar(@RequestParam("codigo") Integer cod) {
			return servicioMed.buscarPorID(cod);
	}
	
	
	
}
