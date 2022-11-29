package com.spring.boot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.dto.EmpleadosDTO;
import com.spring.boot.service.EmpleadosServiceImpl;

@RestController
@RequestMapping("/empleados")
public class EmpleadosController {

	@Autowired
	public EmpleadosServiceImpl service;

	@GetMapping
	public ResponseEntity<List<EmpleadosDTO>> lista() {
		return new ResponseEntity<>(service.listar(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<EmpleadosDTO> guardar(@Valid @RequestBody EmpleadosDTO empleadosdto, BindingResult result) {
		return new ResponseEntity<>(service.guardar(empleadosdto), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<EmpleadosDTO> buscarPorId(@PathVariable("id") Long id) {
		return new ResponseEntity<>(service.buscarPorId(id), HttpStatus.NOT_FOUND);
	}

	@PutMapping("/{id}")
	public ResponseEntity<EmpleadosDTO> actualizar(@PathVariable("id") Long id,
			@Valid @RequestBody EmpleadosDTO empleadosdto) {
		EmpleadosDTO empleadosdt = service.buscarPorId(id);
		empleadosdt.setNombre(empleadosdto.getNombre());
		empleadosdt.setApellido(empleadosdto.getApellido());
		empleadosdt.setEdad(empleadosdto.getEdad());
		empleadosdt.setFecha(empleadosdto.getFecha());
		return new ResponseEntity<>(service.guardar(empleadosdt), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> eliminar(@PathVariable("id") Long id) {
		service.Eliminar(id);
		return new ResponseEntity<>("Empleado eliminado", HttpStatus.OK);
	}

}
