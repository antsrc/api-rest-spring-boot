package desarrolloservidor.empresa.servicios.util;

import org.springframework.stereotype.Component;

import desarrolloservidor.empresa.dtos.EmpleadoDTO;
import desarrolloservidor.empresa.modelo.Empleado;

@Component
public class EmpleadoMapper {

	public EmpleadoDTO toEmpleadoDTO(Empleado empleado) {
		if (empleado == null) {
			return null;
		}
		EmpleadoDTO dto = new EmpleadoDTO();
		dto.setDni(empleado.getDni());
		dto.setNombre(empleado.getNombre());
		dto.setSexo(empleado.getSexo());
		dto.setCategoria(empleado.getCategoria());
		dto.setAntiguedad(empleado.getAntiguedad());
		return dto;
	}

	public Empleado toEmpleado(EmpleadoDTO datos) {
		if (datos == null) {
			return null;
		}
		Empleado empleado = new Empleado(datos.getDni(), datos.getNombre(), datos.getSexo(), datos.getCategoria(),
				datos.getAntiguedad());
		return empleado;
	}

}
