package desarrolloservidor.empresa.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import desarrolloservidor.empresa.dtos.EmpleadoDTO;
import desarrolloservidor.empresa.servicios.EmpleadoService;

import java.util.List;

@RestController
@RequestMapping("/empresa/empleados")
public class EmpleadoController {

	@Autowired
	private EmpleadoService empleadoService;

	@GetMapping("/obtenerEmpleado/{dni}")
	public ResponseEntity<EmpleadoDTO> obtenerEmpleado(@PathVariable("dni") String dni) {
		EmpleadoDTO empleado = empleadoService.obtenerEmpleado(dni);
		if (empleado == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(empleado);
	}

	@GetMapping("/obtenerListaEmpleados")
	public ResponseEntity<List<EmpleadoDTO>> obtenerListaEmpleados() {
		List<EmpleadoDTO> empleados = empleadoService.obtenerListaEmpleados();
		if (empleados.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.ok(empleados);
		}
	}

	@PostMapping("/obtenerListaEmpleadosFiltrada")
	public ResponseEntity<List<EmpleadoDTO>> obtenerListaEmpleadosFiltrada(@RequestBody EmpleadoDTO datos) {
		List<EmpleadoDTO> empleados = empleadoService.obtenerListaEmpleadosFiltrada(datos);
		if (empleados.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.ok(empleados);
		}
	}

	@PostMapping("/crearEmpleado")
	public ResponseEntity<Void> registrarEmpleado(@RequestBody EmpleadoDTO datos) {
		if (empleadoService.registrarEmpleado(datos)) {
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).build();
	}

	@PutMapping("/modificarDatosEmpleado/{dni}")
	public ResponseEntity<String> modificarDatosEmpleado(@PathVariable String dni, @RequestBody EmpleadoDTO datos) {
		if (empleadoService.modificarDatosEmpleado(dni, datos)) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@DeleteMapping("/eliminarEmpleado/{dni}")
	public ResponseEntity<Void> eliminarEmpleado(@PathVariable("dni") String dni) {
		if (empleadoService.eliminarEmpleado(dni)) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

}
