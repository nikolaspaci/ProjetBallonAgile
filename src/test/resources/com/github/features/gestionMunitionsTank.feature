@tag
Feature: Accepter les différentes munitions disponibles pour un char
  
  En tant que Tankiste
  Je veux pouvoir modifier le type de munition de mon char d attaque
  Afin de pouvoir tirer des munitions avec différentes spécifités

  @tag1
  Scenario Outline: Utiliser des munitions différentes simultanement
    Given le tankiste <nomTankiste>
    And son char d attaque calibre <calibre> fabrique par <fabriquant>
    And sa caisse de munitions contient deja une munition de type <typeMunitionAncien>
    When il veut utiliser un <typeMunitionNouveau> en tant que munition
    Then le <typeMunitionNouveau> est bien present dans la caisse a munition du char

    Examples: 
      | nomTankiste  | fabriquant | calibre | typeMunitionAncien | typeMunitionNouveau |
      | "SGT Brody"  | "Renault"  |     200 | "OBUS_PERFORANT"   | "BALLON"            |
      | "SGT Trunk"  | "Renault"  |     200 | "OBUS_PERFORANT"   | "OBUS_EXPLOSIF"     |
      | "SGT Baby"   | "Renault"  |     200 | "BALLON"           | "OBUS_PERFORANT"    |
      | "SCH Jul"    | "MBDA"     |     200 | "BALLON"           | "OBUS_EXPLOSIF"     |
      | "SCH Vegeta" | "MBDA"     |     200 | "OBUS_EXPLOSIF"    | "BALLON"            |
      | "SCH Buee"   | "MBDA"     |     200 | "OBUS_EXPLOSIF"    | "OBUS_PERFORANT"    |
