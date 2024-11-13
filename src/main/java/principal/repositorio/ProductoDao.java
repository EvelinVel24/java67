package main.java.principal.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import principal.modelo.Producto;
import java.util.List;

@Repository
public interface ProductoDao extends JpaRepository<Producto, Long> {

    // Filtrar por marca usando palabras clave de Spring Data JPA
    List<Producto> findByMarca(String marca);

    // Filtrar por modelo usando HQL
    @Query("SELECT p FROM Producto p WHERE p.modelo = ?1")
    List<Producto> filtrarPorModelo(String modelo);

    // Filtrar por palabra en la descripción usando SQL nativo
    @Query(value = "SELECT * FROM Producto WHERE descripcion LIKE %?1%", nativeQuery = true)
    List<Producto> filtrarPorDescripcion(String palabra);
}
