@web
Feature: Testing basic functionalities from an online shop

  Use the following command in the terminal to execute automated tests: mvn verify -Denv=prod -Dit.test=victoria.adidas2.runners.front.OnlineShopFront

  Scenario: Fill the form and click the submit button
    #Customer navigation through product categories: Phones, Laptops and Monitors
    Given I go to 'https://${envProperties:shop.url}'
    Then I maximize the browser
    When '1' elements exists with 'id:cat'
    Then the element on index '0' has 'CATEGORIES' as text
    When I click on the element with 'xpath://*[@onclick="byCat('phone')"]' index '0'
    Then I wait '1' seconds
    When I click on the element with 'xpath://*[@onclick="byCat('notebook')"]' index '0'
    Then I wait '1' seconds
    When I click on the element with 'xpath://*[@onclick="byCat('monitor')"]' index '0'
    Then I wait '1' seconds
    #Navigate to "Laptop" -> "Sony vaio i5" and click on "Add to cart"
    When I click on the element with 'xpath://*[@onclick="byCat('notebook')"]' index '0'
    Then I click on the element with 'xpath://a[contains(text(), 'Sony vaio i5')]' index '0'
    When '1' elements exists with 'class:name'
    Then the element on index '0' has 'Sony vaio i5' as text
    When I click on the element with 'xpath://*[@onclick="addToCart(8)"]' index '0'
    Then I wait '3' seconds
    Then I accept pop-up
    #Navigate to "Laptop" -> "Dell i7 8gb" and click on "Add to cart"
    Then I click on the element with 'xpath://a[contains(text(), 'Home')]' index '0'
    When I click on the element with 'xpath://*[@onclick="byCat('notebook')"]' index '0'
    Then I click on the element with 'xpath://a[contains(text(), 'Dell i7 8gb')]' index '0'
    When '1' elements exists with 'class:name'
    Then the element on index '0' has 'Dell i7 8gb' as text
    When I click on the element with 'xpath://a[contains(text(), 'Add to cart')]' index '0'
    Then I wait '2' seconds
    Then I accept pop-up
    #Navigate to "Cart" -> Delete "Dell i7 8gb" from cart
    When I click on the element with 'xpath://*[@href="cart.html"]' index '0'
    When I click on the element with 'xpath://a[contains(text(), 'Delete')]' index '0'
    #Click on "Place order"
    When I wait '2' seconds
    Then I save attribute 'text' from xpath '//*[@id="totalp"]' on index '0' in environment variable 'TOTAL_PRIZE'
    When I click on the element with 'xpath://button[contains(text(), 'Place Order')]' index '0'
    #Fill in all web form fields
    When I change active window
    Given I fill form with: name 'John', country 'Spain', city 'Madrid', credit card '3232323232323232', month '10' and year '2028'
    #Click on "Purchase"
    Then I click on the element with 'xpath://button[@onclick="purchaseOrder()"]' index '0'
    #Click on "Ok"
    Then I wait '1' seconds
    Then I click on the element with 'xpath://button[contains(text(), 'OK')]' index '0'