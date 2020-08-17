
CREATE SEQUENCE public.url_photo_id_photo_seq;

CREATE TABLE public.url_photo (
                id_photo NUMERIC NOT NULL DEFAULT nextval('public.url_photo_id_photo_seq'),
                url VARCHAR NOT NULL,
                description VARCHAR NOT NULL,
                CONSTRAINT url_photo_pk PRIMARY KEY (id_photo)
);


ALTER SEQUENCE public.url_photo_id_photo_seq OWNED BY public.url_photo.id_photo;

CREATE TABLE public.enum_role (
                code NUMERIC NOT NULL,
                designation VARCHAR NOT NULL,
                description VARCHAR NOT NULL,
                CONSTRAINT enum_role_pk PRIMARY KEY (code)
);


CREATE TABLE public.pays (
                pays_code NUMERIC NOT NULL,
                nom VARCHAR NOT NULL,
                code_alpha_2 VARCHAR NOT NULL,
                code_alpha_3 VARCHAR NOT NULL,
                CONSTRAINT pays_pk PRIMARY KEY (pays_code)
);


CREATE SEQUENCE public.region_id_region_seq_1;

CREATE TABLE public.region (
                id_region NUMERIC NOT NULL DEFAULT nextval('public.region_id_region_seq_1'),
                nom VARCHAR NOT NULL,
                pays_code NUMERIC NOT NULL,
                CONSTRAINT region_pk PRIMARY KEY (id_region)
);


ALTER SEQUENCE public.region_id_region_seq_1 OWNED BY public.region.id_region;

CREATE SEQUENCE public.departement_id_departement_seq_1;

CREATE TABLE public.departement (
                id_departement NUMERIC NOT NULL DEFAULT nextval('public.departement_id_departement_seq_1'),
                numero VARCHAR NOT NULL,
                nom VARCHAR NOT NULL,
                id_region NUMERIC NOT NULL,
                CONSTRAINT departement_pk PRIMARY KEY (id_departement)
);


ALTER SEQUENCE public.departement_id_departement_seq_1 OWNED BY public.departement.id_departement;

CREATE SEQUENCE public.adresse_idadresse_seq_2;

CREATE TABLE public.adresse (
                idAdresse NUMERIC NOT NULL DEFAULT nextval('public.adresse_idadresse_seq_2'),
                adresse VARCHAR NOT NULL,
                ville VARCHAR NOT NULL,
                code_postal VARCHAR NOT NULL,
                pays_code NUMERIC NOT NULL,
                id_region NUMERIC,
                id_departement NUMERIC NOT NULL,
                CONSTRAINT adresse_pk PRIMARY KEY (idAdresse)
);


ALTER SEQUENCE public.adresse_idadresse_seq_2 OWNED BY public.adresse.idAdresse;

CREATE TABLE public.orientation (
                abreviation VARCHAR NOT NULL,
                direction VARCHAR NOT NULL,
                CONSTRAINT orientation_pk PRIMARY KEY (abreviation)
);


CREATE TABLE public.cotation (
                cotation VARCHAR NOT NULL,
                description VARCHAR NOT NULL,
                CONSTRAINT cotation_pk PRIMARY KEY (cotation)
);


CREATE SEQUENCE public.site_escalade_id_seq;

CREATE TABLE public.site_escalade (
                id_site NUMERIC NOT NULL DEFAULT nextval('public.site_escalade_id_seq'),
                type_de_roche VARCHAR,
                cotation VARCHAR NOT NULL,
                orientation VARCHAR,
                taguer BOOLEAN NOT NULL,
                hauteur VARCHAR,
                altitude VARCHAR,
                temps_d_approche VARCHAR,
                Adresse NUMERIC NOT NULL,
                CONSTRAINT site_escalade_pk PRIMARY KEY (id_site)
);


ALTER SEQUENCE public.site_escalade_id_seq OWNED BY public.site_escalade.id_site;

CREATE SEQUENCE public.liste_photo_site_id_liste_photo_seq;

