# Construction de l'image à partir du Dockerfile

:thought_balloon: Cette stack LAMP est différente de la stack static car elle permet d'utiliser un formulaire pour ajouter de nouveau volumes.

`docker build -t my_lamp .`

# Ajout de persistance

## Création du volume

`docker volume create --name mysqldata`

## Exécution de l'image avec des volumes

Le volume nommé `mysqldata` est basé sur le dossier `/var/lib/mysql` :

`docker run -d --name my_lamp_c -v mysqldata:/var/lib/mysql -p 8000:80 my_lamp`
