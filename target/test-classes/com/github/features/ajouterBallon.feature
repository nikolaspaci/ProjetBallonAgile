@tag
Feature: Ajouter un ballon
	En tant que Sportif
  Je veux pouvoir voir les ballons de un sport
  Afin de pouvoir pratiquer un sport 

  @tag1
  Scenario Outline: Ajout du ballon dans la liste
    Given un sport <sport>
    When je lui ajoute un ballon
    Then ce ballon est present dans la liste

    Examples: 
      | sport |
      | "football" |
