# api-webdriver-harmony

Supporting code for Mark Winteringham's REST APIs and WebDriver: In Perfect Harmony talk. You can go through each of the commits to see the implemented changes mentioned from the talk.

This code is for reference only and whilst you can run it against an instance of BugZilla, it will require setup of an instance of BugZilla.

## Abstract

#### REST APIs and WebDriver: In Perfect Harmony

A common pattern that Automator's fall into is trying to execute every action of a test via the UI, from logging in, creating required data, navigating to that specific data and then running assertions on it before logging out. This can lead to tests that are slow to run and likely to break due to the reliance on many Web elements.

This talk will demonstrate to participants how they can use HTTP request libraries and WebDriver in harmony. We'll cover how HTTP request libraries can take care of state manipulation and data setup so that WebDriver can be used to focus on the areas WebDriver is strongest at.

We'll look at:

* How we design a test and what actions are involved in the execution of a test
* How we can break up the different actions of a test and assign different tasks to different libraries
* A practical demonstration of how to add an HTTP request library into a current WebDriver based framework to create data for WebDriver to use
* An approach participants can use to organise HTTP request code to make it DRY and reliable
* Tips and tricks for participants to use to help them determine what HTTP requests and WebDriver can help them with

Participants will leave with a deeper appreciation for the strengths of WebDriver and how to effectively improve their frameworks reliability and speed.