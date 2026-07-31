package ec.edu.espe.agrosmart.mapper;

import ec.edu.espe.agrosmart.domain.Producto;
import ec.edu.espe.agrosmart.entity.ProductoEntity;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ProductoMapper {

    public static Producto aDominio(ProductoEntity entidad) {
        // Convierte la cadena separada por comas en lista
        List<String> correos = entidad.getCorreosNotificacion() == null || entidad.getCorreosNotificacion().isBlank()
                ? Collections.emptyList()
                : Arrays.asList(entidad.getCorreosNotificacion().split("\\s*,\\s*"));

        return new Producto(
                entidad.getIdProducto(),
                entidad.getNombreProducto(),
                entidad.getCategoria(),
                entidad.getPrecioUsd(),
                correos
        );
    }
}