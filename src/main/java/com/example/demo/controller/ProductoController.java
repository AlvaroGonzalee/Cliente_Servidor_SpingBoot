package com.example.demo.controller;

import com.example.demo.model.Producto;
import com.example.demo.service.ProductoService;
import com.example.demo.aspect.EstadisticasAspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//controlador REST que pone los endpoints HTTP para interactuar con los productos
// endpoints get post put delete
//es llamado por el cliente http de Python


@RestController // indicamos que es controlador Rest para que permita get  etc y devulver json
@RequestMapping("/productos") //ruta para los endpoints 
public class ProductoController {

    @Autowired //crear automáticamente una instancia de la clase y le asignaa a esa propiedad.
    private ProductoService productoService;

    @Autowired
    private EstadisticasAspect estadisticasAspect;

    @GetMapping//alguien hace un GET se ejecuta el método 
    public List<Producto> obtenerTodos() {
        return productoService.obtenerTodos();
    }

    @GetMapping("/{id}")// igual que antes pero conla ruta del id 
    public Producto obtenerPorId(@PathVariable Long id) {
        return productoService.obtenerPorId(id).orElse(null);
    }

    @PostMapping
    public Producto guardar(@RequestBody Producto producto) {
        return productoService.guardar(producto);
    }

  
    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable Long id, @RequestBody Producto producto) {
        return productoService.actualizarProducto(id, producto);
    }

    @DeleteMapping("/{id}")
    public boolean eliminarProducto(@PathVariable Long id) {
        return productoService.eliminarProducto(id);
    }

    @GetMapping("/estadisticas")
    public Map<String, Integer> obtenerEstadisticas() {
        return estadisticasAspect.getEstadisticas();
    }
}
