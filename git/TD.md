# TD_GIT
TD sur la pratique de Git et Github

L'idée est d'implémenter plusieurs actions que l'on pourrait retrouver dans un RPG.
Celles-ci seront réalisées au travers d'une classe `Game` et votre objectif final sera de rendre votre jeu accessible au travers d'une CLI.

# Exercice 1

Par binôme / trinôme, **un seul** étudiant devra créer un nouveau projet sous son namespace. Ce sera votre référentiel principal pour le TD.

Contribuez séparément à ce projet en ajoutant les classes des unités de base du jeu (cf [#1](/../../issues/1), [#2](/../../issues/2), [#3](/../../issues/3), [#4](/../../issues/4), [#5](/../../issues/5), [#6](/../../issues/6)).

Pour cela vous allez devoir:
  - ouvrir une issue dans votre projet;
  - créer une branche dédiée à l'implémentation de chaque issue dans votre clône;
  - implémenter la classe dans votre branche;
  - push votre branche dans votre projet;
  - faire une pull request avec demande de relecture de code d'un autre membre du binôme / trinôme avant merge;
  - merge et fermeture de la PR et de l'issue.

# Exercice 2

Implémentation des classes d'équipe (cf [#7](/../../issues/7), [#9](/../../issues/9) et [#10](/../../issues/10)) avec, si souhaité, l'implémentation de [#8](/../../issues/8).

# Exercice 3

Implémentation du "coeur" du jeu avec les classes Game et Loses. Voir [#11](/../../issues/11) et [#12](/../../issues/12)

##

**Liste des actions (méthode) associées à la partie (classe `Game`)  ainsi que leurs explications explication**

* config : permet au joueur de configurer sa partie

    - demande le nom du joueur et modifie les données de la partie

##

* start : permet au joueur de recommencer une partie

    - lancer une partie remet la partie à zéro :
        * le nom du joueur est conservé
        * le contexte d'action du joueur et réinitialisé ("mouvement")
        * le butin du joueur est réinitialisé à 40
        * l'équipe du joueur est vide

##

* status : affiche l'état de la partie

    - si le joueur a perdu : affiche gamer over
    - sinon affiche :
        * le nom du joueur
        * la valeur courante du butin 
        * l'équipe du joueur (nombre de guerriers, chasseurs et magiciens)
        * affiche les actions possibles du joueur:
            * si contexte "mouvement" alors possibilité d'acheter ou de se déplacer
            * si contexte "combat" alors possibilité de se battre ou de s'enfuir

##

* buy UNIT : permet au joueur d'acheter une unité 

    - un achat peut être réalisé uniquement hors combat

##

* move DIRECTION : permet au joueur de se déplacer dans une certaine direction
    
    - un déplacement peut être réalisé uniquement hors combat
    - un déplacement débouche sur l'une des situations suivantes :
        * découverte d'un butin avec une probabilité de min(0.2, (chance de l'équipe du joeur / 5) / 100)
        * découverte de soldats errants avec une probabilité de min(0.1, (chance de l'équipe du joeur / 10) / 100)
        * découverte d'une équipe ennemi avec une probabilité de min(0.2, (chance de l'équipe du joeur / 4) / 100)
        * découverte d'un lieu sûr avec une probabilité de 1 - la somme des probabilités des autres événements

##

* fight : permet au joueur de se battre contre l'équipe adverse

    - se battre n'est possible qu'en cas de contexte "combat"
    - le combat est remporté si le score de dégat du joueur est supérieur à celui de l'équipe adverse
    - si le combat est gagné, aucune perte n'est à déplorer, sinon c'est "game over"

##

* flee : permet au joueur de s'enfuir

    - s'enfuir n'est possible qu'en cas de contexte "combat"
    - lors d'une fuite, chaque unité peut mourir:
        * chance de mourir d'une unité : 1 / score de fuite

##

**Note** : 
Etant donné que vos actions doivent influer sur la partie et vos actions future, vous devrez stocker l'état courant de votre partie.
Dans un premier temps, vous pouvez faire cela dans une classe dédiée mais à terme, il faurait stocker ces informations dans un fichier.
Vous êtes libre de choisir comment faire mais je vous recommande d'utiliser le format `json`.

Les informations a stocker sont les suivantes :

  - le nom du joueur
  - le contexte d'action en cours ("combat" ou "mouvement")
  - le butin du joueur
  - l'équipe du joueur (composée de guerriers, chasseurs et magiciens)

# Exercice 4

Implémentation de nouvelles fonctionnalités, cf [#13](/../../issues/13) ... [#22](/../../issues/22)

# NOTE

Afin de vous faciliter la vie pour "importer" les issues du projet d'origine dans votre projet, vous pouvez utiliser
le package python `pygithub` (https://github.com/PyGithub/PyGithub). Le code suivant, **une fois adapté** (github access token
et `full_name` de votre projet), vous permettra de créer lesdites issues.

```python
from dataclasses import dataclass
from github import Github
from time import sleep


@dataclass
class GithubIssue:
    title: str
    body: str


# Votre depot d'origine
REPO_ORIGIN = "UEVE-TECHNOLOG-2023-2024/Technolog"
# Votre depot cible
REPO_TARGET = ""
# Votre access token
TOKEN = ""

g = Github(TOKEN)

repos = g.get_user().get_repos()
repo_target = next(filter(lambda repo: repo.full_name == REPO_TARGET, repos))
repo_origin = next(filter(lambda repo: repo.full_name == REPO_ORIGIN, repos))
issues_taget_title = [issue.title for issue in repo_target.get_issues()]

issues_origin = repo_origin.get_issues()
issues_origin = sorted(issues_origin, key=lambda issue: issue.number)

# Creation des issues a partir du depot d'origine.
for issue in issues_origin:
    # Test si l'issue existe deja (en cas d'erreur lors de la creation d'une issue)
    if issue.title in issues_taget_title:
        continue
    if issue.number > 22:
        break
    repo_target.create_issue(issue.title, issue.body)
    print(f"Issue {issue.title} created.")
    sleep(0.1)
```


