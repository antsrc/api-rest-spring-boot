package desarrolloservidor.empresa.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.AccessLevel;

@Entity
@Table(name = "empleados")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Empleado implements Persona {

	@Id
	@NotNull
	@NonNull
	@Setter(AccessLevel.NONE)
	private String dni;

	@NotNull
	@NonNull
	private String nombre;

	@NotNull
	@Pattern(regexp = "^[FfMm]$")
	@NonNull
	private String sexo;

	@NotNull
	@Min(value = 1)
	@Max(value = 10)
	@NonNull
	private Integer categoria;

	@NotNull
	@Min(value = 0)
	@NonNull
	private Integer antiguedad;

	@OneToOne(mappedBy = "empleado", fetch = FetchType.LAZY)
	@Setter(AccessLevel.NONE)
	private Nomina nomina;
	
}
