--
-- PostgreSQL database dump
--

\restrict 5HXbNI5eOsqJ9XCcXunbgJNkN2YfhWNn2PkZGu90o7bYbH30idZih0PeL0i2kQJ

-- Dumped from database version 18.1
-- Dumped by pg_dump version 18.1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: clientes_greenpath; Type: TABLE; Schema: public; Owner: vinny
--

CREATE TABLE public.clientes_greenpath (
    nome_cliente character varying(250) NOT NULL,
    apelido_cliente character varying(50),
    sexo boolean NOT NULL,
    senha_cliente character varying(255) NOT NULL,
    data_nascimento date NOT NULL,
    idade integer NOT NULL,
    email_usuario character varying(175) NOT NULL,
    cep character varying(50) NOT NULL,
    proposta character varying(500) NOT NULL,
    saldo_green_wallet double precision CONSTRAINT clientes_greenpath_saldo_greenwallet_not_null NOT NULL,
    ultimo_credito double precision NOT NULL,
    id integer NOT NULL
);


ALTER TABLE public.clientes_greenpath OWNER TO vinny;

--
-- Name: clientes_greenpath_id_seq; Type: SEQUENCE; Schema: public; Owner: vinny
--

CREATE SEQUENCE public.clientes_greenpath_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.clientes_greenpath_id_seq OWNER TO vinny;

--
-- Name: clientes_greenpath_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: vinny
--

ALTER SEQUENCE public.clientes_greenpath_id_seq OWNED BY public.clientes_greenpath.id;


--
-- Name: spring_session; Type: TABLE; Schema: public; Owner: vinny
--

CREATE TABLE public.spring_session (
    primary_id character(36) NOT NULL,
    session_id character(36) NOT NULL,
    creation_time bigint NOT NULL,
    last_access_time bigint NOT NULL,
    max_inactive_interval integer NOT NULL,
    expiry_time bigint NOT NULL,
    principal_name character varying(100)
);


ALTER TABLE public.spring_session OWNER TO vinny;

--
-- Name: spring_session_attributes; Type: TABLE; Schema: public; Owner: vinny
--

CREATE TABLE public.spring_session_attributes (
    session_primary_id character(36) NOT NULL,
    attribute_name character varying(200) NOT NULL,
    attribute_bytes bytea NOT NULL
);


ALTER TABLE public.spring_session_attributes OWNER TO vinny;

--
-- Name: clientes_greenpath id; Type: DEFAULT; Schema: public; Owner: vinny
--

ALTER TABLE ONLY public.clientes_greenpath ALTER COLUMN id SET DEFAULT nextval('public.clientes_greenpath_id_seq'::regclass);


--
-- Data for Name: clientes_greenpath; Type: TABLE DATA; Schema: public; Owner: vinny
--

COPY public.clientes_greenpath (nome_cliente, apelido_cliente, sexo, senha_cliente, data_nascimento, idade, email_usuario, cep, proposta, saldo_green_wallet, ultimo_credito, id) FROM stdin;
Jose de axieta	Zezinho	f	321321321	2025-11-04	15	emailFoda@outlook.com	4412312	altos sexos	10	15000	1
Jose Carlos	Carlinhos	t	123	2018-07-18	25	emailReal@gmail.com	1233321-12	Teste 1	5	5000	2
Novo usuario	\N	f	Novo usuario	2012-06-12	0	NovoEmail@outlook.com	12331	Testando criar um novo usuario	3	1233	11
Novo usuario	\N	f	Novo usuario	2012-06-12	0	NovoEmail@outlook.com	12331	Testando criar um novo usuario	3	1233	12
Novo usuario	\N	f	Novo usuario	2012-06-12	0	NovoEmail@outlook.com	12331	Testando criar um novo usuario	3	1233	13
Novo usuario	\N	f	Novo usuario	2012-06-12	0	NovoEmail@outlook.com	12331	Testando criar um novo usuario	3	1233	14
Novo usuario	\N	f	Novo usuario	2012-06-12	0	NovoEmail@outlook.com	12331	Tomara que pegue1	3	1233	15
Novo usuario	\N	f	Novo usuario	2012-06-12	0	NovoEmail@outlook.com	12331	Tomara que pegue2	3	1233	16
Novo usuario	\N	f	Novo usuario	2012-06-12	0	NovoEmail@outlook.com	12331	Tomara que pegue3	3	1233	17
Maria Clara	\N	f	Senha forte o suficiente	1995-12-05	0	ContatoClara@gmail.com	68690-000	Quero credito para aumentar os recursos e alcance dos paineis solares na cidade do acara, assim aumentando as energias verdes na cidade	8.5	0	18
\.


--
-- Data for Name: spring_session; Type: TABLE DATA; Schema: public; Owner: vinny
--

COPY public.spring_session (primary_id, session_id, creation_time, last_access_time, max_inactive_interval, expiry_time, principal_name) FROM stdin;
\.


--
-- Data for Name: spring_session_attributes; Type: TABLE DATA; Schema: public; Owner: vinny
--

COPY public.spring_session_attributes (session_primary_id, attribute_name, attribute_bytes) FROM stdin;
\.


--
-- Name: clientes_greenpath_id_seq; Type: SEQUENCE SET; Schema: public; Owner: vinny
--

SELECT pg_catalog.setval('public.clientes_greenpath_id_seq', 18, true);


--
-- Name: clientes_greenpath clientes_greenpath_pkey; Type: CONSTRAINT; Schema: public; Owner: vinny
--

ALTER TABLE ONLY public.clientes_greenpath
    ADD CONSTRAINT clientes_greenpath_pkey PRIMARY KEY (id);


--
-- Name: spring_session_attributes spring_session_attributes_pk; Type: CONSTRAINT; Schema: public; Owner: vinny
--

ALTER TABLE ONLY public.spring_session_attributes
    ADD CONSTRAINT spring_session_attributes_pk PRIMARY KEY (session_primary_id, attribute_name);


--
-- Name: spring_session spring_session_pk; Type: CONSTRAINT; Schema: public; Owner: vinny
--

ALTER TABLE ONLY public.spring_session
    ADD CONSTRAINT spring_session_pk PRIMARY KEY (primary_id);


--
-- Name: spring_session_ix1; Type: INDEX; Schema: public; Owner: vinny
--

CREATE UNIQUE INDEX spring_session_ix1 ON public.spring_session USING btree (session_id);


--
-- Name: spring_session_ix2; Type: INDEX; Schema: public; Owner: vinny
--

CREATE INDEX spring_session_ix2 ON public.spring_session USING btree (expiry_time);


--
-- Name: spring_session_ix3; Type: INDEX; Schema: public; Owner: vinny
--

CREATE INDEX spring_session_ix3 ON public.spring_session USING btree (principal_name);


--
-- Name: spring_session_attributes spring_session_attributes_fk; Type: FK CONSTRAINT; Schema: public; Owner: vinny
--

ALTER TABLE ONLY public.spring_session_attributes
    ADD CONSTRAINT spring_session_attributes_fk FOREIGN KEY (session_primary_id) REFERENCES public.spring_session(primary_id) ON DELETE CASCADE;


--
-- PostgreSQL database dump complete
--

\unrestrict 5HXbNI5eOsqJ9XCcXunbgJNkN2YfhWNn2PkZGu90o7bYbH30idZih0PeL0i2kQJ

