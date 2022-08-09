--
-- PostgreSQL database dump
--

-- Dumped from database version 14.4 (Ubuntu 14.4-1.pgdg22.04+1)
-- Dumped by pg_dump version 14.4 (Ubuntu 14.4-1.pgdg22.04+1)

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
-- Data for Name: owner; Type: TABLE DATA; Schema: public; Owner: petclinic_jakartaee
--

INSERT INTO public.owner VALUES (20, 'Hill Drive', 'Auf dem Schrottplatz von Titus Jonas', 'Rocky Beach', 'thomas.woehlke@rub.de', 'Justus', '128', 'Jonas', '+4923452007953', 'Auf dem Schrottplatz von Titus Jonas Justus Jonas Hill Drive 128 99777 Rocky Beach  4923452007953 thomas woehlke rub de ', '\xaced00057372000e6a6176612e7574696c2e55554944bc9903f7986d852f0200024a000c6c65617374536967426974734a000b6d6f7374536967426974737870800ed4e79b1881ed3b17c89b2090495b', '99777');
INSERT INTO public.owner VALUES (21, 'Glatzer Str.', '', 'Berlin', 'thomas.woehlke@gmail.com', 'Thomas', '5a', 'Wöhlke', '+4923452007953', ' Thomas W hlke Glatzer Str 5a 10247 Berlin  4923452007953 thomas woehlke gmail com ', '\xaced00057372000e6a6176612e7574696c2e55554944bc9903f7986d852f0200024a000c6c65617374536967426974734a000b6d6f7374536967426974737870880e96a8a6345ae0b8c37c98b9e64eb4', '10247');


--
-- Data for Name: owner_pet_type; Type: TABLE DATA; Schema: public; Owner: petclinic_jakartaee
--

INSERT INTO public.owner_pet_type VALUES (1, 'Cat', 'Cat ', '\xaced00057372000e6a6176612e7574696c2e55554944bc9903f7986d852f0200024a000c6c65617374536967426974734a000b6d6f73745369674269747378708cdb08d33fb60dbe68d8a13f871f46de');
INSERT INTO public.owner_pet_type VALUES (2, 'Dog', 'Dog ', '\xaced00057372000e6a6176612e7574696c2e55554944bc9903f7986d852f0200024a000c6c65617374536967426974734a000b6d6f7374536967426974737870b95d6ff14a4fd9a4cee8283713354743');
INSERT INTO public.owner_pet_type VALUES (3, 'Mouse', 'Mouse ', '\xaced00057372000e6a6176612e7574696c2e55554944bc9903f7986d852f0200024a000c6c65617374536967426974734a000b6d6f73745369674269747378709185ab7c63d7718278eb8fc442854a48');
INSERT INTO public.owner_pet_type VALUES (4, 'Fish', 'Fish ', '\xaced00057372000e6a6176612e7574696c2e55554944bc9903f7986d852f0200024a000c6c65617374536967426974734a000b6d6f7374536967426974737870a0c70165b11d341acdc8a82114b84522');
INSERT INTO public.owner_pet_type VALUES (5, 'Rabbit', 'Rabbit ', '\xaced00057372000e6a6176612e7574696c2e55554944bc9903f7986d852f0200024a000c6c65617374536967426974734a000b6d6f7374536967426974737870814769874ed52ac1b6bac4c123044528');
INSERT INTO public.owner_pet_type VALUES (6, 'Little Pony', 'Little Pony ', '\xaced00057372000e6a6176612e7574696c2e55554944bc9903f7986d852f0200024a000c6c65617374536967426974734a000b6d6f7374536967426974737870a4a73562fea1007291b6b9e2bc3e4a6b');
INSERT INTO public.owner_pet_type VALUES (7, 'Spider', 'Spider ', '\xaced00057372000e6a6176612e7574696c2e55554944bc9903f7986d852f0200024a000c6c65617374536967426974734a000b6d6f7374536967426974737870a58b4686e8072d2b9b9ffe59c1514720');
INSERT INTO public.owner_pet_type VALUES (8, 'Budgie', 'Budgie ', '\xaced00057372000e6a6176612e7574696c2e55554944bc9903f7986d852f0200024a000c6c65617374536967426974734a000b6d6f73745369674269747378708da81b50ba91f14545866243270a4b23');
INSERT INTO public.owner_pet_type VALUES (9, 'Parrot', 'Parrot ', '\xaced00057372000e6a6176612e7574696c2e55554944bc9903f7986d852f0200024a000c6c65617374536967426974734a000b6d6f7374536967426974737870a29eddacda5179ec14e58e1300c548c7');


--
-- Data for Name: owner_pet; Type: TABLE DATA; Schema: public; Owner: petclinic_jakartaee
--

