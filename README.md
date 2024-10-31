# franquicias-api

## Descripción

API REST para gestionar franquicias, sucursales y productos, permitiendo la creación, modificación y consulta de estos elementos.

## Requisitos Previos

- Java 17 o superior
- MySQL (o cualquier otro gestor de base de datos que uses)
- Maven

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

