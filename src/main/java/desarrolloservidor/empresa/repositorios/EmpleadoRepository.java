package desarrolloservidor.empresa.repositorios;

import desarrolloservidor.empresa.modelo.Empleado;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, String> {

	@Query("SELECT e FROM Empleado e WHERE " + "(:dni IS NULL OR LOWER(e.dni) LIKE LOWER(CONCAT('%', :dni, '%'))) AND "
			+ "(:nombre IS NULL OR LOWER(e.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))) AND "
			+ "(:sexo IS NULL OR e.sexo = :sexo) AND " + "(:categoria IS NULL OR e.categoria = :categoria) AND "
			+ "(:antiguedad IS NULL OR e.antiguedad = :antiguedad)")
	List<Empleado> findByFilters(@Param("dni") String dni, @Param("nombre") String nombre, @Param("sexo") String sexo,
			@Param("categoria") Integer categoria, @Param("antiguedad") Integer antiguedad);
}
