@tag
Feature: Accepter des ballons en tant que munitions
  
  En tant que mecanicien
  Je veux pouvoir ajouter un ballon dans ma caisse de munitions
  Afin de pouvoir tirer des ballons sur des cibles

  @tag1
  Scenario Outline: Integrer un ballon dans la caisse a munition
    Given un mecanicien <nomMecanicien>
    And son char d attaque fabrique par <fabriquant>
    When il veut utiliser des ballons en tant que munitions
    Then le ballon est bien present dans la caisse a munition du char

    Examples:
      | nomMecanicien | fabriquant |
      | "SGT Brody" | "Renault"  |
      | "SCH Buee"  | "MBDA"     |
