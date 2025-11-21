CREATE TABLE public.clientes_greenpath (
                                           nome_cliente VARCHAR(250) NOT NULL,
                                           apelido_cliente VARCHAR(50),
                                           sexo BOOLEAN NOT NULL,
                                           senha_cliente VARCHAR(255) NOT NULL,
                                           data_nascimento DATE NOT NULL,
                                           idade INTEGER NOT NULL,
                                           email_usuario VARCHAR(175) NOT NULL,
                                           cep VARCHAR(50) NOT NULL,
                                           proposta VARCHAR(500) NOT NULL,
                                           saldo_green_wallet DOUBLE PRECISION NOT NULL,
                                           ultimo_credito DOUBLE PRECISION NOT NULL,
                                           id INTEGER NOT NULL
);

CREATE SEQUENCE public.clientes_greenpath_id_seq
    AS INTEGER
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE public.clientes_greenpath_id_seq OWNED BY public.clientes_greenpath.id;

ALTER TABLE ONLY public.clientes_greenpath
    ALTER COLUMN id SET DEFAULT nextval('public.clientes_greenpath_id_seq'::regclass);

ALTER TABLE ONLY public.clientes_greenpath
    ADD CONSTRAINT clientes_greenpath_pkey PRIMARY KEY (id);


-- Spring Session (necessário pro Spring Boot 3 funcionar)
CREATE TABLE public.spring_session (
                                       primary_id CHAR(36) NOT NULL,
                                       session_id CHAR(36) NOT NULL,
                                       creation_time BIGINT NOT NULL,
                                       last_access_time BIGINT NOT NULL,
                                       max_inactive_interval INTEGER NOT NULL,
                                       expiry_time BIGINT NOT NULL,
                                       principal_name VARCHAR(100)
);

CREATE TABLE public.spring_session_attributes (
                                                  session_primary_id CHAR(36) NOT NULL,
                                                  attribute_name VARCHAR(200) NOT NULL,
                                                  attribute_bytes BYTEA NOT NULL
);

ALTER TABLE public.spring_session ADD CONSTRAINT spring_session_pk PRIMARY KEY (primary_id);

ALTER TABLE public.spring_session_attributes ADD CONSTRAINT spring_session_attributes_pk
    PRIMARY KEY (session_primary_id, attribute_name);

ALTER TABLE public.spring_session_attributes
    ADD CONSTRAINT spring_session_attributes_fk
        FOREIGN KEY (session_primary_id)
            REFERENCES public.spring_session(primary_id)
            ON DELETE CASCADE;
