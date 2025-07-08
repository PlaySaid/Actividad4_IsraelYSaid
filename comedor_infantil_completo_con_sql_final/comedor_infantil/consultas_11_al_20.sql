
-- Consulta 11
SELECT DISTINCT a.id_asesor, a.nombre
FROM Asesores a
JOIN Historial_Asesores h ON a.id_asesor = h.id_asesor
WHERE h.empresa = 'Nombre_Empresa_Especifica';

-- Consulta 12
SELECT a.nombre, h.area, 
       SUM(DATEDIFF(h.fecha_fin, h.fecha_inicio)) AS dias_trabajados
FROM Asesores a
JOIN Historial_Asesores h ON a.id_asesor = h.id_asesor
WHERE h.area = 'Nombre_Area'
GROUP BY a.nombre, h.area;

-- Consulta 13
SELECT DISTINCT n.id_nino, n.nombre
FROM Ninos n
JOIN Consumo_Comidas cc ON n.id_nino = cc.id_nino
WHERE cc.fecha >= CURDATE() - INTERVAL 7 DAY;

-- Consulta 14
SELECT t.id_tutor, t.nombre, p.monto, p.fecha_pago
FROM Pagos p
JOIN Tutores t ON p.id_tutor = t.id_tutor
WHERE p.estado_pago = 'pendiente';

-- Consulta 15
SELECT t.nombre AS tutor, n.nombre AS nino, p.monto, p.fecha_pago
FROM Pagos p
JOIN Tutores t ON p.id_tutor = t.id_tutor
JOIN Ninos n ON p.id_nino = n.id_nino
WHERE MONTH(p.fecha_pago) = MONTH(CURDATE()) 
  AND YEAR(p.fecha_pago) = YEAR(CURDATE());

-- Consulta 16
SELECT n.id_nino, n.nombre, COUNT(*) AS total_comidas
FROM Consumo_Comidas cc
JOIN Ninos n ON cc.id_nino = n.id_nino
GROUP BY n.id_nino, n.nombre
ORDER BY total_comidas DESC;

-- Consulta 17
SELECT DISTINCT t.id_tutor, t.nombre, rc.cuenta_bancaria, rc.fecha_cambio
FROM Responsables_Cuenta rc
JOIN Tutores t ON rc.id_tutor = t.id_tutor
WHERE rc.fecha_cambio >= CURDATE() - INTERVAL 30 DAY;

-- Consulta 18
SELECT a.id_asesor, a.nombre, 
       SUM(DATEDIFF(h.fecha_fin, h.fecha_inicio)) AS dias_servicio
FROM Asesores a
JOIN Historial_Asesores h ON a.id_asesor = h.id_asesor
GROUP BY a.id_asesor, a.nombre
ORDER BY dias_servicio DESC;

-- Consulta 19
SELECT n.id_nino, n.nombre, COUNT(DISTINCT cc.fecha) AS dias_asistencia
FROM Consumo_Comidas cc
JOIN Ninos n ON cc.id_nino = n.id_nino
WHERE cc.fecha >= CURDATE() - INTERVAL 3 MONTH
GROUP BY n.id_nino, n.nombre
ORDER BY dias_asistencia DESC;

-- Consulta 20
SELECT MONTH(cc.fecha) AS mes, YEAR(cc.fecha) AS anio, 
       COUNT(*) * 1.50 AS costo_total -- Ej: $1.50 por comida
FROM Consumo_Comidas cc
WHERE MONTH(cc.fecha) = 6 AND YEAR(cc.fecha) = 2025
GROUP BY MONTH(cc.fecha), YEAR(cc.fecha);
