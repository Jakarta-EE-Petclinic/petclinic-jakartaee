--
-- PostgreSQL database dump
--

-- Dumped from database version 14.4 (Ubuntu 14.4-1.pgdg22.04+1)
-- Dumped by pg_dump version 14.4 (Ubuntu 14.4-1.pgdg22.04+1)

--
-- Data for Name: owner; Type: TABLE DATA; Schema: public; Owner: petclinic_jakartaee
--

INSERT INTO public.owner VALUES (24, 'Glatzer Str.', '', 'Berlin', 'thomas.woehlke@gmail.com', 'Thomas', '5a', 'Wöhlke', '+493052007953', ' Thomas W hlke Glatzer Str 5a 10247 Berlin  493052007953 thomas woehlke gmail com ', '\xaced00057372000e6a6176612e7574696c2e55554944bc9903f7986d852f0200024a000c6c65617374536967426974734a000b6d6f73745369674269747378708d42fba9f1d6425ecb0fb9187b054a46', '10247');
INSERT INTO public.owner VALUES (25, 'Hill Drive', 'Auf dem Schrottplatz von Titus Jonas', 'Rocky Beach', 'thomas.woehlke@rub.de', 'Justus', '128', 'Jonas', '+4923452007953', 'Auf dem Schrottplatz von Titus Jonas Justus Jonas Hill Drive 128 99777 Rocky Beach  4923452007953 thomas woehlke rub de ', '\xaced00057372000e6a6176612e7574696c2e55554944bc9903f7986d852f0200024a000c6c65617374536967426974734a000b6d6f7374536967426974737870a045abbabafb4ac175ca895792164357', '99777');


--
-- Data for Name: owner_pet_type; Type: TABLE DATA; Schema: public; Owner: petclinic_jakartaee
--

INSERT INTO public.owner_pet_type VALUES (1, 'Dog', 'Dog ', '\xaced00057372000e6a6176612e7574696c2e55554944bc9903f7986d852f0200024a000c6c65617374536967426974734a000b6d6f7374536967426974737870ad537591b3d71fc0cbb4be57eaf346e5');
INSERT INTO public.owner_pet_type VALUES (2, 'Cat', 'Cat ', '\xaced00057372000e6a6176612e7574696c2e55554944bc9903f7986d852f0200024a000c6c65617374536967426974734a000b6d6f7374536967426974737870a7f7d888f646cf345196a3b645224f68');
INSERT INTO public.owner_pet_type VALUES (3, 'Mouse', 'Mouse ', '\xaced00057372000e6a6176612e7574696c2e55554944bc9903f7986d852f0200024a000c6c65617374536967426974734a000b6d6f73745369674269747378709647db9aee8dfabeba358b36a2a14ada');
INSERT INTO public.owner_pet_type VALUES (4, 'Rabbit', 'Rabbit ', '\xaced00057372000e6a6176612e7574696c2e55554944bc9903f7986d852f0200024a000c6c65617374536967426974734a000b6d6f73745369674269747378708051f1dfbc4b1790f195263e27c942fe');
INSERT INTO public.owner_pet_type VALUES (5, 'Fish', 'Fish ', '\xaced00057372000e6a6176612e7574696c2e55554944bc9903f7986d852f0200024a000c6c65617374536967426974734a000b6d6f7374536967426974737870a71e728e8d1cbc74fa9e49c931f44ef9');
INSERT INTO public.owner_pet_type VALUES (6, 'Spider', 'Spider ', '\xaced00057372000e6a6176612e7574696c2e55554944bc9903f7986d852f0200024a000c6c65617374536967426974734a000b6d6f7374536967426974737870936b731e361e1adf951289ac90244039');
INSERT INTO public.owner_pet_type VALUES (7, 'Hamster', 'Hamster ', '\xaced00057372000e6a6176612e7574696c2e55554944bc9903f7986d852f0200024a000c6c65617374536967426974734a000b6d6f73745369674269747378709d4cdb717f15dee2caa5e48c656148ca');
INSERT INTO public.owner_pet_type VALUES (8, 'Guinea pig', 'Guinea pig ', '\xaced00057372000e6a6176612e7574696c2e55554944bc9903f7986d852f0200024a000c6c65617374536967426974734a000b6d6f73745369674269747378709cb3b35706283639c1ec60f1cbd1440c');
INSERT INTO public.owner_pet_type VALUES (9, 'Little Pony', 'Little Pony ', '\xaced00057372000e6a6176612e7574696c2e55554944bc9903f7986d852f0200024a000c6c65617374536967426974734a000b6d6f7374536967426974737870b14b68c108e81a97fc9050c148f34054');
INSERT INTO public.owner_pet_type VALUES (10, 'Frog', 'Frog ', '\xaced00057372000e6a6176612e7574696c2e55554944bc9903f7986d852f0200024a000c6c65617374536967426974734a000b6d6f7374536967426974737870b1223a59dffe730538d190bfbbbd4b8c');
INSERT INTO public.owner_pet_type VALUES (11, 'Elephant', 'Elephant ', '\xaced00057372000e6a6176612e7574696c2e55554944bc9903f7986d852f0200024a000c6c65617374536967426974734a000b6d6f7374536967426974737870862c2c1a331a531967e920378ce749e9');
INSERT INTO public.owner_pet_type VALUES (12, 'Parrot', 'Parrot ', '\xaced00057372000e6a6176612e7574696c2e55554944bc9903f7986d852f0200024a000c6c65617374536967426974734a000b6d6f7374536967426974737870a2e9cadcb9021dac4ee7a96b585f437f');
INSERT INTO public.owner_pet_type VALUES (13, 'Budgie', 'Budgie ', '\xaced00057372000e6a6176612e7574696c2e55554944bc9903f7986d852f0200024a000c6c65617374536967426974734a000b6d6f7374536967426974737870aa6c45f9ee08ba4b6add9aea3e6f4354');
INSERT INTO public.owner_pet_type VALUES (14, 'Dust Puppy', 'Dust Puppy ', '\xaced00057372000e6a6176612e7574696c2e55554944bc9903f7986d852f0200024a000c6c65617374536967426974734a000b6d6f7374536967426974737870975209984c59c43fa36c8bd3547045fb');