INSERT INTO public.owner_pet VALUES (22, '2021-03-10', 'Hansi', 'Hansi ', '\xaced00057372000e6a6176612e7574696c2e55554944bc9903f7986d852f0200024a000c6c65617374536967426974734a000b6d6f73745369674269747378709c05dbb89b10ab0f845863bc8cc34e9f', 21, 8);


--
-- Data for Name: owner_pet_visit; Type: TABLE DATA; Schema: public; Owner: petclinic_jakartaee
--



--
-- Data for Name: sequence; Type: TABLE DATA; Schema: public; Owner: petclinic_jakartaee
--

INSERT INTO public.sequence VALUES ('SEQ_GEN', 50);


--
-- Data for Name: specialty; Type: TABLE DATA; Schema: public; Owner: petclinic_jakartaee
--

INSERT INTO public.specialty VALUES (10, 'Cardiologist', 'Cardiologist ', '\xaced00057372000e6a6176612e7574696c2e55554944bc9903f7986d852f0200024a000c6c65617374536967426974734a000b6d6f7374536967426974737870893cfb68a45d2cbfb98973bb26474ff7');
INSERT INTO public.specialty VALUES (11, 'Radiologist', 'Radiologist ', '\xaced00057372000e6a6176612e7574696c2e55554944bc9903f7986d852f0200024a000c6c65617374536967426974734a000b6d6f7374536967426974737870af05ba3f19d28e13a5296eac72854a6c');
INSERT INTO public.specialty VALUES (12, 'Rescue Doctor', 'Rescue Doctor ', '\xaced00057372000e6a6176612e7574696c2e55554944bc9903f7986d852f0200024a000c6c65617374536967426974734a000b6d6f737453696742697473787091d3c47d16b3d4b5bb3ddd5d9c014eb2');
INSERT INTO public.specialty VALUES (13, 'Surgeon', 'Surgeon ', '\xaced00057372000e6a6176612e7574696c2e55554944bc9903f7986d852f0200024a000c6c65617374536967426974734a000b6d6f7374536967426974737870bb04854d6c24e5b36c65fb9a66e547e2');
INSERT INTO public.specialty VALUES (14, 'Anesthetist', 'Anesthetist ', '\xaced00057372000e6a6176612e7574696c2e55554944bc9903f7986d852f0200024a000c6c65617374536967426974734a000b6d6f73745369674269747378708df34e31459d0466786a77da916d4940');
INSERT INTO public.specialty VALUES (15, 'Oncologist', 'Oncologist ', '\xaced00057372000e6a6176612e7574696c2e55554944bc9903f7986d852f0200024a000c6c65617374536967426974734a000b6d6f73745369674269747378708c04c5605f9e32924ffc86340ff34c5c');
INSERT INTO public.specialty VALUES (16, 'Neurosurgeon', 'Neurosurgeon ', '\xaced00057372000e6a6176612e7574696c2e55554944bc9903f7986d852f0200024a000c6c65617374536967426974734a000b6d6f73745369674269747378708c06f1ebce6ebffcad5ff5628dde4569');
INSERT INTO public.specialty VALUES (17, 'Gynecologist', 'Gynecologist ', '\xaced00057372000e6a6176612e7574696c2e55554944bc9903f7986d852f0200024a000c6c65617374536967426974734a000b6d6f7374536967426974737870a6fc3538b7cff120da448f6d75834097');


--
-- Data for Name: vet; Type: TABLE DATA; Schema: public; Owner: petclinic_jakartaee
--

INSERT INTO public.vet VALUES (18, 'Marie', 'Curie', 'Marie Curie Neurosurgeon Gynecologist Oncologist Rescue Doctor Cardiologist Radiologist Anesthetist Surgeon ', '\xaced00057372000e6a6176612e7574696c2e55554944bc9903f7986d852f0200024a000c6c65617374536967426974734a000b6d6f737453696742697473787099885c959f8f18625daa5115f0cb41bf');
INSERT INTO public.vet VALUES (19, 'Walther', 'von der Vogelweide', 'Walther von der Vogelweide Anesthetist ', '\xaced00057372000e6a6176612e7574696c2e55554944bc9903f7986d852f0200024a000c6c65617374536967426974734a000b6d6f73745369674269747378709a63fe0d296421a13dc3782f08c2499e');


--
-- Data for Name: vet_specialties; Type: TABLE DATA; Schema: public; Owner: petclinic_jakartaee
--

INSERT INTO public.vet_specialties VALUES (18, 15);
INSERT INTO public.vet_specialties VALUES (18, 11);
INSERT INTO public.vet_specialties VALUES (18, 13);
INSERT INTO public.vet_specialties VALUES (18, 16);
INSERT INTO public.vet_specialties VALUES (18, 14);
INSERT INTO public.vet_specialties VALUES (18, 12);
INSERT INTO public.vet_specialties VALUES (18, 10);
INSERT INTO public.vet_specialties VALUES (18, 17);
INSERT INTO public.vet_specialties VALUES (19, 14);


--
-- PostgreSQL database dump complete
--

