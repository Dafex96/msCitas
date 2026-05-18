package cl.duoc.citasMS.Repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cl.duoc.citasMS.Model.Cita;

@Repository
public interface CitaRepository extends JpaRepository <Cita, Integer> {

    //Buscar cita por vehículo
    List<Cita> findByVehiculoId(Integer vehiculoId);

    //Buscar cita por fecha
    List<Cita> findByFecha(Date fecha);

    //Buscar cita por estado
    List<Cita> findByEstado(String estado);

    //Buscar cita por vehiculo y estado
    List<Cita> findByVehiculoIdAndEstado(Integer vehiculoId, String estado);

    //Buscar cita entre fechas
    List<Cita> findByFechaBetween(Date inicio, Date fin);
}
