Feature: Contact Page

  Background:
    Given user opens Jupiter Toys website

  @Regression @test-error-messages
  Scenario: Navigates to Contact Page and validate error messages for mandatory fields
    When user navigates to "Contact" Page
    And click "Submit" button
    Then error message should appear
    And error messages for mandatory fields should appear

    When user populate mandatory fields
      | Forename | Email                | Message        |
      | John     | john.doe@example.com | This is a test |
    Then error message should not appear
    And error messages for mandatory fields should not appear

  @Smoke @Regression @flaky-test
  Scenario Outline: Navigates to Contact Page and validate successful submission
    When user navigates to "Contact" Page
    And user populate mandatory fields: "<Forename>" "<Email>" "<Message>"
    And click "Submit" button
    Then successful message should appear for user: "<Forename>"
    Examples:
      | Forename | Email                | Message          |
      | John     | john.doe@example.com | This is a test 1 |
      | Jane     | jane.doe@example.com | This is a test 2 |
      | Joey     | joey.doe@example.com | This is a test 3 |
      | Jill     | jill.doe@example.com | This is a test 4 |
      | Jake     | jake.doe@example.com | This is a test 5 |
