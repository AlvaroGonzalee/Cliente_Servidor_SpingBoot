
#  Actividad1_SpringBoot

##  Introducción

**Actividad1_SpringBoot** es un microservicio REST desarrollado con **Spring Boot** que permite gestionar productos en una base de datos MySQL. A través de un cliente en **Python**, los usuarios pueden listar, agregar, modificar y eliminar productos.

###  Tecnologías utilizadas:
- **Java 17**
- **Spring Boot 3.4.4**
- **Spring Data JPA**
- **MySQL 8**
- **Python 3.13**
- **Requests (librería Python)**
- **AspectJ (AOP)**
- **Maven**

##  Guía de Uso

###  Ejecución del Microservicio (Spring Boot)

1. Configura la base de datos MySQL:
   ```sql
   CREATE DATABASE [nombre];
   ```
2. Ajusta las credenciales en `src/main/resources/application.properties`
   ```properties
   spring.datasource.username=usuario
   spring.datasource.password=contraseña
   ```
3. Ejecuta el proyecto con:


###  Ejecución del Cliente (Python)

1. Instala la librería `requests`:
   ```bash
   pip install requests
   ```
2. Ejecuta el cliente:
  

###  Ejemplo de uso:
```
Menú de opciones:
1. Listar productos
2. Agregar producto
3. Modificar producto
4. Eliminar producto
5. Consultar estadísticas
6. Salir

Selecciona una opción: 1

Lista de productos:
ID: 1, Nombre: Ratón, Precio: 25.50, Cantidad: 5
```

##  Arquitectura del Sistema

###  Diagrama de Arquitectura:

```
+------------+          HTTP/JSON          +--------------------+          JDBC          +----------------+
|   Cliente  |  <-------------------->    |   Spring Boot API   |  <------------->       |   MySQL DB     |
|  Python    |       (requests)            |  ProductoController |                      |  springboot_act1|
+------------+                             +--------------------+                       +----------------+
```

###  Componentes principales:
- **Cliente Python**: Interfaz de línea de comandos que consume el microservicio.
- **Spring Boot API**:
  - `ProductoController`: expone las operaciones REST.
  - `ProductoService`: lógica de negocio.
  - `ProductoRepository`: acceso a base de datos mediante JPA.
  - `EstadisticasAspect`: AOP para estadísticas de peticiones.
- **Base de Datos MySQL**: almacena los productos.

##  Esquema de la Base de Datos

###  Diagrama de la tabla `Producto`

| Campo     | Tipo de Dato       | Descripción                       |
|------------|---------------------|------------------------------------|
| `id`        | BIGINT (auto-increment) | Identificador único de producto |
| `nombre`    | VARCHAR(255)         | Nombre del producto                |
| `precio`    | DOUBLE               | Precio del producto                |
| `cantidad`  | INTEGER              | Cantidad en stock                  |

###  Base de Datos:
- **Nombre**: `springboot_act1`
- **Motor**: **MySQL 8**
- **Hibernate Dialect**: `MySQL8Dialect`
- **Configuración**:
  ```properties
  spring.jpa.hibernate.ddl-auto=update
  spring.jpa.show-sql=true
  ```
