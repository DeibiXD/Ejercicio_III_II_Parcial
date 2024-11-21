package hn.unah.poo.ejercio_3.modelos;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="historicopagos")

public class historicoPagos {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; 

    @Column(name = "fechapago")
    private LocalDate fechaPago;

    @Column(name = "horastrabajadas")
    private int horasTrabajadas;

    @Column(name = "precioporhora", precision = 10, scale = 2)
    private BigDecimal precioPorHora;

    @Column(name = "totalsueldo", precision = 10, scale = 2)
    private BigDecimal totalSueldo;

    @ManyToOne
    @JoinColumn(name = "dni", referencedColumnName = "dni")
    @JsonIgnore
    private empleado empleado;
}
