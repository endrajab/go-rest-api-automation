Feature: Create a New User - Get the new user - Update the new user - delete the new user

  Scenario Outline: End to end scenario create user, get new user, update user, and delete new user
    Given email user is <email>
    And name user is <name>
    And gender user is <gender>
    And status status user is <status>
    #Create User
    When user access create user api "/public-api/users"
    Then user get the status code 200
    And response body code 201
    And response body have data <email>, <name>, <gender> and <status>
    #Get User Details
    When user access get user detail api
    Then user get the status code 200
    And response body code 200
    And response body have data <email>, <name>, <gender> and <status>
    #Update User Details
    When user access api for update user with data <updated_email> and <updated_name>
    Then user get the status code 200
    And response body code 200
    And response body have data <updated_email>, <updated_name>, <gender> and <status>
    #Delete User
    When user access delete user api
    Then user get the status code 200
    And response body code 204

    Examples:
      | email             | name     | gender | status   | updated_email     | updated_name |
      | "qwer1234@email.com" | "qwerty" | "Male" | "Active" | "asdf1234@email.com" | "asdf"        |