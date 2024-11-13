package main.java.principal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import principal.servicio.ProductoServicio;
import principal.modelo.Producto;

@SpringBootApplication
public class MainApplication implements CommandLineRunner {

    private final ProductoServicio productoServicio;

    public MainApplication(ProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Override
    public void run(String... args) {
        // Crear productos de ejemplo
        Producto producto1 = new Producto("Carpa", "MarcaA", "Carpa de 4 personas");
        productoServicio.agregarProducto(producto1);
        
        // Pruebas de filtrado y CRUD
        productoServicio.listarProductos().forEach(System.out::println);
        productoServicio.filtrarPorMarca("MarcaA").forEach(System.out::println);
        productoServicio.filtrarPorModelo("Carpa").forEach(System.out::println);
        productoServicio.filtrarPorDescripcion("4 personas").forEach(System.out::println);
    }
}
