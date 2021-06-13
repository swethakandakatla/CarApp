Feature: Car Tax Check - Free Car Check

  @checkCarTax
  Scenario Outline: Free Car Tax Check using <DataInputFile> and <DataOutputFile>
    Given I am on the car tax check page
    When I read the car registration numbers from <DataInputFile> input file
    Then I enter the car numbers and validate the vehicle data from <DataOutputFile> output file
    Examples:
      | DataInputFile | DataOutputFile |
      | car_input     | car_output     |
