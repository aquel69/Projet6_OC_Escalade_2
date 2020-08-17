--
-- PostgreSQL database dump
--

-- Dumped from database version 12.2
-- Dumped by pg_dump version 12.2

-- Started on 2020-05-14 09:05:34

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
-- TOC entry 2989 (class 0 OID 17189)
-- Dependencies: 205
-- Data for Name: pays; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (4, 'AFGHANISTAN', 'AFG', 'AF');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (8, 'ALBANIE', 'ALB', 'AL');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (10, 'ANTARCTIQUE', 'ATA', 'AQ');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (12, 'ALGÉRIE', 'DZA', 'DZ');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (16, 'SAMOA AMÉRICAINES', 'ASM', 'AS');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (20, 'ANDORRE', 'AND', 'AD');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (24, 'ANGOLA', 'AGO', 'AO');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (28, 'ANTIGUA-ET-BARBUDA', 'ATG', 'AG');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (31, 'AZERBAÏDJAN', 'AZE', 'AZ');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (32, 'ARGENTINE', 'ARG', 'AR');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (36, 'AUSTRALIE', 'AUS', 'AU');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (40, 'AUTRICHE', 'AUT', 'AT');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (44, 'BAHAMAS', 'BHS', 'BS');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (48, 'BAHREÏN', 'BHR', 'BH');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (50, 'BANGLADESH', 'BGD', 'BD');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (51, 'ARMÉNIE', 'ARM', 'AM');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (52, 'BARBADE', 'BRB', 'BB');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (56, 'BELGIQUE', 'BEL', 'BE');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (60, 'BERMUDES', 'BMU', 'BM');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (64, 'BHOUTAN', 'BTN', 'BT');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (68, 'BOLIVIE, ÉTAT PLURINATIONAL DE', 'BOL', 'BO');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (70, 'BOSNIE-HERZÉGOVINE', 'BIH', 'BA');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (72, 'BOTSWANA', 'BWA', 'BW');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (74, 'BOUVET, ÎLE', 'BVT', 'BV');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (76, 'BRÉSIL', 'BRA', 'BR');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (84, 'BELIZE', 'BLZ', 'BZ');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (86, 'OCÉAN INDIEN, TERRITOIRE BRITANNIQUE DE L''', 'IOT', 'IO');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (90, 'SALOMON, ÎLES', 'SLB', 'SB');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (92, 'ÎLES VIERGES BRITANNIQUES', 'VGB', 'VG');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (96, 'BRUNÉI DARUSSALAM', 'BRN', 'BN');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (100, 'BULGARIE', 'BGR', 'BG');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (104, 'MYANMAR', 'MMR', 'MM');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (108, 'BURUNDI', 'BDI', 'BI');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (112, 'BÉLARUS', 'BLR', 'BY');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (116, 'CAMBODGE', 'KHM', 'KH');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (120, 'CAMEROUN', 'CMR', 'CM');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (124, 'CANADA', 'CAN', 'CA');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (132, 'CABO VERDE', 'CPV', 'CV');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (136, 'CAÏMANES, ÎLES', 'CYM', 'KY');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (140, 'CENTRAFRICAINE, RÉPUBLIQUE', 'CAF', 'CF');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (144, 'SRI LANKA', 'LKA', 'LK');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (148, 'TCHAD', 'TCD', 'TD');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (152, 'CHILI', 'CHL', 'CL');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (156, 'CHINE', 'CHN', 'CN');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (158, 'TAÏWAN, PROVINCE DE CHINE', 'TWN', 'TW');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (162, 'CHRISTMAS, ÎLE', 'CXR', 'CX');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (166, 'COCOS (KEELING), ÎLES', 'CCK', 'CC');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (170, 'COLOMBIE', 'COL', 'CO');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (174, 'COMORES', 'COM', 'KM');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (175, 'MAYOTTE', 'MYT', 'YT');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (178, 'CONGO', 'COG', 'CG');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (180, 'CONGO, LA RÉPUBLIQUE DÉMOCRATIQUE DU', 'COD', 'CD');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (184, 'COOK, ÎLES', 'COK', 'CK');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (188, 'COSTA RICA', 'CRI', 'CR');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (191, 'CROATIE', 'HRV', 'HR');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (192, 'CUBA', 'CUB', 'CU');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (196, 'CHYPRE', 'CYP', 'CY');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (203, 'TCHÉQUIE', 'CZE', 'CZ');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (204, 'BÉNIN', 'BEN', 'BJ');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (208, 'DANEMARK', 'DNK', 'DK');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (212, 'DOMINIQUE', 'DMA', 'DM');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (214, 'DOMINICAINE, RÉPUBLIQUE', 'DOM', 'DO');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (218, 'ÉQUATEUR', 'ECU', 'EC');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (222, 'EL SALVADOR', 'SLV', 'SV');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (226, 'GUINÉE ÉQUATORIALE', 'GNQ', 'GQ');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (231, 'ÉTHIOPIE', 'ETH', 'ET');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (232, 'ÉRYTHRÉE', 'ERI', 'ER');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (233, 'ESTONIE', 'EST', 'EE');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (234, 'FÉROÉ, ÎLES', 'FRO', 'FO');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (238, 'FALKLAND, ÎLES (MALVINAS)', 'FLK', 'FK');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (239, 'GÉORGIE DU SUD ET LES ÎLES SANDWICH DU SUD', 'SGS', 'GS');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (242, 'FIDJI', 'FJI', 'FJ');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (246, 'FINLANDE', 'FIN', 'FI');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (248, 'ÅLAND, ÎLES', 'ALA', 'AX');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (250, 'FRANCE', 'FRA', 'FR');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (254, 'GUYANE FRANÇAISE', 'GUF', 'GF');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (258, 'POLYNÉSIE FRANÇAISE', 'PYF', 'PF');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (260, 'TERRES AUSTRALES FRANÇAISES', 'ATF', 'TF');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (262, 'DJIBOUTI', 'DJI', 'DJ');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (266, 'GABON', 'GAB', 'GA');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (268, 'GÉORGIE', 'GEO', 'GE');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (270, 'GAMBIE', 'GMB', 'GM');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (275, 'ÉTAT DE PALESTINE', 'PSE', 'PS');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (276, 'ALLEMAGNE', 'DEU', 'DE');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (288, 'GHANA', 'GHA', 'GH');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (292, 'GIBRALTAR', 'GIB', 'GI');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (296, 'KIRIBATI', 'KIR', 'KI');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (300, 'GRÈCE', 'GRC', 'GR');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (304, 'GROENLAND', 'GRL', 'GL');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (308, 'GRENADE', 'GRD', 'GD');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (312, 'GUADELOUPE', 'GLP', 'GP');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (316, 'GUAM', 'GUM', 'GU');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (320, 'GUATEMALA', 'GTM', 'GT');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (324, 'GUINÉE', 'GIN', 'GN');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (328, 'GUYANA', 'GUY', 'GY');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (332, 'HAÏTI', 'HTI', 'HT');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (334, 'HEARD ET MACDONALD, ÎLES', 'HMD', 'HM');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (336, 'SAINT-SIÈGE (ÉTAT DE LA CITÉ DU VATICAN)', 'VAT', 'VA');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (340, 'HONDURAS', 'HND', 'HN');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (344, 'HONG KONG', 'HKG', 'HK');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (348, 'HONGRIE', 'HUN', 'HU');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (352, 'ISLANDE', 'ISL', 'IS');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (356, 'INDE', 'IND', 'IN');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (360, 'INDONÉSIE', 'IDN', 'ID');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (364, 'IRAN, RÉPUBLIQUE ISLAMIQUE D''', 'IRN', 'IR');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (368, 'IRAQ', 'IRQ', 'IQ');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (372, 'IRLANDE', 'IRL', 'IE');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (376, 'ISRAËL', 'ISR', 'IL');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (380, 'ITALIE', 'ITA', 'IT');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (384, 'CÔTE D’IVOIRE', 'CIV', 'CI');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (388, 'JAMAÏQUE', 'JAM', 'JM');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (392, 'JAPON', 'JPN', 'JP');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (398, 'KAZAKHSTAN', 'KAZ', 'KZ');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (400, 'JORDANIE', 'JOR', 'JO');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (404, 'KENYA', 'KEN', 'KE');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (408, 'CORÉE, RÉPUBLIQUE POPULAIRE DÉMOCRATIQUE DE', 'PRK', 'KP');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (410, 'CORÉE, RÉPUBLIQUE DE', 'KOR', 'KR');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (414, 'KOWEÏT', 'KWT', 'KW');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (417, 'KIRGHIZISTAN', 'KGZ', 'KG');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (418, 'LAO, RÉPUBLIQUE DÉMOCRATIQUE POPULAIRE', 'LAO', 'LA');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (422, 'LIBAN', 'LBN', 'LB');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (426, 'LESOTHO', 'LSO', 'LS');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (428, 'LETTONIE', 'LVA', 'LV');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (430, 'LIBÉRIA', 'LBR', 'LR');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (434, 'LIBYE', 'LBY', 'LY');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (438, 'LIECHTENSTEIN', 'LIE', 'LI');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (440, 'LITUANIE', 'LTU', 'LT');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (442, 'LUXEMBOURG', 'LUX', 'LU');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (446, 'MACAO', 'MAC', 'MO');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (450, 'MADAGASCAR', 'MDG', 'MG');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (454, 'MALAWI', 'MWI', 'MW');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (458, 'MALAISIE', 'MYS', 'MY');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (462, 'MALDIVES', 'MDV', 'MV');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (466, 'MALI', 'MLI', 'ML');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (470, 'MALTE', 'MLT', 'MT');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (474, 'MARTINIQUE', 'MTQ', 'MQ');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (478, 'MAURITANIE', 'MRT', 'MR');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (480, 'MAURICE', 'MUS', 'MU');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (484, 'MEXIQUE', 'MEX', 'MX');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (492, 'MONACO', 'MCO', 'MC');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (496, 'MONGOLIE', 'MNG', 'MN');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (498, 'MOLDAVIE', 'MDA', 'MD');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (499, 'MONTÉNÉGRO', 'MNE', 'ME');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (500, 'MONTSERRAT', 'MSR', 'MS');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (504, 'MAROC', 'MAR', 'MA');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (508, 'MOZAMBIQUE', 'MOZ', 'MZ');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (512, 'OMAN', 'OMN', 'OM');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (516, 'NAMIBIE', 'NAM', 'NA');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (520, 'NAURU', 'NRU', 'NR');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (524, 'NÉPAL', 'NPL', 'NP');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (528, 'PAYS-BAS', 'NLD', 'NL');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (531, 'CURAÇAO', 'CUW', 'CW');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (533, 'ARUBA', 'ABW', 'AW');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (534, 'SAINT-MARTIN (PARTIE NÉERLANDAISE)', 'SXM', 'SX');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (535, 'BONAIRE, SAINT-EUSTACHE ET SABA', 'BES', 'BQ');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (540, 'NOUVELLE-CALÉDONIE', 'NCL', 'NC');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (548, 'VANUATU', 'VUT', 'VU');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (554, 'NOUVELLE-ZÉLANDE', 'NZL', 'NZ');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (558, 'NICARAGUA', 'NIC', 'NI');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (562, 'NIGER', 'NER', 'NE');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (566, 'NIGÉRIA', 'NGA', 'NG');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (570, 'NIUÉ', 'NIU', 'NU');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (574, 'NORFOLK, ÎLE', 'NFK', 'NF');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (578, 'NORVÈGE', 'NOR', 'NO');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (580, 'MARIANNES DU NORD, ÎLES', 'MNP', 'MP');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (581, 'ÎLES MINEURES ÉLOIGNÉES DES ÉTATS-UNIS', 'UMI', 'UM');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (583, 'MICRONÉSIE, ÉTATS FÉDÉRÉS DE', 'FSM', 'FM');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (584, 'MARSHALL, ÎLES', 'MHL', 'MH');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (585, 'PALAOS', 'PLW', 'PW');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (586, 'PAKISTAN', 'PAK', 'PK');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (591, 'PANAMA', 'PAN', 'PA');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (598, 'PAPOUASIE-NOUVELLE-GUINÉE', 'PNG', 'PG');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (600, 'PARAGUAY', 'PRY', 'PY');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (604, 'PÉROU', 'PER', 'PE');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (608, 'PHILIPPINES', 'PHL', 'PH');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (612, 'PITCAIRN', 'PCN', 'PN');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (616, 'POLOGNE', 'POL', 'PL');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (620, 'PORTUGAL', 'PRT', 'PT');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (624, 'GUINÉE-BISSAU', 'GNB', 'GW');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (626, 'TIMOR-LESTE', 'TLS', 'TL');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (630, 'PORTO RICO', 'PRI', 'PR');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (634, 'QATAR', 'QAT', 'QA');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (638, 'RÉUNION', 'REU', 'RE');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (642, 'ROUMANIE', 'ROU', 'RO');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (643, 'RUSSIE, FÉDÉRATION DE', 'RUS', 'RU');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (646, 'RWANDA', 'RWA', 'RW');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (652, 'SAINT-BARTHÉLEMY', 'BLM', 'BL');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (654, 'SAINTE-HÉLÈNE, ASCENSION ET TRISTAN DA CUNHA', 'SHN', 'SH');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (659, 'SAINT-KITTS-ET-NEVIS', 'KNA', 'KN');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (660, 'ANGUILLA', 'AIA', 'AI');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (662, 'SAINTE-LUCIE', 'LCA', 'LC');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (663, 'SAINT-MARTIN (PARTIE FRANÇAISE)', 'MAF', 'MF');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (666, 'SAINT-PIERRE-ET-MIQUELON', 'SPM', 'PM');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (670, 'SAINT-VINCENT-ET-LES-GRENADINES', 'VCT', 'VC');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (674, 'SAINT-MARIN', 'SMR', 'SM');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (678, 'SAO TOMÉ-ET-PRINCIPE', 'STP', 'ST');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (682, 'ARABIE SAOUDITE', 'SAU', 'SA');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (686, 'SÉNÉGAL', 'SEN', 'SN');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (688, 'SERBIE', 'SRB', 'RS');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (690, 'SEYCHELLES', 'SYC', 'SC');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (694, 'SIERRA LEONE', 'SLE', 'SL');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (702, 'SINGAPOUR', 'SGP', 'SG');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (703, 'SLOVAQUIE', 'SVK', 'SK');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (704, 'VIET NAM', 'VNM', 'VN');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (705, 'SLOVÉNIE', 'SVN', 'SI');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (706, 'SOMALIE', 'SOM', 'SO');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (710, 'AFRIQUE DU SUD', 'ZAF', 'ZA');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (716, 'ZIMBABWE', 'ZWE', 'ZW');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (724, 'ESPAGNE', 'ESP', 'ES');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (728, 'SOUDAN DU SUD', 'SSD', 'SS');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (729, 'SOUDAN', 'SDN', 'SD');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (732, 'SAHARA OCCIDENTAL', 'ESH', 'EH');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (740, 'SURINAME', 'SUR', 'SR');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (744, 'SVALBARD ET ÎLE JAN MAYEN', 'SJM', 'SJ');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (748, 'ESWATINI', 'SWZ', 'SZ');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (752, 'SUÈDE', 'SWE', 'SE');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (756, 'SUISSE', 'CHE', 'CH');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (760, 'SYRIENNE, RÉPUBLIQUE ARABE', 'SYR', 'SY');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (762, 'TADJIKISTAN', 'TJK', 'TJ');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (764, 'THAÏLANDE', 'THA', 'TH');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (768, 'TOGO', 'TGO', 'TG');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (772, 'TOKELAU', 'TKL', 'TK');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (776, 'TONGA', 'TON', 'TO');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (780, 'TRINITÉ-ET-TOBAGO', 'TTO', 'TT');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (784, 'ÉMIRATS ARABES UNIS', 'ARE', 'AE');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (788, 'TUNISIE', 'TUN', 'TN');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (792, 'TURQUIE', 'TUR', 'TR');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (795, 'TURKMÉNISTAN', 'TKM', 'TM');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (796, 'TURKS ET CAÏQUES, ÎLES', 'TCA', 'TC');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (798, 'TUVALU', 'TUV', 'TV');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (800, 'OUGANDA', 'UGA', 'UG');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (804, 'UKRAINE', 'UKR', 'UA');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (807, 'RÉPUBLIQUE DE MACÉDOINE', 'MKD', 'MK');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (818, 'ÉGYPTE', 'EGY', 'EG');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (826, 'ROYAUME-UNI', 'GBR', 'GB');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (831, 'GUERNESEY', 'GGY', 'GG');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (832, 'JERSEY', 'JEY', 'JE');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (833, 'ÎLE DE MAN', 'IMN', 'IM');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (834, 'TANZANIE, RÉPUBLIQUE UNIE DE', 'TZA', 'TZ');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (840, 'ÉTATS-UNIS', 'USA', 'US');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (850, 'ÎLES VIERGES DES ÉTATS-UNIS', 'VIR', 'VI');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (854, 'BURKINA FASO', 'BFA', 'BF');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (858, 'URUGUAY', 'URY', 'UY');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (860, 'OUZBÉKISTAN', 'UZB', 'UZ');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (862, 'VENEZUELA, RÉPUBLIQUE BOLIVARIENNE DU', 'VEN', 'VE');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (876, 'WALLIS-ET-FUTUNA', 'WLF', 'WF');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (882, 'SAMOA', 'WSM', 'WS');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (887, 'YÉMEN', 'YEM', 'YE');
INSERT INTO public.pays (pays_code, nom, code_alpha_2, code_alpha_3) VALUES (894, 'ZAMBIE', 'ZMB', 'ZM');


