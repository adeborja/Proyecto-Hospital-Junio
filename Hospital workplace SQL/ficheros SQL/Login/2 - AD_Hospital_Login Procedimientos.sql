USE AD_Hospital_Logins
go

/**
Insertar un nuevo login en la tabla de logins para poder conectar a la base de datos
*/
CREATE PROCEDURE InsertarLogin (@numero int, @contrasenia nvarchar(16))
AS
BEGIN

	declare @palabraClave nvarchar(30)

	set  @palabraClave = '8954JD8RJ85HBE9SNSGH9asnAASASx' --hay que modificarlo para cogerlo de otro lado

	INSERT INTO Medico_Login
	(NumeroColegiado, Contrasenia)
	values
	(@numero, ENCRYPTBYPASSPHRASE(@palabraClave, @contrasenia))

	INSERT INTO Login_Medico_Usuario
	(NumeroColegiadoMedico, UsuarioAsignado)
	VALUES
	(@numero, 'UsuarioModificador')
END

go

/**
Comprobar si el login introducido pertenece a la base de datos
*/
create FUNCTION ValidarLogin (@numero int, @contrasenia nvarchar(50))
RETURNS int AS
BEGIN
	
	DECLARE @validez int
	declare @palabraClave nvarchar(30)
	declare @encriptada nvarchar(300)
	declare @desencriptada nvarchar(16)

	set  @palabraClave = '8954JD8RJ85HBE9SNSGH9asnAASASx' --hay que modificarlo para cogerlo de otro lado

	set @encriptada = (select Contrasenia from Medico_Login where NumeroColegiado = @numero)
	set @desencriptada = DECRYPTBYPASSPHRASE(@palabraClave,@encriptada)

	IF @contrasenia=@desencriptada
	BEGIN
		SET @validez = 0
	END
	ELSE
	BEGIN
		SET @validez = -1
	END

	RETURN @validez
END

go

/**
Buscar el usuario que se va a utilizar en la base de datos AD_Hospital para el login actual
*/
create FUNCTION BuscarUsuarioDeMedico_AD_Hospital (@numero int)
returns nvarchar(25) as
begin
	declare @usuario nvarchar(25)
	declare @contrasenia nvarchar(16)
	declare @cadenaDevuelta nvarchar(42)

	--select @usuario=UsuarioAsignado, @contrasenia=contrasenia from Login_Medico_Usuario where NumeroColegiado = @numero


	select @usuario=SL.Nombre, @contrasenia=SL.contrasenia from Superlogin as SL
	inner join Login_Medico_Usuario as LMU on SL.Nombre=LMU.UsuarioAsignado
	where NumeroColegiadoMedico = @numero


	set @cadenaDevuelta = @usuario+','+@contrasenia

	return @cadenaDevuelta
end

go



