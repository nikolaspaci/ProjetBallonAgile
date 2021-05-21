@tag
Feature: Accepter des ballons en tant que munitions
  
  En tant que Tankiste
  Je veux pouvoir ajouter un ballon dans ma caisse de munitions
  Afin de pouvoir tirer des ballons sur des cibles

  @tag1
  Scenario Outline: Integrer un ballon dans la caisse à munition
    Given le tankiste <nomTankiste>
    And son char d attaque calibre <calibre> fabrique par <fabriquant>
    When il veut utiliser des ballons en tant que munitions
    Then le ballon est bien present dans la caisse a munition du char

    Examples: 
      | nomTankiste | fabriquant | calibre |
      | "SGT Brody" | "Renault"  |     100 |
      | "SCH Buee"  | "MBDA"     |     200 |