--
-- Data for Name: owner_pet; Type: TABLE DATA; Schema: public; Owner: petclinic_jakartaee
--



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

INSERT INTO public.specialty VALUES (15, 'Cardiologist', 'Cardiologist ', '\xaced00057372000e6a6176612e7574696c2e55554944bc9903f7986d852f0200024a000c6c65617374536967426974734a000b6d6f7374536967426974737870bd149a11ee0e2b60220f8331e31d474e');
INSERT INTO public.specialty VALUES (16, 'Radiologist', 'Radiologist ', '\xaced00057372000e6a6176612e7574696c2e55554944bc9903f7986d852f0200024a000c6c65617374536967426974734a000b6d6f73745369674269747378708c9b3ac5d60cfd0f19dd72d2cc8f465c');
INSERT INTO public.specialty VALUES (17, 'Rescue Doctor', 'Rescue Doctor ', '\xaced00057372000e6a6176612e7574696c2e55554944bc9903f7986d852f0200024a000c6c65617374536967426974734a000b6d6f7374536967426974737870a2b594806875b65999b7091b61b64634');
INSERT INTO public.specialty VALUES (18, 'Surgeon', 'Surgeon ', '\xaced00057372000e6a6176612e7574696c2e55554944bc9903f7986d852f0200024a000c6c65617374536967426974734a000b6d6f7374536967426974737870aa9500b4fecb23b5d562cb0f91e4434d');
INSERT INTO public.specialty VALUES (19, 'Neurosurgeon', 'Neurosurgeon ', '\xaced00057372000e6a6176612e7574696c2e55554944bc9903f7986d852f0200024a000c6c65617374536967426974734a000b6d6f73745369674269747378709f6092db94deb3c5c830ee14a7c848f6');
INSERT INTO public.specialty VALUES (20, 'Anesthetist', 'Anesthetist ', '\xaced00057372000e6a6176612e7574696c2e55554944bc9903f7986d852f0200024a000c6c65617374536967426974734a000b6d6f73745369674269747378709e6883351e26aad8fad465a24afa4c6f');
INSERT INTO public.specialty VALUES (21, 'Oncologist', 'Oncologist ', '\xaced00057372000e6a6176612e7574696c2e55554944bc9903f7986d852f0200024a000c6c65617374536967426974734a000b6d6f737453696742697473787090e989a75636427aa4e6734240d2401f');


--
-- Data for Name: vet; Type: TABLE DATA; Schema: public; Owner: petclinic_jakartaee
--

INSERT INTO public.vet VALUES (22, 'Marie', 'Curie', 'Marie Curie Neurosurgeon Oncologist Rescue Doctor Cardiologist Radiologist Anesthetist Surgeon ', '\xaced00057372000e6a6176612e7574696c2e55554944bc9903f7986d852f0200024a000c6c65617374536967426974734a000b6d6f737453696742697473787091892e0984e9080d3f1634cd6b034f0a');
INSERT INTO public.vet VALUES (23, 'Walter', 'von der Vogelweide', 'Walter von der Vogelweide Anesthetist ', '\xaced00057372000e6a6176612e7574696c2e55554944bc9903f7986d852f0200024a000c6c65617374536967426974734a000b6d6f737453696742697473787086387c0da7ec6d5205779f67d1f24671');


--
-- Data for Name: vet_specialties; Type: TABLE DATA; Schema: public; Owner: petclinic_jakartaee
--

INSERT INTO public.vet_specialties VALUES (22, 18);
INSERT INTO public.vet_specialties VALUES (22, 19);
INSERT INTO public.vet_specialties VALUES (22, 16);
INSERT INTO public.vet_specialties VALUES (22, 15);
INSERT INTO public.vet_specialties VALUES (22, 20);
INSERT INTO public.vet_specialties VALUES (22, 21);
INSERT INTO public.vet_specialties VALUES (22, 17);
INSERT INTO public.vet_specialties VALUES (23, 20);


--
-- PostgreSQL database dump complete
--

