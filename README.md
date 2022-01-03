
# Adidas Challenge

This is the project for the second exercise - DEMO ONLINE SHOP automation



These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.


How to run the automated tests for this system

To run a specific feature test (specific runner class):
```
mvn verify -Dit.test=victoria.adidas2.runners.front.OnlineShopFront
```

To run a specific feature test with values for an environment:
```
mvn verify -Denv=prod -Dit.test=victoria.adidas2.runners.front.OnlineShopFront
```

To run a specific browser to execute test add the following command:
```
-Denv=firefox
-Denv=chrome
```


More information on how to run automated tests can be found [here](https://github.com/veepee-oss/gingerspec/wiki/Running-your-tests)



* 1.0.0
  * Exercise 1 - Demo Online Shop Automation



* **Victoria Lopez Valencia** - *Quality Assurance* -



This module depends on the GingerSpec framework (QA testing library), where common logic and steps are implemented.

Check more information about the GingerSpec framework [here](https://github.com/veepee-oss/gingerspec/wiki)  