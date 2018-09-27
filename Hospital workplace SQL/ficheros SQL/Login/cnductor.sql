use AD_Hospital_Logins
go

declare @num int
declare @cont nvarchar(16)
declare @contEnc nvarchar(3000)
declare @passDes nvarchar(50)

select @num = 945765, @cont = '123'

--execute dbo.InsertarLogin @num, @cont
--select dbo.ValidarLogin (@num, @cont) --si devuelve 0 es que es correcto, entonces buscar en una tabla el usuario asignado en la base de datos de hospital (usuariomodificador)
select @passDes = dbo.BuscarUsuarioDeMedico_AD_Hospital (@num)
print @passDes

--INSERT INTO Medico_Login
--(NumeroColegiado, Contrasenia)
--values
--(@num, ENCRYPTBYPASSPHRASE('8954JD8RJ85HBE9SNSGH9asnAASASx', @cont))

--SELECT NumeroColegiado FROM Medico_Login WHERE NumeroColegiado=@num AND Contrasenia=DECRYPTBYPASSPHRASE('8954JD8RJ85HBE9SNSGH9asnAASASx', @cont)

--set @contEnc = (select Contrasenia from Medico_Login where NumeroColegiado = @num)
--set @passDes = DECRYPTBYPASSPHRASE('8954JD8RJ85HBE9SNSGH9asnAASASx',@contEnc)

--print @passDes

--SELECT NumeroColegiado FROM Medico_Login WHERE NumeroColegiado=@num AND Contrasenia=@contEnc
