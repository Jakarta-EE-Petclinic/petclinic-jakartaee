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
-- Data for Name: owner; Type: TABLE DATA; Schema: public; Owner: -
--

SET SESSION AUTHORIZATION DEFAULT;

ALTER TABLE "public"."owner" DISABLE TRIGGER ALL;

INSERT INTO "public"."owner" ("id", "address", "address_info", "city", "email", "first_name", "housenumber", "lastname", "phonenumber", "searchindex", "uuid", "zipcode") VALUES (1, 'Laerheidestr.', '', 'Bochum', 'thomas.woehlke@gmail.com', 'Thomas', '8', 'Wöhlke', '+4923452007953', ' Thomas W hlke Laerheidestr 8 44799 Bochum  4923452007953 thomas woehlke gmail com ', '8ef28900-3c70-4276-ae12-b5ea408aaf10', '44799');
INSERT INTO "public"."owner" ("id", "address", "address_info", "city", "email", "first_name", "housenumber", "lastname", "phonenumber", "searchindex", "uuid", "zipcode") VALUES (2, 'Hill Drive', 'Auf dem Schrottplatz von Titus Jonas', 'Rocky Beach', 'thomas.woehlke@rub.de', 'Justus', '128', 'Jonas', '+4923452007953', 'Auf dem Schrottplatz von Titus Jonas Justus Jonas Hill Drive 128 99777 Rocky Beach  4923452007953 thomas woehlke rub de ', 'd5debd0a-f0ce-4288-9947-2967824cd456', '99777');


ALTER TABLE "public"."owner" ENABLE TRIGGER ALL;

--
-- Data for Name: owner_pet_type; Type: TABLE DATA; Schema: public; Owner: -
--

ALTER TABLE "public"."owner_pet_type" DISABLE TRIGGER ALL;

INSERT INTO "public"."owner_pet_type" ("id", "name", "searchindex", "uuid") VALUES (8, 'Cat', 'Cat ', '0781b3ce-d7b2-43b0-9b15-ba53decf541d');
INSERT INTO "public"."owner_pet_type" ("id", "name", "searchindex", "uuid") VALUES (9, 'Dog', 'Dog ', 'ae220828-288e-4a41-99a9-88b3afab2f7b');
INSERT INTO "public"."owner_pet_type" ("id", "name", "searchindex", "uuid") VALUES (10, 'Mouse', 'Mouse ', 'e6d15047-f261-4a9c-b2e2-6341885a5223');
INSERT INTO "public"."owner_pet_type" ("id", "name", "searchindex", "uuid") VALUES (11, 'Whale', 'Whale ', '65a7bc0b-a291-4e88-9a04-6e8b3231d199');
INSERT INTO "public"."owner_pet_type" ("id", "name", "searchindex", "uuid") VALUES (12, 'Horse', 'Horse ', '1d080739-9c62-4263-ad84-cc9cfabfc61b');
INSERT INTO "public"."owner_pet_type" ("id", "name", "searchindex", "uuid") VALUES (13, 'Guinea pig', 'Guinea pig ', '160d9947-35b2-4c60-a4c6-93d452f8a6dc');
INSERT INTO "public"."owner_pet_type" ("id", "name", "searchindex", "uuid") VALUES (14, 'Snake', 'Snake ', '5049db12-e8ec-4478-bae8-6cc047c629f6');
INSERT INTO "public"."owner_pet_type" ("id", "name", "searchindex", "uuid") VALUES (15, 'Shepards Dog', 'Shepards Dog ', '3949d83e-c4a4-4396-a4ca-bf58c3737cff');
INSERT INTO "public"."owner_pet_type" ("id", "name", "searchindex", "uuid") VALUES (16, 'Spider', 'Spider ', 'a27347e4-eebc-4c66-b524-263ba41e4d1f');
INSERT INTO "public"."owner_pet_type" ("id", "name", "searchindex", "uuid") VALUES (51, '01 sdas dasdas dasda das das dsa dsa  asddasasd', '01 sdas dasdas dasda das das dsa dsa  asddasasd ', '190a408a-b341-4da8-8398-661bddf883ad');


