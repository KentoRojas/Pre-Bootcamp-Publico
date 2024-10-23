-- Agregar datos
INSERT INTO clientes (nombre, direccion, telefono) 
VALUES 
    ("Bull", "Calle Artificer 120", "+56 988852205"),
    ("Zeri", "Calle Samir 980", "+56 984298205"),
    ("Jensen", "Calle Cashmir 660", "+56 987552205"),
    ("Martin", "Calle Cougar 520", "+56 954212205"),
    ("Cell", "Calle Toah 360", "+56 914342205"); 

-- Agregar pedidos
INSERT INTO pedidos (cliente_id, fecha, total) 
VALUES 
    (1, '2024-10-01', 15000.00),
    (2, '2024-10-02', 25000.50),
    (3, '2024-10-03', 30000.75),
    (4, '2024-10-04', 12000.20),
    (5, '2024-10-05', 18000.00),
    (1, '2024-10-06', 22000.00),
    (2, '2024-10-07', 27000.25),
    (3, '2024-10-08', 32000.50),
    (4, '2024-10-09', 15000.75),
    (5, '2024-10-10', 19000.90); 

-- Mostrar clientes y pedidos
SELECT c.id, c.nombre, p.fecha, p.total
FROM clientes c
LEFT JOIN pedidos p ON c.id = p.cliente_id;

-- Mostrar pedidos específicos 
SELECT * FROM pedidos WHERE cliente_id = 1; 

-- Suma total de pedidos por cliente
SELECT c.id, c.nombre, SUM(p.total) AS total_pedidos
FROM clientes c
LEFT JOIN pedidos p ON c.id = p.cliente_id
GROUP BY c.id;

-- Eliminación de pedidos y cliente
DELETE FROM pedidos WHERE cliente_id = 1;
DELETE FROM clientes WHERE id = 1;

-- Tres clientes con más pedidos
SELECT c.id, c.nombre, COUNT(p.id) AS total_pedidos
FROM clientes c
JOIN pedidos p ON c.id = p.cliente_id
GROUP BY c.id
ORDER BY total_pedidos DESC
LIMIT 3;
