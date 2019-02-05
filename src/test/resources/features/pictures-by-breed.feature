Feature: Retrieve dog pictures of a particular breed
  Scenario: client makes call to GET /dogs/images/{breed}
    When the client calls /dogs/images/{breed}
    Then the client receives status code of 200
    And the client receives a list of objects containing images
