package ec.edu.espe.agrosmart.domain;

import java.math.BigDecimal;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class ProductoFilters {

    //¿Es válido? precio > 0 Y tiene al menos un correo
    public static final Predicate<Producto> ES_VALIDO = producto ->
            producto.getPrecioUsd().compareTo(BigDecimal.ZERO) > 0
                    && !producto.getCorreosNotificacion().isEmpty();

    // Muestra datos sin devolver nada
    public static final Consumer<Producto> IMPRIMIR_RESUMEN = producto ->
            System.out.printf(" [%d] %s | $%.2f | %s%n",
                    producto.getId(),
                    producto.getNombre(),
                    producto.getPrecioUsd(),
                    producto.getCategoria());

    // Transforma a MAYÚSCULAS → devuelve NUEVO objeto (no modifica el original)
    public static final Function<Producto, Producto> NOMBRE_MAYUSCULAS = producto ->
            new Producto(
                    producto.getId(),
                    producto.getNombre().toUpperCase(),
                    producto.getCategoria(),
                    producto.getPrecioUsd(),
                    producto.getCorreosNotificacion()
            );
}