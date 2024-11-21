package desarrolloservidor.empresa.modelo;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Entity
@Table(name = "nominas")
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class Nomina {

    @Id
    @NotNull
    @Column(name = "empleado_dni", insertable = false, updatable = false)
    @NonNull
    private String dni;

    @NotNull
    @NonNull
    private Double sueldo;
     
    @OneToOne
    private Empleado empleado;

}
