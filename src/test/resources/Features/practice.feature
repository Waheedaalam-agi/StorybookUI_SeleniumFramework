Feature: test

  @test
  Scenario: navigate to google
    Given User navigates to google home page
    When User searches for "ArisGlobal"
    Then User verifies "Miami, FL" is displayed on page
