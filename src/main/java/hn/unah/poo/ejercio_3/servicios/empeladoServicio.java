package hn.unah.poo.ejercio_3.servicios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.poo.ejercio_3.dtos.empleadoDTO;
import hn.unah.poo.ejercio_3.dtos.historicoPagosDTO;
import hn.unah.poo.ejercio_3.modelos.empleado;
import hn.unah.poo.ejercio_3.modelos.historicoPagos;
import hn.unah.poo.ejercio_3.repositorios.empleadoRepositorio;
import hn.unah.poo.ejercio_3.repositorios.historicoPagosRepositorio;

@Service
public class empeladoServicio {
    @Autowired
    private empleadoRepositorio empleadoRepositorio;
    
    @Autowired
    private historicoPagosRepositorio historicoPagosRepositorio;

    private ModelMapper modelMapper;

    public List<empleado> obtenerTodos(){
        return empleadoRepositorio.findAll();
    }
/*(
 * Se crea un empleado sin ningun pago
) */
    public String crearEmpleado(empleadoDTO empleadoNuevoDTO){
        if(empleadoRepositorio.existsById(empleadoNuevoDTO.getDni())){
            return "Usuario ya existe con este Dni";
        } else {
            modelMapper = new ModelMapper();
            empleado empleadoNuevo = this.modelMapper.map(empleadoNuevoDTO, empleado.class);
            empleadoRepositorio.save(empleadoNuevo);
            return "Empleado Creado con exito";
        }
    }
    public String eliminarEmpleado(String empleadoEliminarID) {
        if(empleadoRepositorio.existsById(empleadoEliminarID)){
            empleadoRepositorio.deleteById(empleadoEliminarID);
            return "Empleado borrado con exito";
        }
        return "No encontramos el empleado";
    }
    public List<historicoPagosDTO> buscarPorID(String dni) {
        if(empleadoRepositorio.existsById(dni)){
            modelMapper = new ModelMapper();
            empleado empleadoBuscado = empleadoRepositorio.findById(dni).get();
            empleadoDTO empleadoBuscadoDTO = this.modelMapper.map(empleadoBuscado, empleadoDTO.class);
            //Relacion Uno a Muchos entre Empleado y HistoricoPagos
            List<historicoPagos> listaDeEmpleado = empleadoBuscado.getHistoricoPagos();
            List<historicoPagosDTO> nuevaListaDTO = new ArrayList<>();
            for (historicoPagos historicoPagosAgregar: listaDeEmpleado) {
                historicoPagosDTO nuevoElemenDto = this.modelMapper.map(historicoPagosAgregar, historicoPagosDTO.class);
                nuevaListaDTO.add(nuevoElemenDto);
            }
            return nuevaListaDTO;
        }
        
        return Collections.emptyList();
    }

}
