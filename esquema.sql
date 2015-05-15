
CREATE TABLE industria
(
  id SERIAL NOT NULL,
  nombre_industria text,
  descripcion text,
  CONSTRAINT industria_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);

CREATE TABLE empresa
(
  id SERIAL NOT NULL,
  nombre_empresa text,
  cargo text,
  direccion_empresa text,
  telefono_empresa integer,
  CONSTRAINT empresa_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);


CREATE TABLE contacto
(
  id SERIAL NOT NULL,
  telefono_cliente integer,
  direccion_cliente text,
  correo text,
  celular integer,
  departamento text,
  CONSTRAINT contacto_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);

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
  
