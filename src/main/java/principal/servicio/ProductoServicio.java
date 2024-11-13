package main.java.principal.servicio;

import org.springframework.stereotype.Service;
import principal.modelo.Producto;
import principal.repositorio.ProductoDao;
import java.util.List;

@Service
public class ProductoServicio {
    private final ProductoDao productoDao;

    public ProductoServicio(ProductoDao productoDao) {
        this.productoDao = productoDao;
    }

    public void agregarProducto(Producto producto) {
        productoDao.save(producto);
    }

    public void eliminarProducto(Long id) {
        productoDao.deleteById(id);
    }

    public void actualizarProducto(Producto producto) {
        productoDao.save(producto);
    }

    public List<Producto> listarProductos() {
        return productoDao.findAll();
    }

    public List<Producto> filtrarPorMarca(String marca) {
        return productoDao.findByMarca(marca);
    }

    public List<Producto> filtrarPorModelo(String modelo) {
        return productoDao.filtrarPorModelo(modelo);
    }

    public List<Producto> filtrarPorDescripcion(String palabra) {
        return productoDao.filtrarPorDescripcion(palabra);
    }
}
