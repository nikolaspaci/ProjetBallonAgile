@tag
Feature: Compatibilité calibre char et calibre munitions
  En tant que mecanicien
  Je veux pouvoir ajouter des munitions de calibre inferieur ou egale au calibre du char
  Afin que les munitions rentrent dans la caisse de munitions du char

  Scenario Outline: Ajout d une munition de calibre inferieur ou egale au calibre du char
    Given un mecanicien <nomMecanicien>
    And un char d attaque de calibre <calibreChar> produit par <fabriquant>
    When il veut ajouter une <munition> de calibre inferieur ou egal au char
    Then la munition est bien ajoutee dans la caisse a munitions du char

    Examples: 
      | nomMecanicien  | fabriquant | calibreChar | munition  |
      | "SGT Brody"  | "Renault"  |     30 | "OBUS_PERFORANT"   | 
      
  Scenario Outline: Ajout d une munition de calibre strictement superieur au calibre du char
    Given un mecanicien <nomMecanicien>
    And un char d attaque de calibre <calibreChar> construit par <fabriquant>
    When il veut ajouter une <munition> de calibre superieur au char
    Then la munition ne rentre pas dans la caisse a munitions du char

    Examples: 
      | nomMecanicien  | fabriquant | calibreChar | munition  |
      | "SGT Brody"  | "Renault"  |     10 | "OBUS_PERFORANT"   | 
