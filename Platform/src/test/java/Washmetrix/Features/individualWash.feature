Feature: Individual Car wash

  Background:
    * url 'https://svc-qa.washmetrix.com/'
    * def payload = read('classpath:Washmetrix/resourses/individualWash.json')


  Scenario: Testing api for individual car wash
    Given header Authorization = 'Bearer '+ accessToken
    Given path 'sales-and-labor/individual-wash'
    And request payload
    When method post
    Then status 200


