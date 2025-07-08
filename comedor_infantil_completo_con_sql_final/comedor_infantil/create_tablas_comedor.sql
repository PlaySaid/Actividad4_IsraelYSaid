
-- Tabla: Asesores
CREATE TABLE Asesores (
    id_asesor SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

-- Tabla: Historial_Asesores
CREATE TABLE Historial_Asesores (
    id SERIAL PRIMARY KEY,
    id_asesor INT REFERENCES Asesores(id_asesor),
    empresa VARCHAR(100),
    area VARCHAR(100),
    fecha_inicio DATE,
    fecha_fin DATE
);

-- Tabla: Ninos
CREATE TABLE Ninos (
    id_nino SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

-- Tabla: Consumo_Comidas
CREATE TABLE Consumo_Comidas (
    id SERIAL PRIMARY KEY,
    id_nino INT REFERENCES Ninos(id_nino),
    fecha DATE NOT NULL
);

-- Tabla: Tutores
CREATE TABLE Tutores (
    id_tutor SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

-- Tabla: Pagos
CREATE TABLE Pagos (
    id SERIAL PRIMARY KEY,
    id_tutor INT REFERENCES Tutores(id_tutor),
    id_nino INT REFERENCES Ninos(id_nino),
    monto DECIMAL(10, 2),
    fecha_pago DATE,
    estado_pago VARCHAR(20) -- Ej: 'pendiente', 'pagado'
);

-- Tabla: Responsables_Cuenta
CREATE TABLE Responsables_Cuenta (
    id SERIAL PRIMARY KEY,
    id_tutor INT REFERENCES Tutores(id_tutor),
    cuenta_bancaria VARCHAR(50),
    fecha_cambio DATE
);
