package hn.unah.poo.ejercio_3.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.poo.ejercio_3.dtos.empleadoDTO;
import hn.unah.poo.ejercio_3.dtos.historicoPagosDTO;
import hn.unah.poo.ejercio_3.modelos.empleado;
import hn.unah.poo.ejercio_3.servicios.empeladoServicio;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/empleados")
public class empleadoController {
    
    @Autowired
    private empeladoServicio empeladoServicioUSO;

    @PostMapping("/agregar")
    public String crearEmpleado(@RequestBody empleadoDTO empleadoNuevoDTO) {
        return empeladoServicioUSO.crearEmpleado(empleadoNuevoDTO);
    }

    @DeleteMapping("/eliminar")
    public String eliminarEmpleado(@RequestBody String idEmpleado){
        return empeladoServicioUSO.eliminarEmpleado(idEmpleado);
    }

    @GetMapping("/buscar/id")
    public List<historicoPagosDTO> buscarPorID(@RequestParam(name = "dni")String dni) {
        return empeladoServicioUSO.buscarPorID(dni);
    }

    @GetMapping("/obtener/todos")
    public List<empleado> obtenerTodos() {
        return empeladoServicioUSO.obtenerTodos();
    }
    
    
    
    
}
