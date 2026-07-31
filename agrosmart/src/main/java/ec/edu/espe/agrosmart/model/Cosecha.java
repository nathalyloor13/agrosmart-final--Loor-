package ec.edu.espe.agrosmart.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class Cosecha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate fechaCosecha;

    private Double cantidadObtenida;
    private String unidadMedida;
    private Double precioPorUnidad;

    // Relación: Un cultivo tiene una cosecha
    @OneToOne(optional = false)
    @JoinColumn(name = "cultivo_id", nullable = false, unique = true)
    private Cultivo cultivo;
}