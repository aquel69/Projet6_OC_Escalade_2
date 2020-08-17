# PROJET SITE ESCALADE  
## I - Mise en place du projet sous Interllij IDEA  

---

Avant de démarrer le projet j'ai installé __Apache Tomcat__ dans sa version 9.0.31 pour la gestion de la partie serveur du projet et __Java jdk__
dans sa version 1.8.0_241 pour la partie développement.

J'ai ensuite due configurer sous mon ide la partie serveur. Je vais vous expliquer, pas à pas les différentes étapes :  
  
---
### 1 - Création du nouveau projet  

---

- ( File -> New -> Project) : 

![photo 1 création du projet](Documentation/Screenshots/creationDuProjet1.png "creation projet 1")  

- cocher la case si l'on souhaite intégrer le JavaEE Web Module :  

![photo 2 création du projet](Documentation/Screenshots/creationDuProjet2.png "creation projet 2")  

- mettre un nom au projet, son emplacement et sélectionner le serveur :  

![photo 3 création du projet](Documentation/Screenshots/creationDuProjet3.png "creation projet 3")  
  
---  
### 2 - Configuration du Projet Structure  

---
- ( File -> Projet Structure ) puis dans l'onglet _Project_ nous sélectionnons la version de Java que l'on souhaite.   

![photo 1 configuration du projet](Documentation/Screenshots/ProjectStructure1.png "Project Structure 1")  

- Ensuite vérifier que l'onglet _Module_ corresponde au screenshot suivant :  

![photo 2 configuration du projet](Documentation/Screenshots/ProjectStructure2.png "Project Structure 2")  

- Puis dans l'onglet __Librairies__ nous ajoutons la librairie de tomcat, pour cela nous cliquons sur le '+' et choisissons 'java'. 
Ensuite nous allons chercher le dossier 'tomcat' puis 'lib' dans le répertoire et faisons 'apply' :    

![photo 3 configuration du projet](Documentation/Screenshots/ProjectStructure3.png "Project Structure 3")

- Dans l'onglet _Facet_, nous vérifions qu'il corresponde à ceci :  

![photo 4 configuration du projet](Documentation/Screenshots/ProjectStructure4.png "Project Structure 4")  

- Dans l'onglet artifact, retirer à l'aide du '-' l'artifact en place et cliquer sur le '+' pour ajouter une nouvelle 'Web Application Exploded.
S'assurer que les fichiers présents sur le screenshot sont en place.  

![photo 5 configuration du projet](Documentation/Screenshots/ProjectStructure5.png "Project Structure 5")  
  
---  
  
### 3 - Configuration du Serveur

---
- Pour configurer le serveur, rendons-nous d'abord dans 'Edit configuration', en cliquant sur la petite flèche, située à coté du nom de notre serveur dans la barre des icones de notre IDE.
Ensuite nous modifions le 'build' en bas de l'écran, en l'ajoutant, et en choisissant l'artifact que nous venons de créer.
Il ne nous reste plus qu'a modifié les updates comme sur le screenshot.

![photo 1 configuration du serveur](Documentation/Screenshots/ConfigServeur1.png "Config serveur 1")  

- Il ne reste plus qu'à lancer le serveur avec la flèche verte dans la barre d'icone. Si celui-ci fonctionne une page web blanche devrait apparaitre.
---
##II - Conception du Projet  

---
### 1 - Mise en place du projet

---
J'ai tout d'abord créé un repository sous GitHub à l'adresse suivante https://github.com/aquel69/Projet6_OC_Escalade.  
Ensuite j 'ai commencé par élaborer le projet en plusieurs étapes : 
 - Conception et mise place du projet sous Intellij.
 - Mise en place d'un projet multi-couches à l'aide de maven.  
  
![photo 1 project mutli-couches Maven](Documentation/Screenshots/ProjectMavenMulti-couches.png "project mutli-couches Maven")  
  
---

### 2 - Début du projet  

---  
 - J'ai débuté le projet par la conception de l'arborescence du site web.  

