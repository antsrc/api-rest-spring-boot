package desarrolloservidor.empresa.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import desarrolloservidor.empresa.dtos.EmpleadoDTO;
import desarrolloservidor.empresa.modelo.Empleado;
import desarrolloservidor.empresa.repositorios.EmpleadoRepository;
import desarrolloservidor.empresa.servicios.util.EmpleadoMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmpleadoService {

	@Autowired
	private EmpleadoRepository empleadoRepository;

	@Autowired
	private EmpleadoMapper empleadoMapper;

	public EmpleadoDTO obtenerEmpleado(String dni) {
		Optional<Empleado> empleadoOpt = empleadoRepository.findById(dni);
		if (empleadoOpt.isPresent()) {
			return empleadoMapper.toEmpleadoDTO(empleadoOpt.get());
		}
		return null;

	}

	public List<EmpleadoDTO> obtenerListaEmpleados() {
		return empleadoRepository.findAll().stream().map(empleado -> empleadoMapper.toEmpleadoDTO(empleado))
				.collect(Collectors.toList());
	}

	public List<EmpleadoDTO> obtenerListaEmpleadosFiltrada(EmpleadoDTO datos) {
		return empleadoRepository
				.findByFilters(datos.getDni(), datos.getNombre(), datos.getSexo(), datos.getCategoria(),
						datos.getAntiguedad())
				.stream().map(empleado -> empleadoMapper.toEmpleadoDTO(empleado)).collect(Collectors.toList());
	}

	public boolean registrarEmpleado(EmpleadoDTO datos) {
		if (empleadoRepository.existsById(datos.getDni())) {
			return false;
		}
		empleadoRepository.save(empleadoMapper.toEmpleado(datos));
		return true;
	}

	public boolean modificarDatosEmpleado(String dni, EmpleadoDTO datos) {
		Optional<Empleado> empleadoOpt = empleadoRepository.findById(dni);
		if (empleadoOpt.isPresent()) {
			Empleado empleado = empleadoOpt.get();
			if (datos.getNombre() != null) {
				empleado.setNombre(datos.getNombre());
			}
			if (datos.getSexo() != null) {
				empleado.setSexo(datos.getSexo());
			}
			if (datos.getCategoria() != null) {
				empleado.setCategoria(datos.getCategoria());
			}
			if (datos.getAntiguedad() != null) {
				empleado.setAntiguedad(datos.getAntiguedad());
			}
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

}