--
-- TOC entry 2991 (class 0 OID 17199)
-- Dependencies: 207
-- Data for Name: region; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.region (id_region, nom, pays_code) VALUES (1, 'Auvergne-Rhône-Alpes', 250);
INSERT INTO public.region (id_region, nom, pays_code) VALUES (2, 'Bourgogne-Franche-Comté', 250);
INSERT INTO public.region (id_region, nom, pays_code) VALUES (3, 'Bretagne', 250);
INSERT INTO public.region (id_region, nom, pays_code) VALUES (4, 'Centre-Val de Loire', 250);
INSERT INTO public.region (id_region, nom, pays_code) VALUES (5, 'Corse', 250);
INSERT INTO public.region (id_region, nom, pays_code) VALUES (6, 'Grand Est', 250);
INSERT INTO public.region (id_region, nom, pays_code) VALUES (7, 'Guadeloupe', 250);
INSERT INTO public.region (id_region, nom, pays_code) VALUES (8, 'Guyane', 250);
INSERT INTO public.region (id_region, nom, pays_code) VALUES (9, 'Hauts-de-France', 250);
INSERT INTO public.region (id_region, nom, pays_code) VALUES (10, 'Île-de-France', 250);
INSERT INTO public.region (id_region, nom, pays_code) VALUES (11, 'La Réunion', 250);
INSERT INTO public.region (id_region, nom, pays_code) VALUES (12, 'Martinique', 250);
INSERT INTO public.region (id_region, nom, pays_code) VALUES (13, 'Mayotte', 250);
INSERT INTO public.region (id_region, nom, pays_code) VALUES (14, 'Normandie', 250);
INSERT INTO public.region (id_region, nom, pays_code) VALUES (15, 'Nouvelle-Aquitaine', 250);
INSERT INTO public.region (id_region, nom, pays_code) VALUES (16, 'Occitanie', 250);
INSERT INTO public.region (id_region, nom, pays_code) VALUES (17, 'Pays de la Loire', 250);
INSERT INTO public.region (id_region, nom, pays_code) VALUES (18, 'Provence-Alpes-Côte d''Azur', 250);


