CREATE LOGIN UsuarioModificador with password = '123', default_database=AD_Hospital
USE AD_Hospital
CREATE USER UsuarioModificador FOR LOGIN UsuarioModificador GRANT INSERT, UPDATE, DELETE, EXECUTE TO UsuarioModificador

grant select to UsuarioModificador
--deny select to UsuarioModificador


CREATE LOGIN UsuarioConsultor with password = '123', default_database=AD_Hospital
use AD_Hospital
create user UsuarioConsultor for login UsuarioConsultor grant select to UsuarioConsultor