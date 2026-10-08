## Captures des résultats

### 1. Résultat des tests JUnit
Les quatre tests passent, y compris la recherche des utilisateurs par nom.

<img width="1807" height="1012" alt="01-tests-junit" src="docs/images/01-tests-junit.png" />

### 2. Création des tables et insertion
Hibernate crée les tables `Salle` et `Utilisateur` dans la base H2.

<img width="1842" height="1022" alt="02-creation-tables" src="docs/images/02-creation-tables.png" />

### 3. Affichage de la salle enregistrée
Le programme enregistre la salle puis l’affiche après l’avoir lue depuis la base.

<img width="1835" height="1035" alt="03-insertion-et-affichage" src="docs/images/03-insertion-et-affichage.png" />

### 4. Recherche de l’utilisateur
Le programme retrouve l’utilisateur associé à « Salle Démo » et se termine sans erreur.

<img width="1817" height="992" alt="04-recherche-et-fin" src="docs/images/04-recherche-et-fin.png" />
