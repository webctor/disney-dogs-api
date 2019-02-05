Feature: Retrieve the details associated with a dog picture
  Scenario: client makes call to GET /dogs/images/{id}
    When the client calls /dogs/images/{id}
    Then the client receives status code of 200
    And the client receives a list of objects containing an object with the details for the image
