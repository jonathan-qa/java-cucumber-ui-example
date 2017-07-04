Feature: Ninja Invoice Testes

  Scenario: Login with success
    Given I have an user with email "souza.jonathan@outlook.com"
    And an password "Jso1605jso"
    When i click in the login button
    Then the home private page is opened