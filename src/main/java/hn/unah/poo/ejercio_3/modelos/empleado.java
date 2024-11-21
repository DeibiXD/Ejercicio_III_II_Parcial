package hn.unah.poo.ejercio_3.modelos;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="empleado")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class empleado {
    @Id
    @Column(name = "dni",length = 20)
    private String dni;

    private String nombre;

    private String apellido;

    @Column(name = "fechaingreso")
    private LocalDate fechaIngreso;

    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL)
    private List<historicoPagos> historicoPagos;

}
