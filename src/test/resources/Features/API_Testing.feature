Feature: API_Automation

  @GetAPI
  Scenario: TC01_Validate Get API list Users

    Given endpoint_url "api/users?page=2"
    When user call get method
    Then user can see the StatusCode response
    And Status line should be "HTTP/1.1 200 OK"
