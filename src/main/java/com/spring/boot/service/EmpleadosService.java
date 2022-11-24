package com.spring.boot.service;

import java.util.List;

import com.spring.boot.dto.EmpleadosDTO;

public interface EmpleadosService {

	public List<EmpleadosDTO> listar();
	public EmpleadosDTO guardar(EmpleadosDTO empleadosdto);
	public EmpleadosDTO buscarPorId(Long id);
	public EmpleadosDTO actualizar(EmpleadosDTO empleadosdto);
	public void Eliminar(Long id);
	
}
