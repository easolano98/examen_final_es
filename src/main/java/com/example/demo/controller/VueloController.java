package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.VueloSencillo;
import com.example.demo.service.IGestorVuelosService;


@Controller
@RequestMapping("/productos")
public class VueloController {
	
	@Autowired
	private IGestorVuelosService gestorVuelosService;
	

	@GetMapping("/buscarVuelos")
	public String buscarTodos(VueloSencillo vuelo,Model modelo) {
		List<VueloSencillo>vuelos=this.gestorVuelosService.consultaDisponibles(vuelo.getOrigen(), vuelo.getDestino(), LocalDateTime.parse(vuelo.getFecha().concat("T00:00:00")));
		modelo.addAttribute("vuelos",vuelos);
		return "vistaVuelos";
	}
	
	
	
	
	
	
	
	
	
}
