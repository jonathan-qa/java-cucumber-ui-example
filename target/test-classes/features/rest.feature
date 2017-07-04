Feature: Teste Dojo

  Scenario: Login test
    Given I have an user "495226908"
    And a password "Azul9393!"
    When I call login
    Then I expect HTTP Status 200
    And I expect "Roles" as "AIRM"
