package ec.edu.espe.agrosmart.service;

import ec.edu.espe.agrosmart.domain.Producto;
import ec.edu.espe.agrosmart.domain.ProductoFilters;
import ec.edu.espe.agrosmart.entity.ProductoEntity;
import ec.edu.espe.agrosmart.mapper.ProductoMapper;
import ec.edu.espe.agrosmart.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import java.math.BigDecimal;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository repository;

    public Flux<Producto> listarProductosProcesados() {
        return Flux.defer(() -> Flux.fromIterable(repository.findAll()))
                .subscribeOn(Schedulers.boundedElastic()) // Hilo exclusivo BD
                .map(ProductoMapper::aDominio)              // Entity -> Dominio
                .map(ProductoFilters.NOMBRE_MAYUSCULAS)     // Transforma sin mutar
                .filter(ProductoFilters.ES_VALIDO)          // Solo válidos
                .doOnNext(ProductoFilters.IMPRIMIR_RESUMEN) // Traza por consola
                .switchIfEmpty(Flux.defer(() -> {            // Valor por defecto
                    log.warn(" No se encontraron productos: generando registro por defecto");
                    Producto defecto = new Producto(
                            0L,
                            "SIN PRODUCTOS DISPONIBLES",
                            "GENERAL",
                            BigDecimal.ZERO,
                            java.util.Collections.emptyList()
                    );
                    return Flux.just(defecto);
                }))
                .doOnComplete(() -> log.info("Procesamiento de productos finalizado"));
    }

    public Mono<Long> contarProductosValidos() {
        return listarProductosProcesados().count();
    }
}