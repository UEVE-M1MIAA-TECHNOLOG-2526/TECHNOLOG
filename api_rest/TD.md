L'objectif de cd TD est de vous donner une introduction aux API Rest. Vous ne traiterez pas l'asynchronisme ni les aspects liés à la sécurité / authentification / autorisation.

# Exercice 1 - Service de santé

Créez un modèle `Patient` qui sera utilisé pour stocker des données de santé associées à un patient. Les informations à stocker pour chaque patient sont: le nom, le prénom et le numéro de sécurité social (aussi noté *ssn*). Le numéro renseigné doit pouvoir être décrypté de la manière suivante:
- le premier chiffre vaut 1 si c'est un homme, 2 si c'est une femme;
- le deuxième et troisième chiffre renseignent l'année de naissance;
- le quatrième et cinquième chiffre indiquent le mois de naissance;
- le sixième et septième chiffre indiquent le département de naissance;
- les chiffres huit à dix représentent l'identifiant du pays de naissance;
- les chiffres onze à treize indiquent l'indice de naissance;
- les deux derniers chiffres représentent une clef de contrôle, i.e. complément à 97 du nombre formé par les treizes premiers chiffres du *ssn* modulo 97. 

Réalisez une API Rest (avec `fastapi`) permettant d'accéder à des données stockées sur un fichier JSON et fournissant les points de terminaison suivants:

- [GET] patients
- [POST] patients
- [GET] patients/ssn
- [DELETE] patients/ssn
- [UPDATE] patients/ssn
- [POST] patients/ssn

Dans le cas de l'endpoint `[POST] patients/ssn`, assurez vous qu'une `HTTPException` soit retournée lorsqu'un patient avec le même *ssn* est déjà enregistré.

Voici typiquement quelques appels utilisant le package `json` en python :

```python
import json

def read_json(json_path):
  with open(json_path, "r") as f:
    return json.loads(f.read())

def write_json(json_path, data):
  with open(json_path, "w") as f:
    json.dump(data, f, indent=4)
```

**Indications** : vous utiliserez deux conteneurs, le premier initialisera le fichier JSON, le second exposera l'API Rest sur le port 3000. Utilisez un volume partagé entre les deux contenurs. Il est attendu que votre modèle soit défini dans un fichier `model_patient.py`, que votre application RestAPI soit définie dans un fichier `app.py`.

**Note** : utilisez des `validator` pour vous assurer que le *ssn* est valide (https://pydantic-docs.helpmanual.io/usage/validators/).

# Exercice 2 - Paramétrisation

Retravaillez l'endpoint `[GET] patients/ssn` pour qu'il affiche plus d'informations. Celui-ci devra permettre d'afficher (si spécifié) les informations suivantes :

- le sexe;
- l'année de naissance;
- le moi de naissance;
- le département de naissance;
- le numéro insee;
- l'identifiant d'enregistrement.

Etendez l'endpoint `[POST] patients` pour que celui-ci n'accepte que des patients né dans en Essonne (91).

# Exercice 3 - Livraison

Rédigez un docker compose permettant de lancer le tout.

# Exercice 4 - Développement application cliente GUI 

Développer une application graphique qui communique avec une API REST pour manipuler un fichier JSON partagé entre conteneurs Docker. L'application permet de lire, modifier et résumer ces données via une interface utilisateur. Pour cela vous pouvez utiliser `Tkinter`.

```python
import tkinter as tk

class Application(tk.Tk):
    def __init__(self):
        super().__init__()
        self.title("Application Cliente")
        self.geometry("400x300")

        # Show results
        self.output = tk.Text(self, height=10, width=40)
        self.output.pack(pady=10)

        # Action buttons
        button_frame = tk.Frame(self)
        button_frame.pack()

        tk.Button(button_frame, text="Read", command=self.read_data).grid(row=0, column=0, padx=5)
        tk.Button(button_frame, text="Add", command=self.add_value).grid(row=0, column=1, padx=5)
        tk.Button(button_frame, text="Update", command=self.update_value).grid(row=0, column=2, padx=5)

        # Initialize data
        self.values = []
        self.read_data()

    def read_data(self):
        """Read through GET"""
        pass

    def add_value(self):
        """Add through POST"""
        pass

    def update_value(self):
        """Update through PATCH"""
        pass

if __name__ == "__main__":
    app = Application()
    app.mainloop()
```
