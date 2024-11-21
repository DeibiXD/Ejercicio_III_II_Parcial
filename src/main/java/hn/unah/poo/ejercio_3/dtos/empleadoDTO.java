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

public class empleadoDTO {
    private String dni;

    private String nombre;

    private String apellido;

    private LocalDate fechaIngreso;
}
