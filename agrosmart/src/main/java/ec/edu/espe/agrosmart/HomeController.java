
package ec.edu.espe.agrosmart;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String inicio() {
        return """
        <h1>🌱 AgroSmart - Fase 1 Completada</h1>
        <ul>
            <li>Servidor activo: http://localhost:8177</li>
            <li>Base de datos: PostgreSQL (puerto 5433)</li>
            <li>Entorno listo para desarrollo</li>
        </ul>
        """;
    }
}