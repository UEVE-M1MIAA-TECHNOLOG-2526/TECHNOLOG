# Construction de l'image à partir du Dockerfile

:thought_balloon: Cette stack LAMP est différente de la stack static car elle permet d'utiliser un formulaire pour ajouter de nouveau volumes.

`docker build -t my_lamp .`

# Exécution de l'image

`docker run -d --name my_lamp_c -p 8000:80 my_lamp`

Observez l'image via http://localhost:8000/
