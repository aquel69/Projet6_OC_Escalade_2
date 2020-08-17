--
-- PostgreSQL database dump
--

-- Dumped from database version 12.2
-- Dumped by pg_dump version 12.2

-- Started on 2020-05-14 09:04:11

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 211 (class 1259 OID 17221)
-- Name: adresse; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.adresse (
    idadresse numeric NOT NULL,
    adresse character varying NOT NULL,
    ville character varying NOT NULL,
    code_postal character varying NOT NULL,
    pays_code numeric NOT NULL,
    id_region numeric,
    id_departement numeric NOT NULL
);


ALTER TABLE public.adresse OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 17219)
-- Name: adresse_idadresse_seq_2; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.adresse_idadresse_seq_2
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.adresse_idadresse_seq_2 OWNER TO postgres;

--
-- TOC entry 2991 (class 0 OID 0)
-- Dependencies: 210
-- Name: adresse_idadresse_seq_2; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.adresse_idadresse_seq_2 OWNED BY public.adresse.idadresse;


--
-- TOC entry 225 (class 1259 OID 17303)
-- Name: commentaire; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.commentaire (
    id_commentaire numeric NOT NULL,
    commentaire character varying NOT NULL,
    date date NOT NULL,
    utilisateur numeric NOT NULL
);


ALTER TABLE public.commentaire OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 17301)
-- Name: commentaire_id_commentaire_seq_1; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.commentaire_id_commentaire_seq_1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.commentaire_id_commentaire_seq_1 OWNER TO postgres;

--
-- TOC entry 2992 (class 0 OID 0)
-- Dependencies: 224
-- Name: commentaire_id_commentaire_seq_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.commentaire_id_commentaire_seq_1 OWNED BY public.commentaire.id_commentaire;


--
-- TOC entry 213 (class 1259 OID 17238)
-- Name: cotation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cotation (
    cotation character varying NOT NULL,
    description character varying NOT NULL
);


ALTER TABLE public.cotation OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 17210)
-- Name: departement; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.departement (
    id_departement numeric NOT NULL,
    numero character varying NOT NULL,
    nom character varying NOT NULL,
    id_region numeric NOT NULL
);


ALTER TABLE public.departement OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 17208)
-- Name: departement_id_departement_seq_1; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.departement_id_departement_seq_1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.departement_id_departement_seq_1 OWNER TO postgres;

--
-- TOC entry 2993 (class 0 OID 0)
-- Dependencies: 208
-- Name: departement_id_departement_seq_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.departement_id_departement_seq_1 OWNED BY public.departement.id_departement;


--
-- TOC entry 227 (class 1259 OID 17314)
-- Name: liste_commentaire_site_escalade; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.liste_commentaire_site_escalade (
    id_liste_commentaire numeric NOT NULL,
    site_escalade numeric NOT NULL,
    commentaire numeric NOT NULL
);


ALTER TABLE public.liste_commentaire_site_escalade OWNER TO postgres;

--
-- TOC entry 226 (class 1259 OID 17312)
-- Name: liste_commentaire_site_escalade_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.liste_commentaire_site_escalade_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.liste_commentaire_site_escalade_id_seq OWNER TO postgres;

--
-- TOC entry 2994 (class 0 OID 0)
-- Dependencies: 226
-- Name: liste_commentaire_site_escalade_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.liste_commentaire_site_escalade_id_seq OWNED BY public.liste_commentaire_site_escalade.id_liste_commentaire;


--
-- TOC entry 217 (class 1259 OID 17259)
-- Name: liste_photo_site; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.liste_photo_site (
    id_liste_photo numeric NOT NULL,
    site numeric NOT NULL,
    photo numeric NOT NULL
);


ALTER TABLE public.liste_photo_site OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 17257)
-- Name: liste_photo_site_id_liste_photo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.liste_photo_site_id_liste_photo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.liste_photo_site_id_liste_photo_seq OWNER TO postgres;

--
-- TOC entry 2995 (class 0 OID 0)
-- Dependencies: 216
-- Name: liste_photo_site_id_liste_photo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.liste_photo_site_id_liste_photo_seq OWNED BY public.liste_photo_site.id_liste_photo;


--
-- TOC entry 212 (class 1259 OID 17230)
-- Name: orientation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.orientation (
    abreviation character varying NOT NULL,
    direction character varying NOT NULL
);


ALTER TABLE public.orientation OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 17189)
-- Name: pays; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pays (
    pays_code numeric NOT NULL,
    nom character varying NOT NULL,
    code_alpha_2 character varying NOT NULL,
    code_alpha_3 character varying NOT NULL
);


