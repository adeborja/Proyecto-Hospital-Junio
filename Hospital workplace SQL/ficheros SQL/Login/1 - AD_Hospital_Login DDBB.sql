USE master
go

--drop database AD_Hospital_Logins

--go

create database AD_Hospital_Logins
go

use AD_Hospital_Logins
go

create table Medico_Login
(
NumeroColegiado int not null,
Contrasenia nvarchar(16) not null,
constraint PK_Medico_Login PRIMARY KEY (NumeroColegiado)
)

go


create table Superlogin
(
Nombre nvarchar(25) not null,
Contrasenia nvarchar(50) not null,
constraint PK_Superlogin primary key (Nombre)
)

go


CREATE TABLE Login_Medico_Usuario
(
NumeroColegiadoMedico int not null,
UsuarioAsignado nvarchar(25) not null,
constraint PK_Login_Medico_Usuario primary key (NumeroColegiadoMedico),
constraint FK_Login_Medico_Usuario1 foreign key (UsuarioAsignado) references SuperLogin (Nombre),
constraint FK_Login_Medico_Usuario2 foreign key (NumeroColegiadoMedico) references Medico_Login (NumeroColegiado)
)

go


