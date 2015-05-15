
/*
industria.nombre as nombre_empresa, industria.descripcion
*/
CREATE TABLE industria
(
  id SERIAL NOT NULL,
  nombre text,
  descripcion text,
  CONSTRAINT industria_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
/*
empresa.nombre, empresa.cargo, empresa.direccion, empresa.telefono as telefono_empresa
*/
CREATE TABLE empresa
(
  id SERIAL NOT NULL,
  nombre text,
  cargo text,
  direccion text,
  telefono integer,
  CONSTRAINT empresa_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);

/*
contacto.telefono, contacto.direccion, contacto.correo, contacto.celular, contacto.departamento
*/
CREATE TABLE contacto
(
  id SERIAL NOT NULL,
  telefono integer,
  direccion text,
  correo text,
  celular integer,
  departamento text,
  CONSTRAINT contacto_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
/*
socialdata.facebook, socialdata.twitter, socialdata.google+ , socialdata.youtube,
socialdata.tumblr
*/
CREATE TABLE socialdata
(
  id SERIAL NOT NULL,
  facebook text,
  twitter text,
  "google+" text,
  youtube text,
  tumblr text,
  CONSTRAINT socialdata_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
/*
cliente.nombre, cliente.apellido, cliente.dpi, cliente.rating, cliente.genero,
cliente.fecha_nacimiento as 'fecha nacimiento', cliente.foto, 
*/
CREATE TABLE cliente
(
  id SERIAL NOT NULL,
  nombre text,
  apellido text,
  rating double precision,
  dpi text,
  genero text,
  fecha_nacimiento date,
  foto text,
  contacto_idcontacto integer,
  empresa_idempresa integer,
  socialdata_idsocialdata integer,
  industria_idindustria integer,
  CONSTRAINT cliente_pkey PRIMARY KEY (id),
  CONSTRAINT cliente_contacto_idcontacto_fkey FOREIGN KEY (contacto_idcontacto)
      REFERENCES contacto (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT cliente_empresa_idempresa_fkey FOREIGN KEY (empresa_idempresa)
      REFERENCES empresa (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT cliente_industria_idindustria_fkey FOREIGN KEY (industria_idindustria)
      REFERENCES industria (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT cliente_socialdata_idsocialdata_fkey FOREIGN KEY (socialdata_idsocialdata)
      REFERENCES socialdata (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
  
