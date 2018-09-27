CREATE LOGIN LoginBBDD with password = '123', default_database=AD_Hospital_Logins
USE AD_Hospital_Logins
CREATE USER LoginBBDD FOR LOGIN LoginBBDD GRANT SELECT, INSERT, UPDATE, DELETE, EXECUTE TO LoginBBDD