--
-- TOC entry 2993 (class 0 OID 17210)
-- Dependencies: 209
-- Data for Name: departement; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (165, '1', 'Ain', 1);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (166, '2', 'Aisne', 9);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (167, '3', 'Allier', 1);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (168, '4', 'Alpes-de-Haute-Provence', 18);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (169, '5', 'Hautes-Alpes', 18);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (170, '6', 'Alpes-Maritimes', 18);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (171, '7', 'Ardèche', 1);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (172, '8', 'Ardennes', 6);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (173, '9', 'Ariège', 16);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (174, '10', 'Aube', 6);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (175, '11', 'Aude', 16);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (176, '12', 'Aveyron', 16);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (177, '13', 'Bouches-du-Rhône', 18);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (178, '14', 'Calvados', 14);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (179, '15', 'Cantal', 1);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (180, '16', 'Charente', 15);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (181, '17', 'Charente-Maritime', 15);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (182, '18', 'Cher', 4);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (183, '19', 'Corrèze', 15);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (184, '21', 'Côte-d''Or', 2);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (185, '22', 'Côtes-d''Armor', 3);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (186, '23', 'Creuse', 15);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (187, '24', 'Dordogne', 15);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (188, '25', 'Doubs', 2);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (189, '26', 'Drôme', 1);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (190, '27', 'Eure', 14);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (191, '28', 'Eure-et-Loir', 4);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (192, '29', 'Finistère', 3);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (193, '30', 'Gard', 16);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (194, '31', 'Haute-Garonne', 16);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (195, '32', 'Gers', 16);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (196, '33', 'Gironde', 15);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (197, '34', 'Hérault', 16);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (198, '35', 'Ille-et-Vilaine', 3);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (199, '36', 'Indre', 4);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (200, '37', 'Indre-et-Loire', 4);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (201, '38', 'Isère', 1);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (202, '39', 'Jura', 2);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (203, '40', 'Landes', 15);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (204, '41', 'Loir-et-Cher', 4);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (205, '42', 'Loire', 1);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (206, '43', 'Haute-Loire', 1);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (207, '44', 'Loire-Atlantique', 17);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (208, '45', 'Loiret', 4);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (209, '46', 'Lot', 16);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (210, '47', 'Lot-et-Garonne', 15);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (211, '48', 'Lozère', 16);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (212, '49', 'Maine-et-Loire', 17);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (213, '50', 'Manche', 14);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (214, '51', 'Marne', 6);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (215, '52', 'Haute-Marne', 6);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (216, '53', 'Mayenne', 17);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (217, '54', 'Meurthe-et-Moselle', 6);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (218, '55', 'Meuse', 6);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (219, '56', 'Morbihan', 3);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (220, '57', 'Moselle', 6);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (221, '58', 'Nièvre', 2);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (222, '59', 'Nord', 9);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (223, '60', 'Oise', 9);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (224, '61', 'Orne', 14);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (225, '62', 'Pas-de-Calais', 9);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (226, '63', 'Puy-de-Dôme', 1);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (227, '64', 'Pyrénées-Atlantiques', 15);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (228, '65', 'Hautes-Pyrénées', 16);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (229, '66', 'Pyrénées-Orientales', 16);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (230, '67', 'Bas-Rhin', 6);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (231, '68', 'Haut-Rhin', 6);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (232, '69', 'RhôneNote 7', 1);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (233, '70', 'Haute-Saône', 2);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (234, '71', 'Saône-et-Loire', 2);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (235, '72', 'Sarthe', 17);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (236, '73', 'Savoie', 1);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (237, '74', 'Haute-Savoie', 1);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (238, '75', 'Paris', 10);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (239, '76', 'Seine-Maritime', 14);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (240, '77', 'Seine-et-Marne', 10);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (241, '78', 'Yvelines', 10);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (242, '79', 'Deux-Sèvres', 15);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (243, '80', 'Somme', 9);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (244, '81', 'Tarn', 16);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (245, '82', 'Tarn-et-Garonne', 16);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (246, '83', 'Var', 18);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (247, '84', 'Vaucluse', 18);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (248, '85', 'Vendée', 17);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (249, '86', 'Vienne', 15);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (250, '87', 'Haute-Vienne', 15);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (251, '88', 'Vosges', 6);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (252, '89', 'Yonne', 2);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (253, '90', 'Territoire de Belfort', 2);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (254, '91', 'Essonne', 10);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (255, '92', 'Hauts-de-Seine', 10);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (256, '93', 'Seine-Saint-Denis', 10);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (257, '94', 'Val-de-Marne', 10);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (258, '95', 'Val-d''Oise', 10);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (259, '971', 'Guadeloupe', 7);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (260, '972', 'Martinique', 12);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (261, '973', 'Guyane', 8);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (262, '974', 'La Réunion', 11);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (263, '976', 'Mayotte ', 13);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (264, '2A', 'Corse-du-Sud', 5);
INSERT INTO public.departement (id_departement, numero, nom, id_region) VALUES (265, '2B', 'Haute-Corse', 5);


