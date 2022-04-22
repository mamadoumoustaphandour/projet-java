# Demineur-Java
L’objectif de ce mini-projet est de mettre en œuvre le jeu de Démineur en utilisant Java comme
langage de programmation.
## Description du jeu
Le but du jeu est de découvrir toutes les cases en évitant les mines cachées sous les boutons de
la grille du jeu. Un clic gauche de souris sur une case permet de la révéler. Si une mine se cachait sous celle-ci, 
la partie est perdue. Sinon, soit la case révèle un chiffre
correspondant au nombre de mines adjacentes à cette case,
soit la case est vide et dans ce cas les 8 cases adjacentes
sont découvertes et ainsi de suite pour toute case vide
rencontrée.
Un clic droit de souris sur une case permet d'y poser un
drapeau signifiant que l'on pense qu'une mine se cache
sous la case. Un second clic droit affiche un point
d'interrogation signifiant que le choix est indécis, un troisième clic droit remet la case dans son
état initial (état normal ou non-marqué). A noter qu’un clic gauche sur une case déjà marquée
d’un drapeau ou d’un point d’interrogation ne devrait avoir aucun effet.
La partie est considérée comme gagnée lorsque que toutes les cases cachant une mine ont été
marquées, ou lorsque toutes les cases non minées sont découvertes. Le joueur devra tenter
d’aboutir à ce résultat avec le moins de temps possible, un chronomètre devra ainsi être affiché
dans l’espace de jeu. De même, le nombre de mines à découvrir sera également affiché dans
l’aire de jeu. Il devra être décrémenté au fur et à mesure que des mines sont découvertes
(marquées avec un drapeau).
## Pour aller plus loin
En plus des fonctionnalités de base, vous pourrez doter l’application d’un menu permettant à
l’utilisateur de :
- Démarrer une nouvelle partie
- Choisir le niveau du jeu sachant que les trois niveaux possibles sont le niveau débutant
(grille de 9x9 avec 10 bombes), intermédiaire (grille de 16x16 avec 40 bombes) et
expert (grille de 16x30 avec 99 bombes).
- Sauvegarder ou de restaurer une partie
- Afficher les statistiques du jeu pour chaque niveau (nombre de parties jouées, gagnées
ou perdues, meilleur score)
Vous êtes libre d’ajouter toutes fonctionnalités que vous jugerez pertinentes.
