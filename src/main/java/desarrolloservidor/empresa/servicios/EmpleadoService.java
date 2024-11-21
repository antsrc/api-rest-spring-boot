package desarrolloservidor.empresa.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import desarrolloservidor.empresa.dtos.EmpleadoDTO;
import desarrolloservidor.empresa.modelo.Empleado;
import desarrolloservidor.empresa.repositorios.EmpleadoRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmpleadoService {

	@Autowired
	private EmpleadoRepository empleadoRepository;

	public EmpleadoDTO obtenerEmpleado(String dni) {
		Optional<Empleado> empleadoOpt = empleadoRepository.findById(dni);
		if (empleadoOpt.isPresent()) {
			return toDTO(empleadoOpt.get());
		}
		return null;

	}

	public List<EmpleadoDTO> obtenerListaEmpleados() {
		return empleadoRepository.findAll().stream().map(empleado -> toDTO(empleado)).collect(Collectors.toList());
	}

	public List<EmpleadoDTO> obtenerListaEmpleadosFiltrados(String nombre, String dni, String sexo, Integer categoria,
			Integer antiguedad) {
		nombre = nombre.trim().isEmpty() ? null : nombre.trim();
		dni = dni.trim().isEmpty() ? null : dni.trim();
		sexo = sexo.isEmpty() ? null : sexo;
		return empleadoRepository.obtenerEmpleadosFiltrados(nombre, dni, sexo, categoria, antiguedad).stream()
				.map(empleado -> toDTO(empleado)).collect(Collectors.toList());
	}

	public boolean registrarEmpleado(String dni, String nombre, String sexo, Integer categoria, Integer antiguedad) {
		if (empleadoRepository.existsById(dni)) {
			return false;
		}
		Empleado nuevoEmpleado = new Empleado(dni, nombre, sexo, categoria, antiguedad);
		empleadoRepository.save(nuevoEmpleado);
		return true;
	}

	public boolean actualizarEmpleado(String dni, String nombre, String sexo, Integer categoria, Integer antiguedad) {
		Optional<Empleado> empleadoOpt = empleadoRepository.findById(dni);
		if (empleadoOpt.isPresent()) {
			Empleado empleado = empleadoOpt.get();
			empleado.setNombre(nombre);
			empleado.setSexo(sexo);
			empleado.setCategoria(categoria);
			empleado.setAntiguedad(antiguedad);
			empleadoRepository.save(empleado);
			return true;
		}
		return false;

	}

	public boolean eliminarEmpleado(String dni) {
		if (empleadoRepository.existsById(dni)) {
			empleadoRepository.deleteById(dni);
			return true;
		}
		return false;
	}

	private EmpleadoDTO toDTO(Empleado empleado) {
		EmpleadoDTO dto = new EmpleadoDTO();
		dto.setDni(empleado.getDni());
		dto.setNombre(empleado.getNombre());
		dto.setSexo(empleado.getSexo());
		dto.setCategoria(empleado.getCategoria());
		dto.setAntiguedad(empleado.getAntiguedad());
		return dto;
	}

}
