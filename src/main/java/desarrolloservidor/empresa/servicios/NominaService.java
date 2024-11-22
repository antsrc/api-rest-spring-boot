package desarrolloservidor.empresa.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import desarrolloservidor.empresa.modelo.Nomina;
import desarrolloservidor.empresa.repositorios.NominaRepository;

import java.util.Optional;

@Service
public class NominaService {

    @Autowired
    private NominaRepository nominaRepository;

    public Double obtenerSalario(String dni) {
    	Optional<Nomina> nominaOpt = nominaRepository.findById(dni);
        return nominaOpt.map(Nomina::getSueldo).orElse(null);
    }

}