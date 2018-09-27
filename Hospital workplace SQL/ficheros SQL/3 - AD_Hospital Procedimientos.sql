use AD_Hospital
go

/**
devuelve 0 si el medico existe y 1 si no
*/
CREATE FUNCTION ComprobarMedico (@numero int)
RETURNS INT AS
BEGIN
	DECLARE @codigo tinyint

	IF(SELECT NumeroColegiado FROM Medicos WHERE NumeroColegiado=@numero) IS NOT NULL
	BEGIN
		set @codigo = 0
	END
	ELSE
	BEGIN
		SET @codigo = 1
	END

	RETURN @codigo
END

GO

--declare @num int
--set @num = 112

--SELECT dbo.ComprobarMedico (@num)

go

/**
devuelve 0 si el medico no esta de baja y 1 si lo esta
*/
CREATE FUNCTION ComprobarBajaDeMedico (@numero int)
RETURNS INT AS
BEGIN
	DECLARE @codigo TINYINT

	IF(SELECT ID FROM MedicosDeBaja WHERE NumeroColegiadoMedico=@numero AND FechaFin IS NULL) IS NULL
	BEGIN
		SET @codigo = 0
	END
	ELSE
	BEGIN
		SET @codigo = 1
	END

	RETURN @codigo
END

GO

--select * from MedicosDeBaja

----insert into MedicosDeBaja
----(NumeroColegiadoMedico, FechaInicio)
----values
----(111,CURRENT_TIMESTAMP)

--declare @numero int
--set @numero = 111

--select dbo.ComprobarBajaDeMedico (@numero)

GO
/**
metodo para escribir a un medico en la tabla de bajas
*/
create PROCEDURE EscribirBajaDeMedico @numero int, @fecha smalldatetime = null--, @codigo tinyint output
AS
BEGIN

	--declare @codigo tinyint

		IF(@fecha is null)
		begin
			set @fecha = CURRENT_TIMESTAMP
		end

		begin try
			insert into MedicosDeBaja
			(NumeroColegiadoMedico, FechaInicio)
			values
			(@numero,@fecha)

			--set @codigo = 0

		end try
		begin catch
			THROW;
		end catch


	--END

	--RETURN @codigo

END

GO

/*select * from MedicosDeBaja
--delete from MedicosDeBaja where NumeroColegiadoMedico = 945765 and FechaFin is null	

declare @numero int
declare @codigoDevuelto tinyint

set @numero = 945765
--https://docs.microsoft.com/es-es/sql/relational-databases/stored-procedures/return-data-from-a-stored-procedure?view=sql-server-2017
--execute EscribirBajaDeMedico @numero, null--, @codigo = @codigoDevuelto output; --existe ya un trigger que impide que se introduzca un medico que ya esta de baja
execute EscribirBajaDeMedico @numero, '2000-02-02 02:02' --ponerlo como datos individuales?

select SMALLDATETIMEFROMPARTS(2000,2,2,2,2)

print @codigoDevuelto
*/

GO

/**
metodos para escribir un paciente en la tabla de ingresos
*/
create PROCEDURE EscribirIngresoPaciente @numero int, @fecha smalldatetime = null
AS
BEGIN

		IF(@fecha is null)
		begin
			set @fecha = CURRENT_TIMESTAMP
		end

		begin try
			insert into IngresoDePacientes
			(NumeroSeguridadSocialPaciente, FechaDeIngreso)
			values
			(@numero,@fecha)

		end try
		begin catch
			THROW;
		end catch

END

GO



