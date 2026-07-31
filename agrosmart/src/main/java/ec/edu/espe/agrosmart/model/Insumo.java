package ec.edu.espe.agrosmart.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Insumo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del insumo es obligatorio")
    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(length = 50)
    private String tipo; // semilla, fertilizante, plaguicida

    private Double cantidad;
    private String unidadMedida; // kg, l, saco

    // Relación: Muchos insumos se usan en muchos cultivos
    @ManyToOne(optional = false)
    @JoinColumn(name = "cultivo_id", nullable = false)
    private Cultivo cultivo;
}