CREATE TABLE public.liste_photo_site (
                id_liste_photo NUMERIC NOT NULL DEFAULT nextval('public.liste_photo_site_id_liste_photo_seq'),
                site NUMERIC NOT NULL,
                photo NUMERIC NOT NULL,
                CONSTRAINT liste_photo_site_pk PRIMARY KEY (id_liste_photo)
);


ALTER SEQUENCE public.liste_photo_site_id_liste_photo_seq OWNED BY public.liste_photo_site.id_liste_photo;

CREATE SEQUENCE public.secteur_id_secteur_seq;

CREATE TABLE public.secteur (
                id_secteur NUMERIC NOT NULL DEFAULT nextval('public.secteur_id_secteur_seq'),
                nom VARCHAR NOT NULL,
                id_site NUMERIC NOT NULL,
                CONSTRAINT secteur_pk PRIMARY KEY (id_secteur)
);


ALTER SEQUENCE public.secteur_id_secteur_seq OWNED BY public.secteur.id_secteur;

CREATE SEQUENCE public.voie_id_voie_seq;

CREATE TABLE public.voie (
                id_voie NUMERIC NOT NULL DEFAULT nextval('public.voie_id_voie_seq'),
                numero_de_voie VARCHAR NOT NULL,
                nom VARCHAR NOT NULL,
                cotation VARCHAR NOT NULL,
                id_secteur NUMERIC NOT NULL,
                CONSTRAINT voie_pk PRIMARY KEY (id_voie)
);


ALTER SEQUENCE public.voie_id_voie_seq OWNED BY public.voie.id_voie;

CREATE SEQUENCE public.utilisateur_id_seq;

CREATE TABLE public.Utilisateur (
                id_utilisateur NUMERIC NOT NULL DEFAULT nextval('public.utilisateur_id_seq'),
                email VARCHAR NOT NULL,
                nom VARCHAR NOT NULL,
                prenom VARCHAR NOT NULL,
                nom_utilisateur VARCHAR NOT NULL,
                mot_de_passe VARCHAR NOT NULL,
                idAdresse NUMERIC NOT NULL,
                code_role NUMERIC NOT NULL,
                CONSTRAINT utilisateur_pk PRIMARY KEY (id_utilisateur)
);


ALTER SEQUENCE public.utilisateur_id_seq OWNED BY public.Utilisateur.id_utilisateur;

CREATE SEQUENCE public.topo_id_seq;

CREATE TABLE public.topo (
                id_topo NUMERIC NOT NULL DEFAULT nextval('public.topo_id_seq'),
                nom VARCHAR NOT NULL,
                lieu VARCHAR NOT NULL,
                disponibilite BOOLEAN NOT NULL,
                date_de_parution DATE NOT NULL,
                description VARCHAR NOT NULL,
                id_utilisateur NUMERIC NOT NULL,
                CONSTRAINT topo_pk PRIMARY KEY (id_topo)
);


ALTER SEQUENCE public.topo_id_seq OWNED BY public.topo.id_topo;

CREATE SEQUENCE public.reservation_topo_id_seq;

CREATE TABLE public.reservation_topo (
                id_reservation_topo NUMERIC NOT NULL DEFAULT nextval('public.reservation_topo_id_seq'),
                demande_de_reservation BOOLEAN NOT NULL,
                date_de_reservation DATE NOT NULL,
                id_topo NUMERIC NOT NULL,
                id_utilisateur NUMERIC NOT NULL,
                CONSTRAINT reservation_topo_pk PRIMARY KEY (id_reservation_topo)
);


ALTER SEQUENCE public.reservation_topo_id_seq OWNED BY public.reservation_topo.id_reservation_topo;

CREATE SEQUENCE public.commentaire_id_commentaire_seq_1;

CREATE TABLE public.commentaire (
                id_commentaire NUMERIC NOT NULL DEFAULT nextval('public.commentaire_id_commentaire_seq_1'),
                commentaire VARCHAR NOT NULL,
                date DATE NOT NULL,
                utilisateur NUMERIC NOT NULL,
                CONSTRAINT commentaire_pk PRIMARY KEY (id_commentaire)
);


ALTER SEQUENCE public.commentaire_id_commentaire_seq_1 OWNED BY public.commentaire.id_commentaire;

