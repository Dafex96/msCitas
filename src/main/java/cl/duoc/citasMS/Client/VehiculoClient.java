package cl.duoc.citasMS.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import cl.duoc.citasMS.DTO.VehiculoDTO;

@FeignClient(name = "msVehiculos", url = "http://localhost:8080")

public interface VehiculoClient {

    @GetMapping("/api/v1/vehiculos/dto/{id}")
    VehiculoDTO obtenerVehiculo(@PathVariable("id") Integer id);
}
