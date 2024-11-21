package desarrolloservidor.empresa.repositorios;

import desarrolloservidor.empresa.modelo.Nomina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NominaRepository extends JpaRepository<Nomina, String> {
}