ALTER TABLE public.pays OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 17199)
-- Name: region; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.region (
    id_region numeric NOT NULL,
    nom character varying NOT NULL,
    pays_code numeric NOT NULL
);


ALTER TABLE public.region OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 17197)
-- Name: region_id_region_seq_1; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.region_id_region_seq_1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.region_id_region_seq_1 OWNER TO postgres;

--
-- TOC entry 2996 (class 0 OID 0)
-- Dependencies: 206
-- Name: region_id_region_seq_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.region_id_region_seq_1 OWNED BY public.region.id_region;


--
-- TOC entry 231 (class 1259 OID 17464)
-- Name: reservation_topo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.reservation_topo (
    id_reservation_topo numeric NOT NULL,
    demande_de_reservation boolean NOT NULL,
    date_de_reservation date NOT NULL,
    id_topo numeric NOT NULL,
    id_utilisateur numeric NOT NULL
);


ALTER TABLE public.reservation_topo OWNER TO postgres;

--
-- TOC entry 230 (class 1259 OID 17462)
-- Name: reservation_topo_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.reservation_topo_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.reservation_topo_id_seq OWNER TO postgres;

--
-- TOC entry 2997 (class 0 OID 0)
-- Dependencies: 230
-- Name: reservation_topo_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.reservation_topo_id_seq OWNED BY public.reservation_topo.id_reservation_topo;


--
-- TOC entry 204 (class 1259 OID 17181)
-- Name: role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.role (
    code numeric NOT NULL,
    designation character varying NOT NULL,
    description character varying NOT NULL
);


ALTER TABLE public.role OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 17270)
-- Name: secteur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.secteur (
    id_secteur numeric NOT NULL,
    nom character varying NOT NULL,
    id_site numeric NOT NULL
);


ALTER TABLE public.secteur OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 17268)
-- Name: secteur_id_secteur_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.secteur_id_secteur_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.secteur_id_secteur_seq OWNER TO postgres;

--
-- TOC entry 2998 (class 0 OID 0)
-- Dependencies: 218
-- Name: secteur_id_secteur_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.secteur_id_secteur_seq OWNED BY public.secteur.id_secteur;


--
-- TOC entry 215 (class 1259 OID 17248)
-- Name: site_escalade; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.site_escalade (
    id_site numeric NOT NULL,
    type_de_roche character varying,
    orientation character varying,
    taguer boolean NOT NULL,
    hauteur character varying,
    altitude character varying,
    temps_d_approche character varying,
    adresse numeric NOT NULL
);


ALTER TABLE public.site_escalade OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 17246)
-- Name: site_escalade_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.site_escalade_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.site_escalade_id_seq OWNER TO postgres;

--
-- TOC entry 2999 (class 0 OID 0)
-- Dependencies: 214
-- Name: site_escalade_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.site_escalade_id_seq OWNED BY public.site_escalade.id_site;


--
-- TOC entry 229 (class 1259 OID 17325)
-- Name: topo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.topo (
    id_topo numeric NOT NULL,
    nom character varying NOT NULL,
    lieu character varying NOT NULL,
    disponibilite boolean NOT NULL,
    date_de_parution date NOT NULL,
    description character varying NOT NULL,
    utilisateur numeric NOT NULL
);


ALTER TABLE public.topo OWNER TO postgres;

--
-- TOC entry 228 (class 1259 OID 17323)
-- Name: topo_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.topo_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.topo_id_seq OWNER TO postgres;

--
-- TOC entry 3000 (class 0 OID 0)
-- Dependencies: 228
-- Name: topo_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.topo_id_seq OWNED BY public.topo.id_topo;


--
-- TOC entry 203 (class 1259 OID 17172)
-- Name: url_photo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.url_photo (
    id_photo numeric NOT NULL,
    url character varying NOT NULL,
    description character varying NOT NULL
);


ALTER TABLE public.url_photo OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 17170)
-- Name: url_photo_id_photo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.url_photo_id_photo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.url_photo_id_photo_seq OWNER TO postgres;

--
-- TOC entry 3001 (class 0 OID 0)
-- Dependencies: 202
-- Name: url_photo_id_photo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.url_photo_id_photo_seq OWNED BY public.url_photo.id_photo;


--
-- TOC entry 223 (class 1259 OID 17292)
-- Name: utilisateur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.utilisateur (
    id_utilisateur numeric NOT NULL,
    email character varying NOT NULL,
    nom character varying NOT NULL,
    prenom character varying NOT NULL,
    nom_utilisateur character varying NOT NULL,
    mot_de_passe character varying NOT NULL,
    id_adresse numeric NOT NULL,
    code_role numeric NOT NULL
);


