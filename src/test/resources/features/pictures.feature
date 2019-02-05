Feature: Retrieve pictures grouped by breed
  Scenario: client makes call to GET /dogs/images
    When the client calls /dogs/images
    Then the client receives status code of 200
    And the client receives a list of objects containing images
