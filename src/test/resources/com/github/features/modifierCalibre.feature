#Author: djo@lerigolo.fr
@tag
Feature: Modifier le calibre

  En tant que Mecanicien
  Je veux pouvoir modifier le calibre du canon d'un char
  Afin de pouvoir tirer des munitions d'un autre calibre

  @tag1
  Scenario Outline: Modifier le calibre d'un char par un mecano
    Given le mecanicien <nomMecanicien>
    And le char de calibre <calibre> fabrique par <fabriquant>
    When il change le calibre a <nouveauCalibre>
    Then le calibre du char est bien <nouveauCalibre>

  Examples:
    | nomMecanicien | fabriquant | calibre | nouveauCalibre |
    | "SGT Brody"   | "Renault"  | 100     | 120            |
    | "SCH Buee"    | "MBDA"     | 200     | 100            |

