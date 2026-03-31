FROM debian:stable-slim

# Métadonnées de l'image
LABEL version="1.0" maintainer="Firstname Lastname <Firstname.Lastname@mymail.com>"


# Variables temporaire (limitées au build de l'image)
ARG APT_FLAGS="-q -y"
ARG DOCUMENTROOT="/var/www/html"

# Couche Apache (télécharge la liste des paquets et installe Apache)
RUN apt-get update -y && \
    apt-get install ${APT_FLAGS} apache2


# Couche Php (installe interpréteur php et module php-mysql, supprime le fichier index.html d'Apache)
RUN apt-get install ${APT_FLAGS} \
    php-mysql \
    php && \
    rm -f ${DOCUMENTROOT}/index.html

COPY app ${DOCUMENTROOT}


# Couche MySQL (installe service mysql et ajoute le fichier articles.sql)
RUN apt-get install ${APT_FLAGS} mariadb-server

COPY db/articles.sql /


# Ouverture du port http
EXPOSE 80


# Définition du répertoire de travail
WORKDIR  ${DOCUMENTROOT}


# Démarrage des service à l'exécution de l'image (démarre mysql et construit l'architecture de la BD grâce au fichier article.sql)
# Note : pour éviter la fermeture automatique du conteneur, lancement du service Apache en premier plan)
ENTRYPOINT /etc/init.d/mariadb start && mysql < /articles.sql && apache2ctl -DFOREGROUND