CREATE SEQUENCE public.liste_commentaire_site_escalade_id_seq;

CREATE TABLE public.liste_commentaire_site_escalade (
                id_liste_commentaire NUMERIC NOT NULL DEFAULT nextval('public.liste_commentaire_site_escalade_id_seq'),
                site_escalade NUMERIC NOT NULL,
                commentaire NUMERIC NOT NULL,
                CONSTRAINT liste_commentaire_site_escalade_pk PRIMARY KEY (id_liste_commentaire)
);


ALTER SEQUENCE public.liste_commentaire_site_escalade_id_seq OWNED BY public.liste_commentaire_site_escalade.id_liste_commentaire;

ALTER TABLE public.liste_photo_site ADD CONSTRAINT url_photo_liste_photo_site_fk
FOREIGN KEY (photo)
REFERENCES public.url_photo (id_photo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.Utilisateur ADD CONSTRAINT enum_role_utilisateur_fk
FOREIGN KEY (code_role)
REFERENCES public.enum_role (code)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.adresse ADD CONSTRAINT pays_adresse_fk
FOREIGN KEY (pays_code)
REFERENCES public.pays (pays_code)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.region ADD CONSTRAINT pays_region_fk
FOREIGN KEY (pays_code)
REFERENCES public.pays (pays_code)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.adresse ADD CONSTRAINT region_adresse_fk
FOREIGN KEY (id_region)
REFERENCES public.region (id_region)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.departement ADD CONSTRAINT region_departement_fk
FOREIGN KEY (id_region)
REFERENCES public.region (id_region)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.adresse ADD CONSTRAINT departement_adresse_fk
FOREIGN KEY (id_departement)
REFERENCES public.departement (id_departement)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.Utilisateur ADD CONSTRAINT adresse_utilisateur_fk
FOREIGN KEY (idAdresse)
REFERENCES public.adresse (idAdresse)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.site_escalade ADD CONSTRAINT adresse_site_escalade_fk
FOREIGN KEY (Adresse)
REFERENCES public.adresse (idAdresse)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.site_escalade ADD CONSTRAINT orientation_site_escalade_fk
FOREIGN KEY (orientation)
REFERENCES public.orientation (abreviation)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.site_escalade ADD CONSTRAINT cotation_site_escalade_fk
FOREIGN KEY (cotation)
REFERENCES public.cotation (cotation)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.voie ADD CONSTRAINT cotation_voie_fk
FOREIGN KEY (cotation)
REFERENCES public.cotation (cotation)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.liste_commentaire_site_escalade ADD CONSTRAINT site_escalade_liste_commentaire_site_escalade_fk
FOREIGN KEY (site_escalade)
REFERENCES public.site_escalade (id_site)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.secteur ADD CONSTRAINT site_escalade_secteur_fk
FOREIGN KEY (id_site)
REFERENCES public.site_escalade (id_site)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.liste_photo_site ADD CONSTRAINT site_escalade_liste_photo_site_fk
FOREIGN KEY (site)
REFERENCES public.site_escalade (id_site)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.voie ADD CONSTRAINT secteur_voie_fk
FOREIGN KEY (id_secteur)
REFERENCES public.secteur (id_secteur)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.commentaire ADD CONSTRAINT utilisateur_commentaire_fk
FOREIGN KEY (utilisateur)
REFERENCES public.Utilisateur (id_utilisateur)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.topo ADD CONSTRAINT utilisateur_topo_fk
FOREIGN KEY (id_utilisateur)
REFERENCES public.Utilisateur (id_utilisateur)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.reservation_topo ADD CONSTRAINT utilisateur_reservation_topo_fk
FOREIGN KEY (id_utilisateur)
REFERENCES public.Utilisateur (id_utilisateur)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.reservation_topo ADD CONSTRAINT topo_reservation_topo_fk
FOREIGN KEY (id_topo)
REFERENCES public.topo (id_topo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.liste_commentaire_site_escalade ADD CONSTRAINT commentaire_liste_commentaire_site_escalade_fk
FOREIGN KEY (commentaire)
REFERENCES public.commentaire (id_commentaire)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
