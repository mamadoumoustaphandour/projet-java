# Demineur-Java 

Ceci est un jeu de d�mineur . Il est principalement cod� en Java.

Le code source est distribu� librement.

L�objectif de ce mini-projet est de mettre en �uvre le jeu de D�mineur en utilisant Java comme langage de programmation.
##  Description du jeu
Le but du jeu est de d�couvrir toutes les cases en �vitant les mines cach�es sous les boutons de la grille du jeu. Un clic gauche de souris sur une case permet de la r�v�ler. Si une mine se cachait sous celle-ci, la partie est perdue. Sinon, soit la case r�v�le un chiffre correspondant au nombre de mines adjacentes � cette case, soit la case est vide et dans ce cas les 8 cases adjacentes sont d�couvertes et ainsi de suite pour toute case vide rencontr�e.
Un clic droit de souris sur une case permet d'y poser un drapeau signifiant que l'on pense qu'une mine se cache sous la case. Un second clic droit affiche un point
d'interrogation signifiant que le choix est ind�cis, un troisi�me clic droit remet la case dans son �tat initial (�tat normal ou non-marqu�). A noter qu�un clic gauche sur une case d�j� marqu�e d�un drapeau ou d�un point d�interrogation ne devrait avoir aucun effet.
La partie est consid�r�e comme gagn�e lorsque que toutes les cases cachant une mine ont �t� marqu�es, ou lorsque toutes les cases non min�es sont d�couvertes. Le joueur devra tenter d�aboutir � ce r�sultat avec le moins de temps possible, un chronom�tre devra ainsi �tre affich� dans l�espace de jeu. De m�me, le nombre de mines � d�couvrir sera �galement affich� dans l�aire de jeu. Il devra �tre d�cr�ment� au fur et � mesure que des mines sont d�couvertes (marqu�es avec un drapeau).
##  Pour aller plus loin 
En plus des fonctionnalit�s de base, vous pourrez doter l�application d�un menu permettant � l�utilisateur de :
- D�marrer une nouvelle partie
- Choisir le niveau du jeu sachant que les trois niveaux possibles sont le niveau d�butant (grille de 9x9 avec 10 bombes), interm�diaire (grille de 16x16 avec 40 bombes) et expert (grille de 16x30 avec 99 bombes).
- Sauvegarder ou de restaurer une partie
- Afficher les statistiques du jeu pour chaque niveau (nombre de parties jou�es, gagn�es
ou perdues, meilleur score)
Vous �tes libre d�ajouter toutes fonctionnalit�s que vous jugerez pertinentes.
