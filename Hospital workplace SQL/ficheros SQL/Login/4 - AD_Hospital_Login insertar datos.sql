--introducir usuario y contraseña

--si son correctos
--	devolver usuario y contraseña para bbdd
--sino
--	error
--fin si

use AD_Hospital_Logins
go

--select * from Superlogin

insert into Superlogin
(Nombre, Contrasenia)
values
('UsuarioModificador', '123'),
('UsuarioConsultor', '123')


--select * from Medico_Login

declare @num int
declare @num2 int
declare @cont nvarchar(16)

select @num = 945765, @num2 = 111, @cont = '123'

execute dbo.InsertarLogin @num, @cont
execute dbo.InsertarLogin @num2, @cont

--select * from Login_Medico_Usuario

--insert into Login_Medico_Usuario
--(NumeroColegiadoMedico, UsuarioAsignado)
--values
--(945765, 'UsuarioModificador')