--
-- TOC entry 2995 (class 0 OID 17221)
-- Dependencies: 211
-- Data for Name: adresse; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.adresse (idadresse, adresse, ville, code_postal, pays_code, id_region, id_departement) VALUES (1, '25 rue de la victoire', 'Lyon', '69001', 250, 1, 232);
INSERT INTO public.adresse (idadresse, adresse, ville, code_postal, pays_code, id_region, id_departement) VALUES (2, 'carrière Collot ou chalet de la carrière Collot – rue des soupirs', 'Epinal', '88000', 250, 6, 251);
INSERT INTO public.adresse (idadresse, adresse, ville, code_postal, pays_code, id_region, id_departement) VALUES (3, '32 rue de l''esperance', 'Paris', '75002', 250, 10, 238);
INSERT INTO public.adresse (idadresse, adresse, ville, code_postal, pays_code, id_region, id_departement) VALUES (4, '69 rue des gones', 'Lyon', '69005', 250, 1, 232);


--
-- TOC entry 2988 (class 0 OID 17181)
-- Dependencies: 204
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.role (code, designation, description) VALUES (1, 'Administrateur', 'Administrateur du site de l''association.');
INSERT INTO public.role (code, designation, description) VALUES (2, 'Membre', 'Membre de l''association.');
INSERT INTO public.role (code, designation, description) VALUES (3, 'Utilisateur', 'Utilisateur du site ayant un compte.');


