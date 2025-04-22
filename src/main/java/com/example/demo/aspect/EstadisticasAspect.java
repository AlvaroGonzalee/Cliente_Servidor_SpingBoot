package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


// Programacion orientada a aspectos intercepta las llamadas de productoControler y las registras en estadisticas
@Aspect
@Component
public class EstadisticasAspect {

    private final Map<String, Integer> estadisticas = new HashMap<>();

    @Before("execution(* com.example.demo.controller.ProductoController.*(..))")
    public void registrarEstadistica(JoinPoint joinPoint) {
        String metodo = joinPoint.getSignature().getName();
        String tipoPeticion = Arrays.stream(joinPoint.getArgs())
            .filter(arg -> arg instanceof HttpServletRequest)
            .map(arg -> ((HttpServletRequest) arg).getMethod())
            .findFirst()
            .orElse("Metodo");

        String key = tipoPeticion + " " + metodo;
        estadisticas.put(key, estadisticas.getOrDefault(key, 0) + 1);
        System.out.println("Estadísticas actualizadas: " + estadisticas);
    }

    public Map<String, Integer> getEstadisticas() {
        return estadisticas;
    }
}