ALTER TABLE public.utilisateur OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 17290)
-- Name: utilisateur_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.utilisateur_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.utilisateur_id_seq OWNER TO postgres;

--
-- TOC entry 3002 (class 0 OID 0)
-- Dependencies: 222
-- Name: utilisateur_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.utilisateur_id_seq OWNED BY public.utilisateur.id_utilisateur;


--
-- TOC entry 221 (class 1259 OID 17281)
-- Name: voie; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.voie (
    id_voie numeric NOT NULL,
    numero_de_voie character varying NOT NULL,
    nom character varying NOT NULL,
    cotation character varying NOT NULL,
    id_secteur numeric NOT NULL
);


ALTER TABLE public.voie OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 17279)
-- Name: voie_id_voie_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.voie_id_voie_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.voie_id_voie_seq OWNER TO postgres;

--
-- TOC entry 3003 (class 0 OID 0)
-- Dependencies: 220
-- Name: voie_id_voie_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.voie_id_voie_seq OWNED BY public.voie.id_voie;


--
-- TOC entry 2795 (class 2604 OID 17224)
-- Name: adresse idadresse; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.adresse ALTER COLUMN idadresse SET DEFAULT nextval('public.adresse_idadresse_seq_2'::regclass);


--
-- TOC entry 2801 (class 2604 OID 17306)
-- Name: commentaire id_commentaire; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire ALTER COLUMN id_commentaire SET DEFAULT nextval('public.commentaire_id_commentaire_seq_1'::regclass);


--
-- TOC entry 2794 (class 2604 OID 17213)
-- Name: departement id_departement; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.departement ALTER COLUMN id_departement SET DEFAULT nextval('public.departement_id_departement_seq_1'::regclass);


--
-- TOC entry 2802 (class 2604 OID 17317)
-- Name: liste_commentaire_site_escalade id_liste_commentaire; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.liste_commentaire_site_escalade ALTER COLUMN id_liste_commentaire SET DEFAULT nextval('public.liste_commentaire_site_escalade_id_seq'::regclass);


--
-- TOC entry 2797 (class 2604 OID 17262)
-- Name: liste_photo_site id_liste_photo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.liste_photo_site ALTER COLUMN id_liste_photo SET DEFAULT nextval('public.liste_photo_site_id_liste_photo_seq'::regclass);


--
-- TOC entry 2793 (class 2604 OID 17202)
-- Name: region id_region; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.region ALTER COLUMN id_region SET DEFAULT nextval('public.region_id_region_seq_1'::regclass);


--
-- TOC entry 2804 (class 2604 OID 17467)
-- Name: reservation_topo id_reservation_topo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservation_topo ALTER COLUMN id_reservation_topo SET DEFAULT nextval('public.reservation_topo_id_seq'::regclass);


--
-- TOC entry 2798 (class 2604 OID 17273)
-- Name: secteur id_secteur; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.secteur ALTER COLUMN id_secteur SET DEFAULT nextval('public.secteur_id_secteur_seq'::regclass);


--
-- TOC entry 2796 (class 2604 OID 17251)
-- Name: site_escalade id_site; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.site_escalade ALTER COLUMN id_site SET DEFAULT nextval('public.site_escalade_id_seq'::regclass);


--
-- TOC entry 2803 (class 2604 OID 17328)
-- Name: topo id_topo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo ALTER COLUMN id_topo SET DEFAULT nextval('public.topo_id_seq'::regclass);


--
-- TOC entry 2792 (class 2604 OID 17175)
-- Name: url_photo id_photo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.url_photo ALTER COLUMN id_photo SET DEFAULT nextval('public.url_photo_id_photo_seq'::regclass);


--
-- TOC entry 2800 (class 2604 OID 17295)
-- Name: utilisateur id_utilisateur; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.utilisateur ALTER COLUMN id_utilisateur SET DEFAULT nextval('public.utilisateur_id_seq'::regclass);


--
-- TOC entry 2799 (class 2604 OID 17284)
-- Name: voie id_voie; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.voie ALTER COLUMN id_voie SET DEFAULT nextval('public.voie_id_voie_seq'::regclass);


--
-- TOC entry 2816 (class 2606 OID 17229)
-- Name: adresse adresse_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.adresse
    ADD CONSTRAINT adresse_pk PRIMARY KEY (idadresse);


