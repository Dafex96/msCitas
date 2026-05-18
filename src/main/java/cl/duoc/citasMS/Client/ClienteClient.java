package cl.duoc.citasMS.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import cl.duoc.citasMS.DTO.ClienteDTO;

@FeignClient(name = "msClientes", url = "http://localhost:8081")

public interface ClienteClient {
    
    @GetMapping("/api/v1/clientes/dto/{id}")
    ClienteDTO obtenerCliente(@PathVariable("id") Integer id);
}