--
-- TOC entry 3007 (class 0 OID 17292)
-- Dependencies: 223
-- Data for Name: utilisateur; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.utilisateur (id_utilisateur, email, nom, prenom, nom_utilisateur, mot_de_passe, id_adresse, code_role) VALUES (1, 'bardon.alex@gmail.com', 'bardon', 'alex', 'bardon69', 'securiteadministrateur69', 1, 1);
INSERT INTO public.utilisateur (id_utilisateur, email, nom, prenom, nom_utilisateur, mot_de_passe, id_adresse, code_role) VALUES (2, 'but.sof@yahoo.com', 'but', 'sophie', 'sof', 'bellavita75', 3, 2);
INSERT INTO public.utilisateur (id_utilisateur, email, nom, prenom, nom_utilisateur, mot_de_passe, id_adresse, code_role) VALUES (3, 'millot.jean@laposte.net', 'Millot', 'Jean', 'jeannot', 'iloveescalade', 4, 3);


--
-- TOC entry 3009 (class 0 OID 17303)
-- Dependencies: 225
-- Data for Name: commentaire; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.commentaire (id_commentaire, commentaire, date, utilisateur) VALUES (1, 'Bonjour la communauté, j''ai mis en ligne un topo et toutes les information nécessaire pour ce superbe endroit : la Carrière Collot!!!', '2020-05-10', 3);
INSERT INTO public.commentaire (id_commentaire, commentaire, date, utilisateur) VALUES (2, 'Merci pour l''ajout de ce site que je ne connais pas encore...Je viendrais grimper si je passe dans le coin!!', '2020-05-10', 1);
INSERT INTO public.commentaire (id_commentaire, commentaire, date, utilisateur) VALUES (3, 'Merci pour votre retour et n''hésitez pas, vous ne serez pas déçu!', '2020-05-10', 3);