ALTER TABLE "public"."owner_pet_type" ENABLE TRIGGER ALL;

--
-- Data for Name: owner_pet; Type: TABLE DATA; Schema: public; Owner: -
--

ALTER TABLE "public"."owner_pet" DISABLE TRIGGER ALL;

INSERT INTO "public"."owner_pet" ("id", "birth_date", "name", "searchindex", "uuid", "owner_id", "owner_pet_type_id") VALUES (1, '2019-03-14', 'Tom', 'Tom ', 'c83b2da6-8393-4e44-a53f-6a4d7dbbbc63', 2, 8);
INSERT INTO "public"."owner_pet" ("id", "birth_date", "name", "searchindex", "uuid", "owner_id", "owner_pet_type_id") VALUES (3, '2021-01-10', 'Tom', 'Tom ', '11b50634-227d-43d4-a188-a8aafe344825', 1, 15);
INSERT INTO "public"."owner_pet" ("id", "birth_date", "name", "searchindex", "uuid", "owner_id", "owner_pet_type_id") VALUES (4, '2021-07-11', 'Tom', 'Tom ', '7d452b17-e8a7-4d27-8def-99a0a964acb6', 1, 12);
INSERT INTO "public"."owner_pet" ("id", "birth_date", "name", "searchindex", "uuid", "owner_id", "owner_pet_type_id") VALUES (2, '2022-11-04', '01  lkjhbjhvbghvghkvghv', ' lkjhbjhvbghvghkvghv ', 'ca9f8b19-b6bf-479c-bf9d-cb054a1e45ee', 2, 12);


ALTER TABLE "public"."owner_pet" ENABLE TRIGGER ALL;

--
-- Data for Name: owner_pet_visit; Type: TABLE DATA; Schema: public; Owner: -
--

ALTER TABLE "public"."owner_pet_visit" DISABLE TRIGGER ALL;

INSERT INTO "public"."owner_pet_visit" ("id", "visit_date", "description", "searchindex", "uuid", "owner_pet_id") VALUES (2, '2022-11-04', 'Routine', '2022 11 03T23 00 00Z Routine ', '2f8e4031-22f0-4467-9346-609b44a9d7e8', 1);
INSERT INTO "public"."owner_pet_visit" ("id", "visit_date", "description", "searchindex", "uuid", "owner_pet_id") VALUES (1, '2022-11-14', 'Routine', '2022 11 13T23 00 00Z Routine ', '9ed3402d-a15c-47b9-95c4-abd2fec2a190', 1);
INSERT INTO "public"."owner_pet_visit" ("id", "visit_date", "description", "searchindex", "uuid", "owner_pet_id") VALUES (3, '2022-11-13', 'Routine ASDQWER', '2022 11 12T23 00 00Z Routine ASDQWER ', '4e403885-317a-4c27-ae53-d997af99a770', 2);
INSERT INTO "public"."owner_pet_visit" ("id", "visit_date", "description", "searchindex", "uuid", "owner_pet_id") VALUES (4, '2022-11-01', 'Routine KO', '2022 10 31T23 00 00Z Routine KO ', '6256900e-15ad-4700-b471-03dc8c407370', 1);
INSERT INTO "public"."owner_pet_visit" ("id", "visit_date", "description", "searchindex", "uuid", "owner_pet_id") VALUES (5, '2022-08-12', 'Routine ASDQWER JOLO', '2022 08 11T22 00 00Z Routine ASDQWER JOLO ', '85bfc34a-d3b7-4c86-b672-e79da913835a', 1);


ALTER TABLE "public"."owner_pet_visit" ENABLE TRIGGER ALL;

--
-- Data for Name: specialty; Type: TABLE DATA; Schema: public; Owner: -
--

ALTER TABLE "public"."specialty" DISABLE TRIGGER ALL;

