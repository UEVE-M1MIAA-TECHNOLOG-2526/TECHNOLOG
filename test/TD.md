# TD Test et intégration continue

Votre équipe est chargée de développer plusieurs éléments d'un projet associé à une Pizzeria.

Créez un projet sur Github pour réaliser ce TD. Pensez à suivre un flux de travail basé sur la réalisation d'issues, de branches, de commits et de PR.

## Exercice 1 

Bien que le client sache qu'il servira des pizzas, il n'a pas encore déterminé comment elle seront définitivement définies. Pour le moment, il estime qu'une pizza doit être définie par un nom, une liste d'ingrédients et un prix. Le client estime qu'il incorporera d'autres éléments à son menu mais ne sait pas encore lesquels.

Ainsi, il vous est demandé de coder les classes `Pizza`, `CartePizzeria` et `CartePizzeriaException`. La classe `CartePizzeria` doit implémenter les méthodes suivantes :

- `is_empty()`: retourne un booléen indiquant si la carte est vide ou non

- `nb_pizzas()`: retourne le nombre de pizzas de la carte

- `add_pizza(pizza)`: ajoute une pizza à la carte

- `remove_pizza(name)`: retire la pizza nommée `name` de la carte, si celle-ci n'existe pas, lève une exception `CartePizzeriaException`.

# Exercice 2 - Créez vos tests unitaires

Réalisez les tests unitaires associés à la classe `CartePizzeria` en utilisant les mocks !

# Exercice 3 - Ajoutez de la CI à votre projet

Afin de rendre votre dépôt plus robuste, il vous est demandé de réaliser quelque modification à votre dépôt Github:

- **Protection**: désactivation du push dans la branche principale `main`

- **Intégration continue** : mise en place d'une CI avec l'exécution des tests unitaires et une mesure du niveau de couverture du code. Pour cela, vous allez utiliser le package `pytest-cov` et définir que le niveau de couverture du code est insuffisant s'il est inférieur à 80% (`pytest --cov=. --cov-fail-under=80`, cf https://pytest-cov.readthedocs.io/en/latest/config.html)

- **Robustesse** : possibilité de merge une PR si et seulement si les actions Github sont passées.

# Exercice 4 - Evolution de la carte

Le client a maintenant une meilleure vue sur ce qu'il aimerait avoir dans sa carte :

- Une pizza devra avoir un nom, un prix, une description, une séquence d'ingrédients ainsi qu'une indication sur sa base (tomate ou crème).

- Une boisson devra avoir un nom, un prix et une indication sur la présence d'alcool.

- Un déssert devra avoir un nom, un prix, une liste d'ingredients et une indication sur sa réalisation "fait maison" ou non.

Par ailleurs, il vous est demandé de retravailler la classe `CartePizzeria` pour ajouter les méthodes suivantes :

- `nb_drinks()`: retourne le nombre de boissons dans la carte

- `nb_desserts()`: retourne le nombre de désserts dans la carte

- `add(element)`: ajoute `element` à la carte si celui-ci n'est pas déjà présent, sinon déclenche une exception `CartePizzeriaException`. La présence d'un élément dans la carte suit les règles suivantes :

	- il existe déjà un élément ayant le même nom;
	- si l'élément est une pizza, celle-ci est considérée présente s'il existe une autre pizza avec les mêmes ingrédients et même base.

- `remove(name)`: retire l'élément nommé `name` dans la carte

L'apparition des méthodes `add` et `remove` vous amène à retirer les méthodes `add_pizza` et `remove_pizza`.

# Exercice 5 -  Extra

Ajoutez d'autre jobs à la CI :

- linter (niveau de propreté à votre convenance)
- typage statique (actif ou pas)