--
-- TOC entry 2997 (class 0 OID 17238)
-- Dependencies: 213
-- Data for Name: cotation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.cotation (cotation, description) VALUES ('1', 'Sentier à plat');
INSERT INTO public.cotation (cotation, description) VALUES ('2', 'Sentier escarpé');
INSERT INTO public.cotation (cotation, description) VALUES ('3', 'Début d''usage des mains, voies enfants');
INSERT INTO public.cotation (cotation, description) VALUES ('4a', 'Initiation');
INSERT INTO public.cotation (cotation, description) VALUES ('4b', 'Initiation');
INSERT INTO public.cotation (cotation, description) VALUES ('4c', 'Initiation');
INSERT INTO public.cotation (cotation, description) VALUES ('5a', 'Perfectionnement');
INSERT INTO public.cotation (cotation, description) VALUES ('5b', 'Perfectionnement');
INSERT INTO public.cotation (cotation, description) VALUES ('5c', 'Perfectionnement');
INSERT INTO public.cotation (cotation, description) VALUES ('6a', 'Escalade technique, adhérence, petites prises');
INSERT INTO public.cotation (cotation, description) VALUES ('6b', 'Escalade technique, adhérence, petites prises');
INSERT INTO public.cotation (cotation, description) VALUES ('6c', 'Escalade technique, adhérence, petites prises');
INSERT INTO public.cotation (cotation, description) VALUES ('7a', 'Escalade physique, parfois en dévers');
INSERT INTO public.cotation (cotation, description) VALUES ('7b', 'Début en compétition');
INSERT INTO public.cotation (cotation, description) VALUES ('7c', 'Début en compétition');
INSERT INTO public.cotation (cotation, description) VALUES ('8a', 'Haut Niveau');
INSERT INTO public.cotation (cotation, description) VALUES ('8b', 'Haut Niveau');
INSERT INTO public.cotation (cotation, description) VALUES ('8c', 'Haut Niveau');
INSERT INTO public.cotation (cotation, description) VALUES ('9a', 'Escalade extrême, Top niveau mondial');
INSERT INTO public.cotation (cotation, description) VALUES ('9a+', 'Escalade extrême, Top niveau mondial');
INSERT INTO public.cotation (cotation, description) VALUES ('9b', 'Escalade extrême, Top niveau mondial');
INSERT INTO public.cotation (cotation, description) VALUES ('9b+', 'Le plus dur réalisé');


