
@tag
Feature: Purchase the product Ecommerce
  I want to use this template for my feature file

	Background:
	Given I landed on Ecommerce
	

  @tag2
  Scenario Outline: Positive Submiting the product
    Given Logged in with username <name> and password <Password>
    When I add product <productName> to cart
    And checkout <country> and submit the order
    Then "THANK YOU FOR THE ORDER" is displayed on confirmation
    Examples: 
      | name 								  | Password  	 | productName | country 															 |
      | samicex570@hdrlog.com | Password@123 | qwerty	 		 | British Indian Ocean Territory				 |
 
