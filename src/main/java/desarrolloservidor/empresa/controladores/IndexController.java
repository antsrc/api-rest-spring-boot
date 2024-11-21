package desarrolloservidor.empresa.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping("/")
	public String redireccionInicio() {
		return "redirect:/empresa";
	}

	@GetMapping("/empresa")
	public String mostrarIndice() {
		return "index";
	}

}