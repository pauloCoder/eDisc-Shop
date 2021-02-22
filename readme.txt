Projet de conception d'un site Web de E-commerce
------------------------------------------------

*** But du projet : 
    -------------
Le but de ce projet est de concevoir un site Web de e-commerce. Le site permettra à 
l'utilisateur (client) de parcourir un catalogue de produits, d'en sélectionner 
certains qu'il pourra rajouter. Il pourra entre autres visualiser son panier, 
le modifier (ajout ou retrait) de produit(s) et de passer sa(ses) commande(s) 
après avoir créé son compte client ou s'être connecté s'il est déja inscrit.
Un client déja inscrit se connecter afin de visualiser les commandes qu'il a déja passé.
NB : plus de détails dans le fichier "Enoncé du projet.pdf"

*** Les étapes du projet : 
    --------------------
On réalisera une implémentation et une simulation via la console du projet avant de 
passer au développement web ("Dynamic Web project")

	** Implémentation console (Réalisées) :
	   ----------------------------------
	- Développement des différentes classes 'métier' nécessaire (Exemple : classe
	  produit permettant de créer un produit définit par son nom, son prix, son stock,
	  sa description. Une classe commande permettant de passer une commande définie par
	  son numéro de commande, la date de commande et les détails de la commande qui
	  sont les différentes données sur les produits de la commande...)

	- Simulation en console d'une commande effectuée par un client qui va parcourir le catalogue
	  et ajouter des produits à son panier. L'achat n'étant pas encore effectué, le produit est 
	  'virtuellement retiré du stock' pour s'assurer que le client n'ait pas plus de produits
	  qu'il n'en existe dans son panier. Les stocks sont effectivement mis à jour une fois
	  la commande passée par le client.
	
	- Conception d'une facade fournissant une interface simplifiée du fonctionnement des composants
	  métiers. Cette interface (IFacade) regroupe l'ensemble des fonctionnalités necessaires à
	  faire fonctionner l'application et permet d'éviter de connaître en profondeur la façon dont
	  les composants métiers sont liés entre eux.
	
	- Réalisation de quelques tests unitaires (Consulter le fichier "Docs tests unitaires JUnit.txt")  
	  
	  Plus d'infos : voir diagramme UML (UML.PNG) pour les différentes classes existantes 
	  ainsi que les connexions existantes entre celles-ci et le fichier "Etapes codage.txt"
	  pour une explication plus détaillée du développement de l'application en console

	=> Fin de l'implémentation en mode console. Pour la suite du projet, on se réferera au fichier
	   eCommerceWebsite


