@tag
Feature: Remplir le char d attaque de munitions
  
  En tant que Mecanicien
  Je veux pouvoir ajouter des munitions compatibles dans mon char d attaque
  Afin de pouvoir tirer sur des cibles

  @tag1
  Scenario Outline: Ne pas Integrer des munitions de mauvais calibre dans la caisse a munition du char d attaque
    Given un mecanicien <nomMecanicien>
    And le char de calibre d attaque <calibre> fabrique par <fabriquant>
    When il veut utiliser des <typeMunition> en tant que munition
    Then si le calibre est incompatible,le <typeMunition> n est pas present dans la caisse a munition du char

    Examples: 
      | nomMecanicien | fabriquant | calibre | typeMunition |
      | "SGT Brody" | "Renault"  |     100 | "OBUS_PERFORANT" |
      | "SCH Buee"  | "MBDA"     |     100 | "OBUS_EXPLOSIF" |

  @tag2
  Scenario Outline: Integrer des munitions compatibles dans la caisse a munition du char d attaque
    Given un mecanicien <nomMecanicien>
    And le char de calibre d attaque <calibre> fabrique par <fabriquant>
    When il veut utiliser un <typeMunition> en tant que munitions
    Then le <typeMunition> est bien present dans la caisse a munition du char

    Examples: 
      | nomMecanicien | fabriquant | calibre | typeMunition |
      | "SGT Brody" | "Renault"  |     200 | "OBUS_PERFORANT" |
      | "SCH Buee"  | "MBDA"     |     200 | "OBUS_EXPLOSIF" |
