
# Build l'image

Déplacez vous dans le répertoire courant et construisez l'image `docker build -t vtest .`

# Création et montage du volume data-test dans le répertoire /data du conteneur

`docker run -ti --name vtest_c -v data-test:/data vtest`

# Surveillance en temps réel du contenu du volume

Ouverture du répertoire `Mountpoint` inspecté précédemment (dans mon cas c'était /var/lib/docker/volumes/data-test/_data)

Dans le terminal avec le shell du conteneur : créez un fichier 'test.txt' avec le contenu 'ecriture dans un volume'

`echo "ceci est un test" > test.txt`

# Quittez le conteneur et supprimez le

`docker rm -f vtest_c`

# Créez un nouveau conteneur pour vérifier que les données sont bien sauvegardées

`docker run -ti --name vtest_c -v data-test:/data vtest`

# Vérifiez le contenu du fichier 

`cat test.txt`
