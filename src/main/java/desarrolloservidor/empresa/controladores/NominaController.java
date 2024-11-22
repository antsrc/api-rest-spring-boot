package desarrolloservidor.empresa.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import desarrolloservidor.empresa.servicios.NominaService;

@RestController
@RequestMapping("/empresa/nominas")
public class NominaController {

	@Autowired
	private NominaService nominaService;

	@GetMapping("/obtenerSalario/{dni}")
	public ResponseEntity<Double> obtenerSalario(@PathVariable("dni") String dni) {
		Double salario = nominaService.obtenerSalario(dni);
		if (salario == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(salario);
	}
}
