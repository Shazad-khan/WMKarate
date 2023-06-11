Feature: Login to WM

Background:
  * url 'https://fdn-svc-qa.washmetrix.com/v1/'
    * def user = read('classpath:Washmetrix/resourses/user.json')

Scenario: Loggin in to Washmetrix

    Given path 'login'
    And request user
    When method post
    Then status 200
    Then print response

    * def accessToken = response.AuthenticationResult.AccessToken
    And print accessToken

