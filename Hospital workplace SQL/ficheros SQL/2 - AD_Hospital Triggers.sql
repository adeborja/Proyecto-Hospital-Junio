USE AD_Hospital
GO

/**
Si el dia de la intervencion es anterior al dia actual, se considera que la intervencion ya ha sido realizada y que no puede ser eliminada.
Se concede un dia extra en caso de que una operacion programada sea cancelada en el ultimo momento.
*/
create TRIGGER ComprobarFechaEliminacion ON Intervenciones AFTER DELETE AS
BEGIN
	
	declare @fechaIntervencion smalldatetime
	declare @fechaLimite smalldatetime
	set @fechaIntervencion = DATEADD(day,1,(select Fecha from deleted))
	set @fechaLimite = CURRENT_TIMESTAMP

	IF(@fechaIntervencion<@fechaLimite)
	BEGIN
		ROLLBACK;
		--RAISERROR ('La fecha de la intervencion es anterior al dia actual, no puede ser eliminada.', 16, 0)
		THROW 51000, 'La intervencion no puede ser eliminada. La fecha de la intervencion es anterior al dia actual.', 0;
	END
END

GO

/**
Se crea un nuevo ingreso del paciente que ha sido dado de alta en el sistema de forma automatica
*/
CREATE TRIGGER CrearIngresoDePaciente ON Pacientes AFTER INSERT AS
BEGIN
	declare @numeroSS int
	set @numeroSS = (select NumeroSeguridadSocial from inserted)

	INSERT INTO IngresoDePacientes
	(NumeroSeguridadSocialPaciente, FechaDeIngreso)
	values
	(@numeroSS, CURRENT_TIMESTAMP)

END

GO

/**
Si ya hay un paciente ingresado sin haber sido dado de alta, no puede ser ingresado de nuevo
*/
CREATE TRIGGER PacienteYaIngresado ON IngresoDePacientes AFTER INSERT AS
BEGIN
	DECLARE @NumeroSS int
	DECLARE @IDinsertado int

	SET @NumeroSS = (select NumeroSeguridadSocialPaciente from inserted)
	SET @IDinsertado = (select ID from inserted)

	IF EXISTS(SELECT ID FROM IngresoDePacientes WHERE NumeroSeguridadSocialPaciente=@NumeroSS AND ID!=@IDinsertado AND FechaDeAlta IS NULL)
	BEGIN
		ROLLBACK;
		THROW 51002, 'No se puede realizar un nuevo ingreso de un paciente que ya esta ingresado.', 0;
	END
END

GO

/**
Si el medico ya esta dado de baja, no puede ser nuevamente dado de baja
*/
CREATE TRIGGER MedicoYaEnBaja ON MedicosDeBaja AFTER INSERT AS
BEGIN
	DECLARE @NumeroColegiado int
	DECLARE @IDinsertado int

	SET @NumeroColegiado = (select NumeroColegiadoMedico from inserted)
	SET @IDinsertado = (select ID from inserted)

	IF EXISTS(SELECT ID FROM MedicosDeBaja WHERE NumeroColegiadoMedico=@NumeroColegiado AND ID!=@IDinsertado AND FechaFin IS NULL)
	BEGIN
		ROLLBACK;
		THROW 51001, 'No se puede dar de baja a un medico que ya esta de baja.', 0;
	END
END
