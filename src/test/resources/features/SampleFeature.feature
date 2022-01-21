@Smoke @Sample
Feature: Sample feature to demonstrate the capabilities of this project


  Scenario Outline: Verify Weather Shopper functionality on browser <browser>
   
   Given User open <browser> browser
   When User opens weather shopper website
   Then User verify current tempereture
   Then User verify current tempereture and add product to cart

   
Examples:
| browser |
| chrome  | 
| firefox | 

