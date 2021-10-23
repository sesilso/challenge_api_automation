Feature: Country Layer API

  @All
  Scenario: Verify All Country status code response
    When User send the API request to get all countries
    Then He validates response status code is "200"

  @ByCode
  Scenario Outline: Verify Country by Alpha Code
    When User send the API request to get country by alpha code "<code>"
    Then He validates response status code is "200"
    And He validates the body response
    Examples:
    |code|
    |US  |
    |DE  |
    |GB  |

  @ignore
  Scenario Outline: Verify New Country Addition
    When User send the API request to add a new country "<name>", "<alpha2_code>", "<alpha3_code>"
    Then He validates response status code is "200"
    Examples:
      |name         |alpha2_code|alpha3_code|
      |Test Country |TC         |TCY        |