USE AD_Hospital
GO

INSERT INTO Medicos
(Nombre, Apellidos, FechaNacimiento, DNI, NumeroColegiado, Especialidad, Sexo)
VALUES
('PACO', 'PELUCA', SMALLDATETIMEFROMPARTS(1965,5,5,0,0), '12345678A', 945765, 'CAPILAROLOGIA', 'V'),
('ELENA', 'DADORA', SMALLDATETIMEFROMPARTS(1977,9,22,0,0), '12345679M', 111, 'TOBILLOLOGIA', 'M')

go

INSERT INTO Pacientes
(Nombre, Apellidos, FechaNacimiento, DNI, NumeroSeguridadSocial, Sexo)
VALUES
('AITOR','TILLA',SMALLDATETIMEFROMPARTS(1984,5,12,6,12), '12345678A',6,'V')

GO

INSERT INTO Intervenciones
(NumeroSeguridadSocialPaciente, NumeroColegiadoMedico, Fecha, Descripcion)
VALUES
(6, 945765, SMALLDATETIMEFROMPARTS(2017,1,1,1,1), 'TRANSPLANTE DE PELO')



go

--select * from Intervenciones

--delete from Intervenciones where id = 1

----alter table intervenciones enable trigger ComprobarFechaEliminacion

--select * from ingresodepacientes

--delete from IngresoDePacientes

--INSERT INTO IngresoDePacientes
--(NumeroSeguridadSocialPaciente, FechaDeIngreso)
--values
--(6, DATEADD(day,-4,CURRENT_TIMESTAMP))

UPDATE IngresoDePacientes
SET FechaDeIngreso = DATEADD(day,-4,CURRENT_TIMESTAMP)
WHERE NumeroSeguridadSocialPaciente=6


UPDATE IngresoDePacientes
SET FechaDeAlta = DATEADD(day,-2,CURRENT_TIMESTAMP)
WHERE NumeroSeguridadSocialPaciente=6


--SELECT * FROM MEDICOSDEBAJA

INSERT INTO MedicosDeBaja
(NumeroColegiadoMedico, FechaInicio)
VALUES
(945765, DATEADD(day,-15,CURRENT_TIMESTAMP))

UPDATE MedicosDeBaja
SET FechaFin = DATEADD(day,-8,CURRENT_TIMESTAMP)
WHERE NumeroColegiadoMedico=945765

