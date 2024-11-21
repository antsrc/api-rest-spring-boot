package desarrolloservidor.empresa.controladores;

import org.springframework.beans.factory.annotation.Autowired;
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
    public Double obtenerSalario(@PathVariable("dni") String dni) {
        return nominaService.obtenerSalario(dni);
    }
}
