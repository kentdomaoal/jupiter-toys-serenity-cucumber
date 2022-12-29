Feature: Jupiter Toys Navigation Links

  Background:
    Given user opens Jupiter Toys website

  @Regression @navigation
  Scenario Outline: Navigate to a page and validate Current Url
    When user navigates to "<Page>" Page
    Then current url should be "<Url>"

    Examples:
      | Page    | Url                                               |
      | Home    | https://jupiter.cloud.planittesting.com/#/home    |
      | Shop    | https://jupiter.cloud.planittesting.com/#/shop    |
      | Contact | https://jupiter.cloud.planittesting.com/#/contact |
      | Cart    | https://jupiter.cloud.planittesting.com/#/cart    |
