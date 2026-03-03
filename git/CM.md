---
marp: false
theme: gaia
paginate: true
style: |
  .columns {
    display: grid;
    grid-template-columns: repeat(2, minmax(0, 1fr));
    gap: 1rem;
  }
---

<!--
#header: Technologie Logiciel
footer: Technologies Logicielles | :e-mail: sebastien.morais@proton.me
-->

<style>
  @keyframes point-up {
    from { background-position: 50px 50px; }
    to { background-position: 50px 70px; }
  }
  @keyframes point-down {
    from { background-position: left 50px bottom 50px; }
    to { background-position: left 50px bottom 70px; }
  }
  section {
    animation: 0.5s ease-in-out alternate infinite point-up;
    #background: #fff url('https://icongr.am/feather/arrow-up.svg?color=0288d1') no-repeat 50px 50px / 80px;
    font-size: 30px;
  }
  section::before {
    content: '';
    display: block;
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    pointer-events: none;
    animation: 0.5s ease-in-out alternate infinite point-down;
    #background: transparent url('https://icongr.am/feather/arrow-down.svg?color=0288d1') no-repeat left 50px bottom 50px / 80px;
  }
  @media (prefers-reduced-motion) {
    section, section::before {
      animation: none;
    }
  }
</style>

# Bibliographie et inspirations 
<br/>

- Scott Chacon : https://git-scm.com (graphes et méthodologies)

- Référence en ligne : http://gitref.org

- Git Pocket Guide par Richard Silverman

