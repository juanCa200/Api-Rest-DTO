package com.spring.boot.service;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.dto.EmpleadosDTO;
import com.spring.boot.entity.Empleados;
import com.spring.boot.repository.EmpleadosRepository;

@Service
public class EmpleadosServiceImpl implements EmpleadosService {

	@Autowired
	public EmpleadosRepository repository;

	@Autowired
	public ModelMapper mapear;

	@Override
	public List<EmpleadosDTO> listar() {
		return repository.findAll().stream().map(this::MapearEntidad).collect(Collectors.toList());
	}

	@Override
	public EmpleadosDTO guardar(EmpleadosDTO empleadosdto) {
			Empleados empleados = MapearDTO(empleadosdto);
			Empleados guardar = repository.save(empleados);
			return MapearEntidad(guardar);
	}

	@Override
	public EmpleadosDTO buscarPorId(Long id) {
		Empleados empleados = repository.findById(id).get();
		EmpleadosDTO empleadosdto = MapearEntidad(empleados);
		return empleadosdto;
	}

	@Override
	public EmpleadosDTO actualizar(EmpleadosDTO empleadosdto) {
		Empleados empleados = MapearDTO(empleadosdto);
		Empleados guardar = repository.save(empleados);
		return MapearEntidad(guardar);
	}

	@Override
	public void Eliminar(Long id) {
		repository.deleteById(id);
	}

	public EmpleadosDTO MapearEntidad(Empleados empleados) {
		EmpleadosDTO empleadosdto = mapear.map(empleados, EmpleadosDTO.class);
		return empleadosdto;
	}

	public Empleados MapearDTO(EmpleadosDTO empleadosdto) {
		Empleados empleados = mapear.map(empleadosdto, Empleados.class);
		return empleados;
	}

}