--
-- TOC entry 2996 (class 0 OID 17230)
-- Dependencies: 212
-- Data for Name: orientation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.orientation (abreviation, direction) VALUES ('N', 'Nord');
INSERT INTO public.orientation (abreviation, direction) VALUES ('NE', 'Nord-Est');
INSERT INTO public.orientation (abreviation, direction) VALUES ('E', 'Est');
INSERT INTO public.orientation (abreviation, direction) VALUES ('SE', 'Sud-Est');
INSERT INTO public.orientation (abreviation, direction) VALUES ('S', 'Sud');
INSERT INTO public.orientation (abreviation, direction) VALUES ('SO', 'Sud-Ouest');
INSERT INTO public.orientation (abreviation, direction) VALUES ('O', 'Ouest');
INSERT INTO public.orientation (abreviation, direction) VALUES ('NO', 'Nord-Ouest');


--
-- TOC entry 2999 (class 0 OID 17248)
-- Dependencies: 215
-- Data for Name: site_escalade; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.site_escalade (id_site, type_de_roche, orientation, taguer, hauteur, altitude, temps_d_approche, adresse) VALUES (1, 'grès', 'NE', true, '35', '340', 'a vue vers les voies', 2);


--
-- TOC entry 3011 (class 0 OID 17314)
-- Dependencies: 227
-- Data for Name: liste_commentaire_site_escalade; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.liste_commentaire_site_escalade (id_liste_commentaire, site_escalade, commentaire) VALUES (1, 1, 1);
INSERT INTO public.liste_commentaire_site_escalade (id_liste_commentaire, site_escalade, commentaire) VALUES (2, 1, 2);
INSERT INTO public.liste_commentaire_site_escalade (id_liste_commentaire, site_escalade, commentaire) VALUES (3, 1, 3);


--
-- TOC entry 2987 (class 0 OID 17172)
-- Dependencies: 203
-- Data for Name: url_photo; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.url_photo (id_photo, url, description) VALUES (1, 'http://www.enfantsduroc.fr/wp-content/uploads/2016/04/secteur-a.jpg', 'photo du secteur A');
INSERT INTO public.url_photo (id_photo, url, description) VALUES (2, 'http://www.enfantsduroc.fr/wp-content/uploads/2016/04/secteur-b.jpg', 'photo du secteur B');


