insert into UsuarioTipo(IdTipo, Detalle) values (1, 'ADMINISTRADOR');
insert into UsuarioTipo(IdTipo, Detalle) values (2, 'VENDEDOR');

insert into PersonalDocumento(IdTipoDocumento, Detalle) values (1, 'DNI');
insert into PersonalDocumento(IdTipoDocumento, Detalle) values (2, 'CARNET DE EXTRANJERIA');
insert into PersonalDocumento(IdTipoDocumento, Detalle) values (3, 'PASAPORTE');

insert into Personal(IdEmpresa, IdTipoDocumento, NroDocumento, ApePaterno, ApeMaterno, Nombres, FechaNacimiento, Genero, Celular, Email, Direccion, FechaRegistro, IdPersonalRegistro, FlagActivo) values(1, 1, '46669103', 'Torres', 'Zárate', 'Jorge Luis', '1988-07-05', 'M', '995620211', 'test@gmail.com', 'Naranjal', '2025-08-30', 1, 1);
insert into Personal(IdEmpresa, IdTipoDocumento, NroDocumento, ApePaterno, ApeMaterno, Nombres, FechaNacimiento, Genero, Celular, Email, Direccion, FechaRegistro, IdPersonalRegistro, FlagActivo) values(1, 1, '46669104', 'Vargas', 'Ramirez', 'Juan', '1990-01-01', 'M', '995620212', 'test2@gmail.com', 'Naranjal', '2025-08-30', 1, 1);