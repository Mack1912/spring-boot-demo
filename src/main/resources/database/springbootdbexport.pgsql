--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.1
-- Dumped by pg_dump version 9.6.1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE hibernate_sequence OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: t_tasks; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE t_tasks (
    date_created date,
    name character varying,
    id integer NOT NULL,
    description character varying,
    finished boolean
);


ALTER TABLE t_tasks OWNER TO postgres;

--
-- Name: t_tasks_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE t_tasks_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE t_tasks_id_seq OWNER TO postgres;

--
-- Name: t_tasks_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE t_tasks_id_seq OWNED BY t_tasks.id;


--
-- Name: t_tasks id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY t_tasks ALTER COLUMN id SET DEFAULT nextval('t_tasks_id_seq'::regclass);


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('hibernate_sequence', 9, true);


--
-- Data for Name: t_tasks; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY t_tasks (date_created, name, id, description, finished) FROM stdin;
2017-07-14	sneha	3	thalk	t
2017-07-13	amit	1	singh	t
2017-07-14	kajal	2	dingh	f
2017-07-22	popoeye	8	popu	t
\.


--
-- Name: t_tasks_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('t_tasks_id_seq', 3, true);


--
-- Name: t_tasks t_tasks_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY t_tasks
    ADD CONSTRAINT t_tasks_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

