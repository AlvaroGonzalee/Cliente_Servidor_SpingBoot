package com.example.demo.repository;

import com.example.demo.model.Producto;

import org.springframework.data.jpa.repository.JpaRepository;

//repositorio JPA que permite realizar operaciones de base de datos sobre la entidad Producto
//tiene métodos como findAll(), findById(), save(), deleteById()

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}

