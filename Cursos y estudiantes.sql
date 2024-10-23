-- Insertar estudiantes
INSERT INTO estudiantes (nombre, edad) 
VALUES ("Martin", 25),
       ("Sarif", 21),
       ("Almi", 20),
       ("Jensen", 23),
       ("Maria", 22);

-- Insertar cursos
INSERT INTO cursos (nombre, duracion) 
VALUES ("Curso de Primeros Auxilios", "5 meses"),
       ("Curso de Lectura Clasica", "4 meses"),
       ("Curso Introduccion al Buceo", "6 meses"),
       ("Curso Ciberseguridad", "8 meses"),
       ("Curso Analisis de datos", "1 año");

-- Insertar inscripciones
INSERT INTO inscripciones (id_estudiante, id_curso)
VALUES (1, 1), (1, 2),
       (2, 3), (2, 4),
       (3, 5), (3, 1),
       (4, 2), (4, 3);

-- estudiantes y cursos
SELECT e.nombre AS nombre_estudiante, c.nombre AS nombre_curso
FROM inscripciones i
JOIN estudiantes e ON i.id_estudiante = e.id
JOIN cursos c ON i.id_curso = c.id;

-- estudiantes curso específico 
SELECT e.nombre AS nombre_estudiante
FROM inscripciones i
JOIN estudiantes e ON i.id_estudiante = e.id
JOIN cursos c ON i.id_curso = c.id
WHERE c.nombre IN (
    'Curso de Primeros Auxilios',
    'Curso de Lectura Clasica',
    'Curso Introduccion al Buceo',
    'Curso Ciberseguridad',
    'Curso Analisis de datos'
);

--  cursos estudiante específico
SELECT c.nombre AS nombre_curso
FROM inscripciones i
JOIN cursos c ON i.id_curso = c.id
JOIN estudiantes e ON i.id_estudiante = e.id
WHERE e.nombre IN ('Martin', 'Sarif', 'Almi', 'Jensen', 'Maria');

-- estudiantes por curso
SELECT c.nombre AS nombre_curso, COUNT(i.id_estudiante) AS numero_estudiantes
FROM cursos c
LEFT JOIN inscripciones i ON c.id = i.id_curso
GROUP BY c.nombre;

-- estudiantes no inscritos 
SELECT e.nombre AS nombre_estudiante
FROM estudiantes e
LEFT JOIN inscripciones i ON e.id = i.id_estudiante
WHERE i.id_estudiante IS NULL;











