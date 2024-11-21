package hn.unah.poo.ejercio_3.dtos;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AgregarHisPaDTOaEmp {
   private String idEmpleado;
   private int horasTrabajadas;
   private BigDecimal precioPorHora;

}