--
-- TOC entry 2832 (class 2606 OID 17311)
-- Name: commentaire commentaire_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire
    ADD CONSTRAINT commentaire_pk PRIMARY KEY (id_commentaire);


--
-- TOC entry 2820 (class 2606 OID 17245)
-- Name: cotation cotation_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cotation
    ADD CONSTRAINT cotation_pk PRIMARY KEY (cotation);


--
-- TOC entry 2814 (class 2606 OID 17218)
-- Name: departement departement_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.departement
    ADD CONSTRAINT departement_pk PRIMARY KEY (id_departement);


--
-- TOC entry 2808 (class 2606 OID 17188)
-- Name: role enum_role_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role
    ADD CONSTRAINT enum_role_pk PRIMARY KEY (code);


--
-- TOC entry 2834 (class 2606 OID 17322)
-- Name: liste_commentaire_site_escalade liste_commentaire_site_escalade_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.liste_commentaire_site_escalade
    ADD CONSTRAINT liste_commentaire_site_escalade_pk PRIMARY KEY (id_liste_commentaire);


--
-- TOC entry 2824 (class 2606 OID 17267)
-- Name: liste_photo_site liste_photo_site_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.liste_photo_site
    ADD CONSTRAINT liste_photo_site_pk PRIMARY KEY (id_liste_photo);


--
-- TOC entry 2818 (class 2606 OID 17237)
-- Name: orientation orientation_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orientation
    ADD CONSTRAINT orientation_pk PRIMARY KEY (abreviation);


--
-- TOC entry 2810 (class 2606 OID 17196)
-- Name: pays pays_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pays
    ADD CONSTRAINT pays_pk PRIMARY KEY (pays_code);


--
-- TOC entry 2812 (class 2606 OID 17207)
-- Name: region region_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.region
    ADD CONSTRAINT region_pk PRIMARY KEY (id_region);


--
-- TOC entry 2839 (class 2606 OID 17472)
-- Name: reservation_topo reservation_topo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservation_topo
    ADD CONSTRAINT reservation_topo_pk PRIMARY KEY (id_reservation_topo);


--
-- TOC entry 2826 (class 2606 OID 17278)
-- Name: secteur secteur_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.secteur
    ADD CONSTRAINT secteur_pk PRIMARY KEY (id_secteur);


--
-- TOC entry 2822 (class 2606 OID 17256)
-- Name: site_escalade site_escalade_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.site_escalade
    ADD CONSTRAINT site_escalade_pk PRIMARY KEY (id_site);


--
-- TOC entry 2837 (class 2606 OID 17333)
-- Name: topo topo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo
    ADD CONSTRAINT topo_pk PRIMARY KEY (id_topo);


--
-- TOC entry 2806 (class 2606 OID 17180)
-- Name: url_photo url_photo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.url_photo
    ADD CONSTRAINT url_photo_pk PRIMARY KEY (id_photo);


--
-- TOC entry 2830 (class 2606 OID 17300)
-- Name: utilisateur utilisateur_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.utilisateur
    ADD CONSTRAINT utilisateur_pk PRIMARY KEY (id_utilisateur);


--
-- TOC entry 2828 (class 2606 OID 17289)
-- Name: voie voie_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.voie
    ADD CONSTRAINT voie_pk PRIMARY KEY (id_voie);


--
-- TOC entry 2835 (class 1259 OID 17456)
-- Name: fki_utilisateur_topo_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_utilisateur_topo_fk ON public.topo USING btree (utilisateur);


--
-- TOC entry 2845 (class 2606 OID 17385)
-- Name: site_escalade adresse_site_escalade_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.site_escalade
    ADD CONSTRAINT adresse_site_escalade_fk FOREIGN KEY (adresse) REFERENCES public.adresse(idadresse);


--
-- TOC entry 2853 (class 2606 OID 17380)
-- Name: utilisateur adresse_utilisateur_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.utilisateur
    ADD CONSTRAINT adresse_utilisateur_fk FOREIGN KEY (id_adresse) REFERENCES public.adresse(idadresse);


--
-- TOC entry 2856 (class 2606 OID 17440)
-- Name: liste_commentaire_site_escalade commentaire_liste_commentaire_site_escalade_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.liste_commentaire_site_escalade
    ADD CONSTRAINT commentaire_liste_commentaire_site_escalade_fk FOREIGN KEY (commentaire) REFERENCES public.commentaire(id_commentaire);


--
-- TOC entry 2850 (class 2606 OID 17400)
-- Name: voie cotation_voie_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.voie
    ADD CONSTRAINT cotation_voie_fk FOREIGN KEY (cotation) REFERENCES public.cotation(cotation);


