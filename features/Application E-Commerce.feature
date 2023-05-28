#tester les fonctionnalites suicantes:
#creation d un compte et s abonner a newsletter 
#valider il n'accepter pas les compte doublant
#reinialiser le mot de passe 
#effecuter des rechercehe des produits
#informer le client le peroduit il n est pas disponible 
Feature: application E-Commerce

@tag1
Scenario:creation compte et s abonne
	Given seconnecter a la page d accueil
	When L utilisateur  s inscrire dans l application 
	Then valider l inscription
@tag2
Scenario: l utilisateur peut s inscrire a l application en optant pour l abonnement à la Newsletter
	Given seconnecter a la page d accueil
	When connecter dans le compte existant abonne a newsletter 
	Then valider l abonnement a newsletter
	
@tag3
Scenario: l application ne prender des comptes en double 
	Given seconnecter a la page d accueil
	When L utilisateur  s inscrire dans l application 
	Then valider que l application n accepte pas compte doublant
	
@tag4
Scenario: utilisateur  se connecter avec des informations d identification valides
	Given seconnecter a la page d accueil
	When L utilisateur connecter a son compte  
	Then valider que l application naccede a son compte
	
@tag5
Scenario: utilisateur est en mesure de reinitialiser le mot de passe oublie
	Given seconnecter a la page d accueil
	When reinitailiser mot de passe oublie  
	Then valider que l application naccede a son compte
	
@tag6
Scenario: l utilisateur est en mesure de rechercher des produits
	Given seconnecter a la page d accueil
	When effctuer une recherche sur un produit 'samsung'
	Then valider le resulta de recherche 0
	
@tag7
Scenario: Utilisateur est informe lorsque le produit recherche n est pas disponible
	Given seconnecter a la page d accueil
	When effctuer une recherche sur un produit 'samsungwww'
	Then valider que le resultat de recherche vide

@tag8
Scenario: utilisateur peut passer une commande
	Given seconnecter a la page d accueil
	When L utilisateur connecter a son compte 
	And effctuer une recherche sur un produit 'samsung' 
	And passer la command
	Then valider que la commande passe
	


