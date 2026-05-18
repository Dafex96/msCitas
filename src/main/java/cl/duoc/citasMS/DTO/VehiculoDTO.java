package cl.duoc.citasMS.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class VehiculoDTO {

    private Integer id;
    private String patente;
    private String marca;
    private String modelo;
}
