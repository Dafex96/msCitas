package cl.duoc.citasMS.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.duoc.citasMS.Client.ClienteClient;
import cl.duoc.citasMS.Client.VehiculoClient;
import cl.duoc.citasMS.DTO.*;
import cl.duoc.citasMS.Model.Cita;
import cl.duoc.citasMS.Repository.CitaRepository;

@Service
public class CitaService {

    @Autowired
    private CitaRepository repository;

    @Autowired
    private VehiculoClient vehiculoClient;

    @Autowired
    private ClienteClient clienteClient;

    public List<Cita> listar() {
        return repository.findAll();
    }

    public Cita guardar(Cita cita) {
        VehiculoDTO vehiculo = vehiculoClient.obtenerVehiculo(cita.getVehiculoId());
        if (vehiculo == null) {
            throw new RuntimeException("El Vehiculo no existe");
        }
        return repository.save(cita);
    }

    public Cita buscarPorId(Integer id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("La cita no exiiste"));
    }

    public Cita actualizarEstado(Integer id, String nuevoEstado) {
        Cita cita = buscarPorId(id);
        cita.setEstado(nuevoEstado);
        return repository.save(cita);
    }

    public void eliminar(Integer id) {
        Cita cita = buscarPorId(id);
        repository.delete(cita);
    }

    public CitaDetalleDTO obtenerDetalle(Integer id) {

        Cita cita = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Cita no encontrada"));

        VehiculoDTO vehiculo = vehiculoClient.obtenerVehiculo(cita.getVehiculoId());
        if (vehiculo == null) {
            throw new RuntimeException("Vehiculo no encontrado en el sistema");
        }
    
        ClienteDTO cliente = clienteClient.obtenerCliente(cita.getClienteId());
        if (cliente == null) {
            throw new RuntimeException("Cliente no encontrado en el sistema");
        }

        CitaDetalleDTO dto = new CitaDetalleDTO();

        dto.setId(cita.getId());
        dto.setFecha(cita.getFecha().toString());
        dto.setVehiculo(vehiculo);
        dto.setCliente(cliente);

        return dto;
    }
}
