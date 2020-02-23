Feature: Validating place API's

@Regression
Scenario Outline: Verify whether place is being successfully added using AddPlace API

Given AddPlaceAPI Payload with "<name>" "<address>" and "<language>"

When  User calls the "AddPlaceAPI" with "Post" http request

Then  Response is returned with Status code 200

And  "status" in response body is "OK"

And "scope" in response body is "APP"

And Verify whether place_id created maps to "<name>"



Examples: 
|name|address|language|
|sevan|AA Frontline house|English|
|Rajvee|BB Frontline house|French|

@Regression
Scenario: Verify whether place is being successfully deleted using DeletePlace API

Given DeletePlaceAPI Payload

When  User calls the "DeletePlaceAPI" with "Post" http request

Then  Response is returned with Status code 200

And  "status" in response body is "OK"