- Man gittutorial (https://git-scm.com/docs/gittutorial)

- Cheat Sheets (aide-mémoire) :
    - https://www.atlassian.com/git/tutorials/atlassian-git-cheatsheet
    -  http://ndpsoftware.com/git-cheatsheet.html#loc=local_repo;

- Internet ...

 ---

# Les enjeux du développement

- Le travail en équipe:
    - accès aux développements des autres
    - partage de l’information sur le développement

- L’historisation du travail
    - voir les dernières modifications du projet (sur un certain référentiel)
    - remonter dans le temps et voir les modifications antérieures
    - voir les différences entre les modifications
    - comprendre pourquoi certaines modifications ont été réalisées
:thought_balloon: Besoin de répondre aux question : qui ? quand ? quoi ? pourquoi ?

- La diffusion du code

---

</br>

</br>

:question: Comment avez-vous échanger du code jusqu'à maintenant ?

---

</br>

</br>

:question: Comment avez-vous échanger du code jusqu'à maintenant ?

</br>

Solution possible: les systèmes de contrôle de version ! 

---

# RCS

<div class="columns">
<div> 

- Opère sur des fichiers uniques
- Introduction d'un nouveau fichier d’extension « ,v » contenant des métadonnées
- :white_check_mark: Sauvegarde des révisions ne dépend pas d’un dépôt central
- :x: L’historique des révisions peut être modifié par un utilisateur
- :x: Un seul utilisateur peut travailler sur un fichier à la fois

</div>
<div>

![w:450 h:520](img/RCS.jpeg)

</div>
</div>

---

# SVN

<div class="columns">
<div>

- Système centralisé : stockage du code et métadonnées sur un serveur

- :white_check_mark: Enregistrement des modifications par *delta differencing*

- :x: Pas pratique pour le travail *hors ligne* (des enregistrement en un)

- :x: Surcoût lié au réseau

- :x: Empêche l'enregistrement de modifications local sans partager

</div>
<div>

![w:450 h:520](img/SVN.jpeg)

</div>
</div>

---

# Git

<div class="columns">
<div>

- Système distribué né pour gérer les sources de Linux
- :white_check_mark: Actions extrêmement rapide
    - Nécessite l’accès au disque dure
    - N’utilise le réseau que pour publier / télécharger
- :white_check_mark: Permet le développement local
:thought_balloon: Limite la casse en cas de mauvaise manipulation
- :x: Any ? 

</div>
<div>

![w:450 h:520](img/GIT.jpeg)

</div>
</div>

---

# Git

</br>

- Gestion des binaires larges (solution `git-lfs`)

</br>

- Dans le cas de projet à historique long, le téléchargement peut prendre beaucoup de temps et de place

---

# Installation de Git !

- Installation : https://git-scm.com/book/fr/v2/D%C3%A9marrage-rapide-Installation-de-Git

Une fois installé, configurez le en:

- vous créant une identité (avec vos infos):
    - `git config –-global user.name 'Morais Sébastien'`
    - `git config –-global user.email 'sebastien.morais@univ-evry.fr'`

- choisissant votre éditeur de texte:
    - `git config core.editor notepad`
    :thought_balloon: Si vous utilisez un IDE récent, l'édition peut être réalisée par le biais de celui-ci, e.g. Visual Studio Code.

---

# Fondamentaux

![w:1100 h:500](img/Fondamentaux_0.jpeg)

---

# Fondamentaux

- **Index** (*staging area*) : zone de stockage des instantanés (*snapshots*) à inclure dans la version

- **Commit** : enregistrement d'une version regroupant les *snapshots* placés dans l'index

![w:1100 h:300](img/staging.png)

---

# Premier projet sous git

**Repository** (dépôt) : base de données où les modifications sont stockées et à partir de laquelle les modifications sont publiées

- `git init` : initialise un dépôt Git utilisable en local 
</br>

- `git init --bare` : initialiser un dépôt Git sur un serveur
:thought_balloon: dépôt "installation de stockage" et pas un environnement de développement
</br>

- `git clone` : clone un dépôt déjà existant dans un nouveau répertoire

---

# Gestion des fichiers

- **Tracked** : au moins un enregistrement associé au ficier exite

![w:1100 h:400](img/Fondamentaux_1.jpeg)

---

# Gestion des fichiers

:question: Quelle séance d'actions a permis d'arriver à cet état ?

![w:1100 h:400](img/status.jpg)

----

# Transition d'états

- Ajout d’un fichier dans l’index `git add README`

- Consultation du status des fichiers du dépôt `git status`

- Consultation des modifications depuis le dernier enregistrement `git diff`

- Création d'un enregistrement à partir des modifications dans l’index `git commit -m ‘Nouveau README’`

- Annulation des modifications depuis le dernier enregistrement `git checkout README`

---

# Transition d'états

- Retrait d'un fichier de l’index `git reset README` / suppression d'un enregistrement `git reset shaDuCommit`

- Annulation d'un enregistrement (ajout du négatif)
`git revert myshas238e`

- Stockage temporaire des modifications `git stash`

---

# Organisation du travail

- Chaque enregistrement est lié à son (ses) parent(s)

- Une **branche** est un pointeur vers un enregistrement

- Le pointeur d'une branche avance automatiquement et référence toujours le dernier commit réalisé

![w:1100 h:200](img/branche_focus.jpeg)

---

# Organisation du travail

- Visualation de la branche courante `git branch (-vv)`

- Création d'une branche `git branch feature/remove_group`

- Fusion d'une branche `git merge feature/remove_group`

- Suppression d'une branche `git branch -d feature/remove_group`

- Changement de branche :
    - `git checkout autre-branche`
    - `git switch autre-branche` (requiert Git récent)

---

# Organisation du travail

- Copie d'un enregistrement d’une autre branche `git cherry-pick shaDuCommit` (-x)

- Notes :
    - référence spéciale : `HEAD` (la tête de la copie de travail)
    - lorsque `HEAD` bouge (checkout), les fichiers sont modifiés
    - en général, pointeur sur le dernier commit de la branche courante.

:thought_balloon: La manière d’utiliser les branches dépend de la gestion de projet !

---

# Organisation du travail

![w:1100 h:500](img/branches.png)

---

# Collaboration

<div class="columns">
<div>

- Concept de *remotes*
</br>

- Pointeurs sur des dépôts distants
</br>

![w:550 h:175 blabla](img/remote.jpeg)

</div>
<div>

![w:450 h:520](img/GIT.jpeg)

</div>
</div>

---

# Collaboration

<div class="columns">
<div>

![w:550 h:520](img/push_pull.png)

</div>
<div>

- Récupération des modifications du remote `git fetch origin`

- Publication du travail local sur le dépôt distant `git push origin master`

- Récupération des modifications du remote et mise à jour de sa branche `git pull origin master`

- Mise à jour de sa branche avec une branche distance `git merge origin/master`

</div>
</div>

---

# Quelques outils

<div class="columns">
<div>

- Diff : meld, kompare, tkdiff

- Merge : kdiff3, p4merge, diffMerge

- Log : gitk, gitg, tig

- Edition : git-gui, gitkraken
:thought_balloon: https://git-scm.com/download/gui 

</div>
<div>

![w:450 h:260](img/gitk.jpeg)
![w:450 h:260](img/gitgui.jpeg)

</div>
</div>

:thought_balloon: Certains utilitaires peuvent être intégrés dans votre IDE

---

# Gérer un conflit

- L’action de *merge* peut poser problème
:thought_balloon: Modification de la même portion d’un code sur deux branches différentes

- Git édite le fichier pour y formater les extraits en conflit

![w:1100 h:320](img/conflit.png)

---

# Nous n'avons presque rien vu

- `git archive` : génération d’archives à partir de n’importe quelle référence

- `git bisect` : recherche d’un commit fautif de manière automatisée

- `git format-patch/am` : import/export de commits sous forme de texte (diff)

- `git grep` : plus fort et plus puissant que grep sur dépôt Git

Et plein d’autres ...

---

# Plateformes collaborative

Les forges ou source hubs ne sont pas nécessaire pour héberger votre projet MAIS elles ont plusieurs avantages :
- conçu pour accueillir les utilisateurs les plus novices 
- renforce la visibilité de votre projet
- facilite la contribution de tiers
- outils de collaborations : gestionnaire de bogue, wiki, CI, PR, permissions, ...
- retire la « complexité » de la gestion de l’hébergement 

:thought_balloon: Github, Gitlab, Sourcehut, SourceForge, ...
Pour la suite, créer un compte sur **Github** (tour du proprio)

---

# Apprendre à utiliser les branches

Réalisez les exercices sur LearnGitBranching
:thought_balloon: Comprendre Git à travers la visualisation

https://learngitbranching.js.org/


