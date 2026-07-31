package ec.edu.espe.agrosmart.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Agricultor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Column(nullable = false, length = 150)
    private String nombre;

    @Column(length = 15)
    private String telefono;

    @Email
    @Column(unique = true, length = 100)
    private String correo;

    @Column(length = 200)
    private String direccion;
}