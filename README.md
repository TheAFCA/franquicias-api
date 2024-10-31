# franquicias-api

## Descripción

API REST para gestionar franquicias, sucursales y productos, permitiendo la creación, modificación y consulta de estos elementos.

## Requisitos Previos

- Java 17 o superior
- MySQL (o cualquier otro gestor de base de datos que uses)
- Maven

## Ejecutar el Proyecto con Docker

Este proyecto incluye un archivo `docker-compose.yml` que facilita la creación y ejecución de los contenedores necesarios para la aplicación y la base de datos.

## Configuración

1. Clona el repositorio:
   ```bash
   git clone https://github.com/TheAFCA/franquicias-api.git
   cd franquicias

## Endpoints de la API

### 1. Crear una Franquicia

- **Método:** `POST`
- **URL:** `http://localhost:8080/api/franquicias`
- **Descripción:** Crea una nueva franquicia.
- **Request Body:**
    ```json
    {
      "nombre": "Franquicia Ejemplo"
    }
    ```
- **Responses:**
   - **Código 201:** Franquicia creada exitosamente.
   - **Código 400:** Datos inválidos.

---

### 2. Agregar una Sucursal a una Franquicia

- **Método:** `POST`
- **URL:** `http://localhost:8080/api/franquicias/{franquiciaId}/sucursales`
- **Descripción:** Agrega una nueva sucursal a una franquicia específica.
- **Request Body:**
    ```json
    {
      "nombre": "Sucursal Ejemplo"
    }
    ```
- **Responses:**
   - **Código 201:** Sucursal creada exitosamente.
   - **Código 404:** Franquicia no encontrada.
   - **Código 500:** Error interno del servidor.

---

### 3. Agregar un Producto a una Sucursal

- **Método:** `POST`
- **URL:** `http://localhost:8080/api/sucursales/{sucursalId}/productos`
- **Descripción:** Agrega un nuevo producto a una sucursal específica.
- **Request Body:**
    ```json
    {
      "nombre": "Producto Ejemplo",
      "stock": 100
    }
    ```
- **Responses:**
   - **Código 201:** Producto creado exitosamente.
   - **Código 404:** Sucursal no encontrada.
   - **Código 500:** Error interno del servidor.

---

### 4. Eliminar un Producto

- **Método:** `DELETE`
- **URL:** `http://localhost:8080/api/productos/{productoId}`
- **Descripción:** Elimina un producto específico.
- **Responses:**
   - **Código 204:** Producto eliminado exitosamente.
   - **Código 404:** Producto no encontrado.
   - **Código 500:** Error interno del servidor.

---

### 5. Modificar el Stock de un Producto

- **Método:** `PUT`
- **URL:** `http://localhost:8080/api/productos/{productoId}/stock`
- **Descripción:** Modifica el stock de un producto específico.
- **Request Body:**
    ```json
    {
      "stock": 50
    }
    ```
- **Responses:**
   - **Código 200:** Stock actualizado exitosamente.
   - **Código 404:** Producto no encontrado.
   - **Código 500:** Error interno del servidor.

---

### 6. Obtener Productos con Mayor Stock por Franquicia

- **Método:** `GET`
- **URL:** `http://localhost:8080/api/franquicias/{franquiciaId}/productos-mayor-stock`
- **Descripción:** Retorna el producto con mayor stock por sucursal de una franquicia específica.
- **Responses:**
   - **Código 200:** Lista de productos con su sucursal correspondiente.
   - **Código 404:** Franquicia no encontrada.
   - **Código 500:** Error interno del servidor.

---

### PLUS. Actualizar nombre franquicia

- **Método:** `PUT`
- **URL:** `http://localhost:8080/api/franquicias/{id}?nuevoNombre=Prueba actualizar 11`
- **Descripción:** Actualiza nombre de la franquicia.
- **Responses:**
  - **Código 200:** Actualización exito.
  - **Código 404:** Franquicia no encontrado.
  - **Código 500:** Error interno del servidor.

---

### PLUS. Actualizar nombre Sucursal

- **Método:** `PUT`
- **URL:** `http://localhost:8080/api/franquicias/{id}/nombre?nuevoNombre=Actualizacion nombre`
- **Descripción:** Actualiza nombre de la sucursal.
- **Responses:**
  - **Código 200:** Actualización exito.
  - **Código 404:** Sucursal no encontrado.
  - **Código 500:** Error interno del servidor.

---

### PLUS. Actualizar nombre producto

- **Método:** `PUT`
- **URL:** `http://localhost:8080/api/franquicias/{id}/nombre?nuevoNombre=Actualizacion producto`
- **Descripción:** Actualiza nombre de la sucursal.
- **Responses:**
  - **Código 200:** Actualización exito.
  - **Código 404:** Producto no encontrado.
  - **Código 500:** Error interno del servidor.

---


### Explicación de las tablas

- **franquicia**: Almacena la información sobre las franquicias. Cada franquicia tiene un `id` único y un `nombre`.

- **sucursal**: Almacena las sucursales asociadas a las franquicias. Cada sucursal tiene un `id` único, un `nombre`, y un `franquicia_id` que establece la relación con la tabla `franquicia`.

- **producto**: Almacena la información de los productos. Cada producto tiene un `id` único, un `nombre`, un `stock`, y un `sucursal_id` que establece la relación con la tabla `sucursal`.

### Instrucciones para ejecutar el script

1. Abre tu cliente MySQL.
2. Conéctate a la base de datos donde deseas crear las tablas.
3. Ejecuta el script anterior.

Esto debería hacer que tu README sea más claro y fácil de seguir. Si necesitas más ayuda o ajustes, ¡házmelo saber!

---

### Script para crear tablas en la base de datos

Este script crea las tablas necesarias para la base de datos del proyecto **franquicias**. Asegúrate de ejecutar el script en la base de datos correcta.

```sql
USE franquicias;

CREATE TABLE franquicia (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
);

CREATE TABLE sucursal (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    franquicia_id INT NOT NULL,
    FOREIGN KEY (franquicia_id) REFERENCES franquicia(id) ON DELETE CASCADE
);

CREATE TABLE producto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    stock INT NOT NULL DEFAULT 0,
    sucursal_id INT NOT NULL,
    FOREIGN KEY (sucursal_id) REFERENCES sucursal(id) ON DELETE CASCADE
);

