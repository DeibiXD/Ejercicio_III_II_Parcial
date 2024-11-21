package hn.unah.poo.ejercio_3.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.unah.poo.ejercio_3.modelos.empleado;

public interface empleadoRepositorio extends JpaRepository<empleado,String> {   
}
