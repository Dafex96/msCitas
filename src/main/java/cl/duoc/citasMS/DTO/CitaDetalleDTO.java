package cl.duoc.citasMS.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CitaDetalleDTO {

    private Integer id;
    private String fecha;
    private VehiculoDTO vehiculo;
    private ClienteDTO cliente;
}
