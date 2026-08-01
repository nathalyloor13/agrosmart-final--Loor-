package ec.edu.espe.agrosmart.config;

import ec.edu.espe.agrosmart.entity.ProductoEntity;
import ec.edu.espe.agrosmart.repository.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.util.List;

@Component
public class SembrarDatos implements CommandLineRunner {

    private final ProductoRepository repo;

    public SembrarDatos(ProductoRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) {
        if (repo.count() == 0) { // IDEMPOTENTE: no duplica
            // 3 VÁLIDOS
            ProductoEntity p1 = new ProductoEntity();
            p1.setNombreProducto("Rosas Rojas Premium");
            p1.setPrecioUsd(new BigDecimal("1.85"));
            p1.setStockKg(120);
            p1.setCategoria("Flores");
            p1.setCorreosNotificacion("ventas@floreria.com,export@europa.eu");

            ProductoEntity p2 = new ProductoEntity();
            p2.setNombreProducto("Rosas Blancas Extra");
            p2.setPrecioUsd(new BigDecimal("2.10"));
            p2.setStockKg(95);
            p2.setCategoria("Flores");
            p2.setCorreosNotificacion("pedidos@premium.com");

            ProductoEntity p3 = new ProductoEntity();
            p3.setNombreProducto("Rosas Rosadas Estándar");
            p3.setPrecioUsd(new BigDecimal("0.95"));
            p3.setStockKg(200);
            p3.setCategoria("Flores");
            p3.setCorreosNotificacion("mayorista@mercado.com");

            // 2 INVÁLIDOS
            ProductoEntity p4 = new ProductoEntity();
            p4.setNombreProducto("Rosas Variadas Dañadas");
            p4.setPrecioUsd(BigDecimal.ZERO);
            p4.setStockKg(50);
            p4.setCategoria("Flores");
            p4.setCorreosNotificacion("reclamos@empresa.com");

            ProductoEntity p5 = new ProductoEntity();
            p5.setNombreProducto("Rosas Nuevas Sin Asignar");
            p5.setPrecioUsd(new BigDecimal("1.50"));
            p5.setStockKg(80);
            p5.setCategoria("Flores");
            p5.setCorreosNotificacion("");

            repo.saveAll(List.of(p1,p2,p3,p4,p5));
            System.out.println(" Siembra lista: 3 válidos + 2 inválidos");
        }
    }
}