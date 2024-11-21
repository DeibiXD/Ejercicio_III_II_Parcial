package hn.unah.poo.ejercio_3.servicios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.poo.ejercio_3.dtos.AgregarHisPaDTOaEmp;
import hn.unah.poo.ejercio_3.dtos.historicoPagosDTO;
import hn.unah.poo.ejercio_3.dtos.pagoFechaEspecifica;
import hn.unah.poo.ejercio_3.modelos.empleado;
import hn.unah.poo.ejercio_3.modelos.historicoPagos;
import hn.unah.poo.ejercio_3.repositorios.empleadoRepositorio;
import hn.unah.poo.ejercio_3.repositorios.historicoPagosRepositorio;

@Service
public class historicoPagosServicio {
    @Autowired
    private historicoPagosRepositorio historicoPagosRepositorioUSO;

    @Autowired
    private empleadoRepositorio empleadoRepositorioUSO;

    private ModelMapper modelMapper;

    public List<historicoPagosDTO> obtenerHistoricoPagosFechaEspecifica(pagoFechaEspecifica pagoFechaEspecificaUSO) {
        if(empleadoRepositorioUSO.existsById(pagoFechaEspecificaUSO.getIdEmpleado())){
            empleado empleadoParaAnalisis = empleadoRepositorioUSO.findById(pagoFechaEspecificaUSO.getIdEmpleado()).get();
            List<historicoPagos> listaDePagos = empleadoParaAnalisis.getHistoricoPagos();
            List<historicoPagosDTO> pagosVerficado = new ArrayList<>();
            for (historicoPagos historicoPagosListaUSO : listaDePagos) {
                if(historicoPagosListaUSO.getFechaPago().isBefore(pagoFechaEspecificaUSO.getFechaFin()) && historicoPagosListaUSO.getFechaPago().isAfter(pagoFechaEspecificaUSO.getFechaInicio())){
                    historicoPagosDTO nuevoElemenDto = this.modelMapper.map(historicoPagosListaUSO, historicoPagosDTO.class);
                    pagosVerficado.add(nuevoElemenDto);
                }
            }
            return pagosVerficado;
        } else {
            return Collections.emptyList();
        }
    }

    public String crearPagoParaEmpleado(AgregarHisPaDTOaEmp datosParaHitorial) {
        if(empleadoRepositorioUSO.existsById(datosParaHitorial.getIdEmpleado())){
            modelMapper = new ModelMapper();
            historicoPagos nuevoHistoricoPagos = new historicoPagos();
            nuevoHistoricoPagos.setHorasTrabajadas(datosParaHitorial.getHorasTrabajadas());
            nuevoHistoricoPagos.setPrecioPorHora(datosParaHitorial.getPrecioPorHora());
            nuevoHistoricoPagos.setEmpleado(empleadoRepositorioUSO.findById(datosParaHitorial.getIdEmpleado()).get());
            historicoPagosRepositorioUSO.save(nuevoHistoricoPagos);
            return "Historial actualizado exitosamente";
        }else{
            return "Este empleado no existe";
        }
    }

}
