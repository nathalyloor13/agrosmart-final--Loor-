package ec.edu.espe.agrosmart.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Table(name = "tbl_productos_base_77") // TU TABLA EXACTA
@Data
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long idProducto;

    @Column(name = "nombre_producto", length = 120, nullable = false, unique = true)
    private String nombreProducto;

    @Column(name = "precio_usd", precision = 10, scale = 2)
    private BigDecimal precioUsd;

    @Column(name = "stock_kg", nullable = false)
    private Integer stockKg;

    @Column(length = 40, nullable = false)
    private String categoria;

    @Column(name = "correos_notificacion", length = 500)
    private String correosNotificacion = "";
}