INSERT INTO "public"."specialty" ("id", "name", "searchindex", "uuid") VALUES (1, 'Neurosurgeon', 'Neurosurgeon ', 'd54ab00b-938e-4d45-9b04-20fff41eeca6');
INSERT INTO "public"."specialty" ("id", "name", "searchindex", "uuid") VALUES (2, 'Rescue Doctor', 'Rescue Doctor ', 'f5bdc98c-b8b0-4874-8176-5443ce12365e');
INSERT INTO "public"."specialty" ("id", "name", "searchindex", "uuid") VALUES (3, 'Cardiologist', 'Cardiologist ', '29332a94-37d8-469e-9a77-e9207c4b6a8a');
INSERT INTO "public"."specialty" ("id", "name", "searchindex", "uuid") VALUES (4, 'Oncologist', 'Oncologist ', 'd698bc8a-5817-4ef7-937a-59c9847e5bee');
INSERT INTO "public"."specialty" ("id", "name", "searchindex", "uuid") VALUES (5, 'Anesthetist', 'Anesthetist ', '005c8818-4db2-405d-a656-c8308d553e1a');
INSERT INTO "public"."specialty" ("id", "name", "searchindex", "uuid") VALUES (6, 'Surgeon', 'Surgeon ', 'd5535a85-9042-4249-9f0f-8a3871396884');
INSERT INTO "public"."specialty" ("id", "name", "searchindex", "uuid") VALUES (7, 'Radiologist', 'Radiologist ', '6cf0fe05-97b5-4c19-98c0-aa4228654c5c');


ALTER TABLE "public"."specialty" ENABLE TRIGGER ALL;

--
-- Data for Name: vet; Type: TABLE DATA; Schema: public; Owner: -
--

ALTER TABLE "public"."vet" DISABLE TRIGGER ALL;

INSERT INTO "public"."vet" ("id", "first_name", "lastname", "searchindex", "uuid") VALUES (17, 'Marie', 'Curie', 'Marie Curie Neurosurgeon Oncologist Rescue Doctor Cardiologist Radiologist Anesthetist Surgeon ', '6e1900ee-0d99-4df0-8bc3-1fc3bca2ef10');
INSERT INTO "public"."vet" ("id", "first_name", "lastname", "searchindex", "uuid") VALUES (18, 'Walter', 'von der Vogelweide', 'Walter von der Vogelweide Anesthetist ', 'ae71ac08-04f3-481e-ab23-5e0ef4754333');


ALTER TABLE "public"."vet" ENABLE TRIGGER ALL;

--
-- Data for Name: vet_specialties; Type: TABLE DATA; Schema: public; Owner: -
--

ALTER TABLE "public"."vet_specialties" DISABLE TRIGGER ALL;

INSERT INTO "public"."vet_specialties" ("vet_id", "specialty_id") VALUES (17, 5);
INSERT INTO "public"."vet_specialties" ("vet_id", "specialty_id") VALUES (17, 2);
INSERT INTO "public"."vet_specialties" ("vet_id", "specialty_id") VALUES (17, 4);
INSERT INTO "public"."vet_specialties" ("vet_id", "specialty_id") VALUES (17, 1);
INSERT INTO "public"."vet_specialties" ("vet_id", "specialty_id") VALUES (17, 6);
INSERT INTO "public"."vet_specialties" ("vet_id", "specialty_id") VALUES (17, 7);
INSERT INTO "public"."vet_specialties" ("vet_id", "specialty_id") VALUES (17, 3);
INSERT INTO "public"."vet_specialties" ("vet_id", "specialty_id") VALUES (18, 5);


ALTER TABLE "public"."vet_specialties" ENABLE TRIGGER ALL;

--
-- Name: owner_pet_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('"public"."owner_pet_seq"', 50, true);


--
-- Name: owner_pet_type_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('"public"."owner_pet_type_seq"', 100, true);


--
-- Name: owner_pet_visit_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('"public"."owner_pet_visit_seq"', 50, true);


--
-- Name: owner_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('"public"."owner_seq"', 50, false);


--
-- Name: specialty_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('"public"."specialty_seq"', 100, true);


--
-- Name: vet_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('"public"."vet_seq"', 50, true);


--
-- PostgreSQL database dump complete
--

