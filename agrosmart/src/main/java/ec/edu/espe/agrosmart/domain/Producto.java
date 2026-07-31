package ec.edu.espe.agrosmart.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Producto {
    private final Long id;
    private final String nombre;
    private final String categoria;
    private final BigDecimal precioUsd;
    private final List<String> correosNotificacion;

    // Constructor con validación y copia defensiva
    public Producto(Long id, String nombre, String categoria,
                    BigDecimal precioUsd, List<String> correosNotificacion) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precioUsd = precioUsd;
        // No guardo la lista original: creo una copia nueva
        this.correosNotificacion = new ArrayList<>(correosNotificacion);
    }

    // SOLO GETTERS — NINGÚN SETTER
    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCategoria() { return categoria; }
    public BigDecimal getPrecioUsd() { return precioUsd; }

    // Devuelvo lista de SOLO LECTURA: nadie puede modificar el estado interno
    public List<String> getCorreosNotificacion() {
        return Collections.unmodifiableList(new ArrayList<>(correosNotificacion));
    }
}