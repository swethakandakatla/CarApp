# Elender Test

Project was developed on mac os with Java8 (IntelliJ).


## env.properties (src/test/properties/env.properties)

This file contains properties for driver, timeouts and host.

chromedriver is present with the project (src/test/resources).  
 

## Implementation

Page Objecct Model is used to implement this project

1. BasePage: src/main/java/utils/BasePage.java
    Chromedriver & report are instantiated here 

2. Pages: src/main/java/elender/pages/CarTaxCheckPage.java
    here, for every page form the test website, required elements are declared using page factory and the corresponding actions are imeplemented in the methods.

3. Runner: src/test/java/elender/TestRunner.java
    this is to run the scenarios, step definition path is mentioned in glue.

4. Steps: src/main/java/elender/steps/CarTaxCheckSteps.java
    All the cucumber steps are defined in this file.

5. Utils: src/main/java/utils
    this package is helper package which contains... below
    - BasePage, class for driver & reports instances 
    - Configuration, class to read the properties
    - InputFileReader, class to read the input file and extract the car registration numbers
    - OutputFileReader, class to return the expected vehicle details 
    - pageObjectUtils for asserting the webelement and clicking.
 
6. Data Files: 
    InputFiles: src/test/input
    OutputFiles: src/test/output

## Feature (src/test/features/CarCheck.feature)

This contains 1 scenario outline, feature is tagged with @checkCarTax
    - we can add more input and out files to the test in the Examples.


** How to run tests **
We can run these tests in windows and mac.
We can use the runner file TestRunner.java to test, tags are already defined.

1. Using IDE - Right Click on the Runner file and select Run.
2. Using terminal
    >cd {projectFolder}

    >mvn compile
    
    >mvn test
