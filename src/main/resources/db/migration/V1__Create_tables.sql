CREATE TABLE franquicia (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
);

CREATE TABLE sucursal (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    franquicia_id INT,
    FOREIGN KEY (franquicia_id) REFERENCES franquicia(id)
);

CREATE TABLE producto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    stock INT,
    sucursal_id INT,
    FOREIGN KEY (sucursal_id) REFERENCES sucursal(id)
);