--
-- TOC entry 2844 (class 2606 OID 17375)
-- Name: adresse departement_adresse_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.adresse
    ADD CONSTRAINT departement_adresse_fk FOREIGN KEY (id_departement) REFERENCES public.departement(id_departement);


--
-- TOC entry 2852 (class 2606 OID 17350)
-- Name: utilisateur enum_role_utilisateur_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.utilisateur
    ADD CONSTRAINT enum_role_utilisateur_fk FOREIGN KEY (code_role) REFERENCES public.role(code);


--
-- TOC entry 2846 (class 2606 OID 17390)
-- Name: site_escalade orientation_site_escalade_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.site_escalade
    ADD CONSTRAINT orientation_site_escalade_fk FOREIGN KEY (orientation) REFERENCES public.orientation(abreviation);


--
-- TOC entry 2842 (class 2606 OID 17355)
-- Name: adresse pays_adresse_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.adresse
    ADD CONSTRAINT pays_adresse_fk FOREIGN KEY (pays_code) REFERENCES public.pays(pays_code);


--
-- TOC entry 2840 (class 2606 OID 17360)
-- Name: region pays_region_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.region
    ADD CONSTRAINT pays_region_fk FOREIGN KEY (pays_code) REFERENCES public.pays(pays_code);


--
-- TOC entry 2843 (class 2606 OID 17365)
-- Name: adresse region_adresse_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.adresse
    ADD CONSTRAINT region_adresse_fk FOREIGN KEY (id_region) REFERENCES public.region(id_region);


--
-- TOC entry 2841 (class 2606 OID 17370)
-- Name: departement region_departement_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.departement
    ADD CONSTRAINT region_departement_fk FOREIGN KEY (id_region) REFERENCES public.region(id_region);


--
-- TOC entry 2851 (class 2606 OID 17420)
-- Name: voie secteur_voie_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.voie
    ADD CONSTRAINT secteur_voie_fk FOREIGN KEY (id_secteur) REFERENCES public.secteur(id_secteur);


--
-- TOC entry 2855 (class 2606 OID 17405)
-- Name: liste_commentaire_site_escalade site_escalade_liste_commentaire_site_escalade_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.liste_commentaire_site_escalade
    ADD CONSTRAINT site_escalade_liste_commentaire_site_escalade_fk FOREIGN KEY (site_escalade) REFERENCES public.site_escalade(id_site);


--
-- TOC entry 2848 (class 2606 OID 17415)
-- Name: liste_photo_site site_escalade_liste_photo_site_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.liste_photo_site
    ADD CONSTRAINT site_escalade_liste_photo_site_fk FOREIGN KEY (site) REFERENCES public.site_escalade(id_site);


--
-- TOC entry 2849 (class 2606 OID 17410)
-- Name: secteur site_escalade_secteur_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.secteur
    ADD CONSTRAINT site_escalade_secteur_fk FOREIGN KEY (id_site) REFERENCES public.site_escalade(id_site);


--
-- TOC entry 2859 (class 2606 OID 17478)
-- Name: reservation_topo topo_reservation_topo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservation_topo
    ADD CONSTRAINT topo_reservation_topo_fk FOREIGN KEY (id_topo) REFERENCES public.topo(id_topo);


--
-- TOC entry 2847 (class 2606 OID 17345)
-- Name: liste_photo_site url_photo_liste_photo_site_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.liste_photo_site
    ADD CONSTRAINT url_photo_liste_photo_site_fk FOREIGN KEY (photo) REFERENCES public.url_photo(id_photo);


--
-- TOC entry 2854 (class 2606 OID 17435)
-- Name: commentaire utilisateur_commentaire_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire
    ADD CONSTRAINT utilisateur_commentaire_fk FOREIGN KEY (utilisateur) REFERENCES public.utilisateur(id_utilisateur);


--
-- TOC entry 2858 (class 2606 OID 17473)
-- Name: reservation_topo utilisateur_reservation_topo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservation_topo
    ADD CONSTRAINT utilisateur_reservation_topo_fk FOREIGN KEY (id_utilisateur) REFERENCES public.utilisateur(id_utilisateur);


--
-- TOC entry 2857 (class 2606 OID 17457)
-- Name: topo utilisateur_topo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo
    ADD CONSTRAINT utilisateur_topo_fk FOREIGN KEY (utilisateur) REFERENCES public.utilisateur(id_utilisateur);


-- Completed on 2020-05-14 09:04:11

--
-- PostgreSQL database dump complete
--

