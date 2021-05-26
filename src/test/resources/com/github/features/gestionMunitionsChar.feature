@tag
Feature: Accepter les differentes munitions disponibles pour un char
  
  En tant que mecanicien
  Je veux pouvoir modifier le type de munition de mon char d attaque
  Afin de pouvoir tirer des munitions avec differentes specifites

  @tag1
  Scenario Outline: Utiliser des munitions differentes simultanement
    Given un mecanicien <nomMecanicien>
    And le char d attaque de calibre <calibre> fabrique par <fabriquant>
    And sa caisse de munitions contient deja une munition de type <typeMunitionAncien>
    When il veut utiliser un <typeMunitionNouveau> en tant que munition
    Then la munition de nouveau type est bien ajoutee dans la caisse a munition du char

    Examples: 
      | nomMecanicien  | fabriquant | calibre | typeMunitionAncien | typeMunitionNouveau |
      | "SGT Brody"  | "Renault"  |     200 | "OBUS_PERFORANT"   | "BALLON"            |
      | "SGT Trunk"  | "Renault"  |     200 | "OBUS_PERFORANT"   | "OBUS_EXPLOSIF"     |
      | "SGT Baby"   | "Renault"  |     200 | "BALLON"           | "OBUS_PERFORANT"    |
      | "SCH Jul"    | "MBDA"     |     200 | "BALLON"           | "OBUS_EXPLOSIF"     |
      | "SCH Vegeta" | "MBDA"     |     200 | "OBUS_EXPLOSIF"    | "BALLON"            |
      | "SCH Buee"   | "MBDA"     |     200 | "OBUS_EXPLOSIF"    | "OBUS_PERFORANT"    |
