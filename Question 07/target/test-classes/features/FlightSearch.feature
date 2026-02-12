Feature: Flight Search Functionality

  Scenario: Search round trip flights from HYD to MAA
    Given user launches the MakeMyTrip website
    When user clicks on Flights
    And user selects Round Trip
    And user enters From location as "HYD"
    And user enters To location as "MAA"
    And user selects departure and return dates
    And user clicks on Search button
    Then search results page should be displayed