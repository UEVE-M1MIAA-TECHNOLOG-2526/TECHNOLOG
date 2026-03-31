# Construction de l'image à partir du Dockerfile

`docker build -t my_lamp .`

# Exécution de l'image

`docker run -d --name my_lamp_c -p 8000:80 my_lamp`

Observez l'image via http://localhost:8000/
