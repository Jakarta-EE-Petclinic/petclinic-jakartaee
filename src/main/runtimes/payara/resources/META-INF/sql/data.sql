--
-- PostgreSQL database dump
--

-- Dumped from database version 14.5 (Ubuntu 14.5-2.pgdg22.04+2)
-- Dumped by pg_dump version 15.0 (Ubuntu 15.0-1.pgdg22.04+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

-- *not* creating schema, since initdb creates it


ALTER SCHEMA public OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: owner; Type: TABLE; Schema: public; Owner: petclinic_jakartaee
--

CREATE TABLE public.owner (
    id bigint NOT NULL,
    address character varying(255) NOT NULL,
    address_info character varying(255),
    city character varying(255) NOT NULL,
    email character varying(255) NOT NULL,
    first_name character varying(255) NOT NULL,
    housenumber character varying(255) NOT NULL,
    lastname character varying(255) NOT NULL,
    phonenumber character varying(255) NOT NULL,
    searchindex character varying(255),
    uuid character varying(36) NOT NULL,
    zipcode character varying(255) NOT NULL
);


ALTER TABLE public.owner OWNER TO petclinic_jakartaee;

--
-- Name: owner_pet; Type: TABLE; Schema: public; Owner: petclinic_jakartaee
--

CREATE TABLE public.owner_pet (
    id bigint NOT NULL,
    birth_date date,
    name character varying(255) NOT NULL,
    searchindex character varying(255),
    uuid character varying(36) NOT NULL,
    owner_id bigint,
    owner_pet_type_id bigint
);


ALTER TABLE public.owner_pet OWNER TO petclinic_jakartaee;

--
-- Name: owner_pet_type; Type: TABLE; Schema: public; Owner: petclinic_jakartaee
--

CREATE TABLE public.owner_pet_type (
    id bigint NOT NULL,
    name character varying(255) NOT NULL,
    searchindex character varying(255),
    uuid character varying(36) NOT NULL
);


ALTER TABLE public.owner_pet_type OWNER TO petclinic_jakartaee;

--
-- Name: owner_pet_visit; Type: TABLE; Schema: public; Owner: petclinic_jakartaee
--

CREATE TABLE public.owner_pet_visit (
    id bigint NOT NULL,
    visit_date date NOT NULL,
    description character varying(255) NOT NULL,
    searchindex character varying(255),
    uuid character varying(36) NOT NULL,
    owner_pet_id bigint
);


ALTER TABLE public.owner_pet_visit OWNER TO petclinic_jakartaee;

--
-- Name: sequence; Type: TABLE; Schema: public; Owner: petclinic_jakartaee
--

CREATE TABLE public.sequence (
    seq_name character varying(50) NOT NULL,
    seq_count numeric(38,0)
);


ALTER TABLE public.sequence OWNER TO petclinic_jakartaee;

--
-- Name: specialty; Type: TABLE; Schema: public; Owner: petclinic_jakartaee
--

CREATE TABLE public.specialty (
    id bigint NOT NULL,
    name character varying(255) NOT NULL,
    searchindex character varying(255),
    uuid character varying(36) NOT NULL
);


ALTER TABLE public.specialty OWNER TO petclinic_jakartaee;

--
-- Name: vet; Type: TABLE; Schema: public; Owner: petclinic_jakartaee
--

CREATE TABLE public.vet (
    id bigint NOT NULL,
    first_name character varying(255) NOT NULL,
    lastname character varying(255) NOT NULL,
    searchindex character varying(255),
    uuid character varying(36) NOT NULL
);


ALTER TABLE public.vet OWNER TO petclinic_jakartaee;

--
-- Name: vet_specialties; Type: TABLE; Schema: public; Owner: petclinic_jakartaee
--

CREATE TABLE public.vet_specialties (
    vet_id bigint NOT NULL,
    specialty_id bigint NOT NULL
);


ALTER TABLE public.vet_specialties OWNER TO petclinic_jakartaee;

--
-- Data for Name: owner; Type: TABLE DATA; Schema: public; Owner: petclinic_jakartaee
--

COPY public.owner (id, address, address_info, city, email, first_name, housenumber, lastname, phonenumber, searchindex, uuid, zipcode) FROM stdin;
\.


--
-- Data for Name: owner_pet; Type: TABLE DATA; Schema: public; Owner: petclinic_jakartaee
--

COPY public.owner_pet (id, birth_date, name, searchindex, uuid, owner_id, owner_pet_type_id) FROM stdin;
\.


--
-- Data for Name: owner_pet_type; Type: TABLE DATA; Schema: public; Owner: petclinic_jakartaee
--

COPY public.owner_pet_type (id, name, searchindex, uuid) FROM stdin;
8	Cat	Cat 	0781b3ce-d7b2-43b0-9b15-ba53decf541d
9	Dog	Dog 	ae220828-288e-4a41-99a9-88b3afab2f7b
10	Mouse	Mouse 	e6d15047-f261-4a9c-b2e2-6341885a5223
11	Whale	Whale 	65a7bc0b-a291-4e88-9a04-6e8b3231d199
12	Horse	Horse 	1d080739-9c62-4263-ad84-cc9cfabfc61b
13	Guinea pig	Guinea pig 	160d9947-35b2-4c60-a4c6-93d452f8a6dc
14	Snake	Snake 	5049db12-e8ec-4478-bae8-6cc047c629f6
15	Shepards Dog	Shepards Dog 	3949d83e-c4a4-4396-a4ca-bf58c3737cff
16	Spider	Spider 	a27347e4-eebc-4c66-b524-263ba41e4d1f
\.


--
-- Data for Name: owner_pet_visit; Type: TABLE DATA; Schema: public; Owner: petclinic_jakartaee
--

COPY public.owner_pet_visit (id, visit_date, description, searchindex, uuid, owner_pet_id) FROM stdin;
\.


--
-- Data for Name: sequence; Type: TABLE DATA; Schema: public; Owner: petclinic_jakartaee
--

COPY public.sequence (seq_name, seq_count) FROM stdin;
SEQ_GEN	50
\.


--
-- Data for Name: specialty; Type: TABLE DATA; Schema: public; Owner: petclinic_jakartaee
--

COPY public.specialty (id, name, searchindex, uuid) FROM stdin;
1	Neurosurgeon	Neurosurgeon 	d54ab00b-938e-4d45-9b04-20fff41eeca6
2	Rescue Doctor	Rescue Doctor 	f5bdc98c-b8b0-4874-8176-5443ce12365e
3	Cardiologist	Cardiologist 	29332a94-37d8-469e-9a77-e9207c4b6a8a
4	Oncologist	Oncologist 	d698bc8a-5817-4ef7-937a-59c9847e5bee
5	Anesthetist	Anesthetist 	005c8818-4db2-405d-a656-c8308d553e1a
6	Surgeon	Surgeon 	d5535a85-9042-4249-9f0f-8a3871396884
7	Radiologist	Radiologist 	6cf0fe05-97b5-4c19-98c0-aa4228654c5c
\.


--
-- Data for Name: vet; Type: TABLE DATA; Schema: public; Owner: petclinic_jakartaee
--

COPY public.vet (id, first_name, lastname, searchindex, uuid) FROM stdin;
17	Marie	Curie	Marie Curie Neurosurgeon Oncologist Rescue Doctor Cardiologist Radiologist Anesthetist Surgeon 	6e1900ee-0d99-4df0-8bc3-1fc3bca2ef10
18	Walter	von der Vogelweide	Walter von der Vogelweide Anesthetist 	ae71ac08-04f3-481e-ab23-5e0ef4754333
\.


--
-- Data for Name: vet_specialties; Type: TABLE DATA; Schema: public; Owner: petclinic_jakartaee
--

COPY public.vet_specialties (vet_id, specialty_id) FROM stdin;
17	5
17	2
17	4
17	1
17	6
17	7
17	3
18	5
\.


--
-- Name: owner owner_email_key; Type: CONSTRAINT; Schema: public; Owner: petclinic_jakartaee
--

ALTER TABLE ONLY public.owner
    ADD CONSTRAINT owner_email_key UNIQUE (email);


--
-- Name: owner_pet owner_pet_pkey; Type: CONSTRAINT; Schema: public; Owner: petclinic_jakartaee
--

ALTER TABLE ONLY public.owner_pet
    ADD CONSTRAINT owner_pet_pkey PRIMARY KEY (id);


--
-- Name: owner_pet_type owner_pet_type_name_key; Type: CONSTRAINT; Schema: public; Owner: petclinic_jakartaee
--

ALTER TABLE ONLY public.owner_pet_type
    ADD CONSTRAINT owner_pet_type_name_key UNIQUE (name);


--
-- Name: owner_pet_type owner_pet_type_pkey; Type: CONSTRAINT; Schema: public; Owner: petclinic_jakartaee
--

ALTER TABLE ONLY public.owner_pet_type
    ADD CONSTRAINT owner_pet_type_pkey PRIMARY KEY (id);


--
-- Name: owner_pet_type owner_pet_type_unique_names; Type: CONSTRAINT; Schema: public; Owner: petclinic_jakartaee
--

ALTER TABLE ONLY public.owner_pet_type
    ADD CONSTRAINT owner_pet_type_unique_names UNIQUE (name);


--
-- Name: owner_pet_type owner_pet_type_unique_uuid; Type: CONSTRAINT; Schema: public; Owner: petclinic_jakartaee
--

ALTER TABLE ONLY public.owner_pet_type
    ADD CONSTRAINT owner_pet_type_unique_uuid UNIQUE (uuid);


--
-- Name: owner_pet_type owner_pet_type_uuid_key; Type: CONSTRAINT; Schema: public; Owner: petclinic_jakartaee
--

ALTER TABLE ONLY public.owner_pet_type
    ADD CONSTRAINT owner_pet_type_uuid_key UNIQUE (uuid);


--
-- Name: owner_pet owner_pet_unique_names; Type: CONSTRAINT; Schema: public; Owner: petclinic_jakartaee
--

ALTER TABLE ONLY public.owner_pet
    ADD CONSTRAINT owner_pet_unique_names UNIQUE (name, birth_date, owner_pet_type_id, owner_id);


--
-- Name: owner_pet owner_pet_unique_uuid; Type: CONSTRAINT; Schema: public; Owner: petclinic_jakartaee
--

ALTER TABLE ONLY public.owner_pet
    ADD CONSTRAINT owner_pet_unique_uuid UNIQUE (uuid);


--
-- Name: owner_pet owner_pet_uuid_key; Type: CONSTRAINT; Schema: public; Owner: petclinic_jakartaee
--

ALTER TABLE ONLY public.owner_pet
    ADD CONSTRAINT owner_pet_uuid_key UNIQUE (uuid);


--
-- Name: owner_pet_visit owner_pet_visit_pkey; Type: CONSTRAINT; Schema: public; Owner: petclinic_jakartaee
--

ALTER TABLE ONLY public.owner_pet_visit
    ADD CONSTRAINT owner_pet_visit_pkey PRIMARY KEY (id);


--
-- Name: owner_pet_visit owner_pet_visit_unique_names; Type: CONSTRAINT; Schema: public; Owner: petclinic_jakartaee
--

ALTER TABLE ONLY public.owner_pet_visit
    ADD CONSTRAINT owner_pet_visit_unique_names UNIQUE (visit_date, description, owner_pet_id);


--
-- Name: owner_pet_visit owner_pet_visit_unique_uuid; Type: CONSTRAINT; Schema: public; Owner: petclinic_jakartaee
--

ALTER TABLE ONLY public.owner_pet_visit
    ADD CONSTRAINT owner_pet_visit_unique_uuid UNIQUE (uuid);


--
-- Name: owner_pet_visit owner_pet_visit_uuid_key; Type: CONSTRAINT; Schema: public; Owner: petclinic_jakartaee
--

ALTER TABLE ONLY public.owner_pet_visit
    ADD CONSTRAINT owner_pet_visit_uuid_key UNIQUE (uuid);


--
-- Name: owner owner_pkey; Type: CONSTRAINT; Schema: public; Owner: petclinic_jakartaee
--

ALTER TABLE ONLY public.owner
    ADD CONSTRAINT owner_pkey PRIMARY KEY (id);


--
-- Name: owner owner_unique_email; Type: CONSTRAINT; Schema: public; Owner: petclinic_jakartaee
--

ALTER TABLE ONLY public.owner
    ADD CONSTRAINT owner_unique_email UNIQUE (email);


--
-- Name: owner owner_unique_names; Type: CONSTRAINT; Schema: public; Owner: petclinic_jakartaee
--

ALTER TABLE ONLY public.owner
    ADD CONSTRAINT owner_unique_names UNIQUE (first_name, lastname, city, phonenumber);


--
-- Name: owner owner_unique_uuid; Type: CONSTRAINT; Schema: public; Owner: petclinic_jakartaee
--

ALTER TABLE ONLY public.owner
    ADD CONSTRAINT owner_unique_uuid UNIQUE (uuid);


--
-- Name: owner owner_uuid_key; Type: CONSTRAINT; Schema: public; Owner: petclinic_jakartaee
--

ALTER TABLE ONLY public.owner
    ADD CONSTRAINT owner_uuid_key UNIQUE (uuid);


--
-- Name: sequence sequence_pkey; Type: CONSTRAINT; Schema: public; Owner: petclinic_jakartaee
--

ALTER TABLE ONLY public.sequence
    ADD CONSTRAINT sequence_pkey PRIMARY KEY (seq_name);


--
-- Name: specialty specialty_name_key; Type: CONSTRAINT; Schema: public; Owner: petclinic_jakartaee
--

ALTER TABLE ONLY public.specialty
    ADD CONSTRAINT specialty_name_key UNIQUE (name);


--
-- Name: specialty specialty_pkey; Type: CONSTRAINT; Schema: public; Owner: petclinic_jakartaee
--

ALTER TABLE ONLY public.specialty
    ADD CONSTRAINT specialty_pkey PRIMARY KEY (id);


--
-- Name: specialty specialty_unique_names; Type: CONSTRAINT; Schema: public; Owner: petclinic_jakartaee
--

ALTER TABLE ONLY public.specialty
    ADD CONSTRAINT specialty_unique_names UNIQUE (name);


--
-- Name: specialty specialty_unique_uuid; Type: CONSTRAINT; Schema: public; Owner: petclinic_jakartaee
--

ALTER TABLE ONLY public.specialty
    ADD CONSTRAINT specialty_unique_uuid UNIQUE (uuid);


--
-- Name: specialty specialty_uuid_key; Type: CONSTRAINT; Schema: public; Owner: petclinic_jakartaee
--

ALTER TABLE ONLY public.specialty
    ADD CONSTRAINT specialty_uuid_key UNIQUE (uuid);


--
-- Name: vet vet_pkey; Type: CONSTRAINT; Schema: public; Owner: petclinic_jakartaee
--

ALTER TABLE ONLY public.vet
    ADD CONSTRAINT vet_pkey PRIMARY KEY (id);


--
-- Name: vet_specialties vet_specialties_pkey; Type: CONSTRAINT; Schema: public; Owner: petclinic_jakartaee
--

ALTER TABLE ONLY public.vet_specialties
    ADD CONSTRAINT vet_specialties_pkey PRIMARY KEY (vet_id, specialty_id);


--
-- Name: vet vet_unique_names; Type: CONSTRAINT; Schema: public; Owner: petclinic_jakartaee
--

ALTER TABLE ONLY public.vet
    ADD CONSTRAINT vet_unique_names UNIQUE (first_name, lastname);


--
-- Name: vet vet_unique_uuid; Type: CONSTRAINT; Schema: public; Owner: petclinic_jakartaee
--

ALTER TABLE ONLY public.vet
    ADD CONSTRAINT vet_unique_uuid UNIQUE (uuid);


--
-- Name: vet vet_uuid_key; Type: CONSTRAINT; Schema: public; Owner: petclinic_jakartaee
--

ALTER TABLE ONLY public.vet
    ADD CONSTRAINT vet_uuid_key UNIQUE (uuid);


--
-- Name: owner_pet fk_owner_pet_owner_id; Type: FK CONSTRAINT; Schema: public; Owner: petclinic_jakartaee
--

ALTER TABLE ONLY public.owner_pet
    ADD CONSTRAINT fk_owner_pet_owner_id FOREIGN KEY (owner_id) REFERENCES public.owner(id);


--
-- Name: owner_pet fk_owner_pet_owner_pet_type_id; Type: FK CONSTRAINT; Schema: public; Owner: petclinic_jakartaee
--

ALTER TABLE ONLY public.owner_pet
    ADD CONSTRAINT fk_owner_pet_owner_pet_type_id FOREIGN KEY (owner_pet_type_id) REFERENCES public.owner_pet_type(id);


--
-- Name: owner_pet_visit fk_owner_pet_visit_owner_pet_id; Type: FK CONSTRAINT; Schema: public; Owner: petclinic_jakartaee
--

ALTER TABLE ONLY public.owner_pet_visit
    ADD CONSTRAINT fk_owner_pet_visit_owner_pet_id FOREIGN KEY (owner_pet_id) REFERENCES public.owner_pet(id);


--
-- Name: vet_specialties fk_vet_specialties_specialty_id; Type: FK CONSTRAINT; Schema: public; Owner: petclinic_jakartaee
--

ALTER TABLE ONLY public.vet_specialties
    ADD CONSTRAINT fk_vet_specialties_specialty_id FOREIGN KEY (specialty_id) REFERENCES public.specialty(id);


--
-- Name: vet_specialties fk_vet_specialties_vet_id; Type: FK CONSTRAINT; Schema: public; Owner: petclinic_jakartaee
--

ALTER TABLE ONLY public.vet_specialties
    ADD CONSTRAINT fk_vet_specialties_vet_id FOREIGN KEY (vet_id) REFERENCES public.vet(id);


--
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE USAGE ON SCHEMA public FROM PUBLIC;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

