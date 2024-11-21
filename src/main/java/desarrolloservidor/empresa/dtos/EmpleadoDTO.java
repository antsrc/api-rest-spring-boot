package desarrolloservidor.empresa.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoDTO {

	private String dni;

	private String nombre;

	private String sexo;

	private Integer categoria;

	private Integer antiguedad;

}
