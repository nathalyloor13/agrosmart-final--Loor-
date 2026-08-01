package ec.edu.espe.agrosmart.controller;

import ec.edu.espe.agrosmart.domain.Producto;
import ec.edu.espe.agrosmart.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AgroSmartController {

    private final ProductoService productoService;

    // Endpoint 1: Productos comercializables
    @GetMapping("/productos")
    public Flux<Producto> listarComercializables() {
        return productoService.obtenerProductosComercializables();
    }

    // Endpoint 2: Buscar por ID
    @GetMapping("/productos/{id}")
    public Mono<Producto> buscarPorId(@PathVariable Long id) {
        return productoService.buscarPorId(id);
    }

    // Endpoint 3: El nuevo de publicidad (Fase 5)
    @GetMapping("/agrosmart/publicidad")
    public Mono<String> generarPublicidad(
            @RequestParam String producto,
            @RequestParam String audiencia) {
        return productoService.generarPublicidad(producto, audiencia);
    }

    // (Opcional) Tu endpoint de conteo
    @GetMapping("/productos/contar")
    public Mono<Long> contarValidos() {
        return productoService.contarProductosValidos();
    }

    // Manejo 404 para la excepción
    @ExceptionHandler(ec.edu.espe.agrosmart.exception.ProductoNoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Mono<String> manejarNoEncontrado(ec.edu.espe.agrosmart.exception.ProductoNoEncontradoException ex) {
        return Mono.just(ex.getMessage());
    }
}