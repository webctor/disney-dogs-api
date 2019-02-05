Feature: Vote up and down a dog picture
  Scenario: client makes call to POST /dogs/images/{id}
    When the client calls /dogs/images/{id}
    Then the client receives status code of 202


