package ec.edu.espe.agrosmart;

import ec.edu.espe.agrosmart.entity.ProductoEntity;
import ec.edu.espe.agrosmart.repository.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
public class AgroSmartApplication {

    public static void main(String[] args) {
        SpringApplication.run(AgroSmartApplication.class, args);
    }

    @Bean
    CommandLineRunner sembrarDatos(ProductoRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                ProductoEntity p1 = new ProductoEntity();
                p1.setNombreProducto("Rosa Roja");
                p1.setCategoria("Flores");
                p1.setPrecioUsd(new BigDecimal("2.50"));
                p1.setStockKg(50);
                p1.setCorreosNotificacion("ventas@flores.ec");

                ProductoEntity p2 = new ProductoEntity();
                p2.setNombreProducto("Girasol");
                p2.setCategoria("Flores");
                p2.setPrecioUsd(new BigDecimal("1.80"));
                p2.setStockKg(30);
                p2.setCorreosNotificacion("pedidos@flores.ec");

                ProductoEntity p3 = new ProductoEntity();
                p3.setNombreProducto("Margarita");
                p3.setCategoria("Flores");
                p3.setPrecioUsd(BigDecimal.ZERO); // Inválido
                p3.setStockKg(20);
                p3.setCorreosNotificacion("ventas@flores.ec");

                repo.saveAll(List.of(p1,p2,p3));
                System.out.println(" Datos de prueba insertados");
            }
        };
    }
}