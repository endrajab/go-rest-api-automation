Feature: Create a New User - Get the new user - Update the new user - delete the new user

  Scenario Outline: Create a New User
    Given email user is <email>
    And name user is <name>
    And gender user is <gender>
    And status status user is <status>
    When user access api "/public-api/users"
    Then user get the status code 200
    And response body code 201
    And response body have data <email>, <name>, <gender> and <status>
    When user access api get user detail
    Then user get the status code 200
    And response body have data <email>, <name>, <gender> and <status>
    When user access api for update user with data <updated_email> and <updated_name>
    Then user get the status code 200
    And response body have data <updated_email>, <updated_name>, <gender> and <status>

    Examples:
      | email             | name     | gender | status   | updated_email     | updated_name |
      | "qwer1234@email.com" | "qwerty" | "Male" | "Active" | "asdf1234@email.com" | "asdf"        |