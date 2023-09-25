# Automation Project using Selenium and WebDriver/SeleniumGrid with Java

This is an automation project for TELUS TV+ using Selenium and WebDriver/SeleniumGrid with Java. The project focuses on creating page objects and performing automated tests.

## Prerequisite

Before running the automation tests, ensure that you have access to TELUS TV+ at [TELUS TV+](https://telustvplus.com/#/).

## Requirements

1. **Basic Test Result Report**: The project should generate a basic test result report for test executions.

2. **Modular and Bug-Free Code**: The codebase should be modular and free from bugs.

## Steps to Perform

Follow these steps to perform the automated tests:

1. Launch TELUS TV+ URL.
2. Close the welcome popup.
3. Click on "On Demand".
4. Scroll to "Movies".
5. Click "Movies" > "View All".
6. Click "Filter" and select "Animated".
7. Click the "Apply" option.
8. Loop through the list and find an asset with a rating of 18+.
9. Click the asset to open the details page.

## Expected Results

After completing the steps, the following expected result should be observed:

- The asset with an 18+ rating should be displayed.
