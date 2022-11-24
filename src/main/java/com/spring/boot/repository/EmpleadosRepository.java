package com.spring.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.entity.Empleados;

public interface EmpleadosRepository extends JpaRepository<Empleados,Long> {

}