--
-- TOC entry 3001 (class 0 OID 17259)
-- Dependencies: 217
-- Data for Name: liste_photo_site; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.liste_photo_site (id_liste_photo, site, photo) VALUES (1, 1, 1);
INSERT INTO public.liste_photo_site (id_liste_photo, site, photo) VALUES (2, 1, 2);


--
-- TOC entry 3013 (class 0 OID 17325)
-- Dependencies: 229
-- Data for Name: topo; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.topo (id_topo, nom, lieu, disponibilite, date_de_parution, description, utilisateur) VALUES (1, 'topo-carriere-collot', 'carriere-collot', true, '2020-05-09', 'SUperbe endroit!!', 3);


--
-- TOC entry 3015 (class 0 OID 17464)
-- Dependencies: 231
-- Data for Name: reservation_topo; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.reservation_topo (id_reservation_topo, demande_de_reservation, date_de_reservation, id_topo, id_utilisateur) VALUES (1, true, '2020-05-10', 1, 2);


--
-- TOC entry 3003 (class 0 OID 17270)
-- Dependencies: 219
-- Data for Name: secteur; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.secteur (id_secteur, nom, id_site) VALUES (1, 'secteur A', 1);
INSERT INTO public.secteur (id_secteur, nom, id_site) VALUES (2, 'secteur B', 1);


--
-- TOC entry 3005 (class 0 OID 17281)
-- Dependencies: 221
-- Data for Name: voie; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.voie (id_voie, numero_de_voie, nom, cotation, id_secteur) VALUES (1, '1', 'Rue Béole', '3', 1);
INSERT INTO public.voie (id_voie, numero_de_voie, nom, cotation, id_secteur) VALUES (2, '2', 'éruption', '4b', 1);
INSERT INTO public.voie (id_voie, numero_de_voie, nom, cotation, id_secteur) VALUES (3, '12', 'Captain Hard rock', '5a', 2);
INSERT INTO public.voie (id_voie, numero_de_voie, nom, cotation, id_secteur) VALUES (4, '13', 'Radio lucien', '5c', 2);


--
-- TOC entry 3021 (class 0 OID 0)
-- Dependencies: 210
-- Name: adresse_idadresse_seq_2; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.adresse_idadresse_seq_2', 4, true);


--
-- TOC entry 3022 (class 0 OID 0)
-- Dependencies: 224
-- Name: commentaire_id_commentaire_seq_1; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.commentaire_id_commentaire_seq_1', 3, true);


--
-- TOC entry 3023 (class 0 OID 0)
-- Dependencies: 208
-- Name: departement_id_departement_seq_1; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.departement_id_departement_seq_1', 265, true);


--
-- TOC entry 3024 (class 0 OID 0)
-- Dependencies: 226
-- Name: liste_commentaire_site_escalade_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.liste_commentaire_site_escalade_id_seq', 3, true);


--
-- TOC entry 3025 (class 0 OID 0)
-- Dependencies: 216
-- Name: liste_photo_site_id_liste_photo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.liste_photo_site_id_liste_photo_seq', 2, true);


--
-- TOC entry 3026 (class 0 OID 0)
-- Dependencies: 206
-- Name: region_id_region_seq_1; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.region_id_region_seq_1', 18, true);


--
-- TOC entry 3027 (class 0 OID 0)
-- Dependencies: 230
-- Name: reservation_topo_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.reservation_topo_id_seq', 1, true);


--
-- TOC entry 3028 (class 0 OID 0)
-- Dependencies: 218
-- Name: secteur_id_secteur_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.secteur_id_secteur_seq', 2, true);


--
-- TOC entry 3029 (class 0 OID 0)
-- Dependencies: 214
-- Name: site_escalade_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.site_escalade_id_seq', 1, true);


--
-- TOC entry 3030 (class 0 OID 0)
-- Dependencies: 228
-- Name: topo_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.topo_id_seq', 1, true);


--
-- TOC entry 3031 (class 0 OID 0)
-- Dependencies: 202
-- Name: url_photo_id_photo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.url_photo_id_photo_seq', 2, true);


--
-- TOC entry 3032 (class 0 OID 0)
-- Dependencies: 222
-- Name: utilisateur_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.utilisateur_id_seq', 3, true);


--
-- TOC entry 3033 (class 0 OID 0)
-- Dependencies: 220
-- Name: voie_id_voie_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.voie_id_voie_seq', 4, true);


-- Completed on 2020-05-14 09:05:34

--
-- PostgreSQL database dump complete
--

