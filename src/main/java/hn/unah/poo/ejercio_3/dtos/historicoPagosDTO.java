package hn.unah.poo.ejercio_3.dtos;
import java.math.BigDecimal;
import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class historicoPagosDTO {
 
    private int id; 

   
    private LocalDate fechaPago;

    
    private int horasTrabajadas;

   
    private BigDecimal precioPorHora;


    private BigDecimal totalSueldo;

}