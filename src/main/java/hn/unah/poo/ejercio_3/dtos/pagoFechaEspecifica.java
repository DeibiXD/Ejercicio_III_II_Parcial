package hn.unah.poo.ejercio_3.dtos;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class pagoFechaEspecifica {
    
    private String idEmpleado;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

}
