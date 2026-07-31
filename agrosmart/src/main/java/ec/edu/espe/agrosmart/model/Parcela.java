package ec.edu.espe.agrosmart.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Parcela {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre de la parcela es obligatorio")
    @Column(nullable = false, length = 100)
    private String nombre;

    private Double areaHectareas;

    @Column(length = 100)
    private String ubicacion;

    @Column(length = 50)
    private String tipoSuelo;

    // Relación: Un agricultor tiene muchas parcelas
    @ManyToOne(optional = false)
    @JoinColumn(name = "agricultor_id", nullable = false)
    private Agricultor agricultor;
}