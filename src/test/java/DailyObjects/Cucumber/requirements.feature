@Tag
Feature: Verify 'Out of Stock' products on Studio Collection Pages

  Scenario: Check if any product on the Studio Collection Pages is out of stock
    Given I navigate to Collection listing page
    When I retrieves all collection <pageLinks>
    Then I navigates to each Studio Collection page
    And I scrolls to the product container
    Then no product should be out of stock on the page


