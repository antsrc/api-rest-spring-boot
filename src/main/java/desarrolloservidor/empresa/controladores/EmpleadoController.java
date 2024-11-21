package desarrolloservidor.empresa.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import desarrolloservidor.empresa.dtos.EmpleadoDTO;
import desarrolloservidor.empresa.modelo.Empleado;
import desarrolloservidor.empresa.servicios.EmpleadoService;

import java.util.List;

@RestController
@RequestMapping("/empresa/empleados")
public class EmpleadoController {

	@Autowired
	private EmpleadoService empleadoService;
	
	@GetMapping("obtenerEmpleado/{dni}")
	public EmpleadoDTO obtenerEmpleado(@PathVariable("dni") String dni) {
		return empleadoService.obtenerEmpleado(dni);
	}
	
	@GetMapping("/obtenerListaEmpleados")
	public List<EmpleadoDTO> obtenerListaEmpleados() {
		return empleadoService.obtenerListaEmpleados();
	}

//	@PostMapping("/obtenerListaEmpleadosFiltrados")
//	public List<EmpleadoDTO> obtenerListaEmpleadosFiltrados(@RequestBody EmpleadoDTO empleado) {
//		return empleadoService.obtenerListaEmpleadosFiltrados(empleado);
//	}

//	@GetMapping("/modificar/{dni}")
//	public String modificarEmpleado(@PathVariable String dni, Model model) {
//		Empleado empleado = empleadoService.obtenerEmpleado(dni);
//		model.addAttribute("empleado", empleado);
//		return "modificarEmpleado";
//	}
	
	@DeleteMapping("/eliminarEmpleado/{dni}")
	public void eliminarEmpleado(@PathVariable("dni") String dni) {
		empleadoService.eliminarEmpleado(dni);
	}

}
