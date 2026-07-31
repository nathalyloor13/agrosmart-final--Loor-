package ec.edu.espe.agrosmart.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class RegistroClima {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate fecha;

    private Double temperatura; // °C
    private Double humedad; // %
    private Double precipitacion; // mm

    // Relación: Un cultivo tiene muchos registros
    @ManyToOne(optional = false)
    @JoinColumn(name = "cultivo_id", nullable = false)
    private Cultivo cultivo;
}