![photo 1 arborescence du site web](Documentation/Screenshots/arborescenceDuSite.png "arborescence du site web")  

 - J'ai ensuite conçu les différentes Wireframes qui m'ont permis de savoir de quoi j'allais avoir besoin pour les différentes étapes de la conception.  
 Je me suis servi des logiciels visio et paint.net pour les élaborer.  
 
![photo 1 Wireframe](Documentation/Screenshots/escalade-accueil.jpg "Wireframe")  

 - À partir de mes wireframes, je pouvais commencer à élaborer mon diagramme de classe. J'ai donc coder mes beans représentant mes différentes classes dans la couche escalade-model.  
 
![photo 1 bean](Documentation/Screenshots/CreationDesBeans.png "bean")  
  
---
### 3 - Conception Diagramme de classe / Base de Données

---  

 - Pour ensuite générer le diagramme de classe, à partir de mes beans.  
 
 ![photo 1 Diagramme de Classe](Documentation/Screenshots/Diagramme_de_classe.png "Diagramme de Classe")  
 
 - Je peux alors créer la base de données à l'aide du logiciel Power Architect  
 
![photo 1 Base de données](Documentation/Screenshots/BDDEscalade.png "Base de données")  
  
 - Création de la structure de la base de données sous pgadmin 4  
 
![photo 1 Structure Base de données](Documentation/Screenshots/structureBDD.png "StructureBase de données")  

 - Alimentation de la base de données sous pgadmin 4
 
![photo 1 Data Base de données](Documentation/Screenshots/dataBDD.png "Data de données")   

La base de données est opérationnel.
  
---
### 4 - Mise en place du projet multi-couche à l'aide de Maven

---

 - Création du projet Maven OC-escalade sous intellij, mise en place des différentes couches  
    - couche webapp
    - couche business
    - couche consumer
    - couche model
    - couche technical  
 
![photo 1 Couche du projet](Documentation/Screenshots/projetCouche.png "Couche du projet")  

 - Ajouts des librairies à l'aide de Maven et du frameworks Spring  
 
![photo 1 Librairie du projet](Documentation/Screenshots/AjoutLibrairie.png "Librairie du projet") 

 - Mise en place des différents fichiers 'pom.xml' pour la gestion des libraires dans les différentes couches
 
![photo 1 Fichier pom.xml](Documentation/Screenshots/PomMaven.png "Fichier pom.xml")   

 - Ajouts des fichiers qui vont permettre au différentes couches de pouvoir communiquer, selon les principes de bases de l'acronyme SOLID :
    - S Responsabilité unique (Single responsibility principle) : une classe, une fonction ou une méthode doit avoir une et une seule responsabilité  
    - O Ouvert/fermé (Open/closed principle) : une entité applicative (class, fonction, module ...) doit être ouverte à l'extension, mais fermée à la modification  
    - L Substitution de Liskov (Liskov substitution principle) : une instance de type T doit pouvoir être remplacée par une instance de type G, tel que G sous-type de T, sans que cela ne modifie la cohérence du programme
    - I Ségrégation des interfaces (Interface segregation principle) : préférer plusieurs interfaces spécifiques pour chaque client plutôt qu'une seule interface générale  
    - D Inversion des dépendances (Dependency inversion principle) : il faut dépendre des abstractions, pas des implémentations  

![photo 1 Fichier context.xml](Documentation/Screenshots/ContextCommunicationCouche.png "Fichier context.xml")  

 - Ajouts des fichiers permettant l'accès à la base données et l'envoi de requête SQL 
 
![photo 1 Fichier BDD](Documentation/Screenshots/FichierBDD.png "Fichier BDD")   

 - Ajouts des @Named et @Inject du framework 'Spring' permettant d'instancier et d'ajouter les classes dans le context Spring, permettant ensuite de les injecter où on le souhaite
 
![photo 1 Fichier Spring](Documentation/Screenshots/SpringNameInject.png "Fichier Spring")     




