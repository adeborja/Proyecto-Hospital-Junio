USE master
GO

IF DB_ID('AD_Hospital') IS NOT NULL
BEGIN
	DROP DATABASE AD_Hospital
END

CREATE DATABASE AD_Hospital
GO

USE AD_Hospital
GO

CREATE TABLE Medicos(
Nombre nvarchar(20) not null,
Apellidos nvarchar(20) not null,
DNI nvarchar(9) not null,
FechaNacimiento date not null,
NumeroColegiado int not null,
Especialidad nvarchar(20) not null,
Sexo nvarchar(1) not null,
CONSTRAINT PK_Medicos PRIMARY KEY (NumeroColegiado),
CONSTRAINT CK_DNI_Medicos CHECK(DNI LIKE '[0123456789][0123456789][0123456789][0123456789][0123456789][0123456789][0123456789][0123456789][TRWAGMYFPDXBNJZSQVHLCKE]'),
CONSTRAINT CK_Sexo_Medicos CHECK(Sexo IN ('V','M'))
)

GO

CREATE TABLE MedicosDeBaja (
ID int identity(1,1),
NumeroColegiadoMedico int not null,
FechaInicio SMALLdateTIME not null,
FechaFin  SMALLdateTIME null,
CONSTRAINT PK_MedicosDeBaja PRIMARY KEY (ID),
CONSTRAINT FK_MedicosDeBaja1 FOREIGN KEY (NumeroColegiadoMedico) REFERENCES Medicos (NumeroColegiado) ON DELETE NO ACTION ON UPDATE CASCADE
)

GO

CREATE TABLE Pacientes(
Nombre nvarchar(20) not null,
Apellidos nvarchar(20) not null,
DNI nvarchar(9) not null,
FechaNacimiento date not null,
NumeroSeguridadSocial int not null,
Sexo nvarchar(1) not null,
CONSTRAINT PK_Pacientes PRIMARY KEY (NumeroSeguridadSocial),
CONSTRAINT CK_DNI_Pacientes CHECK(DNI LIKE '[0123456789][0123456789][0123456789][0123456789][0123456789][0123456789][0123456789][0123456789][TRWAGMYFPDXBNJZSQVHLCKE]'),
CONSTRAINT CK_Sexo_Pacientes CHECK(Sexo IN ('V','M'))
)

GO

CREATE TABLE IngresoDePacientes( --Modificar a IngresoDePacientes para controlar cuando son ingresados y cuando son dados de alta. Generar automaticamente si se introduce un nuevo paciente en la tabla de pacientes
ID int identity(1,1),
NumeroSeguridadSocialPaciente int not null,
FechaDeIngreso SMALLdateTIME not null,
FechaDeAlta SMALLdateTIME null,
CONSTRAINT PK_AltaDePacientes PRIMARY KEY (ID),
CONSTRAINT FK_AltaDePacientes1 FOREIGN KEY (NumeroSeguridadSocialPaciente) REFERENCES Pacientes (NumeroSeguridadSocial) ON DELETE NO ACTION ON UPDATE CASCADE
)

GO

CREATE TABLE Intervenciones(
ID INT NOT NULL IDENTITY(1,1),
NumeroSeguridadSocialPaciente int not null,
NumeroColegiadoMedico int not null,
Fecha SMALLdateTIME not null,
Descripcion nvarchar(32) not null,
CONSTRAINT PK_Intervenciones PRIMARY KEY(ID),
CONSTRAINT FK_Intervenciones1 FOREIGN KEY (NumeroSeguridadSocialPaciente) REFERENCES Pacientes (NumeroSeguridadSocial) ON DELETE NO ACTION ON UPDATE CASCADE,
CONSTRAINT FK_Intervenciones2 FOREIGN KEY (NumeroColegiadoMedico) REFERENCES Medicos (NumeroColegiado) ON DELETE NO ACTION ON UPDATE CASCADE
)

GO

