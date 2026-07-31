package ec.edu.espe.agrosmart.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class Cultivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del cultivo es obligatorio")
    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(length = 100)
    private String variedad;

    @Column(nullable = false)
    private LocalDate fechaSiembra;

    @Column(length = 50)
    private String estado; // Ej: germinando, creciendo, listo

    // Relación: Una parcela tiene muchos cultivos
    @ManyToOne(optional = false)
    @JoinColumn(name = "parcela_id", nullable = false)
    private Parcela parcela;
}