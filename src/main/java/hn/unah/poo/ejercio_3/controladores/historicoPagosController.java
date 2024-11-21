package hn.unah.poo.ejercio_3.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.poo.ejercio_3.dtos.AgregarHisPaDTOaEmp;
import hn.unah.poo.ejercio_3.dtos.historicoPagosDTO;
import hn.unah.poo.ejercio_3.dtos.pagoFechaEspecifica;
import hn.unah.poo.ejercio_3.modelos.historicoPagos;
import hn.unah.poo.ejercio_3.servicios.historicoPagosServicio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/api/historico/pagos")
public class historicoPagosController {
    
    @Autowired
    private historicoPagosServicio historicoPagosServicioUSO;

    @GetMapping("/obtener/fecha_especifica")
    public List<historicoPagosDTO> obtenerHistoricoPagosFechaEspecifica(@RequestBody pagoFechaEspecifica pagoFechaEspecificaUSO) {
        return historicoPagosServicioUSO.obtenerHistoricoPagosFechaEspecifica(pagoFechaEspecificaUSO);
    }

    @PostMapping("/agregar/pagos/empleado")
    public String crearPagoParaEmpleado(@RequestBody AgregarHisPaDTOaEmp entity) {
        return historicoPagosServicioUSO.crearPagoParaEmpleado(entity);
    }
    
    
}
